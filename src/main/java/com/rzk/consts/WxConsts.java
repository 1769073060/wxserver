package com.rzk.consts;

/**
 * @PackageName : com.rzk.consts
 * @FileName : WxConsts
 * @Description :
 * @Author : rzk
 * @CreateTime : 18/1/2022 下午9:02
 * @Version : v1.0
 */
public class WxConsts {

    /**
     * 0失败
     * 1成功标志
     */
    public static final int SUCCESS_CODE = 1;
    public static final int FAIL_CODE = 0;

    /**
     * 类型
     * 1个人认证
     * 2商家认证
     */
    public static final int PERSONAL_AUTHENTICATION = 1;
    public static final int MERCHANT_CERTIFICATION = 2;
    /**
     * 设置状态值
     * 0
     * 1
     * 2
     * ...
     * 7
     */
    public static final int ZERO_STATUS = 0;
    public static final int FIRST_STATUS = 1;
    public static final int SECOND_STATUS = 2;
    public static final int THIRD_STATUS = 3;
    public static final int FOURTH_STATUS = 4;
    public static final int FIFTH_STATUS = 5;
    public static final int SIXTH_STATUS = 6;
    public static final int SEVENTH_STATUS = 7;
    /*类型 商家id，用户id*/
    public static final Long BusinessId_Status = 0L;
    public static final Long UserId_Status = 0L;
    /**
     * 经纬度
     * RADIUS 半径千米
     * Double = 2 倍数
     * DEGREES = 180 度数
     */
    public static final int RADIUS = 6371;
    public static final int DOUBLE = 2;
    public static final int DEGREES = 180;

    /**
     * UNPAID 未支付
     * RAID   已支付
     */
    public static final int UNPAID = 0;
    public static final int RAID = 1;
    /**
     * NO_CLICK_RAID 未点击支付
     * CLICK_RAID    已点击支付
     */
    public static final int NO_CLICK_RAID = 0;
    public static final int CLICK_RAID = 1;

    public static final String SUCCESS_MSG = "操作成功";
    public static final String FAIL_MSG = "操作失败";
    public static final String SYSTEM_ERROR_MSG = "系统错误";
    public static final String PARAM_ERROR_MSG = "参数错误";
    public static final String MISS_PARAM_MSG = "缺少参数";
    public static final String AMOUNT_ERROR_MSG = "金额有误";
    public static final String PAY_ERROR_MSG = "支付有误";
    public static final String ALREADY_EXISTS= "不能重复添加";
    public static final String SMS_VALIDATE_FAILE = "验证码不正确";
    public static final String USER_IS_EXIST = "用户已存在";
    public static final String USER_IS_NOT_EXIST = "用户不存在";
    public static final String ACCOUNT_OR_PASSWORD_ERROR = "账号或密码错误";
    //公众号响应的参数
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    //图片消息
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    //语音消息
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    //视频消息
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    //音乐消息
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    //图文消息
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    //公众号请求的参数
    //文本消息
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    //图片消息
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    //语音消息
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    //视频消息
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    //音乐消息
    public static final String REQ_MESSAGE_TYPE_MUSIC = "music";
    //图文消息
    public static final String REQ_MESSAGE_TYPE_NEWS = "news";
    //地理位置消息
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    //链接消息
    public static final String REQ_MESSAGE_TYPE_LINK = "link";
    //事件类型
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";
    //关注
    public static final String EVENT_TYPE_SUBSCRIBE = "SUBSCRIBE";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "UNSUBSCRIBE";
    //扫描带参数二维码
    public static final String EVENT_TYPE_SCAN = "SCAN";
    //上报地理位置
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    //自定义菜单
    public static final String EVENT_TYPE_CLICK = "CLICK";
    //根据自己所需要的场景进行 回复相对于的消息内容

    public static final String FromUserName = "FromUserName";
    public static final String ToUserName = "ToUserName";
    public static final String MsgType = "MsgType";
    public static final String Content = "Content";
    public static final String Event = "Event";

}
