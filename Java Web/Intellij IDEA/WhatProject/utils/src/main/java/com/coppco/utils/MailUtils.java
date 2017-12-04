package com.coppco.utils;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    public static void sendMail(String toAddr, String subject, String content) throws Exception {

        if (null == toAddr || null == subject || content == null || toAddr.length() == 0 || subject.length() == 0 || content.length() == 0) {
            return;
        }

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
        Address receiveAdd = new InternetAddress(toAddr);
        message.setRecipient(Message.RecipientType.TO, receiveAdd);

        //设置邮件正文
        message.setSubject(subject);
        message.setText(content);

        //保存邮件
        message.saveChanges();

        //得到发送邮件的火箭
        Transport transport = session.getTransport("smtp");

        //火箭连接服务器
        transport.connect("smtp.163.com", "bow77", "Junyin520");

        //火箭点火, 发送
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

        //关闭通道
        transport.close();
    }
}
