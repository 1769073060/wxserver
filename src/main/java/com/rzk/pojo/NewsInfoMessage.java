package com.rzk.pojo;



import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @PackageName : com.rzk.pojo
 * @FileName : NewsInfoMessage
 * @Description : 图文消息
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午1:03
 * @Version : v1.0
 */
@XmlRootElement(name = "xml")
public class NewsInfoMessage extends BaseMessage {
    @XmlElement(name = "ArticleCount")
    private String articleCount;
    @XmlElement(name = "Articles")
    private List<Articles> articles;

    public NewsInfoMessage() {
    }

    public NewsInfoMessage(Map<String, String> requestMap, List<Articles> articles) {
        super(requestMap);
        setMsgType("news");
        this.articleCount = articles.size()+"";
        this.articles = articles;
    }

    public String getArticleCount() {
        return articleCount;
    }
    @XmlTransient
    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return articles;
    }
    @XmlTransient
    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsInfoMessage{" +
                "articleCount='" + articleCount + '\'' +
                ", articles=" + articles +
                '}';
    }
}


