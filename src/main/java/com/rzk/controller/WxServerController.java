package com.rzk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rzk.config.RedisConfig;
import com.rzk.pojo.Token;
import com.rzk.util.HttpClient;
import com.rzk.util.HttpConstant;
import com.rzk.util.SignUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/wx/")
public class WxServerController {

    private Logger logger = LoggerFactory.getLogger(WxServerController.class);

    @Resource
    private Environment environment;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping(value = "validate")
    public String validate(String signature, String timestamp, String nonce, String echostr) {

        logger.info("参数{}:"+signature+"  "+timestamp+"  "+ nonce+"  "+echostr);
        logger.info("Token参数{}:"+environment.getProperty("wx.Token"));
        //排序
        String sort = SignUtil.sort(
                environment.getProperty("wx.Token"),
                timestamp,
                nonce);

        //加密
        String sha1 = SignUtil.sha1(sort);
        logger.info("sha1{}:"+sha1);
        logger.info("signature{}:"+signature);

        //检验签名
        if (sha1 != null && sha1 != "" && sha1.equals(signature)){
            logger.info("检验签名成功：{}"+sha1);
            return echostr;
        }else{
            logger.info("检验签名失败：{}");
            return null;
        }
    }


    @PostMapping(value = "validate" )
    public String validate(HttpServletRequest httpServletRequest) {
        logger.info("接收到的消息{}:"+httpServletRequest);
        return null;
    }

    @GetMapping(value = "accessToken")
    public String getAccessToken(){
        Token token = new Token();
        //如果不等于空 或者小于600秒
        if (redisTemplate.getExpire("expires_in")<600||redisTemplate.getExpire("expires_in")==null){

            //使用httpclient请求
            String result = HttpClient.doGetRequest(HttpConstant.API_URI.replace("APPID", environment.getProperty("wx.appid")).replace("APPSECRET", environment.getProperty("wx.secret")));

            //转成json对象
            JSONObject json = JSON.parseObject(result);
            System.out.println(json);
            token.setAccessToken(String.valueOf(json.get("access_token")));
            token.setExpiresIn((Integer) json.get("expires_in"));
            System.out.println(json.get("expires_in"));
            System.out.println(token.getExpiresIn());
            redisTemplate.opsForValue().set("accessToken",json.get("access_token"));
            redisTemplate.opsForValue().set("expiresIn",json.get("expires_in"),7200, TimeUnit.SECONDS);
        }
        String accessToken = redisTemplate.opsForValue().get("accessToken").toString();
        Long expiresIn = redisTemplate.getExpire("expiresIn");
        logger.info("accessToken{}:"+accessToken);
        logger.info("expiresIn{}:"+expiresIn);

        return token.getAccessToken();
    }



}
