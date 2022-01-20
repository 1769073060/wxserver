package com.rzk.pojo;

import lombok.Data;

import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : ImageMessage
 * @Description : 图片消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:15
 * @Version : v1.0
 */

public class ImageMessage extends BaseMessage{

    private String mediaId;

    public ImageMessage(Map<String, String> requestMap, String mediaId) {
        super(requestMap);
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "ImageMessage{" +
                "mediaId='" + mediaId + '\'' +
                '}';
    }
}
