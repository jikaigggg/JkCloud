package com.jikaigg.jkcloud.service;

import com.jikaigg.jkcloud.entities.Payment;

/*
* 订单service接口
* */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
