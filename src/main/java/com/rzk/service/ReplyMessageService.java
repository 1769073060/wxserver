package com.rzk.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@Service
public class ReplyMessageService {

    private Logger logger = LoggerFactory.getLogger(ReplyMessageService.class);
    @Resource
    private IWxResourceService iWxResourceService;



    public BaseMessage replyTextMessage(Map<String, String> requestMap) {
        QueryWrapper<WxResource> queryWrapper = new QueryWrapper();
        StringBuffer stringBuffer = new StringBuffer();
        TextMessage textMessage = null;
        ImageMessage imageMessage = null;
        //用户发来的内容
        String msg = requestMap.get("Content");
        if (msg.equals("图文")){
            List<Articles> articles = new ArrayList<>();
            articles.add(new Articles(new Item("标题","介绍","https://images.cnblogs.com/cnblogs_com/rzkwz/1756659/t_20050309390594F9FC1EB9F4465A71DEFDC6BF42A866.jpg?a=1635065775599","http://www.ruizhukai.com")));
            NewsInfoMessage newsInfoMessage = new NewsInfoMessage(requestMap, articles);
            return newsInfoMessage;
        }
        /**
         * office2010
         */
        if (msg.equals("office2010")||msg.equals("Office2010")||msg.equals("office10")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office2010"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("office10二维码") ||
                msg.equals("office10版二维码")||
                msg.equals("office10图")||
                msg.equals("office2010二维码")||
                msg.equals("office2010版二维码")||
                msg.equals("office2010图")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office2010"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.OfficeMediaId2010);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * office2016
         */
        if (msg.equals("office2016")||msg.equals("Office2016")||msg.equals("office16")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office2016"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("office16二维码") ||
                msg.equals("office16版二维码")||
                msg.equals("office16图")||
                msg.equals("office2016二维码")||
                msg.equals("office2016版二维码")||
                msg.equals("office2016图")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office2016"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.OfficeMediaId2016);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * office2019
         */
        if (msg.equals("office2019")||msg.equals("Office2019")||msg.equals("office19")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("office19二维码") ||
                msg.equals("office19版二维码")||
                msg.equals("office19图")||
                msg.equals("office2019二维码")||
                msg.equals("office2019版二维码")||
                msg.equals("office2019图")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.OfficeMediaId2019);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * office365
         */
        if (msg.equals("office365")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office365"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("office365二维码") ||
                msg.equals("office19版二维码")||
                msg.equals("office365图")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "office365"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.OfficeMediaId365);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * Adobe2022全家桶
         */
        if (msg.equals("Adobe2022") ||
                msg.equals("adobe2022")||
                msg.equals("adobe2022全家桶")||
                msg.equals("Adobe2022全家桶")||
                msg.equals("adobe22")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2022"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("Adobe2022二维码") ||
                msg.equals("Adobe2022版二维码")||
                msg.equals("Adobe2022图")||
                msg.equals("adobe2022二维码") ||
                msg.equals("adobe2022版二维码")||
                msg.equals("adobe2022图")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2022"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaId2022);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * Adobe2019全家桶
         */
        if (msg.equals("Adobe2019") ||
                msg.equals("adobe2019")||
                msg.equals("adobe2019全家桶")||
                msg.equals("Adobe2019全家桶")||
                msg.equals("adobe19")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("Adobe2019二维码") ||
                msg.equals("Adobe2019版二维码")||
                msg.equals("Adobe2019图")||
                msg.equals("adobe2019二维码") ||
                msg.equals("adobe2019版二维码")||
                msg.equals("adobe2019图")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaId2019);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * Adobe2018mac全家桶
         */
        if (msg.equals("Adobe2018mac")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2018mac"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName()+"全家桶");
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("Adobe2018mac二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2018mac"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaId2018Mac);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * Adobe2019mac全家桶
         */
        if (msg.equals("Adobe2019mac")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2019mac"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName()+"全家桶");
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("Adobe2019mac二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "Adobe2019mac"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaId2019Mac);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC
         */
        if (msg.equals("PSCC")||msg.equals("psCC")||msg.equals("pscc")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PSCC二维码")||msg.equals("psCC二维码")||msg.equals("pscc二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPSCC);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC2022
         */
        if (msg.equals("PSCC2022")||msg.equals("psCC2022")||msg.equals("pscc2022")||msg.equals("PS2022")||msg.equals("ps2022")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2022"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PSCC2022二维码")||msg.equals("psCC2022二维码")||msg.equals("pscc2022二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2022"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPSCC2022);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC2020
         */
        if (msg.equals("PSCC2020")||msg.equals("psCC2020")||msg.equals("pscc2020")||msg.equals("ps2020")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2020"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PSCC2020二维码")||msg.equals("psCC2020二维码")||msg.equals("pscc2020二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2020"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPSCC2020);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC2019
         */
        if (msg.equals("PSCC2019")||msg.equals("psCC2019")||msg.equals("pscc2019")||msg.equals("ps2019")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PSCC2019二维码")||msg.equals("psCC2019二维码")||msg.equals("pscc2019二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPSCC2019);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC2018
         */
        if (msg.equals("PSCC2018")||msg.equals("psCC2018")||msg.equals("pscc2018")||msg.equals("ps2018")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2018"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PSCC2018二维码")||msg.equals("psCC2018二维码")||msg.equals("pscc2018二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2018"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPSCC2018);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC2015
         */
        if (msg.equals("PSCC2015")||msg.equals("psCC2015")||msg.equals("pscc2015")||msg.equals("ps2015")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2015"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PSCC2015二维码")||msg.equals("psCC2015二维码")||msg.equals("pscc2015二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2015"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPSCC2015);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC2014
         */
        if (msg.equals("PSCC2014")||msg.equals("psCC2014")||msg.equals("pscc2014")||msg.equals("ps2014")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2014"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PSCC2014二维码")||msg.equals("psCC2014二维码")||msg.equals("pscc2014二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePsCC2014"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPSCC2014);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * AdobePRCC
         */
        if (msg.equals("PRCC")||msg.equals("prCC")||msg.equals("prcc")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PRCC二维码")||msg.equals("prCC二维码")||msg.equals("prcc二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPRCC);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePRCC2022
         */
        if (msg.equals("PRCC2022")||msg.equals("prCC2022")||msg.equals("prcc2022")||msg.equals("PR2022")||msg.equals("pr2022")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2022"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PRCC2022二维码")||msg.equals("prCC2022二维码")||msg.equals("prcc2022二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2022"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPRCC2022);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePRCC2020
         */
        if (msg.equals("PRCC2020")||msg.equals("prCC2020")||msg.equals("prcc2020")||msg.equals("pr2020")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2020"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PRCC2020二维码")||msg.equals("prCC2020二维码")||msg.equals("prcc2020二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2020"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPRCC2020);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePRCC2019
         */
        if (msg.equals("PRCC2019")||msg.equals("prCC2019")||msg.equals("prcc2019")||msg.equals("pr2019")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PRCC2019二维码")||msg.equals("prCC2019二维码")||msg.equals("prcc2019二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2019"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPRCC2019);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePRCC2018
         */
        if (msg.equals("PRCC2018")||msg.equals("prCC2018")||msg.equals("prcc2018")||msg.equals("pr2018")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2018"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PRCC2018二维码")||msg.equals("prCC2018二维码")||msg.equals("prcc2018二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2018"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPRCC2018);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePRCC2015
         */
        if (msg.equals("PRCC2015")||msg.equals("prCC2015")||msg.equals("prcc2015")||msg.equals("pr2015")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2015"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PRCC2015二维码")||msg.equals("prCC2015二维码")||msg.equals("prcc2015二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2015"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPRCC2015);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        /**
         * AdobePSCC2014
         */
        if (msg.equals("PRCC2014")||msg.equals("prCC2014")||msg.equals("prcc2014")||msg.equals("pr2014")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2014"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getFileName());
                stringBuffer.append("链接:");
                stringBuffer.append(wxResource.getUrl());
                stringBuffer.append("提取码:");
                stringBuffer.append(wxResource.getFetchCode());
                textMessage = new TextMessage(requestMap, stringBuffer.toString());
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
            }
            return textMessage;
        }if (msg.equals("PRCC2014二维码")||msg.equals("prCC2014二维码")||msg.equals("prcc2014二维码")){
            WxResource wxResource = iWxResourceService.getOne(queryWrapper.eq("file_name", "AdobePrCC2014"));
            if (wxResource!=null){
                stringBuffer.append(wxResource.getQrCode());
                Image image = new Image();
                image.setMediaId(WxResourcesConsts.AdobeMediaIdPRCC2014);
                imageMessage = new ImageMessage(requestMap, image);
                logger.info("imageMessage{}:"+imageMessage);
            }else {
                textMessage = new TextMessage(requestMap, "该资源不存在,或已失效,可联系我补上该资源!");
                return textMessage;
            }
            logger.info("imageMessage{}:"+imageMessage);
            return imageMessage;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        else {
            stringBuffer.append("找不到该资源，关键字输入未匹配到或还未添加该资源");
            stringBuffer.append(",可参考：");
            stringBuffer.append("<a href=\"https://mp.weixin.qq.com/s?__biz=Mzk0MzMyMTI3Mg==&mid=2247483697&idx=1&sn=128c8d3b32a983390b3f402a017132b2&chksm=c334f8e6f44371f0caa1335ab7b15a5f199e57e649df2f490245d46853963dae4ef23d21421b#rd\">资源目录</a>");

            textMessage = new TextMessage(requestMap, stringBuffer.toString());
            logger.info("返回回复文本消息"+textMessage);
            return textMessage;
        }
    }

    public static String getVideoInfo(){
        com.alibaba.fastjson.JSONObject basicInfo = null;
        try {
            String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
            // 注意时区，否则容易出错
            StringBuilder payload = new StringBuilder();
            payload.append("{\"type\":");
            payload.append("\"");

            payload.append("image");
            payload.append("\"");
            payload.append(",\"offset\":1");
            payload.append(",\"count\":20");
            payload.append("}");

            System.out.println("payload======>"+payload.toString());


            //发送请求的URL
            StringBuffer url = new StringBuffer();
            url.append("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=");
            url.append("53_hcIKt5vg2MEGh6TYwLgCxMQ9atbUetC2So4yzKOzBNQC5kHZSIQ4NhOnNlJnLBeTvW-xklXGms86sAYc5errfUa_7Z3R5JDaBjEERV_N3ORV_0OOM_G2FZ0mlUTA5dH2XGfXxVbyUvEH1zXIQWBdAAAWCH");
            //使用帮助类HttpClients创建CloseableHttpClient对象
            CloseableHttpClient client = HttpClients.createDefault();
            //代理
            //HttpHost proxy = new HttpHost("10.19.108.2",8080);
            //HttpHost proxy = new HttpHost("120.79.7.36",80);

            //HTTP请求类型创建HttpPost实例
            HttpPost post = new HttpPost(url.toString());

            //开启代理
            //RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            //post.setConfig(config);
            CloseableHttpResponse response = null;
            //string是一个json字符串
            StringEntity params = new StringEntity(payload.toString(),"UTF-8");
            params.setContentType("application/json;charset=UTF-8");
            post.setEntity(params);
            try {
                //通过执行HttpPost请求获取CloseableHttpResponse实例 ,从此CloseableHttpResponse实例中获取状态码,错误信息,以及响应页面等等.
                response = client.execute(post);
                System.out.println("<=====================>==>"+response);

                HttpEntity entity = response.getEntity();
                System.out.println("<=====================>==>"+response);

                Header headers[] = response.getAllHeaders();
                int i = 0;

                while (i < headers.length) {
                    System.out.println("请求头部信息=====>"+headers[i].getName() + ":  " + headers[i].getValue());
                    i++;
                }
                String resData = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                System.out.println("<=====================>==>"+resData);

                com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(resData);

                EntityUtils.consume(entity);
            } catch (
                    UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return basicInfo.toString();
    }

}
