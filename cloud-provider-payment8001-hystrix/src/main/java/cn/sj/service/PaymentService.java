package cn.sj.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/5 13:39
 */
@Service
public class PaymentService {

    /*服务降级开始===========*/
    public String paymentInfo_OK(Integer id)
    {
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_fallback"  //指定处理善后工作的方法
            ,commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000") //3s超时
    })
    public String paymentInfo_TimeOut(Integer id)
    {
        try { TimeUnit.MILLISECONDS.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): 3";
    }

    public String paymentInfo_fallback(Integer id){
        return "线程池:  "+Thread.currentThread().getName()+" 系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
    }
    /*服务降级结束===========*/

    /*服务熔断开始===========*/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启服务熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "20"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 快照时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")// 失败率达到多少后跳闸
            /*涉及到断路器的三个重要参数：
            快照时间窗：断路器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近的10秒。
            请求总数阀值：在快照时间窗内，必须满足请求总数阀值才有资格熔断。默认为20，意味着在10秒内，如果该hystrix命令的调用次数不足20次,即使所有的请求都超时或其他原因失败，断路器都不会打开。
            错误百分比阀值：当请求总数在快照时间窗内超过了阀值，比如发生了30次调用，如果在这30次调用中，有15次发生了超时异常，也就是超过50%的错误百分比，在默认设定50%阀值情况下，这时候就会将断路器打开。*/
            /*服务熔断流程：服务降级-》服务熔断-》恢复服务调用*/
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
    /*服务熔断结束===========*/
}
