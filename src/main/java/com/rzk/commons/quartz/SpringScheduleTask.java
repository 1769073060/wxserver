package com.rzk.commons.quartz;

import com.rzk.controller.WxServerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @PackageName : com.rzk.commons.quartz
 * @FileName : SpringScheduleTask
 * @Description : wxToken定时器
 * @Author : rzk
 * @CreateTime : 14/2/2022 上午3:28
 * @Version : v1.0
 */
@Component
@EnableScheduling
public class SpringScheduleTask {

    private Logger logger = LoggerFactory.getLogger(SpringScheduleTask.class);


    @Resource
    private WxServerController wxServerController;

    /**
     * 每两小时执行一次
     */
    @Scheduled(cron = "0 0 0/2 * * ?")
    public void WxTokenTimer(){
        String accessToken = wxServerController.getAccessToken();
        logger.info("执行检查wxtoken{}:\n"+accessToken);
    }
}
