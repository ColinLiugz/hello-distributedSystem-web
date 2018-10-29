package hello.distributedSystem.web.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Colin
 * @Date: 2018/8/15 13:37
 * 进行参数判空
 */
@Aspect
@Component
public class ParamCheckAop {

    @Before(value = "@annotation(paramCheck)")
    public void checkParam(ParamCheck paramCheck){
        System.out.println("注解被使用");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String[] parameters = paramCheck.isNull().split(",");
        for(String parameter : parameters){
            if(StringUtils.isEmpty(request.getParameter(parameter))){
                try {
                    throw new Exception("参数不能为空！！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}
