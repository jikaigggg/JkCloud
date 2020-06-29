package com.jikaigg.jkcloud.controller;

import com.jikaigg.jkcloud.entities.CommonResult;
import com.jikaigg.jkcloud.entities.Payment;
import com.jikaigg.jkcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果：{}",result);
        if (result > 0 ){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult<>(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果：{}",payment);
        if (payment != null ){
            return new CommonResult(200,"查询数据库成功",payment);
        }else {
            return new CommonResult(444,"查询"+id+"失败",null);
        }
    }
}
