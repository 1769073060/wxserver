package com.rzk.pojo;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : VoiceMessage
 * @Description : 语音消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:19
 * @Version : v1.0
 */
@XmlRootElement(name = "xml")
public class VoiceMessage extends BaseMessage{
    @XmlElement(name = "Voice")
    private Voice voice;

    public VoiceMessage() {

    }

    public VoiceMessage(Map<String, String> requestMap, Voice voice) {
        super(requestMap);
        setMsgType("voice");
        this.voice = voice;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @Override
    public String toString() {
        return "VoiceMessage{" +
                "voice=" + voice +
                '}';
    }
}
