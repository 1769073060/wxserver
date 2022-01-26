package com.rzk.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : Video
 * @Description :
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午12:57
 * @Version : v1.0
 */
public class Video {
    @XmlElement(name = "MediaId")
    private String mediaId;
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Description")
    private String description;

    public Video() {
    }

    public Video(String mediaId, String title, String description) {
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

    public String getMediaId() {
        return mediaId;
    }
    @XmlTransient
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }
    @XmlTransient
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    @XmlTransient
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Video{" +
                "mediaId='" + mediaId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
