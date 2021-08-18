package cn.sj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/6 12:26
 */
@Service
//fallback = PaymentHystrixFeignServiceImpl.class 配置文件需要配置feign.hystrix.enabled=true
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX",fallback = PaymentHystrixFeignServiceImpl.class)
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
