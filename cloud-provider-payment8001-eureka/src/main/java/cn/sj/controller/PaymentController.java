package cn.sj.controller;

import cn.sj.entities.CommonResult;
import cn.sj.entities.Payment;
import cn.sj.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/19 13:30
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/add")
    /*
    * @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的);GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。
    * */
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("查询结果{}",result);
        if(result>0){
            return new CommonResult(200,"新增成功,serverport="+serverport,result);
        }else{
            return new CommonResult(400,"新增失败",null);
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果{}",payment+"测试热部署");
        if(payment!=null){
            return new CommonResult(200,"查询成功,serverport="+serverport,payment);
        }else{
            return new CommonResult(400,"查询失败",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//注册在eureka上的服务名称Application
        for (String service : services) {
            log.info("services----"+service);
        }
        //根据注册在eureka上的绝体服务名称，查询服务下的具体信息，如服务下有哪些具体的实列等
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping("/payment/openfeign/timeout")
    public String paymentOpenFeignForTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverport;
    }

    @GetMapping("/payment/lb")
    public String lb(){
        return serverport;
    }
}
