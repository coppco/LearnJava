package com.coppco.main;

import com.coppco.Config;
import com.coppco.FunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        FunctionService service = context.getBean(FunctionService.class);
        service.sayHello("World");
        context.close();
    }

}
