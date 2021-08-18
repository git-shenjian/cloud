package cn.sj.service;

import cn.sj.entities.CommonResult;
import cn.sj.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/4 14:03
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")  //使用openfeign ，指定eureka集群上注册的微服务名字
public interface PayMentService {

    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/openfeign/timeout")
    public String paymentOpenFeignForTimeOut();
}
