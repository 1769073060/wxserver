package com.rzk.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rzk.consts.TbConsts;
import com.rzk.pojo.BaseMessage;
import com.rzk.pojo.TextMessage;
import com.rzk.service.ITbTaoZheKouMessageService;
import com.rzk.util.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Map;

/**
 * @PackageName : com.rzk.service.impl
 * @FileName : TbTaoZheKouMessageServiceImpl
 * @Description : 淘折扣返利消息处理
 * @Author : rzk
 * @CreateTime : 2022/2/8 13:40
 * @Version : 1.0.0
 */

@Service
public class TbTaoZheKouMessageServiceImpl implements ITbTaoZheKouMessageService {

    private Logger logger = LoggerFactory.getLogger(TbTaoZheKouMessageServiceImpl.class);

    //http://58.214.250.20:10000/api/open_gaoyongzhuanlian.ashx
    // ?appkey=f81dcde8b42a4b3ebcd1346f270e411f
    // &sid=70801
    // &pid=mm_1557400062_2570700239_111879800422
    // &num_iid=641558126959
    // &signurl=4
    public BaseMessage replyTbZheKouMessage(Map<String, String> requestMap) {
        StringBuffer stringBuffer = new StringBuffer();
        TextMessage textMessage = null;

        String url = requestMap.get("Content");
        int lastIndexOf = url.lastIndexOf("id=");
        //取出商品id，发送httpclient请求
        String num_iid = url.substring(lastIndexOf + 3, url.length());

        stringBuffer.append(TbConsts.URL);
        stringBuffer.append("?");
        stringBuffer.append("appkey=" + TbConsts.APPKEY);
        stringBuffer.append("&");
        stringBuffer.append("sid=" + TbConsts.SID);
        stringBuffer.append("&");
        stringBuffer.append("pid=" + TbConsts.PID);
        stringBuffer.append("&");
        stringBuffer.append("num_iid=" + num_iid);
        stringBuffer.append("&");
        stringBuffer.append("signurl=" + TbConsts.SIGN_URL_FIVE);
        logger.info("stringBuffer.toString()" + stringBuffer.toString());
        //http://58.214.250.20:10000/api/open_gaoyongzhuanlian.ashx?
        // appkey=f81dcde8b42a4b3ebcd1346f270e411f
        // &sid=70801
        // &pid=mm_1557400062_2570700239_111879800422
        // &num_iid=641558126959
        // &signurl=4

        //https://api.zhetaoke.com:10001/api/open_gaoyongzhuanlian.ashx?
        // appkey=f81dcde8b42a4b3ebcd1346f270e411f
        // &sid=70801
        // &pid=mm_1557400062_2570700239_111879800422
        // &num_iid=64155812695
        // &signurl=4
        String response = HttpClient.doGetRequest(stringBuffer.toString());
        JSONObject jsonObject = JSONObject.parseObject(response);
        logger.info("返回的参数{}:" + jsonObject);
        JSONObject jsonObjects = null;
        JSONArray jsonArray = null;
        try {
            String resultResponse = String.valueOf(jsonObject.get("content"));
            jsonArray = JSONArray.parseArray(resultResponse);
            jsonObjects = jsonArray.getJSONObject(0);//带修改


            String title = jsonObjects.getString("title");
            String zk_final_price = jsonObjects.getString("size"); /*折扣价*/
            String finalPrice = jsonObjects.getString("quanhou_jiage");//卷后价格
            String coupon_amount = jsonObjects.getString("coupon_info_money"); /*优惠券金额*/
            String password_simple = jsonObjects.getString("tkl");/*淘口令*/
            String tkfee3 = jsonObjects.getString("tkfee3");/*返佣金额*/
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(title).append("\n")
                    .append("【商品单价】：").append(zk_final_price).append("\n");
            if (!"0".equals(coupon_amount)) {
                stringBuilder.append("【优惠金额】：").append(coupon_amount).append("\n")
                        .append("【券后价】：").append(finalPrice).append("\n");
            }
//        if (StringUtils.isNotBlank(tkfee3)) {
//            BigDecimal multiply = new BigDecimal(tkfee3).multiply(new BigDecimal("0.6"));
//            stringBuilder.append("【返俐】：").append(multiply.toString()).append("\n");
//        }
            stringBuilder.append(password_simple).append("\n")
                    .append("——————————\n")
                    .append("【购买方法】：\n")
                    .append("1.长按选择一键复制\n")
                    .append("2.打开手机桃宝\n")
                    .append("——————————\n");
//        return stringBuilder.toString();
            logger.info("    {}" + stringBuilder.toString());
            textMessage = new TextMessage(requestMap, stringBuilder.toString());
        }catch (Exception e){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("一一一/::(查 询 消 息/::(一一一").append("\n");
            stringBuilder.append("这家店铺太抠门了，没有设置优惠卷和补贴哦！")
                    .append("\n");
            textMessage = new TextMessage(requestMap, stringBuilder.toString());
        }

        //{"":
        // {"msg":"Remote service error",
        // "code":15,
        // "sub_msg":"该item_id对应宝贝已下架或非淘客宝贝",
        // "sub_code":"isv.item-not-exist",
        // "request_id":"6iamof86djvw"}}


        return textMessage;
    }

}
