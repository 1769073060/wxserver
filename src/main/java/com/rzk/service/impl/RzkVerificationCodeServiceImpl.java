package com.rzk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rzk.pojo.WpOptions;
import com.rzk.service.IRzkVerificationCodeService;
import com.rzk.service.IWpOptionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RzkVerificationCodeServiceImpl implements IRzkVerificationCodeService {
    private Logger logger = LoggerFactory.getLogger(RzkVerificationCodeServiceImpl.class);
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private WpOptionService wpOptionService;

    @Override
    public String verificationCode() {
        QueryWrapper queryWrapper = new QueryWrapper<WpOptions>();
        //判断是否为空
        if (redisTemplate.getExpire("huoduan_wechatfans_expire")<60||redisTemplate.getExpire("huoduan_wechatfans_expire")==null) {
            //生成6位数的验证码
            int verification = (int) ((Math.random() * 9 + 1) * 100000);
            queryWrapper.eq("option_name","huoduan_wechatfans");
            WpOptions wpOptions = wpOptionService.getOne(queryWrapper);
            String wechatFans = wpOptions.getOptionValue();

            int indexOf = wechatFans.indexOf("s:6:");
            System.out.println(indexOf);
            String s1 = wechatFans.substring(indexOf+5, indexOf +5 + 6);
            wechatFans = wechatFans.replace(s1, String.valueOf(verification));
            System.out.println(s1);
            System.out.println(wechatFans);

            wpOptions.setOptionValue(wechatFans);
            wpOptionService.updateById(wpOptions);
            redisTemplate.opsForValue().set("huoduan_wechatfans",verification);
            redisTemplate.opsForValue().set("huoduan_wechatfans_expire",verification,7200, TimeUnit.SECONDS);
        }
        String wechatfans = redisTemplate.opsForValue().get("huoduan_wechatfans").toString();
        Long wechatfans_expire = redisTemplate.getExpire("huoduan_wechatfans_expire");
        logger.info("wechatfans{}:"+wechatfans);
        logger.info("wechatfans_expire{}:"+wechatfans_expire);

        return wechatfans;

    }

    public static void main(String[] args) {
        String s = "a:7:{s:11:\"wechat_name\";s:15:\"睿共享资源\";s:14:\"wechat_account\";s:7:\"ruigxzy\";s:14:\"wechat_keyword\";s:15:\"微信验证码\";s:11:\"wechat_code\";s:6:\"985698\";s:12:\"wechat_qrimg\";s:84:\"https://www.rzkai.com/wordpress/%22wp-content/uploads%22/2022/07/ruigxzy-290x300.jpg\";s:10:\"wechat_day\";s:1:\"1\";s:10:\"wechat_key\";s:32:\"19b030f46adc23d2ae8bd7b652b0d14c\";}";

    }
}
