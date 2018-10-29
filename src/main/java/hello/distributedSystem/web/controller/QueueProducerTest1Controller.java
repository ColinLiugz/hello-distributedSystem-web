package hello.distributedSystem.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: Colin
 * @Date: 2018/8/3 20:08
 */
@RestController
@CrossOrigin
public class QueueProducerTest1Controller {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @ApiOperation(value = "测试队列之topic")
    @RequestMapping(value = "/topic/send", method = RequestMethod.GET)
    public void sendTopic(){
        System.out.println("<<--------发送队列信息---------->>");
        jmsMessagingTemplate.convertAndSend(this.topic,"一对多!");
    }

    @ApiOperation(value = "测试队列之queue")
    @RequestMapping(value = "/queue/send", method = RequestMethod.GET)
    public void sendQueue(){
        System.out.println("<<--------发送队列信息---------->>");
        jmsMessagingTemplate.convertAndSend(this.queue,"点对点!");
    }
}
