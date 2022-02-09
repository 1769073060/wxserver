package com.rzk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rzk.consts.WxConsts;
import com.rzk.consts.WxResourcesConsts;
import com.rzk.pojo.*;
import com.rzk.mapper.WxResourceMapper;
import com.rzk.service.IReplyMessageService;
import com.rzk.service.IWxResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rzk
 * @since 2022-02-02
 */
@Service
public class WxResourceServiceImpl extends ServiceImpl<WxResourceMapper, WxResource> implements IWxResourceService  {

}
