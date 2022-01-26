package com.rzk.pojo;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : MusicMessage
 * @Description : 音乐消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:25
 * @Version : v1.0
 */
@XmlRootElement(name = "xml")
public class MusicMessage extends BaseMessage{

    @XmlElement(name = "Music")
    private Music music;

    public Music getMusic() {
        return music;
    }

    @XmlTransient
    public void setMusic(Music music) {
        this.music = music;
    }

    public MusicMessage() {

    }

    public MusicMessage(Map<String, String> requestMap, Music music) {
        super(requestMap);
        setMsgType("music");
        this.music = music;
    }

    @Override
    public String toString() {
        return "MusicMessage{" +
                "music=" + music +
                '}';
    }
}
