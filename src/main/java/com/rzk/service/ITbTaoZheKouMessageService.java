package com.rzk.service;

import com.rzk.pojo.BaseMessage;

import java.util.Map;


public interface ITbTaoZheKouMessageService {
    //淘折扣获取商品折扣优惠
    public BaseMessage replyTbZheKouMessage(Map<String,String> request);
}
