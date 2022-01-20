package com.rzk.pojo;

import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : VoiceMessage
 * @Description : 语音消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:19
 * @Version : v1.0
 */
public class VoiceMessage extends BaseMessage{

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public VoiceMessage(Map<String, String> requestMap, String mediaId) {
        super(requestMap);
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "VoiceMessage{" +
                "mediaId='" + mediaId + '\'' +
                '}';
    }
}
