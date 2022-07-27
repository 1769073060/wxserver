package com.rzk.service.impl;

import com.rzk.service.IRzkVerificationCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class RzkVerificationCodeServiceImpl implements IRzkVerificationCodeService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public int verificationCode() {
        //判断是否为空
        if (redisTemplate.getExpire("expires_in")<60||redisTemplate.getExpire("expires_in")==null) {
            int verification = (int) ((Math.random() * 9 + 1) * 100000);
            redisTemplate.opsForValue().set("huoduan_wechatfans",verification);
        }
            return 0;
    }

    public static void main(String[] args) {
        String s = "a:7:{s:11:\"wechat_name\";s:15:\"睿共享资源\";s:14:\"wechat_account\";s:7:\"ruigxzy\";s:14:\"wechat_keyword\";s:15:\"微信验证码\";s:11:\"wechat_code\";s:6:\"985698\";s:12:\"wechat_qrimg\";s:84:\"https://www.rzkai.com/wordpress/%22wp-content/uploads%22/2022/07/ruigxzy-290x300.jpg\";s:10:\"wechat_day\";s:1:\"1\";s:10:\"wechat_key\";s:32:\"19b030f46adc23d2ae8bd7b652b0d14c\";}";
        int indexOf = s.indexOf("s:6:");
        System.out.println(indexOf);
        String s1 = s.substring(indexOf+5, indexOf +5 + 6);
        s = s.replace(s1, "333333");
        System.out.println(s1);
        System.out.println(s);
    }
}
