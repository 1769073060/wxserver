package com.rzk.util;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @PackageName : com.rzk.util
 * @FileName : BeanToXml
 * @Description :
 * @Author : rzk
 * @CreateTime : 24/1/2022 上午1:43
 * @Version : v1.0
 */

public class BeanToXml {
    private static Logger logger = LoggerFactory.getLogger(BeanToXml.class);


    public static String convertToXml(Object obj){
        StringWriter writer = new StringWriter();
        try {
            //通过传入的类,创建该类的转换上下文
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            //创建实例
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化xml输出的格式,true会格式化输出,false会全部压缩到一起
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            //是否打印xml的说明头 <?xml version="1.0" encoding="UTF-8" standalone="yes">
            //设置为true表示不打印,设置为false表示打印,默认打印
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,Boolean.TRUE);
            //将对象转换成输出流形式的xml
            marshaller.marshal(obj,writer);
        } catch (JAXBException e) {
            System.out.println(String.format("错误转换信息，详情%s",e.getMessage()));
        }
        return writer.toString();
    }

    /**
     * 对象转XML
     * @param obj 目标对象
     * @return  返回string格式的xml报文
     */
    public static String objToXml(Object obj){
        StringWriter sw = new StringWriter();
        String result = null;
        try {
            //通过传入的类,创建该类的转换上下文
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            //创建实例
            Marshaller marshaller = context.createMarshaller();
            //格式化xml输出的格式,true会格式化输出,false会全部压缩到一起=
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            //是否打印xml的说明头 <?xml version="1.0" encoding="UTF-8" standalone="yes">
            //设置为true表示不打印,设置为false表示打印,默认打印
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,Boolean.TRUE);
            //将对象转换成输出流形式的xml
            marshaller.marshal(obj,sw);
            result = sw.toString() ;
        } catch (JAXBException e) {
            logger.error("对象转XML异常：{}",e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                sw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
