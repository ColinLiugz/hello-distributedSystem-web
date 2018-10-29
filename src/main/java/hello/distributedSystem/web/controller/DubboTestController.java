package hello.distributedSystem.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import hello.distributedSystem.web.aop.ParamCheck;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.HelloDubboFacade;

/**
 * @Author: Colin
 * @Date: 2018/8/5 22:23
 */
@RestController
@CrossOrigin
public class DubboTestController {

    @Reference(version = "1.0.0")
    private HelloDubboFacade helloDubboFacade;

    @ApiOperation(value = "测试dubbo")
    @RequestMapping(value = "/testDubbo", method = RequestMethod.GET)
    public String testDubbo(){
        return helloDubboFacade.sayHello("dubbo");
    }

    @ApiOperation(value = "测试自定义注解")
    @RequestMapping(value = "/testAop", method = RequestMethod.GET)
    @ParamCheck(isNull = "name,id")
    public String testAop(String name,Integer id){
        return "ok";
    }
}
