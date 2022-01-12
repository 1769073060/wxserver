package com.rzk.controller;


import com.rzk.util.SignUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController
@RequestMapping("/wx/")
public class WxServerController {

    private Logger logger = LoggerFactory.getLogger(WxServerController.class);

    @Resource
    private SignUtil signUtil;
    @Resource
    private Environment environment;

    /**
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping("validate")
    public String validate(String signature, String timestamp, String nonce, String echostr) {

        logger.info("参数{}:"+signature+"  "+timestamp+"  "+ nonce+"  "+echostr);
        logger.info("Token参数{}:"+environment.getProperty("wx.Token"));
        //排序
        String sort = signUtil.sort(
                environment.getProperty("wx.Token"),
                timestamp,
                nonce);
        //加密
        String sha1 = signUtil.sha1(sort);

        //检验签名
        if (sha1 != null && sha1 != "" && sha1.equals(signature)){
            logger.info("检验签名成功：{}"+sha1);
            return timestamp;
        }else{
            logger.info("检验签名失败：{}");
            return null;
        }
    }


}
