package cn.sj.service.impl;

import cn.sj.dao.PaymentDao;
import cn.sj.entities.Payment;
import cn.sj.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/19 13:23
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    public Payment getPaymentById(@PathVariable("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}
