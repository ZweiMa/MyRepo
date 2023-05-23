package com.atguigu.xmldemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        //1. 创建解析器对象
        SAXReader reader=new SAXReader();
        //2. 去解析xml文件
        try {
            Document document = reader.read(Demo2.class.getClassLoader().getResourceAsStream("persons.xml"));
            //3. 有两个方法
            /*document.selectSingleNode("");
            document.selectNodes("");*/

            //4.
            Element node = (Element) document.selectSingleNode("/persons/abc");
            System.out.println(node.element("name").getText());

            List<Element> list = document.selectNodes("//name");
            System.out.println(list.size());
            for (Element element : list) {
                System.out.println(element.getText());
            }
            System.out.println("------------------------------");
            List<Element> list1 = document.selectNodes("/persons/abc/*");
            System.out.println(list1.size());
            for (Element o : list1) {
                System.out.println(o.getText());
            }

            System.out.println("--------------");
            Element node1 = (Element)document.selectSingleNode("/persons/abc[@age='20']");
            System.out.println(node1.element("name").getText());


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
