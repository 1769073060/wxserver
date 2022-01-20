package com.rzk.pojo;

import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : MusicMessage
 * @Description : 音乐消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:25
 * @Version : v1.0
 */
public class MusicMessage extends BaseMessage{

    private String title;
    private String description;
    private String musicURL;
    private String hQMusicUrl;
    private String thumbMediaId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicURL() {
        return musicURL;
    }

    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    public String gethQMusicUrl() {
        return hQMusicUrl;
    }

    public void sethQMusicUrl(String hQMusicUrl) {
        this.hQMusicUrl = hQMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public MusicMessage(Map<String, String> requestMap, String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId) {
        super(requestMap);
        this.title = title;
        this.description = description;
        this.musicURL = musicURL;
        this.hQMusicUrl = hQMusicUrl;
        this.thumbMediaId = thumbMediaId;
        setMsgType("music");
    }

    @Override
    public String toString() {
        return "MusicMessage{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", musicURL='" + musicURL + '\'' +
                ", hQMusicUrl='" + hQMusicUrl + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                '}';
    }
}
