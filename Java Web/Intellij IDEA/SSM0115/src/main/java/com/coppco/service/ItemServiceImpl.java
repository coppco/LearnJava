package com.coppco.service;

import com.coppco.dao.ItemsMapper;
import com.coppco.pojo.Items;
import com.coppco.pojo.ItemsExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service(value = "itemService")
public class ItemServiceImpl implements ItemService {

    @Resource(name = "itemsMapper")
    private ItemsMapper itemsMapper;

    public List<Items> list() {
        ItemsExample example = new ItemsExample();
        //包含大文本对象
        return itemsMapper.selectByExampleWithBLOBs(example);
    }

    public Items findById(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    public void updateItems(Items items) {
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
