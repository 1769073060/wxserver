package com.rzk.service;

import java.util.Map;

/**
 * @PackageName : com.rzk.service
 * @FileName : WxService
 * @Description :
 * @Author : rzk
 * @CreateTime : 19/1/2022 上午2:00
 * @Version : v1.0
 */
public class WxService {

    /**
     * 用于处理所有的事件和消息的回复
     * @param requestMap
     * @return
     */
    public static String getResponse(Map<String, String> requestMap) {
        String msgType = requestMap.get("MsgType");
        switch (msgType){
            case "text":

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
        return null;
    }
}
