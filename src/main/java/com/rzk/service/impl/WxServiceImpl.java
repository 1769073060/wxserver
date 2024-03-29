package com.rzk.service.impl;

import com.rzk.consts.WxConsts;
import com.rzk.pojo.BaseMessage;
import com.rzk.service.IReplyMessageService;
import com.rzk.service.ITbTaoZheKouMessageService;
import com.rzk.service.IWxService;
import com.rzk.util.BeanToXml;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class WxServiceImpl implements IWxService {
    private Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);

    @Resource
    private IReplyMessageService iReplyMessageService;
    @Resource
    private ITbTaoZheKouMessageService iTbTaoZheKouMessageService;


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
                String msg = requestMap.get("Content");
                String substring = msg.substring(0, 2);

                //取出商品id，发送httpclient请求

                if (substring.equals("ht")){
                    message = iTbTaoZheKouMessageService.replyTbZheKouMessage(requestMap);
                    break;
                }else {
                    message = iReplyMessageService.replyTextMessage(requestMap);
                    logger.info("进入text");
                    break;
                }


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
                message = iReplyMessageService.replyEventMessage(requestMap);
                break;
            //            // 事件推送
//            else if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_EVENT)) {
//                // 事件类型
//                String eventType = (String) requestMap.get(WxConsts.Event);
//                // 关注
//                if (eventType.equals(WxConsts.EVENT_TYPE_SUBSCRIBE)) {
//                    respContent = "谢谢您的关注！";
//                    respXml = MsgUtil.sendTextMsg(requestMap, respContent);
//                }
//                // 取消关注
//                else if (eventType.equals(WxConsts.EVENT_TYPE_UNSUBSCRIBE)) {
//                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
//                }
//                // 扫描带参数二维码
//                else if (eventType.equals(WxConsts.EVENT_TYPE_SCAN)) {
//                    // TODO 处理扫描带参数二维码事件
//                }
//                // 上报地理位置
//                else if (eventType.equals(WxConsts.EVENT_TYPE_LOCATION)) {
//                    // TODO 处理上报地理位置事件
//                }
//                // 自定义菜单
//                else if (eventType.equals(WxConsts.EVENT_TYPE_CLICK)) {
//                    // TODO 处理菜单点击事件
//                }
//            }
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