package com.rzk.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : TextMessage
 * @Description : 文本消息
 * @Author : rzk
 * @CreateTime : 19/1/2022 上午2:13
 * @Version : v1.0
 */
@XmlRootElement(name = "xml")
public class TextMessage extends BaseMessage{
    @XmlElement(name = "Content")
    private String content;

    public String getContent() {
        return content;
    }
    @XmlTransient
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
    public TextMessage() {
    }
    public TextMessage(Map<String,String> requestMap, String content) {
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }
}
