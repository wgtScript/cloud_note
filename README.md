# cloud_note
达内云笔记（扩展接口）




坑
1、ajax跨域问题：后台添加filter ，增加响应头response.addHeader("Access-Control-Allow-Origin", "*");  
2、宿舍github代码commit后隔天公司down不下来，没有push！
3、数据库sql文件要两边都有。（初始化）
4、启动完项目，访问接口时报错：Could not create connection to database server.
	原因：公司的mysql安装的是最新的。   
	进入mysql->status;     可以看版本是8.0.11
	jdk版本是1.8，mysql版本是8.0.11，mysql-connector-java版本是5.1.37，后来把mysql-connector-java改为最新版mysql-connector-java-5.1.46-bin.jar后，运行成功。
5、运行成功，接口访问时没有数据，两边eclipse 配置tomcat 的端口不一样。