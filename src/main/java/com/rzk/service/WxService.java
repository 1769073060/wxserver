package com.rzk.service;

import com.rzk.consts.WxConsts;
import com.rzk.pojo.BaseMessage;
import com.rzk.util.BeanToXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @PackageName : com.rzk.service
 * @FileName : WxService
 * @Description : 用于处理所有的事件和消息的回复
 * @Author : rzk
 * @CreateTime : 19/1/2022 上午2:00
 * @Version : v1.0
 */
@Service
public class WxService {
    private Logger logger = LoggerFactory.getLogger(WxService.class);

    @Resource
    private ReplyMessageService replyMessageService;
    /**
     * 用于处理所有的事件和消息的回复
     * @param requestMap
     * @return
     */
    public String getResponse(Map<String, String> requestMap) {
        BaseMessage message = null;
        //接收到的用户消息只需要获取到消息类型即可
        String msgType = requestMap.get("MsgType");
        logger.info("消息类型{}:"+msgType);

        //根据自己所需要的场景进行 回复相对于的消息内容
        switch (msgType){
            // 文本消息
            case WxConsts.REQ_MESSAGE_TYPE_TEXT:
                logger.info("进入text");
                message = replyMessageService.replyTextMessage(requestMap);
                logger.info("进入text");
                break;
            case WxConsts.REQ_MESSAGE_TYPE_IMAGE:

                break;
            case WxConsts.REQ_MESSAGE_TYPE_VOICE:

                break;
            case WxConsts.REQ_MESSAGE_TYPE_VIDEO:

                break;
            case WxConsts.REQ_MESSAGE_TYPE_SHORT_VIDEO:

                break;

            case WxConsts.REQ_MESSAGE_TYPE_LOCATION:

                break;
            case WxConsts.REQ_MESSAGE_TYPE_LINK:

                break;
            // 事件推送
            case WxConsts.REQ_MESSAGE_TYPE_MSG_TYPE:
                message = replyMessageService.replyEventMessage(requestMap);
                break;
            default:
                break;
        }
        if (message!=null){
            logger.info("消息======>{}:"+message);
            logger.info("消息======>{}:"+BeanToXml.objToXml(message));
            return BeanToXml.objToXml(message);
        }

        return null;
    }


}