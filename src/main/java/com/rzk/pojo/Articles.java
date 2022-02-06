package com.rzk.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : Articles
 * @Description :
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午1:13
 * @Version : v1.0
 */
public class Articles {

    @XmlElement(name = "item")
    private Item item;

    public Articles(Item item) {
        this.item = item;
    }

    public Articles() {
    }

    public Item getItem() {
        return item;
    }

    @XmlTransient
    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "item=" + item +
                '}';
    }
}
