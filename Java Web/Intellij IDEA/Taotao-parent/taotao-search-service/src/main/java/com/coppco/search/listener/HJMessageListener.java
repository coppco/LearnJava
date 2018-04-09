package com.coppco.search.listener;

        import javax.jms.JMSException;
        import javax.jms.Message;
        import javax.jms.MessageListener;
        import javax.jms.TextMessage;

public class HJMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            //取消息内容
            String text = textMessage.getText();
            System.out.println(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
