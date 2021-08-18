package cn.sj.service;

import cn.sj.entities.Payment;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/19 13:22
 */

public interface PaymentService {

    public int add(Payment payment);

    public Payment getPaymentById(Long id);
}
