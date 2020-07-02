package com.jikaigg.jkcloud.dao;

import com.jikaigg.jkcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
* 订单dao
* */
@Mapper
public interface PaymentDao {
    //创建订单
    int create(Payment payment);

    //根据id查询订单
    Payment getPaymentById(@Param("id")Long id);
}
