package com.atguigu.xmldemo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        //1. 创建解析器对象
        SAXReader reader=new SAXReader();
        //2. 解析xml文件,得到Document对象
        try {
            Document document = reader.read(Demo1.class.getClassLoader().getResourceAsStream("persons.xml"));
            //3. 从文档对象中获得根节点
            Element root = document.getRootElement();
            //4. 获得abc中name标签的值
            Element abc = root.element("abc");
            Element name = abc.element("name");
            String text = name.getText();
            System.out.println("text = " + text);
            System.out.println("--------------------------");
            //5. 获得所有的abc中的name标签的值
            List<Element> abcs = root.elements("abc");
            for (Element element : abcs) {
                System.out.println(element.element("name").getText());
            }
            System.out.println("--------------------------");
            //6. 获得根节点中所有的标签中name标签的值
            List<Element> elements = root.elements();
            for (Element element : elements) {
                System.out.println(element.element("name").getText());
            }
            System.out.println("---------------------");
            //7. 获得第一个abc中的gender属性值

            Element abc1 = root.element("abc");
            Attribute gender = abc1.attribute("gender");
            String value = gender.getValue();
            System.out.println("value = " + value);

            //8. 获得第二个abc标签的age属性值
            Element abc2 = (Element) root.elements("abc").get(1);
            Attribute age = abc2.attribute("age");
            System.out.println(age.getValue());
            System.out.println("--------------------------");
            //9. 获得第一个abc中所有的属性值
            Element abc3 = root.element("abc");
            List<Attribute> attributes = abc3.attributes();
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
