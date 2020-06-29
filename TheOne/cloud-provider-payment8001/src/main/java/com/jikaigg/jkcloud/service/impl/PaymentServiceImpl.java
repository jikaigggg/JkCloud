package com.jikaigg.jkcloud.service.impl;

import com.jikaigg.jkcloud.dao.PaymentDao;
import com.jikaigg.jkcloud.entities.Payment;
import com.jikaigg.jkcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
