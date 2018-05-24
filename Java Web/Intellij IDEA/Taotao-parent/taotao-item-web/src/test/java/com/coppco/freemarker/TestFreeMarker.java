package com.coppco.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;


import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TestFreeMarker {

    @Test
    public void testFreemarker() throws Exception{

        //1、Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());

        //2、设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(new File("/Users/apple/LearnJava/Java Web/Intellij IDEA/Taotao-parent/taotao-item-web/src/main/webapp/WEB-INF/ftl"));

        //3、设置模板文件使用的字符集。一般就是utf - 8.
        configuration.setDefaultEncoding("utf-8");

        //4、加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("hello.ftl");

        //5、创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map map = new HashMap<>();
        map.put("hello", "Coppco");

        //6、创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        FileWriter writer = new FileWriter(new File("/Users/apple/Desktop/hello.html"));

        //7、调用模板对象的process方法输出文件。
        template.process(map, writer);

        //8、关闭流。
        writer.close();
    }

    @Test
    public void testStudent() throws Exception{

        //1、Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());

        //2、设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(new File("/Users/apple/LearnJava/Java Web/Intellij IDEA/Taotao-parent/taotao-item-web/src/main/webapp/WEB-INF/ftl"));

        //3、设置模板文件使用的字符集。一般就是utf - 8.
        configuration.setDefaultEncoding("utf-8");

        //4、加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("student.ftl");

        //5、创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Student student = new Student(10, "呵呵", 11, "杭州市");
        Map map = new HashMap();
        map.put("student", student);
        map.put("date", new Date());
        map.put("val", 123);
        map.put("hello", "coppco");

        //6、创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        FileWriter writer = new FileWriter(new File("/Users/apple/Desktop/student.html"));

        //7、调用模板对象的process方法输出文件。
        template.process(map, writer);

        //8、关闭流。
        writer.close();
    }
}
