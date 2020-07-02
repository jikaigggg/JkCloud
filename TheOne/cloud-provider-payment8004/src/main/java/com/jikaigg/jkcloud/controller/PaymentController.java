package com.jikaigg.jkcloud.controller;

import com.jikaigg.jkcloud.entities.CommonResult;
import com.jikaigg.jkcloud.entities.Payment;
import com.jikaigg.jkcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+serverPort+ UUID.randomUUID().toString();
    }
}
