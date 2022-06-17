package com.rzk.util;


import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

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

    public static void main(String[] args) throws DocumentException {
        Document doc = null;
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Map> mapList = new ArrayList<Map>();

        String result = "<resultInfo><successCode>0</successCode><returnResult><taskList><task><accidentNo>80052022110000002346</accidentNo><inputData>2022-05-24 19:56:53</inputData></task><task><accidentNo>80052022110000002373</accidentNo><inputData>2022-05-26 15:29:26</inputData></task><task><accidentNo>80052022110000002374</accidentNo><inputData>2022-05-26 15:33:23</inputData></task><task><accidentNo>80052022110000002376</accidentNo><inputData>2022-05-26 15:59:53</inputData></task></taskList><taskNumber>4</taskNumber></returnResult></resultInfo>";
        doc = DocumentHelper.parseText(result);
        Element rootElt = doc.getRootElement();
        System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
        Iterator returnResult = rootElt.elementIterator("returnResult"); ///获取根节点下的子节点bbbb

        // 遍历returnResult节点
        while (returnResult.hasNext()) {
            Element taskList = (Element) returnResult.next();
            Iterator task = taskList.elementIterator("taskList"); // 获取子节点bbbb下的子节点cccc
            while (task.hasNext()) {
                Element itemEle = (Element) task.next();
                Iterator iterator = itemEle.elementIterator("task");
                while (iterator.hasNext()) {
                    Map map = new HashMap();
                    Element tableItem = (Element) iterator.next();
                    //String username = tableItem.elementTextTrim("accidentNo"); // 拿到dddd下的字节点username的值
                    map.put("accidentNo",tableItem.elementTextTrim("accidentNo"));
                    map.put("inputData",tableItem.elementTextTrim("inputData"));
                    mapList.add(map);
                }

                    resultMap.put("data", mapList);
                    resultMap.put("success", true);
            }
        }
    }


    /**
     * dom4j解析Xml
     * @param xml
     */
    public static void getXmlAttribute(String xml) {
        Document doc = null;
        try {
            // 将字符串转为XML
            doc = DocumentHelper.parseText(xml);
            // 获取根节点
            Element rootElt = doc.getRootElement();
            //获取城市名
            String cityPair = rootElt.attributeValue("resultInfo");
            System.out.println(cityPair);
            //获取CWS节点
            Iterator CWS = rootElt.elementIterator("returnResult");
            while (CWS.hasNext()) {
                Element recordEle = (Element) CWS.next();
                //获取ABK节点
                Iterator ABK = recordEle.elementIterator("taskList");
                while (ABK.hasNext()) {
                    Element abkRecord = (Element) ABK.next();
                    //获取ABK节点下的所有节点
                    Iterator f = abkRecord.elementIterator();
                    while (f.hasNext()) {
                        //BkresultBean bkresultBean = new BkresultBean();
                        Element itemAtr = (Element) f.next();
                        //获取需要的数据
                        itemAtr.elementText("");
                        String berth1 = itemAtr.attributeValue("accidentNo");
                        String priceOfOne = itemAtr.attributeValue("inputData");

                        System.out.println(berth1 + priceOfOne);
//                            bkresultBean.setBerth1(berth1);
//                            bkresultBean.setPriceofone(priceOfOne);
//                            bkresultBean.setFightline(cityPair);
//                            bkresultBeans.add(bkresultBean);
                    }
                }
            }

            //插入数据
//            bkresultBeans.forEach(bkresultBean -> {
//                Integer insert = bkresultMapper.insertAllColumn(bkresultBean);
//            });

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
