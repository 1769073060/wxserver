package com.rzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : TextMessage
 * @Description : 文本消息
 * @Author : rzk
 * @CreateTime : 19/1/2022 上午2:13
 * @Version : v1.0
 */
public class TextMessage extends BaseMessage{

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "content='" + content + '\'' +
                "toUserName='" + getToUserName() + '\'' +
                ", fromUserName='" + getFromUserName() + '\'' +
                ", createTime='" + getCreateTime() + '\'' +
                '}';
    }

    public TextMessage(Map<String,String> requestMap, String content) {
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }
}
