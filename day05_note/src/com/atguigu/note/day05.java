package com.atguigu.note;

public class day05 {
    /*
        1. tomcat(服务器)
            服务器：硬件+软件
            硬件：电脑(操作系统)
            软件：tomcat
            1.1 tomcat的安装
                采用解压的方式安装(解压的位置->一个无空格无中文目录下)
            1.2 了解tomcat的安装目录结构
                bin          tomcat的命令文件
                conf         tomcat的配置文件
                lib          tomcat的jar包
                logs         tomcat的日志文件
                temp         tomcat的临时文件
                webapps      tomcat的部署目录
                work         tomcat的工作目录
            1.3 tomcat的前提环境
                必须配置JAVA_HOME的环境变量
            1.4 修改服务器的端口号
                conf->server.xml
            1.5 服务器的启动和停止
            1.6 部署一个自己的项目
                将BookStore01粘贴到webapps内，在启动服务器，访问该项目
                http://ip地址:端口号/项目名/目录名.../资源
       2. 将tomcat集成到idea内   ★
            2.1 将tomcat的家目录配置到idea内
            2.2 创建一个web项目
                目录结构：
                  day05_tomcat_http   本地项目名
                    resources   -->   项目的配置文件
                    src         -->   项目的java代码
                    web         -->   静态资源+WEB_INF
                        静态资源：html/css/js/图片/音频/视频...
                        WEB-INF: web.xml(web项目的核心配置文件)  +  lib(jar包)
                注意：
                    a. lib下的jar包需要添加一下
                    b. resources需要设置为资源目录
                    c. lib必须在WEB-INF，名称必须叫lib
            2.3 启动服务器(自动将当前项目部署在服务器上)
                启动成功后，会自动弹出一个浏览器
                    http://localhost:8888/day05_tomcat_http_war_exploded   -->  默认找index.html->index.jsp
                原理：
                    idea在启动服务器的时候，会创建一个本地服务器的副本
                        位置：C:\Users\86152\.IntelliJIdea2019.2\system\tomcat\服务器副本
                    找到这个服务器上部署的当前项目(看看什么样子)
                        位置：D:\workspace\atguigu\bj0819\out\artifacts\项目
                        结构：
                            day05_tomcat_http_war_exploded   部署在服务器上的项目名
                                就是web下的内容
                                    静态资源      -->     pages/static/index.html
                                    WEB-INF
                                        classes
                                            class文件     -->    src编译后的class文件
                                            配置文件      -->     资源目录下的配置文件
                                        web.xml   -->     依然是核心配置文件夹
                                        lib       -->     jar包
               异常情况：
                   404 -->   资源找不到
                    我们可以根据自己项目的结构，修改这个网址
                   idea中启动服务器自动弹出一个浏览器，自动访问当前项目下的index.html-->index.jsp

                   通过浏览器去访问服务器(感觉资源是不对的)
                       a. 客户端有缓存(清缓存，在次访问)
                       b. 客户端没有问题就是服务器端的问题
                             本地项目内删除index.html,新增admin.html
                             重启服务器(有比较小的记录，重启服务器，也不会将这次修改影响服务器上)  看一下
                          解决方案：找到部署在服务器上的项目，删除，在启动服务器
        3. tomcat的基础设置
            3.1 服务器的名字
                目的：就是为了区分这个副本服务器上部署的是哪个项目
            3.2 设置自动打开的浏览器和默认的网址
            3.3 设置重新部署
            3.4 修改tomcat的端口号
            3.5 修改部署在服务器上的项目名

        4. HTTP协议
            超文本传输协议：它是一种详细规定了浏览器和万维网服务器之间互相通信的规则
            浏览器传输数据到服务器  --> 请求
            服务器传输数据到浏览器  --> 相应
            规定了请求和响应中数据的格式

          4.1 请求报文
              ① 请求方式
                    get请求
                        网址栏直接敲网址
                        超链接
                        form表单的method属性值为get
                    post请求
                        form表单的method属性值为post
              请求首行
                请求方式      请求资源                            协议
                GET /day05_tomcat_http_war_exploded/user.html HTTP/1.1
              请求头部
                User-Agent : 客户端产品的信息
                cookie:      客户端的会话
                Referer：    请求来源(防盗链)
              空行
              请求主体
                  get请求时没有请求体
                    不能传输太大的数据
                  post请求时有请求体(存储的数据是用户输入的数据-->请求参数)
                    理论上说，请求的内容大小是无限制
              请求头案例：
                GET /day05_tomcat_http_war_exploded/user.html HTTP/1.1
                Host: localhost:9999
                Connection: keep-alive
                sec-ch-ua: "Chromium";v="94", "Google Chrome";v="94", ";Not A Brand";v="99"
                sec-ch-ua-mobile: ?0
                sec-ch-ua-platform: "Windows"
                Upgrade-Insecure-Requests: 1
                User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36
                Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,;q=0.8,application/signed-exchange;v=b3;q=0.9
                    Sec-Fetch-Site: same-origin
                    Sec-Fetch-Mode: navigate
                    Sec-Fetch-User: ?1
                    Sec-Fetch-Dest: document
                    Referer: http://localhost:9999/day05_tomcat_http_war_exploded/admin.html
                    Accept-Encoding: gzip, deflate, br
                    Accept-Language: zh-CN,zh;q=0.9
                    If-None-Match: W/"149-1633850813152"
                    If-Modified-Since: Sun, 10 Oct 2021 07:26:53 GMT
          4.2 响应报文
            响应首行
                协议      响应状态码
                HTTP/1.1 200
            响应头
            空行
            响应主体
                看到的页面

            响应头案例：
                HTTP/1.1 200
                Accept-Ranges: bytes
                ETag: W/"149-1633850813152"
                Last-Modified: Sun, 10 Oct 2021 07:26:53 GMT
                Content-Type: text/html
                Content-Length: 149
                Date: Sun, 10 Oct 2021 07:42:48 GMT
           响应状态码：
                200 成功
                404 资源找不到
                500 服务器出现错误

                304  获取缓存
                405  方法被禁用
















     */
}
