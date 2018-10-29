package hello.distributedSystem.web.controller;

import hello.distributedSystem.common.utils.ActiveMQUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Colin
 * @Date: 2018/8/3 20:08
 */
@RestController
@CrossOrigin
public class QueueProducerTest2Controller {
    @Autowired
    private ActiveMQUtils activeMQUtils;

    @ApiOperation(value = "测试队列")
    @RequestMapping(value = "/topic/send/v2", method = RequestMethod.GET)
    public void sendTopic(){
        System.out.println("<<--------发送队列信息---------->>");
        activeMQUtils.sendMessage("topic","sd");
    }

}
