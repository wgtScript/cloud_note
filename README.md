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
5、运行成功，接口访问时没有数据，因为两边eclipse 配置tomcat 的端口不一样。请求路径要改。
6、直接访问页面 ，topjui的toolbar加载不出来。   解决：部署到服务器上。
	本地直接file://     这样是不行的。
7、静态页面放在nginx  里面  加载不出来！！！！     root路径，尚未解决。
	#root	E:\testWorkspace\GitHub\note\cloudNote\pc-readNote; 这样不行
	root		E:\cloud_note\pc-readNote;  这样可以
8、页面乱码：
	eclipse：Window--Preference--- General---workspace 设置utf-8
	html <meta charset="utf-8"></meta>
9、文本编辑器没有初始化进入 KindEditor.ready()方法。
	改用另一种方式初始化。
	
10、回宿舍tomcat端口都+1，保持两边一致。  都是8081。
11、把Nginx的文件夹也放到git里面，然后检出时，目录选择E盘就可以了。
10、直接用topjui的富文本编辑器，UEditor
11、mybatis   test 字段判空
	<if test="id!=null and id != ''">
		and id_ = #{id}
	</if>
#需求
1、待买物品（每月都买点粮食）
2、待学知识（吉他、看书）-->读书笔记
3、代办事项（每月任务） 