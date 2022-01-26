package com.rzk.pojo;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : ImageMessage
 * @Description : 图片消息
 * @Author : rzk
 * @CreateTime : 21/1/2022 上午2:15
 * @Version : v1.0
 */
@XmlRootElement(name = "xml")
public class ImageMessage extends BaseMessage{
    @XmlElement(name = "Image")
    private Image image;

    public Image getImage() {
        return image;
    }

    @XmlTransient
    public void setImage(Image image) {
        this.image = image;
    }

    public ImageMessage() {
    }


    public ImageMessage(Map<String, String> requestMap, Image image) {
        super(requestMap);
        setMsgType("image");
        this.image = image;
    }

    @Override
    public String toString() {
        return "ImageMessage{" +
                "image=" + image +
                '}';
    }
}
