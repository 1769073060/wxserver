package com.rzk.consts;

/**
 * @PackageName : com.rzk.consts
 * @FileName : TbConsts
 * @Description : 淘宝返利参数
 * @Author : rzk
 * @CreateTime : 2022/2/8 11:09
 * @Version : 1.0.0
 */
public class TbConsts {

    //折淘客
    public static final String URL = "https://api.zhetaoke.com:10001/api/open_gaoyongzhuanlian.ashx";
    //授权账号ID（sid）
    public static final String SID = "70801";
    //淘客PID，mm_xxx_xxx_xxx,三段格式，必须与授权的账户相同，否则出错
    public static final String PID = "mm_1557400062_2570700239_111879800422";
    //折淘客的对接秘钥appkey
    public static final String APPKEY = "f81dcde8b42a4b3ebcd1346f270e411f";
    //signurl=5，返回结果整合高佣转链API、解析商品编号API、全网商品详情API、淘口令创建API，已经自动判断和拼接使用全网G券还是全网S券。
    public static final Integer SIGN_URL_FIVE = 5;
    //signurl=4，返回结果整合高佣转链API、解析商品编号API、商品简版详情API、淘口令创建API，已经自动判断和拼接使用全网G券还是全网S券。
    public static final Integer SIGN_URL_FOUR = 4;
    //signurl=3，返回结果整合高佣转链API、解析商品编号API，已经自动判断和拼接使用全网G券还是全网S券。
    public static final Integer SIGN_URL_THREE = 3;
    //signurl=0或1或2，返回官方高佣转链接口结果，需要自行判断和拼接使用全网G券或者全网S券。
    //signurl=0，表示直接返回最终结果。
    //signurl=1或2，表示返回淘宝联盟请求地址，大家拿到地址后再用自己的服务器二次请求即可获得最终结果，值为1返回http链接，值为2返回https安全链接。
    public static final Integer SIGN_URL_TWO = 2;
    public static final Integer SIGN_URL_ONE = 1;
    public static final Integer SIGN_URL_ZERO = 0;
}
