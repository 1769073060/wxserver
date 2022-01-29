package com.rzk.pojo;

import lombok.Data;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
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
    @XmlElement(name = "ToUserName")
    private String toUserName;
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    @XmlElement(name = "CreateTime")
    private String createTime;
    @XmlElement(name = "MsgType")
    private String msgType;

    public BaseMessage() {
    }

    public BaseMessage(Map<String,String> requestMap) {
        this.toUserName = requestMap.get(WxConsts.FromUserName);
        this.fromUserName = requestMap.get(WxConsts.ToUserName);
        this.createTime = System.currentTimeMillis()/1000+"";
    }

    public String getToUserName() {
        return toUserName;
    }
    @XmlTransient
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }
    @XmlTransient
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }
    @XmlTransient
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }
    @XmlTransient
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
