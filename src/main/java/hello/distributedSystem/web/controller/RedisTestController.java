package hello.distributedSystem.web.controller;

import hello.distributedSystem.common.redis.RedisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Colin
 * @Date: 2018/10/23 21:14
 */
@RestController
@CrossOrigin//处理跨域
public class RedisTestController {

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "测试redis")
    @RequestMapping(value = "/test/redis", method = RequestMethod.GET)
    public void set(String key,String value){
        redisService.set(key,value);
        System.out.println("<<--------写入redis---------->>");
    }
}
