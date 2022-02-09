package com.rzk.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rzk.consts.WxConsts;
import com.rzk.consts.WxResourcesConsts;
import com.rzk.controller.WxServerController;
import com.rzk.pojo.*;
import com.rzk.service.impl.WxResourceServiceImpl;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @PackageName : com.rzk.service
 * @FileName : ReplyMessageService
 * @Description : 处理回复消息
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午1:50
 * @Version : v1.0
 */
public interface IReplyMessageService {


    public BaseMessage replyTextMessage(Map<String, String> requestMap);

    public String getVideoInfo();

    public BaseMessage replyEventMessage(Map<String, String> requestMap);
}
