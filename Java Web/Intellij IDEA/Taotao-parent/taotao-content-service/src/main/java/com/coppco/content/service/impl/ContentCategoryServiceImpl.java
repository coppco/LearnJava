package com.coppco.content.service.impl;

import com.coppco.common.pojo.EasyTreeNode;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.content.service.ContentCategoryService;
import com.coppco.mapper.TbContentCategoryMapper;
import com.coppco.pojo.TbContentCategory;
import com.coppco.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内容分类
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    /**
     * 获取内容分类列表
     * @param parentId
     * @return
     */
    @Override
    public List<EasyTreeNode> getContentCategoryList(long parentId) {
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectByExample(tbContentCategoryExample);
        List<EasyTreeNode> list = new ArrayList<>();
        for (TbContentCategory category:tbContentCategories) {
            EasyTreeNode node = new EasyTreeNode();
            node.setId(category.getId());
            node.setText(category.getName());
            node.setState(category.getIsParent() ? "closed" : "open");
            list.add(node);
        }
        return list;
    }

    /**
     * 新增内容分类
     * @param parentId
     * @param name
     * @return
     */
    @Override
    public TaotaoResult addContentCategory(long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();

        //补全全信息
        tbContentCategory.setName(name);
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setStatus(1);  //状态1-正常
        tbContentCategory.setSortOrder(1); //排序
        tbContentCategory.setIsParent(false);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        contentCategoryMapper.insert(tbContentCategory);

        //判断父节点状态
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if (!parent.getIsParent()) {
            parent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parent);
        }

        return TaotaoResult.ok(tbContentCategory);
    }

    /**
     * 更新内容分类
     * @param id
     * @param name
     * @return
     */
    @Override
    public TaotaoResult updateContentCategory(long id, String name) {
        TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        tbContentCategory.setName(name);
        contentCategoryMapper.updateByPrimaryKey(tbContentCategory);
        return TaotaoResult.ok();
    }

    /**
     * 删除内容分类
     * @param id
     * @return
     */
    @Override
    public TaotaoResult deleteContentCategory(long id) {
        TbContentCategory deleteObject = contentCategoryMapper.selectByPrimaryKey(id);
        TbContentCategory parentObject = contentCategoryMapper.selectByPrimaryKey(deleteObject.getParentId());
        //如果是父节点先删除子节点
        if (deleteObject.getIsParent()) {
            List<EasyTreeNode> childList = getContentCategoryList(id);
            for (EasyTreeNode node:childList) {
                deleteContentCategory(node.getId());
            }
        }

        contentCategoryMapper.deleteByPrimaryKey(id);
        //更新父节点的状态
        List<EasyTreeNode> list = getContentCategoryList(deleteObject.getParentId());
        if (list.size() == 0) {
            parentObject.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKey(parentObject);
        }

        return TaotaoResult.ok();
    }
}
