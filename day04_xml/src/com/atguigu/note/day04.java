package com.atguigu.note;

public class day04 {
    /*
        1. xml
            可扩展标记语言(标签、属性名称随意定义)  -->  企业
            xml存在一些约束的(框架-Spring[bean...],web项目[servlet/filter...])
            1.1 配置文件
                xml主要用途就是项目的配置文件
            1.2 xml的基本语法
                ① 文档声明
                    <?xml version="1.0" encoding="UTF-8"?>
                ② 要有一个根标签
                    <persons></persons>
                ③ xml的约束
                    功能：规定xml文档内有哪些标签、哪些属性、标签的顺序都可以有要求
                    约束知识：DTD (XXX.dtd文件) 或  Schema (xxx.xsd)
                    注意：如果没有约束，那就真的是随意写\
                ④  语法要求
                    和html的语法要求一致
             1.3 xml的解析(为了理解了框架是如何拿到配置文件的数据的)
                反射 ->  jdbc(DBUtils-->结果集处理器)
                ① dom解析
                    一次性将xml文件读取到内存，形成一个dom树(document)
                ② SAX解析
                    逐行读取，基于事件驱动，解析一行释放一行，内存占用非常小
                ③ DOM4J
                    a. 将dom4j的jar包导入到项目内
                    b. 创建解析器对象
                        SAXReader reader=new SAXReader();
                    c. 解析xml文件,得到Document对象
                        Document document = reader.read(Demo1.class.getClassLoader().getResourceAsStream("persons.xml"));
                    d. 从文档对象中获得根节点
                        Element root = document.getRootElement();
                ④ Element下的常用方法
                    Element element(String s)   根据标签名获得第一个匹配到标签对象
                    String getText()             获得标签的标签体内容
                    List elements(String s)     根据标签名获得所有匹配到标签对象
                    List elements()             获得所有子标签对象

                    attribute(String s);      根据属性名获得属性对象
                    attributes();             获得标签内所有的属性对象
                 Attribute下的方法：
                    getValue()                获得属性值

              1.4 XPATH
                a. 导入jar包
                b. 创建解析器对象
                c. 解析xml文件，得到Document对象
                d. 调用Document对象下的方法
                    document.selectSingleNode("路径规则");  找单个节点
                    document.selectNodes("路径规则");       找所有节点


     */
}
