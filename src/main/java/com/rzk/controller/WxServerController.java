package com.rzk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rzk.consts.WxConsts;
import com.rzk.pojo.Token;
import com.rzk.service.WxService;
import com.rzk.util.HttpClient;
import com.rzk.util.HttpConstant;
import com.rzk.util.MsgUtil;
import com.rzk.util.SignUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/wx/")
public class WxServerController {

    private Logger logger = LoggerFactory.getLogger(WxServerController.class);

    @Resource
    private Environment environment;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping(value = "validate")
    public String validate(String signature, String timestamp, String nonce, String echostr) {

        logger.info("参数{}:"+signature+"  "+timestamp+"  "+ nonce+"  "+echostr);
        logger.info("Token参数{}:"+environment.getProperty("wx.Token"));
        //排序
        String sort = SignUtil.sort(
                environment.getProperty("wx.Token"),
                timestamp,
                nonce);

        //加密
        String sha1 = SignUtil.sha1(sort);
        logger.info("sha1{}:"+sha1);
        logger.info("signature{}:"+signature);

        //检验签名
        if (sha1 != null && sha1 != "" && sha1.equals(signature)){
            logger.info("检验签名成功：{}"+sha1);
            return echostr;
        }else{
            logger.info("检验签名失败：{}");
            return null;
        }
    }

    @PostMapping(value = "validate" )
    public String validate(HttpServletRequest httpServletRequest) {
        logger.info("接收到的消息{}:"+httpServletRequest);
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent;
        try {
            // 调用parseXml方法解析请求消息
            Map<String,String> requestMap = MsgUtil.parseXml(httpServletRequest);
            WxService.getResponse(requestMap);
            // 消息类型
            String msgType = (String) requestMap.get(WxConsts.MsgType);
            String mes = null;

            return respXml;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @PutMapping(value = "validate" )
    public String validate(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("接收到的消息{}:"+httpServletRequest);
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent;
        try {
            // 调用parseXml方法解析请求消息
            Map<String,String> requestMap = MsgUtil.parseXml(httpServletRequest);
            // 消息类型
            String msgType = (String) requestMap.get(WxConsts.MsgType);
            String mes = null;
            // 文本消息
            if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_TEXT)) {
                mes =requestMap.get(WxConsts.Content).toString();
                if(mes!=null&&mes.length()<2){
                    /**
                    List<ArticleItem> items = new ArrayList<>();
                    ArticleItem item = new ArticleItem();
                    item.setTitle("照片墙");
                    item.setDescription("阿狸照片墙");
                    item.setPicUrl("http://changhaiwx.pagekite.me/photo-wall/a/iali11.jpg");
                    item.setUrl("http://changhaiwx.pagekite.me/page/photowall");
                    items.add(item);

                    item = new ArticleItem();
                    item.setTitle("哈哈");
                    item.setDescription("一张照片");
                    item.setPicUrl("http://changhaiwx.pagekite.me/images/me.jpg");
                    item.setUrl("http://changhaiwx.pagekite.me/page/index");
                    items.add(item);

                    item = new ArticleItem();
                    item.setTitle("小游戏2048");
                    item.setDescription("小游戏2048");
                    item.setPicUrl("http://changhaiwx.pagekite.me/images/2048.jpg");
                    item.setUrl("http://changhaiwx.pagekite.me/page/game2048");
                    items.add(item);

                    item = new ArticleItem();
                    item.setTitle("百度");
                    item.setDescription("百度一下");
                    item.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505100912368&di=69c2ba796aa2afd9a4608e213bf695fb&imgtype=0&src=http%3A%2F%2Ftx.haiqq.com%2Fuploads%2Fallimg%2F170510%2F0634355517-9.jpg");
                    item.setUrl("http://www.baidu.com");
                    items.add(item);

                    respXml = MsgUtil.sendArticleMsg(requestMap, items);
                     **/
                }else if("我的信息".equals(mes)){
                    /**
                    Map<String, String> userInfo = getUserInfo(requestMap.get(WxConsts.FromUserName));
                    System.out.println(userInfo.toString());
                    String nickname = userInfo.get("nickname");
                    String city = userInfo.get("city");
                    String province = userInfo.get("province");
                    String country = userInfo.get("country");
                    String headimgurl = userInfo.get("headimgurl");
                    List<ArticleItem> items = new ArrayList<>();
                    ArticleItem item = new ArticleItem();
                    item.setTitle("你的信息");
                    item.setDescription("昵称:"+nickname+" 地址:"+country+" "+province+" "+city);
                    item.setPicUrl(headimgurl);
                    item.setUrl("http://www.baidu.com");
                    items.add(item);

                    respXml = MsgUtil.sendArticleMsg(requestMap, items);
                    **/
                }
            }
            // 图片消息
            else if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
                respXml = MsgUtil.sendTextMsg(requestMap, respContent);
            }
            // 语音消息
            else if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
                respXml = MsgUtil.sendTextMsg(requestMap, respContent);
            }
            // 视频消息
            else if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
                respXml = MsgUtil.sendTextMsg(requestMap, respContent);
            }
            // 地理位置消息
            else if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
                respXml = MsgUtil.sendTextMsg(requestMap, respContent);
            }
            // 链接消息
            else if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
                respXml = MsgUtil.sendTextMsg(requestMap, respContent);
            }
            // 事件推送
            else if (msgType.equals(WxConsts.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = (String) requestMap.get(WxConsts.Event);
                // 关注
                if (eventType.equals(WxConsts.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！";
                    respXml = MsgUtil.sendTextMsg(requestMap, respContent);
                }
                // 取消关注
                else if (eventType.equals(WxConsts.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equals(WxConsts.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                }
                // 上报地理位置
                else if (eventType.equals(WxConsts.EVENT_TYPE_LOCATION)) {
                    // TODO 处理上报地理位置事件
                }
                // 自定义菜单
                else if (eventType.equals(WxConsts.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                }
            }
            mes = mes == null ? "不知道你在干嘛" : mes;
            if(respXml == null)
                respXml = MsgUtil.sendTextMsg(requestMap, mes);
            System.out.println(respXml);
            return respXml;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping(value = "accessToken")
    public String getAccessToken(){
        Token token = new Token();
        //如果不等于空 或者小于600秒
        if (redisTemplate.getExpire("expires_in")<600||redisTemplate.getExpire("expires_in")==null){

            //使用httpclient请求
            String result = HttpClient.doGetRequest(HttpConstant.API_URI.replace("APPID", environment.getProperty("wx.appid")).replace("APPSECRET", environment.getProperty("wx.secret")));

            //转成json对象
            JSONObject json = JSON.parseObject(result);
            System.out.println(json);
            token.setAccessToken(String.valueOf(json.get("access_token")));
            token.setExpiresIn((Integer) json.get("expires_in"));
            System.out.println(json.get("expires_in"));
            System.out.println(token.getExpiresIn());
            redisTemplate.opsForValue().set("accessToken",json.get("access_token"));
            redisTemplate.opsForValue().set("expiresIn",json.get("expires_in"),7200, TimeUnit.SECONDS);
        }
        String accessToken = redisTemplate.opsForValue().get("accessToken").toString();
        Long expiresIn = redisTemplate.getExpire("expiresIn");
        logger.info("accessToken{}:"+accessToken);
        logger.info("expiresIn{}:"+expiresIn);

        return token.getAccessToken();
    }



}
