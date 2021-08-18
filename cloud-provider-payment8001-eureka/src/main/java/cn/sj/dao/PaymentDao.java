package cn.sj.dao;

import cn.sj.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:dao
 * @author: sj
 * @createDate: 2021/7/19 13:13
 */
@Mapper
public interface PaymentDao {

    public int add(Payment payment);

    public Payment getPaymentById(Long id);
}
