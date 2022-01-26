package com.rzk.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : Item
 * @Description :
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午1:13
 * @Version : v1.0
 */
public class Item {
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "Description")
    private String description;
    @XmlElement(name = "PicUrl")
    private String picUrl;
    @XmlElement(name = "Url")
    private String url;

    public Item() {
    }

    public Item(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
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

    public String getPicUrl() {
        return picUrl;
    }
    @XmlTransient
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }
    @XmlTransient
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
