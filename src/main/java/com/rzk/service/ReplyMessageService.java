package com.rzk.service;

import com.rzk.controller.WxServerController;
import com.rzk.pojo.BaseMessage;
import com.rzk.pojo.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @PackageName : com.rzk.service
 * @FileName : ReplyMessageService
 * @Description : 处理回复消息
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午1:50
 * @Version : v1.0
 */
@Service
public class ReplyMessageService {

    private Logger logger = LoggerFactory.getLogger(ReplyMessageService.class);

    public BaseMessage replyTextMessage(Map<String, String> requestMap) {
        logger.info("处理回复文本消息"+requestMap);
        TextMessage textMessage = new TextMessage(requestMap, "hh");
        logger.info("返回回复文本消息"+textMessage);
        return textMessage;
    }
}
