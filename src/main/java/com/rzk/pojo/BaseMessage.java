package com.rzk.pojo;

import lombok.Data;

import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : BaseMessage
 * @Description : 父类消息体
 * @Author : rzk
 * @CreateTime : 19/1/2022 上午2:08
 * @Version : v1.0
 */
@Data
public class BaseMessage {
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType;

    public BaseMessage(Map<String,String> requestMap) {
        this.toUserName = requestMap.get("ToUserName");
        this.fromUserName = requestMap.get("FromUserName");
        this.createTime = System.currentTimeMillis()/1000+"";
    }


}
