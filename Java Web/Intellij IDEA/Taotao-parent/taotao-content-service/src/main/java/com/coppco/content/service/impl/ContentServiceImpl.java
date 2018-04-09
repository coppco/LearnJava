package com.coppco.content.service.impl;

import com.coppco.common.pojo.EasyUIDataGridResult;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.common.utils.JsonUtils;
import com.coppco.content.service.ContentService;
import com.coppco.jedis.JedisClient;
import com.coppco.mapper.TbContentMapper;
import com.coppco.pojo.TbContent;
import com.coppco.pojo.TbContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private TbContentMapper contentMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_INDEX_CONTENT_KEY}")
    private String REDIS_INDEX_CONTENT_KEY;

    /**
     * 内容列表分页查询
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIDataGridResult getContentList(int page, int rows, long categoryId) {
        //设置参数
        PageHelper.startPage(page, rows);
        TbContentExample tbContentExample = new TbContentExample();
        tbContentExample.createCriteria().andCategoryIdEqualTo(categoryId);
        //查询
        List<TbContent> list = contentMapper.selectByExample(tbContentExample);
        //取查询结果
        PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);

        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    /**
     * 添加内容
     * @param content
     * @return
     */
    @Override
    public TaotaoResult addContent(TbContent content) {
        Date updated = new Date();
        content.setCreated(updated);
        content.setUpdated(updated);
        contentMapper.insert(content);

        //删除对应的缓存
        jedisClient.hdel(REDIS_INDEX_CONTENT_KEY, content.getCategoryId().toString());

        return TaotaoResult.ok();
    }

    /**
     * 编辑内容
     * @param content
     * @return
     */
    @Override
    public TaotaoResult editContent(TbContent content) {
        content.setUpdated(new Date());
        contentMapper.updateByPrimaryKey(content);

        //删除对应的缓存
        jedisClient.hdel(REDIS_INDEX_CONTENT_KEY, content.getCategoryId().toString());

        return TaotaoResult.ok();
    }

    /**
     * 批量删除内容
     * @param ids
     * @return
     */
    @Override
    public TaotaoResult deleteContents(String ids) {
        if (null != ids) {
            String[] split = ids.split(",");
            ArrayList<Long> list = new ArrayList<>();
            for (String id:split) {
                list.add(Long.parseLong(id));
            }
            TbContentExample example = new TbContentExample();
            example.createCriteria().andIdIn(list);
            contentMapper.deleteByExample(example);

            return TaotaoResult.ok();
        } else {
            return TaotaoResult.build(201, "不能删除空的内容");
        }
    }

    /**
     * 根据id查询内容
     * @param categoryId
     * @return
     */
    @Override
    public List<TbContent> queryContentByCid(long categoryId) {
        //先查询缓存中有没有,没有再查下数据库并保存缓存中
        try {
            String json = jedisClient.hget(REDIS_INDEX_CONTENT_KEY, categoryId + "");
            if (StringUtils.isNotBlank(json)) {
                List<TbContent> tbContents = JsonUtils.jsonToList(json, TbContent.class);
                return tbContents;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        TbContentExample example = new TbContentExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        List<TbContent> result = contentMapper.selectByExample(example);
        //添加缓存
        try {
            jedisClient.hset(REDIS_INDEX_CONTENT_KEY, categoryId + "", JsonUtils.objectToJson(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
