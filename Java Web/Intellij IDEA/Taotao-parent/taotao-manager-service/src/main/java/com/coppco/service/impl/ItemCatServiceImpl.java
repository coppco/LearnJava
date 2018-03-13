package com.coppco.service.impl;

import com.coppco.common.pojo.EasyTreeNode;
import com.coppco.mapper.TbItemCatMapper;
import com.coppco.pojo.TbItemCat;
import com.coppco.pojo.TbItemCatExample;
import com.coppco.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyTreeNode> getCatList(Long parentId) {

        //根据父节点查询
        TbItemCatExample example = new TbItemCatExample();

        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        
        List<EasyTreeNode> treeNodes = new ArrayList<>();

        for (TbItemCat cat: tbItemCats) {
            EasyTreeNode node = new EasyTreeNode();
            node.setId(cat.getId());
            node.setText(cat.getName());

            //如果下面有子节点, closed,  没有的话opened
            node.setState(cat.getIsParent() ? "closed" : "open");
            treeNodes.add(node);
        }
        return treeNodes;
    }
}
