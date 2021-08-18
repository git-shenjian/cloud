package cn.sj.controller;

import cn.sj.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/6 12:29
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
/*
* 目前问题1 每个业务方法对应一个兜底的方法，代码膨胀
* 解决方法
* 1:1每个方法配置一个服务降级方法，技术上可以，但是不聪明
* 1:N除了个别重要核心业务有专属，其它普通的可以通过@DefaultProperties(defaultFallback = “”)统一跳转到统一处理结果页面
* 通用的和独享的各自分开，避免了代码膨胀，合理减少了代码量
*/
public class OrderHystrixController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_fallback"  //指定处理善后工作的方法
            ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500") //1.5s超时
    })
    String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_fallback(Integer id){
        return "线程池:  "+Thread.currentThread().getName()+" 80系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
