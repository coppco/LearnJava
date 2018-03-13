package com.test;

import com.coppco.mapper.TbItemMapper;
import com.coppco.pojo.TbItem;
import com.coppco.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//Spring提供的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class TestPageHelper {

    @Autowired
    private TbItemMapper itemMapper;

    @Test
    public void testPageHelper() throws Exception {
        //1、配置分页插件

        //2、开始之前调用静态方法设置参数
        PageHelper.startPage(11,10);

        //3、执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);

        //4、取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        System.out.println("总记录"+ pageInfo.getTotal());
        System.out.println("总页数"+ pageInfo.getPages());
        System.out.println("返回数据"+ list.size());
        System.out.println("当前页"+ pageInfo.getPageNum());
    }

}
