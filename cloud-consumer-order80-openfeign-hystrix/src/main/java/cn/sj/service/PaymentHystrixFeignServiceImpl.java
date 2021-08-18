package cn.sj.service;

import org.springframework.stereotype.Component;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/9 13:38
 */
@Component
public class PaymentHystrixFeignServiceImpl implements PaymentFeignService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "fallback-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "fallback-paymentInfo_TimeOut";
    }
}
