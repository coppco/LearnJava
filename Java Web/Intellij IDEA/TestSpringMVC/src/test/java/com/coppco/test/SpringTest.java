package com.coppco.test;

import com.coppco.config.MyConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml") //加载指定配置
@ContextConfiguration(classes = MyConfig.class) //加载指定配置类
@WebAppConfiguration //web资源位置默认/src/main/webapp
public class SpringTest {

    //模拟MVC对象
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockHttpSession session;

    @Autowired
    private MockHttpServletRequest request;

    @Before
    public void setup() {
        //@Before先初始化mockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 模拟MVC对象
     * @throws Exception
     */
    @Test
    public void testGetJson() throws Exception {
        mockMvc.perform(get("/async"))
                .andExpect(status().isOk())
                .andExpect(view().name("async"))
                .andExpect(forwardedUrl("/WEB-INF/async.jsp"));

    }
}
