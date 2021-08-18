package cn.sj.controller;

import cn.sj.entities.CommonResult;
import cn.sj.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/20 13:09
 */
@RestController
@Slf4j
public class OrderController {
    //private static final String PAYMENT_URL="http://localhost:8001";//单机版
    private static final String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT";//集群版本,这个是服务提供者的应用名，spring.application.name
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/getforentity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        if(entity.getStatusCode().equals(HttpStatus.OK)){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/consumer/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//注册在eureka上的服务名称Application
        for (String service : services) {
            log.info("services----"+service);
        }
        //根据注册在eureka上的绝体服务名称，查询服务下的具体信息，如服务下有哪些具体的实列等
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-CONSUMER-ORDER");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return discoveryClient;
        //return restTemplate.getForObject(PAYMENT_URL+"/payment/discovery",Object.class);

    }
}
