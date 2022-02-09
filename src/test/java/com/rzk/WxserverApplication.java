package com.rzk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rzk.pojo.Articles;
import com.rzk.pojo.Item;
import com.rzk.pojo.NewsInfoMessage;
import com.rzk.util.BeanToXml;
import com.rzk.util.HttpClient;
import com.rzk.util.HttpConstant;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class WxserverApplication {
    private Logger logger = LoggerFactory.getLogger(WxserverApplication.class);
//<xml>
//    <ToUserName>gh_f7eda2057df2</ToUserName>
//    <FromUserName>ouE4K6_PtzNblcwMQ8sEkw9CWy5A</FromUserName>
//    <CreateTime>1643048741</CreateTime>
//    <MsgType>text</MsgType>
//    <Content>hh</Content>
//</xml>
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void xmlTest() throws JAXBException {
        //payload======>{"FileIds":image,"offset":OFFSET,"count":COUNT}

//        String videoInfo = ReplyMessageService.getVideoInfo();
//        System.out.println(videoInfo);

        String charset = "utf-8";
        StringBuffer buffer = new StringBuffer();
        buffer.append("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=");
        buffer.append("53_-e-ZmPiNoI0jTYOslnpqP29YR6j45VAlqBc0DC0dUH6oGaB6ZueBaxXf9O8IDkdzByWLaon7ANjaKpPSEoaf47puYGoSXiqymN4k_Ifd_AhMZPRZ1qsPTGm8-8kQ6FPY3bhiao5Iabtz9LgaVHKbAHALXA");
        Map<String,String> createMap = new HashMap<String,String>();

            String httpOrgCreateTestRtn = HttpClient.doPost(buffer.toString(),createMap,charset);
            System.out.println("result:"+httpOrgCreateTestRtn);


        Map<String,String> map = new HashMap<>();
        ArrayList<Articles> arrayList = new ArrayList<>();
        Articles articles = new Articles();
        map.put("ToUserName","to");
        map.put("FromUserName","from");
        map.put("MsgType","type");


        Item item1 = new Item("英语", "1", "http://", "http://");
        Item item2 = new Item("数学", "2", "http://", "http://");
        Item item3 = new Item("政治", "3", "http://", "http://");
        articles.setItem(item1);
        articles.setItem(item2);
        articles.setItem(item3);
        arrayList.add(articles);
        NewsInfoMessage message1 = new NewsInfoMessage(map,arrayList);
        System.out.println("打印iTem===>{}"+message1);
        System.out.println("打印iTem===>{}"+BeanToXml.convertToXml(message1));
//        JAXBContext jaxbContext = JAXBContext.newInstance(TextMessage.class);
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        StringWriter writer = new StringWriter();
//
//        marshaller.marshal(message,writer);
    }
    @Test
    void contextLoads() {
//        System.out.println(redisTemplate.getExpire("expiresIn"));
//        String accessToken = redisTemplate.opsForValue().get("accessToken").toString();
//        String expiresIn = redisTemplate.getExpire("expiresIn").toString();
//        System.out.println(accessToken);
//        System.out.println(expiresIn);
//        System.out.println("accessToken{}:"+redisTemplate.opsForValue().get("accessToken"));
//        System.out.println("expiresIn{}:"+redisTemplate.opsForValue().get("expiresIn"));

        //使用httpclient请求
        String result = HttpClient.doGetRequest(HttpConstant.API_URI.replace("APPID", "wx9b012c8a72024068").replace("APPSECRET", "0546d6d0bd51348b77a9b831518688db"));

        //转成json对象
        JSONObject json = JSON.parseObject(result);
        System.out.println(json);
        redisTemplate.opsForValue().set("accessToken",json.get("access_token"));
        redisTemplate.opsForValue().set("expiresIn",json.get("expires_in"),7200, TimeUnit.SECONDS);
        System.out.println(json.get("access_token"));
        System.out.println(json.get("expires_in"));

//        ValueOperations<String, Object> value =
//                redisTemplate.opsForValue();
//        value.set("b3","3");
//        System.out.println(value.get("b2"));
    }

}
