package com.rzk.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : Music
 * @Description :
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午12:49
 * @Version : v1.0
 */
public class Music {
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Description")
    private String description;
    @XmlElement(name = "MusicURL")
    private String musicURL;
    @XmlElement(name = "HQMusicUrl")
    private String hQMusicUrl;
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

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

    public String getMusicURL() {
        return musicURL;
    }
    @XmlTransient
    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    public String gethQMusicUrl() {
        return hQMusicUrl;
    }
    @XmlTransient
    public void sethQMusicUrl(String hQMusicUrl) {
        this.hQMusicUrl = hQMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }
    @XmlTransient
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public Music() {
    }

    public Music(String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId) {
        this.title = title;
        this.description = description;
        this.musicURL = musicURL;
        this.hQMusicUrl = hQMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", musicURL='" + musicURL + '\'' +
                ", hQMusicUrl='" + hQMusicUrl + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                '}';
    }
}
