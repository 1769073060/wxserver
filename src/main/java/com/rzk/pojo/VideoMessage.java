package com.rzk.pojo;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : VideoMessage
 * @Description : 视频消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:22
 * @Version : v1.0
 */
@XmlRootElement(name = "xml")
public class VideoMessage extends BaseMessage{
    @XmlElement(name = "Video")
    private Video video;

    public VideoMessage() {

    }

    public VideoMessage(Map<String, String> requestMap, Video video) {
        super(requestMap);
        setMsgType("video");
        this.video = video;
    }

    public Video getVideo() {
        return video;
    }
    @XmlTransient
    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "VideoMessage{" +
                "video=" + video +
                '}';
    }
}
