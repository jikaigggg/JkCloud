package com.jikaigg.jkcloud.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Preconditions;
import com.jikaigg.jkcloud.entities.CommonResult;
import com.jikaigg.jkcloud.entities.Payment;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

public class GsonTest01 {
    // 定义一个Payment对象
    Payment payment = new Payment(3L,"haha");

    // 定义一个Common
    CommonResult<Payment> commonResult = new CommonResult<Payment>(200,"成功",new Payment( 2L,"yaojikai"));

    // 定义json转对象字符串
    String str1 = "{\"id\":6,\"serial\":\"shimengyu\"}";
    String str2 = "{\"code\":200,\"message\":\"成功\",\"data\":{\"id\":2,\"serial\":\"yaojikai\"}}";

    // 创建Gson方式
    // 1、直接使用构造方法创建
    Gson gson = new Gson();
    // 2、使用GsonBuilder创建,相比直接使用构造方法，GsonBuilder创建的方式更灵活，因为它支持对Gson的配置
    Gson gsonb = new GsonBuilder().create();


    /**
     * 对象转json
     */
    @Test
    public void objectToJson() {
        String s1 = gsonb.toJson(payment);
        System.out.println("原始对象为:  " + payment);
        System.out.println("对象转成json为:  "+s1);

        String s2 = gsonb.toJson(commonResult);
        System.out.println("对象为:  "+commonResult);
        System.out.println("对象转成json为:  "+s2);
    }

    /**
     * json转对象
     */
    @Test
    public void jsonToObject(){
        Payment payment = gsonb.fromJson(str1, Payment.class);
        System.out.println("原始json为:" + str1);
        System.out.println("json转对象为:  " + payment);

        CommonResult<Payment> commonResult = gsonb.fromJson(str2,CommonResult.class);
        System.out.println("原始json为:" + str2);
        System.out.println("json转对象为:  " + commonResult);

    }
}
