package marco.zlc.dabl.common.support.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/12 10:04
 *@修改人和其它信息消息   zlc  对消息队列和主体两种
 *  生产类，需要使用的时候直接注入即可。
 *  目前支持：字符串， 字符串集合， 对象， 对象集合的队列和主题
 */
@Service
public class MqProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;//注入java消息模板
    /**
     * 发送字符串消息队列
     *
     * @param queueName 队列名称
     * @param message   字符串
     */
    public void sendStringQueue(String queueName, String message) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), message);
    }


    /**
     * 发送字符串集合消息队列
     *
     * @param queueName 队列名称
     * @param list      字符串集合
     */
    public void sendStringListQueue(String queueName, List<String> list) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), list);
    }


    /**
     * 发送对象消息队列
     *
     * @param queueName 队列名称
     * @param obj       对象
     */
    public void sendObjQueue(String queueName, Serializable obj) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), obj);
    }


    /**
     * 发送对象集合消息队列
     *
     * @param queueName 队列名称
     * @param objList   对象集合
     */
    public void sendObjListQueue(String queueName, List<Serializable> objList) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), objList);
    }


    /**
     * 发送字符串消息主题
     *
     * @param topicName 主题名称
     * @param message   字符串
     */
    public void sendStringTopic(String topicName, String message) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(topicName), message);
    }


    /**
     * 发送字符串集合消息主题
     *
     * @param topicName 主题名称
     * @param list      字符串集合
     */
    public void sendStringListTopic(String topicName, List<String> list) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(topicName), list);
    }


    /**
     * 发送对象消息主题
     *
     * @param topicName 主题名称
     * @param obj       对象
     */
    public void sendObjTopic(String topicName, Serializable obj) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(topicName), obj);
    }


    /**
     * 发送对象集合消息主题
     *
     * @param topicName 主题名称
     * @param objList   对象集合
     */
    public void sendObjListTopic(String topicName, List<Serializable> objList) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(topicName), objList);
    }


}
