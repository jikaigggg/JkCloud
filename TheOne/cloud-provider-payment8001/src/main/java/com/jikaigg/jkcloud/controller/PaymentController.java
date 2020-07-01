package com.jikaigg.jkcloud.controller;

import com.jikaigg.jkcloud.entities.CommonResult;
import com.jikaigg.jkcloud.entities.Payment;
import com.jikaigg.jkcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果：{}",result);
        if (result > 0 ){
            return new CommonResult(200,"插入数据库成功"+serverPort,result);
        }else {
            return new CommonResult<>(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果：{}",payment);
        if (payment != null ){
            return new CommonResult(200,"查询数据库成功"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询"+id+"失败",null);
        }
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        /*获取已注册的服务列表
        2020-07-01 23:52:36.251  INFO 7218 --- [nio-8001-exec-1] c.j.j.controller.PaymentController       : 服务有：cloud-payment-service
        2020-07-01 23:52:36.252  INFO 7218 --- [nio-8001-exec-1] c.j.j.controller.PaymentController       : 服务有：cloud-order-service
        */

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务有：{}" ,service);
        }
        /*
        获取实例信息
        2020-07-01 23:52:36.256  INFO 7218 --- [nio-8001-exec-1] c.j.j.controller.PaymentController       : serviceId:payment8001,serviceHost:192.168.1.5,servicePort:8001,serviceUri:http://192.168.1.5:8001
        2020-07-01 23:52:36.256  INFO 7218 --- [nio-8001-exec-1] c.j.j.controller.PaymentController       : serviceId:payment8002,serviceHost:192.168.1.5,servicePort:8002,serviceUri:http://192.168.1.5:8002
         */
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("serviceId:{},serviceHost:{},servicePort:{},serviceUri:{}",
                    instance.getInstanceId(),
                    instance.getHost(),
                    instance.getPort(),
                    instance.getUri());
        }
        return this.discoveryClient;
    }
}
