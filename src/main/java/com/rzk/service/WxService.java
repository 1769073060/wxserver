package com.rzk.service;

import com.rzk.pojo.BaseMessage;
import com.rzk.util.BeanToXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        String msgType = requestMap.get("MsgType");
        logger.info("消息类型{}:"+msgType);

        //根据自己所需要的场景进行 回复相对于的消息内容
        switch (msgType){
            case "text":
                logger.info("进入text");
                message = replyMessageService.replyTextMessage(requestMap);
                logger.info("进入text");
                break;
            case "image":

                break;
            case "voice":

                break;
            case "video":

                break;
            case "shortvideo":

                break;

            case "location":

                break;
            case "link":

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
