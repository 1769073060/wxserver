package com.rzk.pojo;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : Voice
 * @Description :
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午12:54
 * @Version : v1.0
 */
public class Voice {
    @XmlElement(name = "MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }
    @XmlTransient
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }


    public Voice() {
    }

    public Voice(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "Voice{" +
                "mediaId='" + mediaId + '\'' +
                '}';
    }
}
