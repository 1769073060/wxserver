package com.rzk.pojo;

import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : VideoMessage
 * @Description : 视频消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:22
 * @Version : v1.0
 */
public class VideoMessage extends BaseMessage{

    private String mediaId;
    private String title;
    private String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

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


    public VideoMessage(Map<String, String> requestMap, String mediaId, String title, String description) {
        super(requestMap);
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
        setMsgType("video");
    }


    @Override
    public String toString() {
        return "VideoMessage{" +
                "mediaId='" + mediaId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
