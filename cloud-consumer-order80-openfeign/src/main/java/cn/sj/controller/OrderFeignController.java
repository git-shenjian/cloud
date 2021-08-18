package cn.sj.controller;

import cn.sj.entities.CommonResult;
import cn.sj.entities.Payment;
import cn.sj.service.PayMentService;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/4 14:06
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PayMentService payMentService;

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return payMentService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/openfeign/timeout")
    public String paymentOpenFeignForTimeOut(){
        //Openfeign默认等待1s钟
        return payMentService.paymentOpenFeignForTimeOut();
    }
}
