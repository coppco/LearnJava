package com.coppco.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mail.xml")
public class JavaMailTest {

    @Resource(name = "mailMessage")
    private SimpleMailMessage simpleMailMessage;

    @Resource(name = "mailSender")
    private JavaMailSender javaMailSender;

    /**
     * 发送邮件, 使用原始方式
     */
    @Test
    public void sendMail01() throws Exception {
        Properties properties = new Properties();
        //邮件服务器地址
        properties.put("mail.smtp.host", "smtp.163.com");
        //验证身份
        properties.put("mail.smtp.auth", "true");

        //获取session
        Session session = Session.getInstance(properties);
        //启用debug, 可以在控制台输出smtp状态
        session.setDebug(true);

        //MimeMessage格式的格式
        MimeMessage message = new MimeMessage(session);

        //设置发送者
        Address sendAdd = new InternetAddress("bow77@163.com");
        message.setFrom(sendAdd);

        //设置接受者
        Address receiveAdd = new InternetAddress("coppco@qq.com");
        message.setRecipient(RecipientType.TO, receiveAdd);

        //设置邮件正文
        message.setSubject("哥哥: 晚上约你!");
        message.setText("晚上老地址见!");

        //保存邮件
        message.saveChanges();

        //得到发送邮件的火箭
        Transport transport = session.getTransport("smtp");

        //火箭连接服务器
        transport.connect("smtp.163.com", "bow77", "Junyin520");

        //火箭点火, 发送
        transport.sendMessage(message, message.getRecipients(RecipientType.TO));

        //关闭通道
        transport.close();
    }

    /**
     * 发送简单邮件
     */
    @Test
    public void sendMail02() {
        simpleMailMessage.setSubject("使用spring整合JavaMail");
        simpleMailMessage.setText("你好, Spring、JavaMail");
        simpleMailMessage.setTo("coppco@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 发送带图片和附件的邮件
     */
    @Test
    public void sendMail03() throws Exception {
//        HttpServletRequest request = ServletActionContext.getRequest();
        //创建一个带附件的邮件
        MimeMessage message = javaMailSender.createMimeMessage();

        //通过工具类操作message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //设置内容
        helper.setSubject("带图片的附件");
        helper.setFrom("bow77@163.com");
        helper.setTo("coppco@qq.com");
        //第二个标签表示要解析为html标签
//        helper.setText("<html><head></head><body><h1>你好这个一个带图片的邮件</h1>" + "<a href=http://localhost:8080/web></a>" + "<img scr=" + "http://localhost:8080/web/codeAction_code" + " /></body></html>", true);


        helper.setText("<html><head></head><body><h1>你好这个一个带图片的邮件</h1>" + "<a href=http://localhost:8080/web>查看</a>" + "<img scr=cid:imageFile /></body></html>", true);

        //添加图片
        FileSystemResource resource = new FileSystemResource("/Users/apple/Downloads/WechatIMG4.png");
        helper.addInline("imageFile", resource);

        //添加附件
        FileSystemResource file = new FileSystemResource("/Users/apple/Downloads/Util-master.zip");
        helper.addAttachment("Util-master.zip", file);

        javaMailSender.send(message);
    }
}
