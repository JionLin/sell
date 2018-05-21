### 1/22

```
1	每日签到表，在记录表上夹着	ok
2	navicat 数据库教程使用 已经下载	ok
3	dbaver 数据库连接使用 教程 已经下载	ok
4	格式对齐 idea 设置 未设置，
5	每个月发送一次，先是代玉星 后肖志兵	ok
6	电脑密码设置	OK 不用的时候，把电脑盖上就好，不需要密码
7	看shiro权限框架（8---）ok
8	idea配置资料（60--122	ok
9	有道词典下载（ 本地下载--单词	ok
10	爱立信的考评环节（不需要，是转正人员填写的）	ok
11	台式电脑copy API	ok
12	页面寻找，首页面，看样式，资源 js 之类的，找到首页	ok
13	使用idea，需要进行方法参数的设置  ok
14	另外还有一个，接口的话，需要传入的参数，和返回的参数，返回的参数，没看到，在哪里找？（重点） 接口怎么写 
15	代码不懂得百度，没找到具体的多少个了。明天记得一二三，标好 
16	测试类，不懂得自己开个eclipse，就好  ok
```

### 1/23

```
SELECT
COUNT(alldetail.*) alldetails,COUNT(point.*) points,COUNT(reason.*) reasons,COUNT(indata.*) indatas,COUNT(outdata.*) outdatas
FROM
app_test.app_complain_all_t as alldetail,
app_test.app_complain_point_t as point,
app_test.app_complain_reason_t as reason,
app_test.app_interrupt_in_t  as indata,
app_test.app_interrupt_out_t  as outdata

WHERE 
201707 = alldetail.processing_time 
AND
201707 = indata.var_month
AND
201707 = outdata.var_month
AND
201707 = reason.var_month
AND
2017 = point.var_month 

月报进行查询出来，先把时间进行比对好，年和月的数据进行比对，在servie层，进行数据的比较，返回，在dao层，进行数据的输入，查询的时候，进行多张表的书写。

sql语句  要使用1=1来进行比对
	<!-- 数据总量 -->
	<select id="getSum" resultType="long" >
     select count(code) 
	 from app_test.app_util_common_t
		where 1=1 
		<if test="startTime != null">
			and val =#{startTime}
			
		</if>
		<if test="code != null">
			and code =#{code}
			
		</if>
  	</select>
```



```
1	触摸板问题，问客服 
2	问题点MapperScannerConfigurer配置 annotationClass ？
3	aop config配置 表达式中可以用or来  
4	新建连接到vict数据库 OK 
5	dbeaver的熟悉，数据库表不出来
6	sql语句的查询 ok
7	数据库表不显示出来 
8	创建表百度的资料，拷贝到电脑里面来 ok
9	月报的sql语句书写，在service层进行截取，进行统一的月份，返回数据 
10	用eclipse的时候，输入的项目名，必须要输入项目的名字才行， OK
11	以后不要用谷歌邮箱了，太扯淡了，一律用qq或者163吧，回去申请 OK
12	今天的代码，月报的生成。 杨文豪写的资料ok
13	substring（） length（） ok substring（0,1）截取第一个，不包括第二个
14  project facts 不支持1.8 记得修改ok
15	每天写的接口参数，自己在重新写三遍，
16	明天的数据库要重新进行连接，怎么会出错那么严重 找不到数据  
17	不懂得要想办法弄清楚，自己在action层和service，dao层做的方法笔记记得去除掉。做好一二三个记录
18	tochcar 数据库查询语句的意思 ok
19	把返回状态码的类重新写一遍	 不熟悉 
20	枚举有什么效果 在类中书写 枚举需要加构造方法  ok
21	记得写接口的时候，需要斜杠 ok
22	还有一个接口没有写出来	
TO_CHAR 是把日期或数字转换为字符串	
TO_NUMBER 将字符转化为数字； 
TO_DATE 是把字符串转换为数据库中得日期类型转换函数

以后每天记录的时候，特别是代码的那一段，要做好标记，记录好，后面找的时候，才好找到，
把问题的解答方式也写出来，private final Logger logger = 前面这个是进行当前类的加载 LoggerFactory.getLogger(MonthReportReleaseAction.class); 用来加载打印日志的 logger.error(打印本地日志，)
22 接口		serviceimpl	if (sum >= 1) {
//			返回0是什么意思？  四
			return 0;
		}
		
		if (StringUtil.isEmpty(code))
			code = "month"; 是什么意思 
```

### 1/24

```
接口文档的书写，需要的步骤
1	标题：名字
2	描述：
3	class
4	method
5	测试接口URL 示例：http://192.168.121.171/jkapp/rest/monthReport/createReport
6	生产接口URL 示例：https://jkzx.archclearing.com:8433/jkapp/rest/monthReport/createReport
7	生产方：	接受方：
8	请求参数	
	名称					类型		是否必填	描述		示例
	time 需要传入的参数	String 		Y OR NO		时间		yyyyMM
	code 				 String		 Y or NO	月报类型	month
9	请求示例：http://192.168.121.171/jkapp/rest/monthReport/createReport?time=201707&code=month
10	返回参数：code: 返回状态 (0/1/-1) (0:成功 1:失败  -1:参数错误)
			msg:状态描述
			data: null; 在controller层进行书写
11	返回示例：
			{
			"code": 0,
			"data": null,
			"msg": "成功!"
				}
```

```
1	server服务器记得开启 ok
2	dbeaver数据库有时连接不了，有时可以连接，很蛋疼 OK
3	网络问题，最尴尬，麻烦。  下个月解决
4	数据库真坑爹，连接不上去，下午先看接口，先写接口 	
5	数据库字段offset的意思，group by 分组 limit 分页  offset	 order by 排序  默认为升序asc为上升 降序为desc 	OK
6	谷歌浏览器无法访问本地 直接清楚掉缓存，以及代理设置 ok
7	服务器，启动，不需要每次都开启	没设置好，
8	回去下载词典 有道和navicat有冲突  ok 必应词典
9	回去把后面电脑教程表格数据拉进来。
10	跑项目用workspace跑，敲代码自己熟悉用workspace2跑，有异常，呆会回去处理， 
11	项目的导入导出文件的处理，回去看资料 OK
12	SELECT * FROM exam LIMIT 4,1 显示一条数据	SELECT * FROM exam LIMIT 1 OFFSET 2 显示两条数据
13	自己在家写接口 周六周末的时候  没弄
14	postman环境变量配置	没弄
15	只看生成月报的代码数据库 ok
16	回去看查询语句	ok
17	以后看代码用谷歌浏览器，搜索资料看火狐浏览器	OK
18	星期六把eclipse全部配置好，就差格式化了	OK
```

### 1/25

```
1	项目就弄两个空间就好，一个为workspace，公司代码，一个为workspace2，自己练习代码 切记，别去弄其他的了，
2	奥德赛账号的连接 连接不了
3	花生壳
4	xftp下载，需要打包项目，进行发布 还有项目的命名方式，需要修改日期时间
5	分页查询显示 
6	今天晚上limit分页 
7	项目的发布 
		1 进行打war包  把名字进行修改，在文件夹里面使用xftp进行修改，很简单
		2 进行数据库里面的参数？转移符设置 localhost:8080/apptest?useUnicode=true&amp;characterEncoding=utf-8
		3 连接xshell xftp ，把war包拖到tomcat里面的webapper下，进行 重新开启就ok
		4 rm -rf 进行项目的删除
		5 tomcat的启动，在user/local/tomcat/bin目录下， ./startup.sh
		6 数据库的启动  /etc/init.d/mysql start
8	周六在家，把虚拟机装好，有空的时候，自己玩会。没有弄好，
9	数据库看到07
```

### 1/26

```
1	主机能连接上虚拟机网络，但是ping不通虚拟机，原因有
		首先主机要ping通虚拟机ip地址，需要虚拟机关闭或正确设置防火墙！
		其次，检查虚拟机的网络适配器工作模式设置状态
		桥接模式下，虚拟机和主机为同一网段，只可能是防火墙问题
		NAT模式下，确定vmnet8虚拟网卡启用，通过vmnet8和虚拟机通讯，vmnet8和虚拟机为同一网段
		hostonly仅主机模式下，确认vmnet1虚拟网卡启用，并设置虚拟机和vmnet1为同一网段ip即可。
2	上传文件到svn上面，需要进行修改。  OK
3	springmvc自带拦截器 三个方法 博客里面

4	进行模拟svn上传解决bug 一个jva文件，被两个用户下载，两个用户更改不同的内容，A和B，A更改了内容并提交上去，B也开始提交内容，就会出现红色，进行报错，就需要进行文件的修改。看看合并后的内容如何，像刚才那种情况，不要在遇到了 重点 OK 记得先更新后下载 OK
5	资料发布，尽快 	ok
6	快捷查找文件 ctrl+shift+r ok
7	文件发布，在webapp下面，全部发布下去  ?
8	需要改名字，来查看端口是否被占用 lsof -i:80  后面这个是查找占用的程序  netstat -anp|grep 80  杀掉pid kill -9 pid 查看tomcat是否启动 ps -ef|grep java 
9	查看tomcat的进程是否启动，ps -ef|grep java bootstrap  启动tomcat的时候会有出现 tomcat .start 
10	明天sql语句的书写 一个小时吧。ok
```

### 1/27

```
用svn进行代码上传的时候，出现错误J，未找到原因在哪里 是classpath和project文件没有，导致的不能够编译问题
```

### 1/28

```
web项目 导入到idea中 明天弄清楚
idae导入eclipse项目需要在moudle里面路径设置 上面的web.xml路径设置，下面的为webcontent路径设置


导入eclipse项目的时候，直接打开文件夹就好。里面有提示进行的
重新来过几遍

导入项目进来，选择第一个 create project from existing sources eclipse  一直下一步 
import project --> project name --> source files 
后面project structure 结构 libraies; 进行名字设置 然后在modules里面进行依赖设置
project setting 
project 不用管
modules 只加依赖
libraries 只加名字
facets 进行添加 面，切面


1/26号虚拟机出现的异常问题 可能导致的问题如下，没清除缓存，war包就没导入进去，，都可以看到参数了 重命名的问题，mv 文件 新文件名 进行移动
只能放war包才能解压，解压的命令 unzip project.war -d project 

svn客户端解决冲突问题 OK
碰到的问题有，过时，冲突 往前往后移动OK
需要提交的时候，一定的进行先更新，后提交，看看svn的按键说明 OK 
导出war包，点击artitacts（手工制品） +号，web application，archive（档案），进行名字的更改和输出路径，然后在点击 include in project buile 点击下面的+号，选择dictory content webcontent 也是web的根目录 目录内容就OK
```

### 1/29

```
1	发布项目，先把缓存进行清除，在启动tomcat试试

2	http://192.168.121.171:8080/jkapp/jkapp.html测试的时候链接

3	每周的星期五，进行周报的发送 yuliang@chinamobilesz.com 公司邮箱，禹亮 

4	项目的部署问题，进行war的打理，把war包托到tomcat的webapp下进行，开启tomcat的时候，在bin目录下./startup.sh 进行tomcat的开启，关闭的时候，在bin目录的./shutdown.sh 进行关闭，查看是否已经关闭，用ps -ef|grep java 进行查查看是否已经关闭， 有出现bootstrap的时候，是未关闭的状态，那就进行kill -9 ：pid 删除进程，在进行查看，只有出现一行状态的时候，就是未关闭状态。 虚拟机删除命令 OK
5	路径问题，呆会下午到晚上，把路径搞定。OK
6	放假时间，2-14到2-25号 、OK
7	回去把springboot项目，有时间看看。今天放到电脑里面来。 0K
8	弄清楚原因了，路径需要进行更改，以前是一个端口号的，现在变成了 两个端口号，ok
9	今天上午说的发送资料给龚舒（hr）ok
10	虚拟机的文件移动 mv 从跟目录开始 OK
11	先弄数据库，在弄个虚拟机  回去把虚拟机装上去
12	如果弄得话，需要设置git的客户端下载  不弄了 
13	最主要的还是看代码。今天把war进行打包后，已经ok，明天没有出现新的请求。如果出现新的请求的话，记得晚上在家里面进行资料的查询，获取思路。该加班的加班，加点的加点。加油 目前最主要的心思是看代码，别去想另外的事情了，比较头疼。ok
14	明天下午，U盘资料菜菜资料库
15	戴尔电脑锁屏键 win+L
```

### 1/30

```
1	每天弄饭的时候，不要打汤，汤全部倒掉。要不然每次的时候，那个袋子上面都是汤汁。
2	在和朋友交往的时候，该记住的东西就得记住，避免尴尬的事情发生。
3	以后女朋友买衣服的事情，价格合适的话，直接下单就好了，不要磨磨蹭蹭的，大跌眼镜。
4	今天任务，看代码怎么写的，自己去理思路。
5	这个礼拜天，换手机屏幕和去买衣服，明年过来的时候，羽绒服带两件过来，另外的在这边的西装，上班时间又不怎么穿，浪费了。在这边冷的时候，就穿西装吧。
6	需求来了，把数据的数据导入到redis中，进行查询的时候，从redis里面进行读取数据。
	思维逻辑：1 导入jar包
	在业务层进行读取数据，如果有，直接从redis里面进行读取，没有的话，设置到redis缓存里面。
	redis：配置spring-redis.xml 里面需要有约束
	<description>   <bean id="redisURI1" class="redis.clients.jedis.HostAndPort"> 0 ip地址 1 端		口号 </bean>
	
	<bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">
                <property name="maxIdle" value="150"/> 最大的空闲数
                <property name="maxTotal" value="300" /> 最大的总数
                <property name="testOnBorrow" value="true" /> 获得一个jedis实例的时候是否检查连接可			用性（ping()）；如果为true，则得到的jedis实例均是可用的；
      </bean>
        集群 <bean id="binaryJedisCluster" class="redis.clients.clusterc.BinaryClusterHelper" 			destroy-method="close">
                <constructor-arg index="0">
                        <set>
                                <ref bean="redisURI1"/>
                                <ref bean="redisURI2"/>
                                <ref bean="redisURI3"/>
                                <ref bean="redisURI4"/>
                                <ref bean="redisURI5"/>
                                <ref bean="redisURI6"/>
                        </set>
                </constructor-arg>
                <constructor-arg index="1" value="12000"/>
                <constructor-arg index="2" value="5"/>
                <constructor-arg index="3" ref="jedisPoolConfig"/>
        </bean>
        expire
        
 7 redis资料
 9	对AppAction，L1tfAction流量统付模块，UpssAction做缓存
 10	拦截器问题，想办法解决掉 前端admin.js问题 有权限控制  下次要记得进行全部搜索查看的，ctrl+shift+f	ok
 11	sso的redismanager参数 	
 12	APP账号和密码资料guods/!qaz2Wsx账号密码 OK
 13	先用自己的项目跑起来，试试用redis缓存好了，在部署项目上去，今天晚上搞定。 未搞定
```

### 1/31

```
1	redis客户端和服务端的操作 怎么确定连接成功。？OK
2	CONFIG set requirepass "password" 设置服务端密码
3	合同单号，中午查 OK
4	路径直接从上面开始获取，获取到缓存了，现在下一步任务为每个接口连接缓存。OK
5	二级缓存，没有想法的时候，就进行百度查看要点 OK
6	redis的详细配置写到工作报告中来
7	另外一个，把每天学的资料，进行整理，放到一个md档案里面去，记录下来。记住，花不了几分钟的时间。 
8	ctrl+F12 查询类中的所有方法 OK
9	过年回家把xshell玩会
10	spring整合redis，有用到配置文件，spring-redis.xml，redis.properties	和TestJedisDemo 
11	进行配置 在查询的时候， 三个util包，注销
	1	使用缓存，settings里面进行设置	useCache="true" 
	2	Mybatis的Mapper的配置文件如下：<cache type="redis实体类路径">
	3	在查询语句的时候使用useCache="true"
```

### 2/1

```
这个月的目的有哪些：
	使用redis，对它进行熟悉。和spring的集成，使用注解进行运行出来。主要是进行项目的运行。reids 自己看资料。 
	自己项目的代码资料，自己要熟悉，要去看，不要一写上去，下次就不记得了。
	另外一个，自己使用接口进行语句的书写。从最简单的开始，获取到数据，给前端返回的值来讲。30个。
	看ssm框架，里面的配置，从基地出来的配置

我的目的是尽量的在3年以内，工作重心往长沙转移，把东西学扎实了，每年都这样漂泊也不是一个好的方法，今年最大的目的是把婚结了，明年的话，把车子买了，或者把房子的首付付了，自己贷款慢慢还，明年过来，就开始找房子呗，把东西全部放脑子里面了，那样跳槽出去心里面才有底气。
从文思进去的日期2018年2月6号入职，想办法跳槽的话，在2020年的3月份吧，那个时候学的东西多了，直接就叫17K就好了。
加油努力干，明天是属于你的。
```

```
1	OpenSessionInViewFilter 允许在每次的整个request的过程中使用同一个hibernate session,可以在这个request任何时期lazy loading数据。 在request把session绑定到当前thread期间一直保持hibernate session在open状态，使session在request的整个期间都可以使用
2	SuppressWarnings 告诉编译器忽略指定的警告，不用在编译完成后出现警告信息。
 unchecked
 ("serial")如果编译器出现这样的警告信息：The serializable class WmailCalendar does notdeclare a static final serialVersionUID field of type long
 @SuppressWarnings("unchecked", "deprecation")
告诉编译器同时忽略unchecked和deprecation的警告信息。
·  @SuppressWarnings(value={"unchecked", "deprecation"})
等同于@SuppressWarnings("unchecked", "deprecation")
3	web.xml中的顺序，context-param-->listen-->filter-->servlet
	还有一个是设置字符集请求和响应    <filter>
        <filter-name>Set Character Encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>Set Character Encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    session-config 120分钟 
    <session-config>
        <session-timeout>120</session-timeout>
    </session-config> 用于指定http session的失效时间
   4	ContextLoaderListener
    spring 的ContextLoaderListener springmvc的dispatchServlet
      <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
    欢迎页面 
    在Spring2.0中除了以前的Singleton和Prototype外又加入了三个新的web作用域，分别为request、session和global session，如果你想让你的容器里的某个bean拥有其中某种新的web作用域，除了在bean级上配置相应的scope属性，还必须在容器级做一个额外的初始化配置。 
    ContextLoaderListener(或ContextLoaderServlet)将Web容器与spring容器整合。RequestContextListener将Spring容器与Web容器结合的更加密切。 
前者为必选配置，后者为可选配置，并且后者与scope=”request”搭配使用。
5	mybatis的foreach标签，进行遍历的时候，如果传递的是list，动态sql的collection就放list，如果是数组就传数组，array，放在queryVo里面就放 变量名。
```

Mybatis

```
一对一，assoiction id result column  property

使用的是select<resultMap< id,type类型<result column 或者 property >
一对多，collection 里面的字段都需要写 比如要查询的参数，id，username，password 
用户对应订单，一个用户多个订单，查询所有的用户，查询用户下所需要的订单。使用collection字段，ofType=类型，所代表的是对应类类型，所对应的property 所代表的是属性名，jdbcType所代表的是集合类或者对象类。
```







```
1	怎么将bean转换为参数放到实体类中
2	case sensitive completion  idea区分打下写敏感。设置为none	OK
3	idea路径，自动拷贝 OK
4	读写超时，未解决  解决办法  java.net.socketTimeoutException:read timed out
Connector port="8086" maxHttpHeaderSize="8192"
               maxThreads="150" minSpareThreads="25" maxSpareThreads="75"
               enableLookups="false" redirectPort="8443" acceptCount="100"
               connectionTimeout="20000" disableUploadTimeout="true" />
5	空指针异常redis配置	没搞定
```

### 2/2

```
1	连接超时:修改tomcat的参数  <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" disableUploadTimeout="true"/>
2	就那样配没有问题，主要的方向往spring这一块来，本来就一个服务器。
3	回去把ssm框架搭好。从最简便的开始
	步骤，需要添加jar包，从文件中拷贝	没有
4	体检报告，离职证明，毕业证，身份证，招商银行，一张一寸的照片 ok
5	周六体检报告 ok
6	进行周报的发送 ok
7	按照他们的配置来，config配置文件和类文件统一放到src目录下面
8	springmvc常用注解：@controller  @requestMapper 配置试图解析器  
 	InternalResourceViewResolver  prefix" value="/WEB-INF/views/
 	name="suffix" value=".jsp">
 	requestMapper 六个注解： 1、 value
　　　　value：指定请求的实际地址；
     2、method；
　　　　method： 指定请求的method类型 @PathVariable参数指定
　　　　consumes 指定处理请求的提交内容类型 produces:    指定返回的内容类型 params： 指定request中必须包含某些参数值 headers： 指定request中必须包含某些指定的header值
　　　3 @Resource和@Autowired 
　　　@Resource并不是Spring的注解，它的包是javax.annotation.Resource
　　　Autowired为Spring提供的注解，需要导入包org.springframework.beans.factory.annotation.Autowired;只按照byType注入
9	记得提交的时候，要修改前端和拦截器的功能
10	使用redis做缓存，回去看视频，真要。把那个项目运行起来，加入缓存 最后一个项目。
```

### 2/3

```
1	注入的时候总是报错。
2	没弄过的东西，记得测试的时候，一个一个去注销避免报错。
3	向同事说的，看配置有没有报错，是否有被扫描。
4	日志大全。 没搞定 桌面上面
5	mybatis的流程 xml中处理< >的方法： <  &lt;   > 	&gt;	 &amp; &
 &apos;  ’	     &quot;   " 使用转义符	
 SELECT * FROM test WHERE 1 = 1 AND start_date  &lt;= CURRENT_DATE AND end_date &gt;= CURRENT_DATE
6	先把redis搞完 静态类的注入没搞定
```

### 2/4

```
1	安装虚拟机 账号：root 密码：JIAOLIN	OK 
2	文思海辉账号登录查看、	OK
	上面有写项目，到文思上面去，时间简历上面有写。 OK
	一、	必备材料
1.	最近任职单位加盖公章或人事章的离职证明原件 ； 明天搞定
2.	身份证或护照的原件及复印件；  明天发图片给菜菜。
3.	最高学历及学位证书的原件及复印件；明天发图片给菜菜。
4.	外籍人员需提供有效工作签证的原件及复印件。
4.	银行借记卡正反面复印件；明天发图片给菜菜。
5.	彩色证件照： 1 寸 1 张 ，需要提供同底证件照的电子版； 已准备
6.	提供公司认可的体检机构或二级以上公立医院出具的3个月内体检证明原件（建议项目包括：心电图、胸透、血尿常规、腹部Ｂ超）；OK
7	关于离职的，明天enter肖志兵，去办理离职证明。
8	虚拟机里面需要安装jdk，tomcat，mysql，redis 明天或者后天安装好。
9	资料，全部清理掉 不要传。
10	关机快捷键：alt+F4
```

### 2/5

```
1	明天文思海辉报到日期 威新软件园1号楼，9.30 资料 
    打印 1离职证明
    2身份证原件和复印件
    3毕业证原件和复印件ok
    4银行卡正反面
    5照片ok6体检原件OK
2	提交svn到服务器的时候，记得，用svn提交不要哦用eclipse去提交，把不需要的东西，进行文件的忽略，仔细看个几遍，别弄错了，那样很麻烦。ok
3	新建文件夹的快捷键为ctrl+shift+n。
4	弄缓存的时候，从第一个action开始，改L1df.xml，只有改过mapper.xml文件。
5	上传的时候记得把月报的缓存干掉，用L1DF流量支付模块使用，现在看不到具体的效果
6	要不这样，把拦截器全部干掉，直接用l1df来访问看缓存的命中率	ok
7	看好这个了，就去看mybatis缓存和redis缓存的利用和使用了解。
8	共用一个缓存使用cache-ref namespace=""	OK
9	多表操作不适合缓存 L1df单表操作 OK
10	使用redis直接在业务层做缓存，用注解的方式，spring+redis集成 接下来的事情
11	下载pdf编辑器	ok 
12	工商银行	ok
13	阿里旺旺下载 ok
```

### 2/6

```
1	明天办理入职手续，下午进行缓存的测试，并报告。OK
2	webapprootkey在web.xml中的意义。路径的问题，在前端数据里面需要用到。未搞定 
3	hub系统填写请假单，另外给禹亮进行邮件的发送请假单。 明天。
4	每天都需要打卡，早上9点以前和晚上6点以后确定。设置闹铃。OK
5	和飞信账号和密码 13145904403	jiaolin123@
6	明天请假的事情，账号和密码P0114132	f%#7W@6a
7	2.12,2.13,2.14号和2.22，2.23,2.24请假，直接5天年休，1天事假得了。
8	另外的事情，不过6点以后，不要去看手机上面的小说。OK 
9	还有英泽信息的离职邮件，晚上获取，看看有什么东西。OK
10	回去把jdk，tomcat，mysql安装好。
```

### 2/7

```
1	关于请假的事情，明天到hub上和发邮件给禹亮。ok HUB上有问题，明天上午或者下午在登录看看。
2	关于工资问题，上个月工作的10天，在这个10号发，这个月工作的前面5天在下个月底进行发放，还有一个在下个月的5号进行发放。
3	对于查看的资料，重新在每个月的1号里面进行记录，要不然会忘记掉
4	明天还要准备一张照片	OK
5	电话，接听免费，打电话1毛钱一分钟。流量的问题，省内1元800M，省外2元800M OK
6	另外的下午进行测试，给报告过去。多测试两个接口。未完成。
7	春节放假事宜：是用来周六上班时间填的。
8	修改了ComplainReasonDao.xml里面的参数。getlist和getSum的参数 业务详单-->明细数据	complainDetaildao.xml数据 页支详单，明细数据和焦点投诉
9	呆会晚上和尹忠聊聊这个问题。上班时间较闲。 明天或者后天聊这个事情
10	回家bug %20 是在前端页面传递值的时候，有空格出现	ok
```

### 2/8

```
1	晚上回家看springmvc的资料，也拷贝到电脑里面来，把东东给的那一套视频，ssm框架的全部copy回家。明天晚上的事情。今天晚上搞定。ok
2	把springmvc的资料重新看一遍。看了一半。
3 	看到3.5 资料，今天中午把它看完。OK
4	进行缓存的多个页面扫描。OK
5	都是同事，不要说别人的不是。OK
6	下次在遇到这个的事情，可以选择转场，直接提高工资，可以多选择。
7	出来的bug，不要直接clear掉，要找百度看看是什么原因。
8	这样签到的问题，不要在出现了，低级错误。麻烦别人。OK
```

### 2/9

```
1	要带的东西有电脑，散热风扇，带一套衣服（一条牛仔裤，一条黑色休闲裤，一件打底衣，一件毛线衣，袜子两双，内裤两条），雨伞，剃须刀，身上穿一套衣服，定型喷雾，买双皮鞋，还有把电热风带回家，晚上肯定要看资料的，拿回家去。还是要带件西装回家，不带过来了。过年来的时候，带两件羽绒服过来。OK
2	提交代码的时候，主要修改了哪个，在哪个文件右键提交svn。OK
3	把mysql安装好。
4	看软件的存放目录。
5	进行资料填写，文思海辉的。ok 系统问题，不要管。
6	进行曾健电话拨打，问问具体情况，电话拿不到。
7	记得家里的东西，电源线记得全部关闭，窗户全部关闭，拿把雨伞回家，ipad记得把电源拔了，第二天穿的衣服，晚上记得全部找好，ok
8	充电宝记得带好。OK
9	VMware Workstation 内部错误 在服务里面打开这个系统，开启后OK
10	安装jdk有错误javac没有显示出来，找了一段时间是路径问题，只需要配置JAVA_HOME和Path路径就好。
11	在linux机里面进行文件的配置的时候，把需要进行编译的文件进行拷贝，记得一律为后缀名 名字+copy2 切记。
12	另外打招呼的问题，不是很想和你聊得话，就不需要说太多话了，引起不满，自己也比较尴尬。
13	linux上面时间不同步。
14	VWware是虚拟机，Centos6.5是linux的发型版本。
15	linux下tomcat环境的配置问题未解决。
```

### 2/10

```
1	把电脑里面的资料全部整理下，不要的全部删除掉。今天晚上搞定	ok
2	上午就到家了，下午把springmvc第一天的的视频看了，把代码敲出来。
3	陪陪家人，聊天。
4	晚上没事，自己看看电脑，进行敲代码，时间自己抓紧点，为了未来的我们，加油拼搏。
5	太阳能下面的沉淀，弄掉  太阳能桶子上面漏水。
6	网络管理员密码：JIAOLIN123@ WIFI密码：JIAOLIN1219??	http://melogin.cn/
```

### 2/11

```
1	先看mybatis第一天第二天，后面两天在看springmvc视频把代码敲出来，下午去外婆家一趟。
2	代码一律使用idea进行跑动，没搞定的晚上继续加油搞定，早上8点记得起床就好。
3	有时间帮家里人做点事情，在家一年陪他们的日子不是很多， 对家里人的东西，该出钱就多出钱，他们是你最亲密的人，自己脑袋里面要有个数。 
4	计划不如变化，老爸老妈催的太急，那边一点都不急，让我何去何从。那边父母亲不同意这件事情，让我怎么能够厚着脸皮过去。
5	昨天陪聊天去了，今天把昨天的资料看了吧，今天的资料延后一天。想办法全部补上来。
6	上火比较严重，自己主要多喝开水。
7	上午呆会到9点把饭菜煮熟了，自己弄好饭菜，差不多工作的人也过来了，就需要去忙了。
8	晚上问同事李娜，给六险一金的合同交，百分百为多少。
9	回来的太早，老爸老妈年前都在干活，就自己煮饭煮菜，都没有那个味道。聊天扯皮。
10	等会把碗洗了，晚上把饭煮熟，呆会外婆家里面去聊天。和舅舅去聊聊天。
11	有点冷，自己穿衣服，不要他们说了，都这么大一个人了。
12	呆会去问问菜菜她爸妈的名字。晚上去二婶家转转，让他们指点一下迷津。
13	不要偷懒，计划自己做好。
14	给小黑发信息过去。
15	明年把后面的视频的代码放百度网盘里面去。
16	使用mybatis，进行增删改查都没用。好扯淡。
17	5点以后出发过去外婆家，带上钱。
18	路径问题，要知道需要用到src路径才行。要不然获取不到。
19	出去外面的时候，记得穿的帅气一点，不管什么原因。
20	电脑密码已经设置好。
21	玩的好的朋友结婚，不要在乎那么1,200块钱，相处时间长了，都是要过的，别破坏感情。
22	触摸板永久禁止。设置，鼠标另外设置，硬件HID-compliant mouse禁止。
23	老妈的微信号18274356783密码15115974772a
24	菜菜的微信密码huangjiao
```

### 2/12

```
1	ssm项目的整合，一天时间全部看完，弄懂其中的意思。不懂得自己做笔记，放在每个月的
	1号文档本里面进行保存。把整个项目全部跑起来，不会的自己晚上加班搞定。
2	每天的早餐和中餐，记得煮个汤蛋，老妈强烈要求。O(∩_∩)O哈哈~
3	洗碗每天下午3点钟左右把碗洗了。
4	晚上要老妈把衣服的扣子弄好了。
5	还有一个，把视频上的东西，重新过一遍。今天来个总结，放在每个月的1号去补全。
6	idea强大的功能，可以在数据库里面进行数据的查询。
7	呆会晚点的话，去看下薪资单。去系统里面找找。
8	住房公积金卡有异常，后天去建设银行查询看看。
9	缴纳基数是什么？今天问清楚 
10	就先关于住房公积金卡注销的问题，问清楚，了解清楚，呆会上百度多查查看。
11	后面的话，自己时间多抓紧点，往专业方面多看，多抓紧。
12	另外一个问题，资金问题，手头多紧点。
14	有时间多去二婶家坐坐，听取下他们的意见。
15	这几天在家，还是多看些资料，别那个玩游戏了，玩不起了。
16	sql片段语句，在写if的时候，test="UserId!=null" 里面的UserId为实体类参数id，只有进行数据库查询的时候，才用数据，另外的就都用实体类的字段。
17	for循环快捷键 itar 生成array for代码块	itco 生成Collection迭代  iten 生成enumeration遍历	iter 生成增强forxun	itit  生成iterator 迭代	itli 生成List的遍历
ittok 生成String token遍历	itve 生成Vector数组迭代
18	sql语句异常，需要字段对应，进行
19	快捷键ctrl+alt+x 进行项目的整体关闭
20	老爸腰疼，呆会晚上看下病例，去咨询医生，买药回来。
21	呆会问清楚老爸的病因，知道具体名字，咨询医生
13	二婶说的话，心里面想了一段时间，挺难受的。
22	什么时候返回单个对象，什么时候返回集合。
23	FOREACAH循环有毒。
```

### 2/13

```
1	mysql多表查询，把资料视频全部拷贝回家，
2	花费两天的时间去记，去背诵关键字，查看笔记和博客。
3	这里浪费几分钟，那里浪费几分钟，时间就没有了。
4	记得和老爸提买蜂蜜的事情。有说
5	扣子的事情。
6	一对多代码
7	明天和她讲这个事情，请个人过去说，看看意见如何，二婶的意见是这样，这样下去也不是一个办法，这些钱省不了的就不要省了，讲道理，
	1 是要别人说我的坏事，传到阿姨口中，还是说我这边找个人说这件事，这两者之间影响很大。
8	今年这个事情，一定要把他搞定，我要想知道结果，后面和老哥说下。明天先打下预防针。在家也就这么几天，我想确定下，过来也是为了奔结婚来的，不是为了处对象，在这边，我的薪资待遇也有这么些了，我过来也是为了摆明一个诚意。我爸妈都喜欢菜菜，只是怕太唐突了，所以今天没有过来，
到时候买的东西有，酒和烟，去买。
9	是打算偷偷摸摸还是正大光明的在一起好点？
	是打算他们传送负面消息好点，还是我老哥传递正面消息好点。
	我为了的是结婚，而不是处对象。

10	明天的话，要问到具体的时间，那边大年初三，初四，初五下午的时间，一定要约一个。要提前和老哥打招呼。先要预约好老哥的时间，他比较忙。到时候他过去，能够说的比较顺畅，我就不需要怎么去担心。
11	自己记得身上带两包烟，过去。
11好、一对多代码

有两种结果，同意固然大好，不同意，也不至于打脸打的很响，后面看菜菜的反应了。就看是不是爱过的太深。

未知	触摸屏禁止：位置为在I2C HID设备上。
```

### 2/14

```
1	看springboot的视频资料，也就那么几节，以项目为主，先把helloworld跑起来。
2	在看看别的资料。
3	情人节，出去走走吧。
4	有些事情不可能的就不要出去瞎起哄了。
5	计划永远赶不上变化，说好的看资料那么多，总是被打扰。自己晚上加班加点呗，改弄懂的还是要去弄懂，加油，相信自己。
6	初二过去，看看阿姨的意见，要是阿姨看的上眼没有，没有的话，就看你的意见了。
7	明天打电话过去吧，我不想拖着了。不管什么原因。
8	一对一，一对多，主外键联合的时候，cloumn参数要对应，属性要对应
```

### 2/15

```
1	阿姨彻底不同意，就看菜菜的坚持了。坚持了两天，MMP 我草 
```

### 2/17

```
1	mybatis生成映射文件，需要修改三处地方，第一个是mapper接口的位置，第二个是mapper映射文件的位置，这两个要放在同一个位置，还有一个是pojo类的位置。
2	springmvc配置，/*拦截所有，/拦截所有，不包括jsp页面，.action指的是后缀名为action的路径名
3	springmvc的配置	  
<!--注解驱动-->
    <mvc:annotation-driven/>
    <!--视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp"/>
        <property name="suffix" value=".jsp"/>
    </bean>
 4	心里面挺不是滋味的，一直在和她好好的沟通，为什么会出现这样的结果，挺别扭的，真的。
 5	不要找人说了，耻辱。尽然和我提出分手。
 6	分手原来是这么容易从口中说出来。
```

### 2/18

```
1	springMvc视频参数，第一天和第二天。后面在整合~q
2	过两天说下这个网线的事情,正当的事情.
3	在mybatis里面的参数,
	1	配置数据库	2	配置db.properties	3	还有sqlMapConfig
	4	mybatis的工厂	5	mybatis的包扫描
	
	jdbc.driver=com.mysql.jdbc.Driver
    jdbc.url=jdbc:mysql://localhost:3306/crm?characterEncoding=utf-8
    jdbc.username=root
    jdbc.password=root

	    <!--进行包扫描-->
    <context:component-scan base-package="com.jiaolin"/>

    <context:property-placeholder location="classpath:db.properties"/>

    <!--配置数据库-->
    <bean class="org.apache.commons.dbcp.BasicDataSource" id="dataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="maxIdle" value="5"/>
        <property name="maxActive" value="10"/>
    </bean>

    <!--mybatis的工厂-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:sqlMapConfig.xml"/>
    </bean>

    <!--mybatis的包扫描-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.jiaolin.mapper"/>
    </bean>
    
    service层配置,进行配置扫描
    trans配置,1	事物注解,里面有包含数据库 2	开启事物 里面有属性参数,attributes	3 需要配置切面 切点和通知 point-cut tx-advice
        <!--事物注解-->
    <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="transactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--开启注解-->
    <tx:advice transaction-manager="transactionManager" id="txAdvice">
        <tx:attributes>
            <tx:method name="save*" propagation="SUPPORTS"/>
            <tx:method name="insert*" propagation="REQUIRED"/>
            <tx:method name="delete*" propagation="REQUIRED"/>
            <tx:method name="update*" propagation="REQUIRED"/>
            <tx:method name="find*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="get*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="query*" propagation="SUPPORTS" read-only="true"/>
        </tx:attributes>
    </tx:advice>
        <!--切面-->
    <aop:config>
       <aop:advisor advice-ref="txAdvice" pointcut="execution(* 				com.jiaolin.service.*.*(..))"/>
    	</aop:config>
    	
3	controller层参数,进行springmvc.xml的配置  在web.xml里面配置参数的时候,要配置disspathServlet,
springmvc配置参数的时候,需要配置扫描包,和注解驱动和视图解析器 internalviewResource
    <context:component-scan base-package="com.jiaolin.controller"/>
    <!--注解驱动-->
    <mvc:annotation-driven/>

    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
4	web.xml参数
需要配置context-param参数和spring的监听器和springmvc的分发器
  <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
       <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>*.action</url-pattern>
    </servlet-mapping>
```

### 2/19

```
1	在京东或者淘宝看电源插头和电源线和插板~ 买6个回来.
2	插头 ,电源线,插板,电源胶布,螺丝刀和斜口钳 看插座内部采用的是什么,铜芯设置? 
	电源线在京东购物车,插头和插座在淘宝买 插座和插头能不能放1.5平的线
3	起床问老爸的意见
4	打印机问题,另改为PDF就可以了.
5	今天安装的插座,明天早上需要进行安装.
```

### 2/20

```
1 在家休息
```

### 2/21

```
1	呆会把衣服全部清好,羽绒服1件,棉衣一件,大衣一件. 都已找到,但羽绒服的帽子没有找到,回家问问老妈.(还有一套衣服在那边晾着,明天带过去,还有牙刷和洗脸的毛巾,也一起带过去.)
2	呆会找个大点的袋子,装吃的过去,鸡蛋和蜂蜜和豆腐和腊肉,牛肉,打包的肉,买点卤菜,100元左右.
3	过几天,到那边的话,去买个冰箱. 
4	try catch if for do while  runnable 的快捷键 ctrl+alt+t 
```

### 2/22

```
1	罗涛地址位置:湖北省孝感市孝南区胜利街164号
```

### 2/23

```
1	坐姐夫的车从家过来深圳,下午2点出发,到这里差不多6.50的样子。直接送到了楼下
2	下次去超市的时候,买点菊花回来,用来泡菊花茶喝.
```



### 2/24

```
1	比较尴尬的事情是,不理我了.我有时候不知道怎么去想了.都说先上船后买票.哪那么容易
2	现在把东西全部放进冰箱里面去。ok
3	后面把拦截器的东西弄懂，熟悉，把东西整理下，明天把ssm整合的代码写了。
4	呆会下单给老爸老妈各买一套保暖衣，老爸，身高163,140斤，老妈不知道。
5	有时间就去适当的运动下，周六周末的时候，别老呆在家里。OK
6	另外一个事情，对一些平常的日常生活不是很清楚的，自己百度，多看看别人的意见。你会发现你也懂很多。加油。 OK
7	把资金算一下,今年的目标是多少,呆会算算. 
	住房公积金:5700元,工商银行:24380	平安银行:4433	招商银行:4300元 证券:16262  总金额 55075 减去 6500的电脑 48575  加上今年的8W 总算起来有9500*12=114000 有个12W就不错了.
8	晚上的拦截器没搞定,明天早上起来弄.
```

### 2/25

```
1	抓紧时间看ssm整合的代码,把上班的任务完成后，在想办法自己去补充别的知识点。学习另外的知识点，以后在说了。在前面的半年时间里面还是想办法把ssm框架弄清楚，弄明白在加上shiro框架。另外的还有一个angularjs的学习。最主要的前面半年为这些。主要的是用idea去提交项目。	ok
2	今年的9月份开始去学习springboot视频，	ok	
3	电脑有时候反应不灵敏，多看看鼠标的问题，几次都是鼠标问题所造成的，不要心急。	ok
4	把衣服全部用洗衣机洗了，还有一个棉衣用手洗，不要放机洗，后面会造成不保暖的状态、OK
5	F8走下一步,在debug模式下 如果是方法,不进入到方法体中,	ok
	F7相反,如果是方法,进入到方法体中
	F9是恢复程序运行,如果有断点,直接跳转到下一个断点处.
	alt+F8 通过调试对象,查看所输出的结果
6	每到周六周日的时候,要记得先把当天的杂事做完,然后在自己敲代码,那样的话,可以不用分心.	ok
7	明天去看虚拟机里面的redis服务器有没有开,	
8	自定义分页标签,用java代码写的.公共类	ok
9	11.30-12点钟的word密钥输入 ok
10	ssm开始项目的时候,分步骤来,第一步:先导jar包
 在开始配置dao(需要配置sqlMapConfig.xml,里面需要配置有头文件和别名,pojo,还有需要配置applicationContext-dao.xml,里面需要配置有三个 数据库,sqlSessionFactory 指向数据库和加载sqlMapConfig.xml参数和mapperScanConfig扫描包进行mapper扫描) service(进行service层扫描) controller(进行springmvc的配置,里面需要配置三个参数,controller扫描,和注解驱动,和视图解析器 suffix 后缀) trans的配置(有三个,事物管理器,DataSourceTransactionManager,通知:<tx:advice>
 切面:<aop:config 通知的指向>和切点 在service层 execute(* com.jiaolin.service.*.*(..)))
 在web.xml中进行配置加载application-*的参数 ,另外还有listen监听器,spring的监听器contextLoaderListener,和Filter过滤器,和servlet服务器,用的是dispatchServlet中心分发器 里面需要配置路径 springmvc.xml 还有一个load-on-startup 为1 进行配置,另外一个url路径为/意思代表的是拦截所有.)
 
  <!--加载器 context-parm-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring/applicationContext-*.xml</param-value>
    </context-param>
    <!--spring监听器 listen监听-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <!--filter过滤器 utf-8-->
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!--dispatchServlet前端控制器-->
    <servlet>
        <servlet-name>crm</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/springmvc.xml</param-value>
        </init-param>
        <!--最开始就加载-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>crm</servlet-name>
        <!--/是拦截所有-->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    
    
 log4j
# Global logging configuration
log4j.rootLogger=DEBUG, stdout
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n


db.properties
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/crm?characterEncoding=utf-8
username=root
password=root

 <!--需要配置controller扫描-->
    <context:component-scan base-package="com.jiaolin.controller"/>
    <!--需要配置注解驱动-->
    <mvc:annotation-driven/>
    <!--配置试图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    
    
    <!--事物的配置,jdbc事物 需要指向DataSource -->
    <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="transactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
<!--通知-->
    <tx:advice transaction-manager="transactionManager" id="txAdvice">
        <tx:attributes>
            <!-- 传播行为 -->
            <tx:method name="save*" propagation="REQUIRED" />
            <tx:method name="insert*" propagation="REQUIRED" />
            <tx:method name="add*" propagation="REQUIRED" />
            <tx:method name="create*" propagation="REQUIRED" />
            <tx:method name="delete*" propagation="REQUIRED" />
            <tx:method name="update*" propagation="REQUIRED" />
            <tx:method name="find*" propagation="SUPPORTS" read-only="true" />
            <tx:method name="select*" propagation="SUPPORTS" read-only="true" />
            <tx:method name="get*" propagation="SUPPORTS" read-only="true" />
            <tx:method name="query*" propagation="SUPPORTS" read-only="true" />
        </tx:attributes>
    </tx:advice>
<!--切面-->
    <aop:config >
       <aop:advisor advice-ref="txAdvice" pointcut="execution(* com.jiaolin.service.*.*(..))"/>
    </aop:config>
    
    
     <context:property-placeholder location="classpath:db.properties"/>

    <!--需要配置数据库 和db.properties-->
    <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource">
        <property name="driverClassName" value="${driverClassName}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
    </bean>

    <!--sqlsessionFactory工厂,需要进行加载sqlMapConfig.xml文件 指向数据库 -->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:mybatis/sqlMapConfig.xml"/>
    </bean>

    <!--mapper扫描器,扫描包-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.jiaolin.mapper"/>
    </bean>
```



### 2/26

```
1	在虚拟机里面配置redis,在里面进行操作	未完成
2	冰箱	冰箱温控旋钮一般有0、1、2、3、4、5档或者是0、1、2、3、4、5、6、7档（一般情况下，0档是停机档。5、6、7档是强制冷档位，打到强制冷档位时，压缩机不断运行，冰箱处于不停机状态，请注意一下咯）一般春秋天我们放到3档上，夏天我们可以打到1档或2档，冬天打到4档或5档（数字越大，冰箱温度越低）
温度越高耗电量就越低		OK
3	把下面的泡沫弄掉 东西收拾下,过10分钟重新插电	ok
4	明天京东发票问题.
5	redis被我解压到哪里去了,没看到,明天找出来.先睡觉,不然会睡过头的.明天就晚点睡.先涂点碘酒和涂下脸,每天晚上都要注意这些. 已经解压好了,出错
6	xshell软件的下载,回家,台式电脑copy  也会过期,看看破解版的.CRT的下载,和安装.文档说明 OK
7	redis在linux中的安装,并且回去找伴郎需要的西裤,黑色皮鞋和白色衬衫~	回去看视频
8	闲下来了,把数据库整理一下~多操作操作
9	还有一个使用hibernate和数据库所对应的参数文件配置
10	电脑触摸板快速操作~
11	U盘有借出去,记得拿回来.
12	杀死tomcat的进程	[mcbadm@AppMonitora bin]$ ps -ef|grep tomcat
	mcbadm    4813     1  0 Feb08 ?   进程的pid为4813 
```

### 2/27

```
1	看传入的参数问题,前端传过来的参数	ok
2	日期转换格式 yyyy-MM-dd HH:mm:ss 年月日,时分秒	OK
3	不该说的话,不用说,以免伤感情~  不愿意学的,不要交,浪费时间~	ok
4	日期格式转换	ok
5	crm2还没有完成~
6	谷歌浏览器看数据,要全部知道意思,才行	ok
7	java.sql.Timestamp怎么写参数
8	晚上回家去超时一趟,买纸巾	ok
9	谷歌浏览器debug模式的运行	
10	明天换衣服,针织衫过来,扣子还没弄好~	ok
11	清除谷歌浏览器缓存快捷键为ctrl+shift+del键	ok
12	别的电脑有参数,自己的多删除,多测试,会有的.就像数据库参数一样.	ok
13	每次回家的时候,记得把垃圾带到垃圾桶里面去	ok
14	服务器两个,一个171放tomcat,一个172放数据库和图片 	OK
15	这个星期把月报发布的后台代码写出来,另外的时间在家里干活,一些杂事弄清楚了~	ok
16	redis服务器安装好了,在后台,可视化工具连接不上去.明天解决 解决不了
```



### 2/28

```
1	电脑程序自动启动异常,未解决 
2	后台启动,为./redis.server redis.conf 	关闭redis服务 进入到redis.cli端,使用shutdown进行关闭 客户端连接redis服务,未解决	
3	今天回去把电源线全部接好~ 斜口钳回来了
4	公司邮箱登录~查看薪资单	OK
5	设置为开机启动,在linux中 未解决
6	英泽邮箱账号/密码:i1173/inzy2018	未解决
7	回去快递~2个 OK
8	内存溢出 修改TOMCAT_HOME/bin/catalina.sh	OK
            在“echo "Using CATALINA_BASE: $CATALINA_BASE"”上面加入以下行：
            JAVA_OPTS="-server -Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=128m"
             解决方案.
9	虚拟机中mysql账号/密码是root/root
```

### 3/1

```
mybatis的一对一方法 一种继承,一种直接在类里面添加对象 返回的都是list集合
第一种
public class OrdersUser extends Orders {
	private String username;
	private String address;
	}
	List<OrdersUser> getItemsList(@Param("start")int start, @Param("pageSize")  int pageSize);
	    <select id="getItemsList" resultType="OrdersUser">
           SELECT o.id,o.user_id,o.createtime,u.username,u.username,u.address
           FROM orders o
           LEFT JOIN user u on o.user_id=u.id LIMIT #{start},#{pageSize}
    </select>
	第二种
	public class Orders {
	private Integer id;
	private Integer userId;
	private String number;
	private Date createtime;
	private String note;
	private User user;
	}
	List<Orders> getItems(@Param("start")int start,@Param("pageSize") int pageSize);
	    <resultMap id="order_user" type="orders" autoMapping="true">
        <id column="id" property="id"/>
        <association property="user" javaType="User" autoMapping="true">
            <!--column 关联字段  property为javabean的字段名-->
            <id column="user_id" property="id"/>
        </association>
    </resultMap>

    <select id="getItems" resultMap="order_user">
           SELECT o.id,o.user_id,o.number,o.createtime,u.username,u.address
            FROM orders o
            LEFT JOIN user u
            on o.user_id=u.id LIMIT #{start},#{pageSize}
    </select>
    
    一对多:用户与订单 和多对一就是sql语句进行左右互换
    在User里面添加List<Orders>order 返回的是一个map集合,在xml中resultType="Map集合"
    <resultMap id ="Map集合" type="当前类的名字" >
    	<id column ="id名字" property="javaBean属性名"/>
    	<result column="" property=""/>
    	<collection javaType="所对应的集合list"(可以省略) ofType="集合里面所对应的类" property="所对应的属性"/>
    	<id column ="中间的连接点,本数据库中的外键对应的别的数据库的注解的字段列" property="javabean的属性"/>
    </resultMap>
```



```
1	md文档图片的上传 ![图片名字](图片的路径) 加入3个--- 是一条水平引线
2	虚拟机安装mysql和tomcat和jdk和redis 
3	文件有隐藏,需要进行设置,点击电脑,查看,隐藏的项目里面进行设置.
4	虚拟机不要关机,开机需要一段时间.
5	GMT是国际时间
6	一月到十二月 一月(January Jan)	二月(February Feb)	三月(March Mar)	四月(April,Apr)
五月(May,may) 六月(June,jun) 七月(July,jul)	八月(August,Aug) 九月(September,Sep) 十月(October,Oct) 十一月(November,Nov) 十二月(December,Dec)
7	星期天到星期六		Sunday (Sun.)星期天  星期一 Monday  二Tuesday 三 Wednesday Wed 四 Thursday Thur 五 Friday	六Saturday Sat
8	已经安装好jdk mysql,(用外部nacavit能连接),tomcat(用8080能够连接),redis在linux中安装成功,
9	linux加载资源 source /etc/profile(文件路径) 创建文件mkdir touch空文件
10	rpm -qa : 查询所有安装过的软件包 rpm -e --nodeps  删除的软件包名: 删除指定的安装包 
		rpm -ivh  包名 :安装rpm包	quit:退出 	cd -     切换到上一个所在目录(上一个操作的)	1mkdir(make directory): pwd:打印当前工作的目录
11	还有遇到一个问题,在本地运行时正常的,在测试环境跑的时候,就出现了异常,那就重新导war包,进行重新测试.不要急,出现问题了,自己去多找找.特别是bug的时候,每一个都要去想,去看.解决问题.
12	转码问题,看别的模块.用户信息,查询特定的省份.	在服务器的tomcat里面的server.xml里面进行配置了useBodyEncodingForURI="true" URIEncoding="UTF-8" 
一般的连接有内连接,左外连接,右外连接.
```

###   3/2

```
1	分页代码的显示,在百度网盘上,去进行下载,还有svn的操作,50天资料里面,进行观看.
2	上午进行项目的发布
3	分页代码的显示
4	住房公积金,没有正常状态的联名卡,不能登录 待解决,还有一个社保的问题,待解决.
5	不要说了,还更加麻烦.
6	乱码问题 useBodyEncodingForURI="true" URIEncoding="UTF-8" 测试服务器里面的tomcat的server.xml中增加参数 看tomcat的服务器参数的修改和本身是否有转码
7	在跑动的时候一定要先停tomcat.
8	进行动态获取参数 sql语句能写,动态获取参数 
9	爱立信的离职证明放在杨文豪手中
10	写接口欠缺太多 动态获取数据,自己来写接口,今天抓紧看懂,会写.
11	在mapper.xml中写sql语句,大小写无所谓 sql语句一句一句来传 一个方法写一个接口 在dao的参数@param参数传入到dao中
12	今天晚上问猴子的问题 关于mybatis框架问题 字段对应
13	把crm摸透 今天 看参数的对应值
14	  	 <if test="varCode != null and varCode !='' ">
            and var_code=#{varCode}
        </if>
        <if test="varCode != null and varCode !='' "> varCode指的是传入的值是否为空,前端的值(name还是value?) 进行查询
        var_code=#{varCode} var_code指的是数据库查询的字段  varCode指的是获取的数据 从前端获取的数据
<!-- query capes data list -->
    <select id="getCapesDateList" resultType="java.util.Map">
        select *
        from app_test.app_month_report_middata
        where 1=1 and data_month=#{dataMonth}
        <if test="provinceName != null and provinceName != '' ">
            and province=#{provinceName}

        </if>
        <if test="varCode != null and varCode !='' ">
            and var_code=#{varCode}
        </if>
        <if test="varName != null and varName !='' ">
            and var_name =#{varName}
        </if>
        limit 10 offset #{pageNum,jdbcType=INTEGER}
    </select>
    
    	public List<Map<String, Object>> getCapesDateList(@Param("pageNum") int pageNum,
			@Param("dataMonth") String dataMonth, @Param("provinceName") String provinceName,
			@Param("varCode") String varCode, @Param("varName") String varName) throws MyAppException;
```

```java


import java.util.List;

public class PageBean<T> {

	private int currentPage;// 当前页数
	private int pageSize;// 每页显示的条数
	private long totalPage;// 总共有多少页
	private long totalSize;// 总共的条数
	private List<T> list;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
```



### 3/3

```
1	欧阳凯结婚,当伴郎,吃饭喝酒.没干点屁事
```

### 3/4

```
1	在xml中sql动态语句,int类型 的时候,!=null String类型!=null and !=''串的时候..
2	动态语句, and id=#{id} 括号里面的id是对象里面的属性值.
3	寄快递回家,邮政962017923181 
4	结婚算了下,408红包~	皮鞋50,西装80  130
5	用idea导入eclipse参数,出现Class文件异常,处理办法,重新创建一个类,把资源全部导入进去,如果有依赖,在重新把类名改成原来的类名。
6	今天晚上还看另外sql动态的参数.
```

### 3/5

```
1	数据库sql语句的书写
2	换了网线,可以进行网络的连接,测速的话,有590KB/S左右,进行下载试试看,都需要设置代理,代理的添加为192.168.105.71端口号为80.谷歌和火狐浏览器代理是一样的设置.
3	在项目中能够跑动起来,连接上网络的话.
4	在Navicat中查看表的字段类型使用的是,点击表,且右键进行设置表,可以查看到属性.
5	明天开始做新的需求了~有活干了.
5	困了,就中午睡会,呆会醒来了,继续看mysql
6	回去把idea视频下载好,公司网络不好
7	mysql连接查询,分为内连接和外连接
	内连接分为隐式内连接和显示内连接 隐式内连接也称为笛卡尔积,显示内连接以等于号进行过滤 inner join on	形成的中间表为两个表经过on进行过滤,查询出交集所对应的参数.
	外连接分为左外连接和右外连接,左外连接,查询出所对应的交集,如果右边表没有数据,则以空显示.
	右外连接和左外连接相反,左边表没有相应的数据,则以空显示
8	SQL查询的基本原理
	单表查询:根据where条件过滤表中的记录,然后根据select选择列进行返回最终结果
	两表连接查询:在on后面写连接条件,在where后面写过滤的查询条件,根据select指定列进行返回查询结果.
	多表连接查询:先对第一个和第二个表按照两表连接做查询,然后用查询结果和第三个表做连接查询,以此类推,直到所有的表连接上为止,最终形成一个中间的结果表,后根据where条件过滤中间表的记录,根据select指定的列返回查询结果.
	on 和where条件的区别:
		on:过滤两个链接表笛卡尔积形成中间表的约束条件.
		where:on只进行连接操作,where过滤中间表的记录.
	
	对于连接类型的选择：  在实际运用中如果连接类型选择不当， 不但出现效率低并且可能还会出现逻辑的错误

1、 查两表关联列相等的数据用内连接

2、 Col_L是Col_R的子集时用右外连接。（左边表是右边表的子集，用右外）(如果集合A的任意一个元素都是集合B的元素，那么集合A称为集合B的子集)

3、 Col_R是Col_L的子集时用左外连接。（右边表是左边表的子集， 用左外）

4、 求差操作的时候用联合查询。

并且，多个表查询的时候，这些不同的连接类型可以写到一块
9	手机费用问题,回去下载10086联通话费app	OK
10	把手指甲剪掉,
11	联通客户密码:911219 我的生日 积分兑换 回去弄	OK
12	进行多表查询的时候,用内连接,使用join on 表达式 
13	即"(+)"所在位置的另一侧为连接的方向，右连接说明等号右侧的所有
14	两个收藏的博客资料
15	网络和手机实现实时更新,
16	Decimal 十进位的,小数的[desiml]
17	having和group by的使用 明天的任务
18	sql练习做到28题.
```

### 3/6

```
1	百度网盘不需要设置代理,就可以下载东西,看图标,是否变成灰色.
2	速度快的时候,有5M/s,呆会下班后,自己下载,尹忠的文件视频里面有需要的参数,家里面的最高速度就370KB/s.
3	数据库limit的书写和group by having的书写.
4	--  LIMIT n 开始数是从0到n条
	-- 	limit n,m 从 n+1条数值开始,结束为n+m条 一页显示m条
	-- 	limit n,m m为无线大时,显示出来的是从n+1到最后一条数据
5	新的需求  1	 测试环境中redis的开启,以及启动,做的3个缓存,进行测试.
			2	版本更新 数据库版本的更新 
			3	系统日志 把操作了的数据进行书写出来. 
			4	角色管理 
			5	权限管理 
			6	app端知识库的接口链接
6	进行redis的测试,端口号没有,肯定不行
7	禹亮整理的资料
	1、版本更新管理：涉及表：jkapp库，t_sys_app表，apk和iOS安装包上传目录：（生产：192.168.75.60上的/root/datatransfer/apk）(无数据库,无表)

      2、用户权限管理：集团用户可以查看全国和各省的数据，省端的只能查看全国和本省的数据，系统管理员可以查看所有数据（这个具体怎么设计可以开个会讨论一下）(回去看看项目中用到的角色)

      3、用户角色管理：zskdb库，bskm_role表，()

      4、知识库（APP端）：查看请求的接口，知识库推荐和最新知识需要和pc端的一致（需要了解知识库pc端的话，可以带你们看下）(查看知识库的接口参数)

      5、session过期，跳转到登录页，月报管理的每个请求后台的接口需要处理 (前端进行页面的路径跳转)

      6、用户行为监控：把目前系统日志页面的日志数据，新做一个统计分析的页面，图标形式展示
      	(数据库表进行数据查询,进行分页查询,看分页的代码) 需要创建实体类,在controller层进行返回成功或者失败,

      7、安卓、iOS，漏洞修复  (做的是jar混淆)
      
 8	呆会5.30以后进行项目的发布与访问,先找到对应的路径~ 进行集群版的测试,看打印的日志,有没有命中率 先看看redis集群版
 9	缓存有好多异常的,先放一个上去,就做流量支付模块,另外的不要管.(该改的,该删的,全部删除掉)
 10	进行重开一条分支问题的问题
 11	idea下载的jar包放在什么目录下 下载到C盘,从 jar包的真是路径来查看 	也就是:C:/Users/jl250/.ideaLibSources/目录
 12	回家任务,集群设置,把redis单机改为集群,到时候,就需要进行撤出
 13	住房公积金,证书需要用ie浏览器才行,另外去银行看看,是交了142还是285,应该是142,共同交285
 14	redis集群节点的配置
 15	进行cp到文件夹的时候,记得后面要加 -r 递归复制
 16 vim *.sh 创建文件夹 
 17	-c以集群的方式连接,
 18	明天还需要去进行设置,批量关闭,设置快捷按钮
```

### 3/7

```
1	试着去把redis缓存关闭,看报错不,在流量L1tfdao.xml中,进行注释掉在流量支付xml里面的缓存引用
2	在redis集群中进行添加节点,进行设置,后面的代码需要更改~
3	座位的话,不打算换,要不然没有网络,比较吃亏.
4	用的本地网络,可以进行ping通
5	主要工作为昨天新需求的任务
6	不需要设置代理,浏览器,也可以使用.
7	需要写文档,写controller,service,dao
8	文件搜索,ctrl+h fileserach
9	需要返回值,给前端 返回对象ResultVo  成功了则返回ResultVoUtils.succes(data) 里面有返回data和smag和code,失败则ResultVoUtils.fail()
10	创建分支
11	字段名字是否要相同 注解传参的话,在dao层 使用@param ("名字一样,和xml里面传的参数")
12	在web层的参数,比如像(int currentPage,String startTime,String endTime),字段的名字,一定要匹配 才能够获取到.
13	呆会回去看看
14	dao传递过来的字段名称一定要和xml里面的字段名称一致,那样才能获取到.
```

### 3/8

```
 1	明天记得时间的sql语句进行书写,
2	明天一过,就把那个进行删除,并上传参数
3	创建好表,直接去数据库导出,用xftp
4	F8下一步,
5	创建分支,在原来的地方进行copy到另外一路径就行.删除的话,也打字就行!
6	全网监控 原版图形 https://pro.modao.cc/app/uxfAxjy4kNftPYLbbXcCyUX8CtahmM5#screen=s9C91C6EC2E1496659957646
7	启用驼峰式命名 在sqlMapConfig.xml中添加 <setting name="mapUnderscoreToCamelCase" value="true" />
8	使用map进行参数的设置
9	create_time 是以时间戳的数字进行显示
10	系统日志:登录账号,所属省份,操作,客户端,操作时间
11	权限问题
12	 select * from tb_Book order by id asc limit ?,? limit arg1,arg2 arg1指定查询记录的起始位置； arg2用于指定查询数据所返回的记录数
13	多表查询使用pagehelper 进行分页 回去看资料
14	<!-- 配置分页插件 -->
    <plugins>
        <plugin interceptor="com.github.pagehelper.PageInterceptor">
            <!-- 设置数据库类型 Oracle,Mysql,MariaDB,SQLite,Hsqldb,PostgreSQL六种数据库-->
            <property name="helperDialect" value="mysql"/>
        </plugin>
    </plugins>
    
 15	mybatis的xml配置先后顺序
  <!-- 属性：定义配置外在化 -->  
    <properties></properties>  
    <!-- 设置：定义mybatis的一些全局性设置 -->  
    <settings>  
       <!-- 具体的参数名和参数值 -->  
       <setting name="" value=""/>   
    </settings>  
    <!-- 类型名称：为一些类定义别名 -->  
    <typeAliases></typeAliases>  
    <!-- 类型处理器：定义Java类型与数据库中的数据类型之间的转换关系 -->  
    <typeHandlers></typeHandlers>  
    <!-- 对象工厂 -->  
    <objectFactory type=""></objectFactory>  
    <!-- 插件：mybatis的插件,插件可以修改mybatis的内部运行规则 -->  
    <plugins>  
       <plugin interceptor=""></plugin>  
    </plugins>  
    <!-- 环境：配置mybatis的环境 -->  
    <environments default="">  
       <!-- 环境变量：可以配置多个环境变量，比如使用多数据源时，就需要配置多个环境变量 -->  
       <environment id="">  
          <!-- 事务管理器 -->  
          <transactionManager type=""></transactionManager>  
          <!-- 数据源 -->  
          <dataSource type=""></dataSource>  
       </environment>   
    </environments>  
    <!-- 数据库厂商标识 -->  
    <databaseIdProvider type=""></databaseIdProvider>  
    <!-- 映射器：指定映射文件或者映射类 -->  
    <mappers></mappers> 
  16	文件上传 在博客文档里下载好了 CommonsMultipartResolver 公共的文件解析器,  enctype="multipart/form-data"一种编码,用来传输特殊格式的,比如图片或者文件
```

### 3/9

```
1	用户行为监控：把目前系统日志页面的日志数据，新做一个统计分析的页面，图标形式展示 问禹亮哪个数据库和表,还有一个原型图
2	系统日志,修改和删除 OK
3	上传的文件的demo  	OK
4	debug模式下,报错port is specific 端口号无效,看设置tomcat-->startup/connection -->debug模式下的port端口进行设置
5	源码分析的五种境界:
	1只关注项目本身,不懂就百度一下.
	2除了做好项目木,还会阅读和项目相关的技术书籍
	3除了阅读相关的书籍,还会阅读相关行业的书.
	4找一些开源项目看看,大量试用第三方框架.还会写写demo
6	新需求	系统日志,查询四个,按时间(折线图),按省份(柄状图),按模块(柄状图 operation),按平台(柱状图 platform) 
还有一个jar包混乱,容易被攻击

7	获取当前年的一月份
8	数据库时间转换问题
9	写好的代码在文件中不要删除
```

### 3/10

```
1	在家捣鼓一天代码,请教同事问题
```

### 3/11

```
1	请教同事问题,进行代码的书写
2	时间戳转换问题,数据库中字段为timeStamp,显示为2017-06-22 19:02:17,
查询语句 转为 年月日select date_format(date ,'%Y-%m-%d' ) from talbe_a
3	接口文档
4	jar包混肴
5	1分钟60秒,60000毫秒
```

### 3/12

```

1	文件属性加载properties
2	windows-->show views-->project explorer 显示窗口属性
3	杨龙 	SVN仓库：https://192.168.59.18/svn/JKAPP_SVN/branches/01develop/01branches
	
	SVN账号： wyyanglong
	
	SVN密码： SVN@euyg87$
	
	原型地址： https://pro.modao.cc/app/uxfAxjy4kNftPYLbbXcCyUX8CtahmM5#screen=s11DCD6C8001495020615041
  
	测试地址： http://192.168.121.171/jkapp/views/admin.html#/monthRep

	

	eclipse启动服务，本地地址： http://localhost:8080/jkapp/views/admin.html#/home

	线上地址： http://192.168.121.171:8080/jkapp/views/admin.html#/home
		   http://192.168.121.171:8080/jkapp/jkapp.html
4	eclipse视图设置,windows-->reset perspective
5	今天回家把自己写的代码捋下思路.
6	版本管理的需求,任务
7	jar包混肴  和url路径,解密加密问题
8	文件上传问题,路径
9	下次代码按照自己的风格来
10	@Repository3 自己写注解,涉及到注解 @Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Repository3 {

	public abstract String value() default "";
	
}  不懂意思.
在spring-mysql.xml配置文件中写 设计到数据库的问题
11	eclipse中搜索的使用 ctrl+h fileSearch 
12	银行卡资金问题 
13	晚上,springmvc.xml和spring-mysql和mybatis-config.xml参数文章 静态资源问题
	XSD是指XML结构定义 ( XML Schemas Definition
14	先把遇到的问题,进行能够理解,下次能写出来就好,不要去深究源代码,那样比较累,等一年或者两年之后在去深究源代码,把基本的业务逻辑跑起来在说. 基础的不懂,不要去深究~~
	web.xml中webAppRootKey 为获取根目录路径,用来配置logback.xml 日志文件
	
		<mvc:annotation-driven>
		<mvc:message-converters>
			<bean
				class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
				<property name="features">
					<array>
						<value>WriteMapNullValue</value>
					</array>
				</property>
			</bean>
		</mvc:message-converters>
	</mvc:annotation-driven> 
	fastjson 进行转换 WriteMapNullValue 当为空值null时 不输出
	
	MainIntercepter 主拦截器
	
	<aop:aspectj-autoproxy />aop面向切面 --> 自动代理 有一个proxy-target-class属性，默认为false，表示使用jdk动态代理织入增强 当为true时,表示使用cglib动态代理
	<task:annotation-driven /> 使用spring注解配置定时任务
	
		<bean id="mysql_config"  class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="sqlSessionFactory" ref="mysqlSessionFactory" />
		<property name="annotationClass" value="cn.cmsz.jkapp.basic.util.Repository2" />  
		数据库设置注解类,自动扫描注解
		
	 <bean id="mysqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation" value="classpath:config/mybatis-config.xml" />
		<property name="dataSource" ref="mysqlDataSource" />
		<property name="mapperLocations" value="classpath:cn/cmsz/jkapp/**/mappermysql/*.xml" />
		sqlSessionFactory的mapperLocations 为扫描mapper动态代理位置.xml参数
```

### 3/13

```
1	@Controller和@RestController的区别？
官方文档：
@RestController is a stereotype annotation that combines @ResponseBody and @Controller.
2	进行判空处理,在serviceImpl层
3	eclipse格式化快捷键 ctrl+shift+f
4	eclipse方法注释模板设置 今天回去把模板类,方法注释好,还有设置 
5	进行文件路径加载 properties参数.load(in) 
6	移动热点为什么关闭?
7	${}进行拼接 #{}进行占位
8	接口示例要和查询到的数据一致,不要为了省内存
9	本地测试http://localhost:8088/systemLog/getSystemLog.action?startTime=201701&endTime=201801&provName=全网监控中心
10	月份查询查到年底 
11	代码更新了,不要在问别人的意见
12	需要按年先过滤然后再按月,增加,删除,修改 
13	问题太多~
14	明天的任务,判断不为空,
15	有些事,不该问,就不用问,很尴尬的.
```

### 3/14

```
1	每天上下班,可以看看浏览器网址,看报错异常,每天时间有两个小时.
2	在忙的情况下,或者别人语言有什么不对的地方,就当做没看到就好,等下班在回信息也可以.
3	java字段都改为Integer
4	这么不好说话,就很尴尬了~
5	进行保存,不需要
6	进行对象添加的时候,直接传入对象,可以进行值的获取,传值错误的时候,也不能进入方法中
7	类型都需要进行大写 还有在参数的时候,字段要和实体类的字段一致.
8	动态获取参数OK
9	更新数据 仔细仔细在仔细 脑力活,刚开始,多想一点~想到各种可能
10	过两天在说问题点了~
11	U盘之类的东西,不熟悉的,就不借了,丢掉了~~妈蛋
12	回去把保存参数在重新用一种方法做 看debug模式
13	判断Integer为空,就是 变量==null 
14	进行resultVo和ResultVoUtils的书写
15	情人节~ 
16	晚上把代码格式规范,导入进去了,在java-->code type-->formmat里面点击google setting --> line wrapper 设置100 第一行,都设置成4个空格,命名为文件三月14号.epf,以后要更好新空间的实际,到另外一个空间时点击Copy setting 两个都勾选,还有需要导入配置,import exference.epf文档,就可以看里面的格式
```

### 3/15

```
1	进行添加对象的时候,传入参数只传所对应的参数
2	还有,进行查询的时候,只查询所需要的字段,不要放对象进去,明天看sql,传对象
3	jar包混肴  和url路径,解密加密问题 
4	明天继续写版本~ 
5	周六周末进行jar包的更改 OK
6	周六周末进行url路径的更改 加密解密问题
7	springBoot,和mybatis返回结果集类型. 动态代理
8	查询的参数不对,看debug模式,转码问题.和他们的配置环境要一致.
9	任务,不该抢的时候,不要抢,自己写demo就好
10	需要搬房子,另外一个,需要~事情比较尴尬~
11	另外,照相头要往镜头看
12	查看.bat文件错误,window+r,点击cmd 把.bat文件拉进去,进行编译,就能查看到文件是否错误,问题出在哪里
13	还有一个问题,java编译错误,需要把%JAVA_HOME% 移动path最前面 
14	还有个时间长短的问题,说实在的跟心情有很大的关系.
15	没实体类,可以查询到数据吗?查找不到
```

### 3/16

```
1	jar包混淆
2	接口加密
3	增删改查,改良方法
4	参数为int类型,返回的时候,可以返回一个int类型,当>0时,成功
5	还有一个,数据库的资料,不要更改
6	明天想起来还有另外一个事情,就是说时间间隔,不能大于2年 OK
7	还有一个问题,是属于springmvc进行加载静态资源问题.
8	问下尹枫url问题	ok
9	文件上传URL路径怎么写 
10	D:\eclipse\configuration\org.eclipse.update
E:\jkappIdea\out\artifacts\jkappIdea_jar
11	修改了129行
```

### 3/17

```
1	在家捣鼓一天的Fiddler抓包工具和Wireshark抓包工具,Fiddler出来了个URL,具体的URL还没有出来,
2	使用jar混淆,还没有开始做,明天或者晚上多摸索下.OK
```

### 3/18

```
1	上午摸索了下Fiddler,下午打王者荣耀去了,和女朋友,到欧阳凯那里转了一下午,吃了个饭,让鸭脑壳飞~,真辣! ok
```

### 3/19

```
1	早上骑自行车,不好骑的不要去选择了,宁愿走路,本身就没有多长的一段时间。ok
2	jar混淆和接口加密工具，这个星期的工作量。没有搞定jar混淆  java项目加密，使用Proguard进行项目混淆加密  ok
3	参保状态 一档 基本医疗保险一档区别？ok
4	Mapper代码的增删改查代码	 E:\Mapper增删改查\free-Mapper-master 看不懂
5	任务捷威微信产品，支付问题 
6	该花钱的地方，想着办法去花钱，特别是对女朋友。大方点。答应的事情就应该做到，还有一个，需要去吃烧烤，买花。能花多少钱。ok
7	生活之余,不要把工作之中的情绪带进来。ok
8	session和cookie的问题 session是在服务端,cookie是在客户端,用来保存账号密码的
cookie默认浏览器关闭,就没有,如有设置,会保存在硬盘中,下次打开,直接从硬盘中获取cookie
session 是服务器给自动分配的,没有的时候,自动添加一个,有的话,进行匹配 OK
9	明天的任务fiddler抓包  一一兑现	
10	今天晚上任务,摹课网视频,加密 jdkbase64不建议使用 ok
11	加密问题在E:\java加密代码 里面进行查看,还有github上面和谷歌收藏里面 ok java-security-master看不懂 E:\java加密代码\obfuseSmaliText-master看不懂 E:\java加密代码\JarEncrypt-master看不懂
```

### 3/20

```
 1	今天任务,把jar包混淆的参数,进行修改,做个总结。在项目中进行跑动起来。ok
2	月末鸭让脑壳飞.ok
3	呆会中午的时间,用idea跑起来所有的项目,查看知识库接口 没有找到.ok
4	端口号,所对应的路径,未找到。
5	今天晚上一对一，一对多查询。使用mybatis。
6	主键和外键的问题   constraint FK_sid foreign key(sid) references student(id)  
7	数据库连接的时候，是对应的数据库名字，里面有所对应的表。外面所对应的只是一个别名而已，没有任何的作用。
8	还有一个，批量增加，批量删除。回去看，遇到的问题，接口中大小写搞混了。
9	一对一查询，有user，order，items类  只查询user，order 先写一个类，来继承order，为orderUser类，里面有username，sex 第一种 ,查询的时候,order类为查询所有,继承order的OrderUser类,里面有什么字段,就能够查询到什么字段. 用的是左连接查询,另外一个还有返回的是一个集合,多个,返回集合!!! resultType返回的是一个实体类,OrderUser 是以key,value形式
10	回去一对一查询，两种方式，全部弄懂。 另外一种 是在Order里面放User对象,有set和get方法,返回值也为List<Order>,在里面需要使用resultMap 集合,<resultMap id ="为下面的id" type ="为所对应的类的名字" autoMapping =true>
	<id column="字段列名" property="javabean字段">
	<association  property=" 在类里面所对应的属性名字段" javaType="为所对应的javaBean名字" autoMapping=true> 
	<id column ="为数据库 所对应的外键" property ="javaBean里面id所对应的字段"
	</association>
</resultMap> 后面返回的值,都是两个对应的javabean整个字段. 查询字段的时候,就会显示字段,没有的就以null进行显示,后面这个json的格式是{key,value={key,value} } 嵌套中还有对象,就不行.
11	用户与订单,以订单为中心,对应用户 是一对一
12	那个辣鱼,在也不吃了,扛不住啦 
13	另外,有不懂得多试试,不要怕错.前面怕错,后面记得会更多. ok
```

### 3/21

```
1	foreach 遍历,mybatis里面的参数。  要遍历的名称
2	Integer[] ids 用array List<Integer> ids 用list
3	谷歌浏览器的问题,回家把蓝灯放进去 用浏览器设置好了. 不弄了，没什么用 回去试试看 在公司不行
设置-->打开代理设置-->局域网设置-->代理服务器里面的高级-->例外-->填写http://192.168.121.171:8080,就OK了,填写需要连接的服务器。这是公司的服务器，
4 对于本地服务器，设置-->打开代理设置-->局域网设置-->代理服务器-->对于本地地址不适用代理服务器 就OK
5	在navicat里面查看点击表,设计表-->里面有可以看到所对应的外键,索引,触发器,注释,字段名,sql预览。ok
6	朋友给的资料，多往网上找找 OK
7	外键 constraint(约束) fk_sid foregin key(外键名) references 表(主键)
8	每天的工牌,还是放在散热风扇这挂起,要不然会忘记带~ ok
9	mybatis主键插入,主键生成问题 paramType 可以省略的有insert update delete 可以省略 parameterType传入一个的时候,可以使用${value} 如果要获取值,只能写${value},多个的时候,可以使用#{0},#{1} 或者在mapper中加入@param注解
10 #{}只是占位符,用于参数传递 ${}用于sql拼接
11 resultMap 定义,当查询一张表的时候,使用的column和property 不同时所需要对应的
12 choose标签里面包括 when otherwise 相当于if 和elseif <when  test=""/> <otherwise >
<if test=""> 
13 <where>和<set>标签 set标签可以自动去除最后一个逗号
14 		<!--开启延迟加载,默认为false-->
          <setting name="lazyLoadingEnabled" value="true"/>
          <!--将积极加载改为消极加载 默认为true-->
        <setting name="aggressiveLazyLoading" value="false"/>
15	如果传入的是单参数且参数类型是一个 List 的时候，collection 属性值为 list
  如果传入的是单参数且参数类型是一个 array 数组的时候，collection 的属性值为 array
  如果传入的参数是多个的时候，我们就需要把它们封装成一个 Map 了，当然单参数也可以封装成 map。 map里面添加的参数,collection就使用哪个OK
16	呆会使用map进行数据的传输,创建实体类的问题~ 不需要创建实体类,就可以拿到数据 OK
17	逆向工程问题,盘里面有
18	Dbeaver数据库需要jdk1.8+才行,点快捷方式,右键属性,目标添加-vm D:\JAVA\JDK18\bin\javaw这个为jdk里面的参数路径 D:\dbeaver\insatall\DBeaver\dbeaver.exe -nl en -vm D:\JAVA\JDK18\bin\javaw
19	用户与权限  用户权限管理：集团用户可以查看全国和各省的数据，省端的只能查看全国和本省的数据，系统管理员可以查看所有数据（这个具体怎么设计可以开个会讨论一下）(回去看看项目中用到的角色)
      用户角色管理：zskdb库，bskm_role表，()
      url接口加密
      :后面几天的任务
20	今天回去,关于权限和角色
21	导入开源中国的代码,跑不起来,尴尬,还需要努力!
22	继续混淆jar包
23	枚举,主方法,数据驱动,本地方法不能改变
24	回去把桌面里面的资料好好整理下~
25	静下心来看~ 英语不会,也是一个坑
26	需要导入jsp-api.jar和servlet-api.jar
```

### 3/22

```
1	看角色权限资料
2	IDEA导入资料的时候,目录结构问题没有解决
3	1 shiro权限与角色步骤   看到shiro教程授权-->授权流程
	1	导入jar shiro-all
	2	在web.xml中配置权限过滤shiro框架,必须配置在struts2核心过滤器前
		 <filter>
        <filter-name>shiroFilter</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>shiroFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <filter-name>shiroFilter 必须配置对应的shiro的bean
    3	在applicationContext.xml中配置 shiro权限控制框架,id要和web.xml中的filter-name相同
        <bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
        <!-- 注入securityManager,shiro框架核心:安全管理器 -->
        <property name="securityManager" ref="securityManager"></property>
        <!-- 指定需要验证的页面 -->
        <property name="loginUrl" value="/login.html"></property>
        <!-- 指定权限验证成功后,跳转的页面 -->
        <property name="successUrl" value="/index.html"></property>
        <!-- 指定权限不足或者登录失败的的页面 -->
        <property name="unauthorizedUrl" value="/unauthorized.html"></property>
        <!-- 过滤规则 -->
        <property name="filterChainDefinitions">
            <!-- authc:框架提供的过滤器,检查权限,有权限放行,无权限拒绝访问 -->
            <!-- anon:框架提供的过滤器,可以进行匿名访问 -->
            <!-- 下面的value属性不允许换行 -->
            <value>
                <!-- /demo/demo4.jsp= roles["role1"]
                /demo/demo3.jsp= perms["test1"] -->
                /css/* = anon
                /images/* = anon
                /js/** = anon
                /validatecode.jsp* = anon
                /userAction_login.action = anon
                /** = authc
            </value>
        </property>
    </bean>
      <!-- 注册securityManager -->
    <bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
        <property name="realm" ref="userRealm"></property>
        <!-- 注入缓存管理员 -->
        <property name="cacheManager" ref="cacheManager"></property>
    </bean>
4	导入maven项目问题,直接导入的是pom.xml
5	今天的任务,上午先把classes运行,跑动起来。 可以跑动起来，把里面的classes文件全部放进去
6	下午看shiro框架
7	war包导出放在杂货店G盘里面
8	还有一个pagehelper分页 
9	酷狗音乐不能播放，用网易云音乐，只能在中午播放下，上班时间不要播放，切记！
10	今天下午在重新跑一遍,有问题.拦截器拦截掉了,另外的a.class也可以放进去跑的.
11	在linux中tomcat怎么清除缓存.
12	一天背诵30个单词
13	使用maven项目进行
14	接口加密问题 这几天的打算.
15	get请求和post请求: get请求,post请求携带参数,get有限制,post没有限制,另外一个是安全问题,post比get更安全
16	另外一个,util里面的类,没有显示,直接进行删除
17	获取知识列表URL: baseUrl+'/bskm/rest/appsearch/list?'+data
```

### 3/23

```
3	在action里面就要进行验证,如果验证码正确,就进行获取当前对象,创建令牌,进行登录,获取user对象,根据身份,把user对象存到session里面去,来判断是否是账号还是密码不正确进行抓取,
4 在service层里面UserRealm继承AuthorizingRealm重写两个方法,认证和授权,UsernamePasswordToken token=(UsernamePasswordToken)token;根据token拿到用户名,利用mapper进行用户名的获取,得到用户,如果用户为空,返回空,不为空,进行比对,使用AuthenticationInfo info=new SimpleAuthenticationInfo(user(身份),user.getPassword()密码,getName()) return info;
  <!-- 由spring框架提供,基于spring的动态代理,创建service的代理对象 -->
    <bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator">
        <!-- 开启cglib注解 -->
        <property name="proxyTargetClass" value="true"></property>
    </bean>
    
    <!-- 配置shiro的切面 -->
    <bean class="org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor">
        <property name="securityManager" ref="securityManager"></property>
    </bean>
	苹果系统5.84G
5	导入maven项目,运行maven项目
6	昨晚做梦了,怕被学校开除,打牌也是够了~
```

### 3/24

```
1 任务,把shiro跑起来,想办法加入角色和权限,菜单,用户。
2	springmvc里面的web.xml的中心器怎么配置
3	路径问题,login和succes输入路径
4	下周六,龙华人民医院做牙医治疗,上午去,人少.
5	shiro框架,配置路径,还有springmvc的路径配置
6	腾讯课堂和腾讯视频登录不了配置
7	以后不知道的事情,上百度找,总有点蛛丝马迹的
```

### 3/25

```
1	外出游玩,欢乐谷,最大的失误,没带书包去, 在欢乐谷外面东西不要买,
2	必须要背书包出发,把吃的东西买齐了,还有氺,里面的东西太贵,价格是外面的3-5倍,划不来,在旅游景点区的话.
3	欢乐谷路线,进去的左手边,一直往那边转过去,有过山车,雪域雄鹰,完美风暴,大摆锤,太空梭在右手边,这就是攻略。年票880,另外一个为记得带充电宝。
4	这些天早点回家，看shiro视频，页面自己调整还是调整好，下周六没时间的~
5	如果要搬出去的话，我也打算搬欧阳凯那边去，观澜天虹，篮球场和跑步的场所，有时间就去溜达溜达。减肥，明天还有一个事情，下单买米的事情。打电话。
6	在application.xml中进行/courieAction=perms["courier_pageQuery"] 在reaml中需要改变 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 进行授权
        // 真实项目的话,权限应该是从数据库中查询出来,动态的进行授权
        info.addStringPermission("courier_pageQuery");
return info;
7	使用注解方式:需要进行cglib动态代理开启,默认为jdk,实现接口,而cglib是继承对应的类,代理类是对象类的子类
    <!-- 由spring框架提供,基于spring的动态代理,创建service的代理对象 -->
    <bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator">
        <!-- 开启cglib注解 -->
        <property name="proxyTargetClass" value="true"></property>
    </bean>
    
    <!-- 配置shiro的切面 -->
    <bean class="org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor">
        <property name="securityManager" ref="securityManager"></property>
    </bean>
   
8	还有标签方式实现,编码方式实现
9	用户注销:secrityUtil.getsubject.logout
		secrityUtil.getsubject.getsession.invidate 把当前状态改为未登录状态
10	如果路径在web-inf下面,就写location,如果在src下面就写classpath路径
11			dispatchServlet <url-pattern>/</url-pattern>  会匹配到/login这样的路径型url，不会匹配到模式为*.jsp这样的后缀型url
<url-pattern>/*</url-pattern> 会匹配所有url：路径型的和后缀型的url(包括/login,*.jsp,*.js和*.html等)
12	腾讯课堂看邢景春视频
13	加密解密问题,这几天的问题,看到第四节
14	明天的话,开始把war包copy上去.
```

### 3/27

```
1	问题点,接口数据加密问题没有解决,
2	war包也不需要重新加密了,是安卓和ios的问题
3	接下来学习shiro框架
4	网络上面的资料,在家先下载下来,外网根本不行.
5	认证策略:<bean id="authenticator" class="ModularRealmAuthenticator"> 默认为多处认证,一次成功就算成功
	<property name="realms">
	<list>
	<ref bean="jdbcRealm"/> <ref bean="secondRealm"/>
	</list>
	</property>
	</property name="authenticatorStrage" ref=""/> 改变多处认证
	<bean id="authenticatorStrage" class="allsuccessfulstrategy"/>
```

### 3/28

```
1	把昨天的shiro资源看完,结束太潦草。
2	今天把数据库表格相对应关系弄清楚。
3	视频播放资料，没有，就不去搞了。
4	还有java1234网，资源网太多
5	还有另外一个，ssm框架中，增删改查，需要多去写些，一天写一次吧，给自己的任务。
6	还有一个svn视频资料播放。下载好。
7	java基础视频，1-4套全部保存
```

### 3/29

```
1	今天继续昨天的shiro视频,先看代码!!!不懂才去看视频.
2	数据库可以不需要进行外键的,在使用sql语句的时候进行关联就可以了。
3	查询md5，sql语句 select md5（11111）
4	点击为resource root
5	后面还有svn和eclipse的操作
6	excle文档编辑，三角箭头为数据-->筛选,在点击数据-->数据校验-->设置--允许里面的序列-->来源
7	常用url拦截
8	今天晚上回去看代码,写代码,视频是07,06分
9	已经看完,明天全部写代码,自己去看,去改。另外的还有一个用户到角色没看到
```

### 3/30

```
1	奥德赛账号,登录
2	shiro项目,从开始做起~~
3	呆会把不需要的全部删除掉,在进行重新跑项目。
4	springboot，慕课网资料
5	shiro配置资料 web.xml资料 	
6	拦截器问题 
<!-- shiro的filter -->
	<!-- shiro过虑器，DelegatingFilterProxy通过代理模式将spring容器中的bean和filter关联起来 -->
	<filter>
		<filter-name>shiroFilter</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		<!-- 设置true由servlet容器控制filter的生命周期 -->
		<init-param>
			<param-name>targetFilterLifecycle</param-name>
			<param-value>true</param-value>
		</init-param>
		<!-- 设置spring容器filter的bean id，如果不设置则找与filter-name一致的bean-->
		<init-param>
			<param-name>targetBeanName</param-name>
			<param-value>shiroFilter</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>shiroFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
	
	在applicationContext-shiro中配置 web的shiro控制器(登录url,无权限url,失败url,自定义filter权限,里面,过滤器定义(anon匿名访问,authc 认证,user(user:例如/admins/user/**=user没有参数表示必须存在用户, 身份认证通过或通过记住我认证通过的可以访问，当登入操作时不做检查),logout清除session),还有securityManager管理控制器(里面有缓存,自定义realm,sessionManager,记住我.)
	
		<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
		<property name="securityManager" ref="securityManager" />
		<!-- loginUrl认证提交地址，如果没有认证将会请求此地址进行认证，请求此地址将由formAuthenticationFilter进行表单认证 -->
		<property name="loginUrl" value="/login.action" />
		<!-- 认证成功统一跳转到first.action，建议不配置，shiro认证成功自动到上一个请求路径 -->
		<property name="successUrl" value="/first.action"/>
		<!-- 通过unauthorizedUrl指定没有权限操作时跳转页面-->
		<property name="unauthorizedUrl" value="/refuse.jsp" />
		<!-- 自定义filter配置 -->
		<property name="filters">
			<map>
				<!-- 将自定义 的FormAuthenticationFilter注入shiroFilter中-->
				<entry key="authc" value-ref="formAuthenticationFilter" />
			</map>
		</property>
		
		<!-- 过虑器链定义，从上向下顺序执行，一般将/**放在最下边 -->
		<property name="filterChainDefinitions">
			<value>
				<!-- 对静态资源设置匿名访问 -->
				/images/** = anon
				/js/** = anon
				/styles/** = anon
				<!-- 验证码，可匿名访问 -->
				/validatecode.jsp = anon
				
				<!-- 请求 logout.action地址，shiro去清除session-->
				/logout.action = logout
				<!--商品查询需要商品查询权限 ，取消url拦截配置，使用注解授权方式 -->
				<!-- /items/queryItems.action = perms[item:query]
				/items/editItems.action = perms[item:edit] -->
				<!-- 配置记住我或认证通过可以访问的地址 -->
				/index.jsp  = user
				/first.action = user
				/welcome.jsp = user
				<!-- /** = authc 所有url都必须认证通过才可以访问-->
				/** = authc
				<!-- /** = anon所有url都可以匿名访问 -->
				
			</value>
		</property>
	</bean>

<bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
		<property name="realm" ref="customRealm" />
		<!-- 注入缓存管理器 -->
		<property name="cacheManager" ref="cacheManager"/>
		<!-- 注入session管理器 -->
		<property name="sessionManager" ref="sessionManager" />
		<!-- 记住我 -->
		<property name="rememberMeManager" ref="rememberMeManager"/>
		
	</bean>


<bean id="customRealm" class="cn.itcast.ssm.shiro.CustomRealm">
	<!-- 将凭证匹配器设置到realm中，realm按照凭证匹配器的要求进行散列 -->
	<property name="credentialsMatcher" ref="credentialsMatcher"/>
</bean>


<!-- 凭证匹配器 -->
<bean id="credentialsMatcher"
	class="org.apache.shiro.authc.credential.HashedCredentialsMatcher">
	<property name="hashAlgorithmName" value="md5" />
	<property name="hashIterations" value="1" />
</bean>

<!-- 缓存管理器 -->
<bean id="cacheManager" class="org.apache.shiro.cache.ehcache.EhCacheManager">
    	<property name="cacheManagerConfigFile" value="classpath:shiro-ehcache.xml"/>
    </bean>

<!-- 会话管理器 -->
    <bean id="sessionManager" class="org.apache.shiro.web.session.mgt.DefaultWebSessionManager">
        <!-- session的失效时长，单位毫秒 -->
        <property name="globalSessionTimeout" value="600000"/>
        <!-- 删除失效的session -->
        <property name="deleteInvalidSessions" value="true"/>
    </bean>

<!-- 自定义form认证过虑器 -->
<!-- 基于Form表单的身份验证过滤器，不配置将也会注册此过虑器，表单中的用户账号、密码及loginurl将采用默认值，建议配置 -->
	<bean id="formAuthenticationFilter" 
	class="cn.itcast.ssm.shiro.CustomFormAuthenticationFilter ">
		<!-- 表单中账号的input名称 -->
		<property name="usernameParam" value="username" />
		<!-- 表单中密码的input名称 -->
		<property name="passwordParam" value="password" />
		<!-- 记住我input的名称 -->
		<property name="rememberMeParam" value="rememberMe"/>
 </bean>

<!-- rememberMeManager管理器，写cookie，取出cookie生成用户信息 -->
	<bean id="rememberMeManager" class="org.apache.shiro.web.mgt.CookieRememberMeManager">
		<property name="cookie" ref="rememberMeCookie" />
	</bean>
	<!-- 记住我cookie -->
	<bean id="rememberMeCookie" class="org.apache.shiro.web.servlet.SimpleCookie">
		<!-- rememberMe是cookie的名字 -->
		<constructor-arg value="rememberMe" />
		<!-- 记住我cookie生效时间30天 -->
		<property name="maxAge" value="2592000" />
	</bean>


shiro-ehcache.xml
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="../config/ehcache.xsd">
	<!--diskStore：缓存数据持久化的目录 地址  -->
	<diskStore path="F:\develop\ehcache" />
	<defaultCache 
		maxElementsInMemory="1000" 
		maxElementsOnDisk="10000000"
		eternal="false" 
		overflowToDisk="false" 
		diskPersistent="false"
		timeToIdleSeconds="120"
		timeToLiveSeconds="120" 
		diskExpiryThreadIntervalSeconds="120"
		memoryStoreEvictionPolicy="LRU">
	</defaultCache>
</ehcache>
```

### 3/31

```
1	大梅沙去玩,还有菜菜搬公司去了
```

### 4/1

```
1	周末去龙华人民医院去了,一天5个号,需要预约,晚上0点开始,预约这个周六的,4月4号或者4.5号晚上0点预约,记得抢号.
2	不喜欢和不熟悉的人一起玩,4.2号开始住那边的.
3	大方向,先看项目,不要管那些工具之类的了。看网络上的资料
```

### 4/2 

```
1	今天任务还是shiro
2	mysql安装,
3	回去U盘的问题,直接拷贝资料,把代码弄上去,不带电脑回家了,
4	今天把钱转到老姐那里去.
整个系统有4个后端部分，除了月报和知识库，另外两部分的代码也接手一下吧 月报ok 知识库和另外两部分(监控部分)?
其中sso单点登录模块在18年1月份就有上线过，这个源代码可以问禹亮要，OK
另外的监控那块的代码tomcat服务器上显示的17年1月上的线可以找人问问 ??
5	验证码的比对
6	回去视频shiro资料
7	数据库的表关联比较吃亏
8	测试的数据,不要去改,知道怎么去弄
9	修改参数 lina290  password 8b780846f1e123dcb3cf87a00d452472 
salt 1c8b1217eb7d53b8d390c3431373f9e4  guods参数 c5085a235a9d4e564a4df22df528b830 96060e0953fce1c20368d06a60cff820   用户名zhangrui290  password 0522f86f9c1d6c762999b56cee4ea714 salt 3bcb89d3e2f2a6d9897e1622320534c0
10	springboot资料查询 2小时学会springboot  ,资料,做笔记
11	maven的相关知识,阿里云的maven下载不了.
12	Maven配置问题.
回去总结的资料
1	U盘找到,不带电脑,回家用台式电脑,每天把代码之类的东西,全部拷贝到u盘里面去,(每日总结和代码)
C:\ProgramData\Oracle\Java\javapath;%CATALINA_HOME%\bin;%JAVA_HOME%\bin;%SystemRoot%/system32;%SystemRoot%;F:\TortoiseSVN\bin;%MAVEN_HOME%\bin;H:\DevelopTool\git\Git\cmd;H:\DevelopTool\git\TortoiseGit\bin
2	后天任务还有一个svn视频,
3	maven的配置.
4	application.properties文件的配置,不过不建议,建议使用.yml的文件配置,能够节省代码的书写,整洁性较强
	看注解的意思:@value("${属性名}") private string 属性名 就能够拿到yml里面的属性值,@compont 组件扫描,意思是一定要使用它,spring才能够扫描到,
	@autowired bean的注入,要使用里面的属性,必须要注入才行 
	@restController 是在spring4里面的注解,代表的是controller和responsebody的结合体,
	@reqiestMapper(value="/hello",method=requestMethod.get)指的是路径,指的是get方法.
	@configurationProperties(prifex="属性名") 指的是properties的属性名的前缀是什么,可以从属性里面
	@requestParam("id")Integer id 对应的url里面传值的id
	@PathVariable("id")
	@getMapper("/say") 方法为get相当于method=requestMethod.get ,requestMapper
	@putMapper("/say") 方法为put 相当于@requestMapper("/say" method=requestMethod.put)
	@putMapper("/girl/{id}") put更新方式的时候,body格式需要使用x-www-form-urlencoded
	@Transactional 事物,要么成功,要么失败.
	@DynamicUpdate 动态更新时间
	@Date  lombak 插件  生成get,set和toString方法
	@Transaction 在测试的时候,是不保存数据
	数据库问题
	获取到值.
5	Springboot的视频,4-1还未配置 
6	https://blog.csdn.net/liu_shi_jun/article/details/78733633 本地仓库的问题
7	配置本地仓库,把maven的解压好 setting.xml进行配置 配置本地仓库
```

### 4/3

```
1.APP首页重构：重新设计首页风格、排版、内容重新整理

2.首页轮播图可配置化：后台实现APP首页轮播图可配置化、不止是局限于报告

3.APP监控接口优化转移：实体厅实现实体厅监控模块内所有接口的重构、迁移

4.APP端session管理:session失效控制、失效后的处理逻辑

这个月的任务

shiro问题
	<!-- 自定义会话管理配置 -->
	<bean id="sessionManager" class="com.common.security.shiro.session.SessionManager"> 
		<property name="sessionDAO" ref="sessionDAO"/>
		
		<!-- 会话超时时间，单位：毫秒  -->
		<property name="globalSessionTimeout" value="${session.sessionTimeout}"/>
		
		<!-- 定时清理失效会话, 清理用户直接关闭浏览器造成的孤立会话   -->
		<property name="sessionValidationInterval" value="${session.sessionTimeoutClean}"/>
<!--  		<property name="sessionValidationSchedulerEnabled" value="false"/> -->
 		<property name="sessionValidationSchedulerEnabled" value="true"/>
 		
		<property name="sessionIdCookie" ref="sessionIdCookie"/>
		<property name="sessionIdCookieEnabled" value="true"/>
	</bean>
	
	
更新会话：SecurityUtils.getSubject().getSession().touch()； 
停止会话：SecurityUtils.getSubject().getSession().stop()； 
|-相当于WEB开发中的：session.invalidate()方法的执行； 
|-注销：SecurityUtils.getSubject().logout()。

markdown插入图片
<img src="图片链接（比如https://img-blog.csdn.net/20151111221623501）" width = "450" alt="图片描述" align=center />

    @RequestMapping(value = {"/hello/{id}"},method = RequestMethod.GET)
    public String girlTest(@PathVariable("id") Integer myId){
        return "id "+myId;
    }  pathvariable("id") 和url对应,Myid可以随便选取 
 开始看6-1 
 
 明天早上记得做笔记,笔记在家里面的电脑里面。回去做
```

### 4/4

```
1	写拦截器,springmvc的,springboot笔记今天上班时间做
2	拦截器 实现接口HandlerInterceptor 里面有preHandler 进入方法前 false不放心,返回true才放行
,postHandler 执行方法后,afterCompletion,返回modelandView后 配置的话,在springmvc里面进行配置
配置一个的时候是这样
<mvc:intercepts>  
	<mvc:interceptor>
          <mvc:mapping path="/**"/>
          <bean class="com.itheima.ssm.interceptor.HandlerInterceptor1"></bean>
      </mvc:interceptor>
      <mvc:interceptor>
          <mvc:mapping path="/**"/>
          <bean class="com.itheima.ssm.interceptor.HandlerInterceptor2"></bean>
      </mvc:interceptor>
</mvc:intercepts>
preHandler都放行返回true的时候
正常执行流程为preHandler1-->preHandler2-->目标方法-->postHandler2-->postHandler1-->afterCompletion2-->afterCompletion1
preHandler和afterCompletion1统一的
当第二个为false时,preHandler1-->preHandler2-->afterCompletion1
登陆方法拦截器
```

```
//跳转到用户登录的页面
	@RequestMapping("/user/showLogin")
	public String showLogin(){
		return "login";
	}
	
	//登录的验证
	@RequestMapping("/user/Login")
	public String login(String username,String password,HttpSession session){
		if("123".equals(username) && "456".equals(password)){
			//2.1根据用户名和密码查询数据库验证，如果查询到，设置session信息，并返回商品列表页面
			session.setAttribute("user", username);
			return "itemList";
		}
		//2.2 如果登录不成功，直接重定向到登录的页面。

		return "redirect:/user/showLogin";
	}
```

```
@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hanlder) throws Exception {
		//首先从当前的url中获取访问的路径，如果/user/showLogin 和/user/Login （不需要拦截）
		String pathrequest = request.getRequestURL().toString();
		if(pathrequest.contains("Login")){
			return true;
		}
		//如果不是，就需要拦截进行验证。
		Object object = request.getSession().getAttribute("user");
		//从session中获取用户的信息
			if(object!=null){
				//如果有，说明登录，就放行
				return true;
			}
		//如果没有，跳转到登录的页面
		response.sendRedirect(request.getContextPath()+"/user/showLogin");
		return false;
	}
	
	下午提需求还有拦截器问题
3	redis缓存问题，合并知识库问题，看视频，回去下载redis
	一头扎进redis下载	OK 
    和redis从入门到精通 下载 
	springboot企业点餐系统下载
	mysql优化。
	svn版本控制 cmd svn --version
	版本库的创建 在目录中G:\subversion\crm cmd命令使用  svnadmin create G:\subversion\crm 可以创建版本库，里面有conf（当前版本库配置文件），db（数据库），hooks（钩子程序，像触发器一样），locks（文件的锁定有关）文件夹
	看完5,svn 先更新,后提交,解决冲突的时候,点击右键,team-->编辑冲突,把右边的放左边来,在进行保存,这样,eclipse就任务是已经编辑好冲突了,-->在点击team键-->标记为已解决,上面的乱七八糟的符号就会消失,这是在eclipse上面遇到的问题
	备份-->进行checkout
	代码还原-->时光机问题:点击team-->显示内容-->查看,在点击项目进行提交,就回到原来的地方去了
	协同修改:先更新,后提交,解决冲突的时候,点击右键,team-->编辑冲突,把右边的放左边来,在进行保存,这样,eclipse就任务是已经编辑好冲突了,-->在点击team键-->标记为已解决,上面的乱七八糟的符号就会消失,这是在eclipse上面遇到的问题
	多版本文件管理:svn自动帮我们做的,不用管,进行增量管理
	追溯代码人和时间:有用户名和密码问题。
	权限控制问题：在conf里面的svnservice.conf里面 有匿名访问 #auth-access =wirte 
	授权 auth-access =wirte 用户名和密码  password-db=passwd 哪个文件保存密码  authz-db=authz 保存授权的信息 passwd 文件里面[users] 自己写 tom = 123456 tom用户名的密码为123456 jerry=123456 打开authz设置具体权限[groups] 分组 kaifa=tom,jerry为读写 
	ceshi=123456 为只读 [/]为根目录 @kaifa=rw 开发这个组为可读可写 ceshi=r 测试为只读的权限 * = 起屏蔽的作用
用小乌龟进行修改:也是-->编辑冲突-->有四个,使用此文本快,使用整个文件(指的是不使用服务器的文件,使用我的文件),先使用我的"文本"块(指的是,冲突位置中,先使用我的放在前面),先使用他们的文本块(他们的文本放在前面)-->点击保存-->标记为已解决,关掉其界面,其余的冲突就没有了
```

### 4/5

```
1	打电话回家
2	把台式电脑的资料全部清理一遍,不要的资料全部删除掉
3	分享的资料,先从1-11看了一遍,可以的话,就进行保存,没有的话,下次不要去看了	
4	设置token
5	明天的拦截器问题,shiro视频问题 本地bos的 
```

### 4/6

```
	在家玩了一天,没什么事情.
```

### 4/7

```
1	打算去龙华公园，没去成
2	问题找错,第一,从前端过来页面的字段是什么,第二,后台debug模式,拿到什么样的值。在想办法去修改.
3	家里面的电脑,虚拟机密码 CentOS账号 为root 密码为123456 
4	使用xml文件,插入redis的端口号,怎么用
5	查找目录：find /（查找范围） -name '查找关键字' -type d
	查找文件：find /（查找范围） -name 查找关键字 -print
6	https://blog.csdn.net/donggang1992/article/details/51064962 redis集群
```

### 4/8

```
1	idea激活码
2	接口数据加密,感觉到无力. 不看了,放弃掉
3	IntelliJ IDEA 2017.2.5
      Build #IU-172.4343.14, built on September 26, 2017
      Licensed to jl250
      JRE: 1.8.0_152-release-915-b12 amd64
      JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
      Windows 10 10.0
4	https://pan.baidu.com/s/1jMg48V15P_y4qsZGaP62Cw?qq-pf-to=pcqq.group#list/path=%2F&parentPath=%2F 百度网盘资料.
5	redis设置密码,在linux中
6	java1234网址 http://blog.java1234.com/index.html
7	直接连接集群版的节点就可以,它里面会有算法,根据算法确定到哪个槽里面去。
8	检查集群的情况，没有设置
9	redis问题，回去设置 单机和集群版都挂了，实现不行，进行重新删除，安装
10	外婆生日，打电话回家，别呆会又忘记了,每年的2月23号
11	一头扎进shiro视频,资料,今天先看springboot资料.
12	springboot 代码,资料,做笔记
13	springboot的点餐系统，全部copy
14	idea导入maven项目，依赖不下载，把项目拿回去，看看是不是网络问题。要解决.
15	点餐系统代码和项目 第3章,3-2没有下载.
16	看项目视频,明天看项目视频.整合视屏
```

```
Error:(55, 29) java: 无法将接口 org.springframework.data.repository.query.QueryByExampleExecutor<T>中的方法 findOne应用到给定类型;
  需要: org.springframework.data.domain.Example<S>
  找到: java.lang.Integer
  原因: 无法推断类型变量 S
    (参数不匹配; java.lang.Integer无法转换为org.springframework.data.domain.Example<S>)
    
```

### 4/9

```
1	看整合视频
2	先从过年电脑拷贝的视频看,而后是今天下载的这个视频.主要是敲代码.
3	回家看视频 idea视频,百度网盘上面下载的资料
4	每天至少200行代码,不要去看视频资料了。先跑crm的项目，springboot项目到第5章 ，copy
5	maven导入不进来的原因是网络问题导致。
6	做了这个项目,3天时间,后面去看医院管理项目,好像有代码,给自己5天时间，想办法把shiro也加进来。
7	领导打招呼的时候，需要聪明点。蠢死了,记得叫哥!
8	这个礼拜,明天把冰箱里面的东西煮了,冰箱清理一下,味道太难闻了。没开封的就不要去动了。还剩下猪肉和芹菜。明天早上把叉烧包煮了。这两天早上都弄叉烧包，记得，把它吃掉
9	明天早上说，没有代码的事情，不要去管别的了。
10	一天半个小时的锻炼。吃完饭休息一个小时，到8.30就出发，看手上的月牙就知道健康状况了。
11	每天半个小时的锻炼，8点半到9点，后面可以的话，可以增加到一个小时，地方的话，前后左右的路程，慢慢的延长下去，出了一身汗，舒服多了。回来9.30洗澡。
12	当数据库的字段和表字段一致的时候，那么驼峰式命名就不需要了，不然获取不到值
13	明天9点半！问题点，直接在群里@
```

### 4/10

```
1	群里面@管理员,九点半
2	晚上把叉烧包弄4个.
3	写代码,不要去看视频了。
4	先把springboot放一放。
5	过滤器问题,编码 在tomcat里面进行配置 
	1	JSP页面中文乱码 <%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>    
    2	URL传递参数中文乱码:<Connector port="8080" protocol="HTTP/1.1" 			URIEncoding="gb2312"
 connectionTimeout="20000"    redirectPort="8443" />
6	tomcat被我修改了.
7	id传值不过来。
8	把代码在重新写一遍。 代码全部拷贝好。今天晚上的任务
9	后面的话,把代码写好了,可以改的,自己去改理解不透彻的东西,并做好笔记。
10	明天的代码,进行修改。
11	还有一个牙周治疗问题，记得在网上找资料。
12	另外一个，还有电饭煲问题，
```

### 4/11

```
1	上午把代码问题有疑问的解决掉,
2	得不到数据,恼火。看数据库字段问题，呆会进行字段的修改。以这个项目为中心。里面的传入的数据是根据类里面传递的参数来的。
3	驼峰式命名，试试。
4	进行替换 ctrl+r 全局替换为ctrl+shift+r
5	不看那个，先看springboot的进阶版。每天多敲代码。
6	每学完一节,需要进行总结,把代码敲出来.
```

```
springboot总结,数据库的问题,进行jpa的操作,原hibernate的封装,配置如下,
spring:
  profiles:
    active: dev
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/springboottest
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    jpa还需要有实体类,进行和数据库的字段对应 @Entity表明是实体类,@Id表示当前为主键 GeneratedValue表示主键生成的方式,未指定的话,由程序进行控制- 
 strategy ：指定主键生成策略.策略为GenerationType类定义的常量
- IDENTITY：主键由数据库自动生成（主要是自动增长型） 
- SEQUENCE : 根据底层数据库的序列来生成主键，条件是数据库支持序列
- AUTO : 主键由程序控制
- TABLE : 使用一个特定的数据库表格来保存主键
数据库的增删改查,增删改查,增加为postMapper,删除DeleteMapper,改putMapper,查询GetMapper ,今天回家可能的话,看点视频,把springboot的资料全部看完,做好代码,做好笔记.晚上的任务 
5	进行表单的认证，@Min（value=18 message="静止未成年人入内"）
				private Integer age;
	在GirlController层里面进行校验,校验的是对象@Valid Gilr girl ,BindResult bindresult 需要进行验证,里面传入字段,绑定结果, if(bindresult.getErrors()){
sout(bindresult.getFiledError.getDefaultMessage())
}
6	aop面向切面编程 使用注解@aspect和@component 
	在方法上面使用@pointcut切入点(execution(pubulic * com.jiaolin.controller.GirlController.*(..))) 后面的* 代表里面的任何方法,..代表0个或者多个  @before @After
```

### 4/12

```
1	把家里的电脑和公司的电脑,路径配置成一样的，那样就不用那么麻烦了。
2	使用jpa为什么会多创建一张表出来。
3	电饭煲的事情
4	拿笔
5	细心细心
6	aop下没做笔记
7	maven从家里的电脑放公司电脑,maven下载不来.
8	今天把进阶全部看完. 获取之前的参数,url,方法,类,ip 和返回值的参数
	ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		LOGGER.info("url={}",request.getRequestURL());
		//method
		LOGGER.info("method={}",request.getMethod());
		//ip
		LOGGER.info("ip={}",request.getRemoteAddr());
		//类方法
		LOGGER.info("class_method={}",			joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//参数
		LOGGER.info("args={}",joinPoint.getArgs());
		返回值的参数
	@AfterReturning(returning = "object",pointcut = "log()")
	public void doAfterReturning(Object object){
		LOGGER.info("response={}",object.toString());
	}
9	看maven导入不进去,先试试看,jdk有没有导入进去,要不然maven导入不来.
10	今天任务,回去异常代码,异常统一处理 写完.
11	怎么把girl类转化为Optional类java1.8 是一个非空类,  Optional<Girl> girl = girlRepository.findById(id);	 Integer age = girl.get().getAge();

	异常
	ExceptionHandl
@ControllerAdvice  注解,还需要  @ExcptionHandler(Exception.class) @responsebody
     统一异常处理,需要定义一个字节的GirlException类 去继承RuntimeException springboot才会进行回滚,
    
```

```
     
     GirlServiceImpl
     Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        if (age<10){
            throw  new GirlException(ResultEnum.PRIMARYSCHOOL);
        }else  if (age>10&&age<16){
            throw new GirlException(ResultEnum.MIDDLESCHOOL);
        }
    }
```

```
public class GirlException extends RuntimeException {
	private Integer code;

	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code=resultEnum.getCode();
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
```

```

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
      if (e instanceof GirlException){
          GirlException girlException= (GirlException) e;
          return ResultUtils.fail(girlException.getCode(),girlException.getMessage());
      }else {
          return ResultUtils.fail (-1,"未知错误");
      }
    }
```

```
package com.jiaolin.girl.Enums;

public enum ResultEnum {

	UNKOWNERROR(-1, "未知错误"),
	SUCCESS(0, "成功"),
	PRIMARYSCHOOL(100, "我猜你可能还在上小学"),
	MIDDLESCHOOL(101, "你可能在上初中"),
	;

	private Integer code;
	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
```

```
package com.jiaolin.girl.domain;

public class Result<T> {
	//信息码
	private Integer code;
	//信息
	private String message;
	//具体的信息
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
```

### 4/13

```
1	单元测试 service层的方法上面方法直接右键GO TO-->Test 创建方法,在测试方法中,需要加上@RunWith(SpringRunner.class)
@SpringBootTest  注入service接口
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceImplTest {


	@Autowired
	private GirlService girlService;
	
	@Test
	public void selectOne() throws Exception {
		Optional<Girl> girl = girlService.selectOne(4);
		Assert.assertEquals(new Integer(19),girl.get().getAge());

	}
2	controller层进行测试-->方法直接右键GO TO-->Test 创建方法,需要加上注解
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc//进行注入注解 ,进行controller的测试
@Autowired
	private MockMvc mvc;
	
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc//进行注入注解 ,进行controller的测试
public class GirlControllerTest {
	@Autowired
	private MockMvc mvc;
	@Test
	public void selectAll() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/girl/selectAll"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
//mockMvc.perform执行一个请求；//MockMvcRequestBuilders.get  构造一个请求    	    //MockMvcResultMatchers.status().isOk() 状态码匹配
//andExpect 添加执行完成后的断言

boot进阶完成了,后面看ssm框架项目整合.

springboot项目先停下来,先把mybatis和springmvc多敲代码,多巩固.
```

```
通过自动回复机器人学习mybatis,
	使用servlet进行开发, jsp页面需要放到web-inf中,从后台进行访问
1	不要慌,进行路径的查找,从web.xml中去查
2	在写sql语句时,不能写select * , 
3	记得每个表之间要写注释
4	在这边的网络有问题,太慢,视频资料不好看
jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
加入jar包jstl
<c:forEach items="${messageList}" var="message" varStatus="status">
<tr>
<td><input type="checkbox" /></td>
<td>${status.index +1}</td>
<td>${message.COMMAND}</td>
<td>${message.DESCRIPTION}</td>
<td>
<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
<a href="#">删除</a>
</td>
</tr>
</c:forEach>

今天任务和明天任务,把mybatis基础和加强,还有springmvc想办法看一遍,有一天的时间,记得敲代码!!
```

### 4/14

```
1	看了些资料,没看完,有她在的日子里面,时间是不属于我的。
```

### 4/15

```
1	玩了一天,别的什么都没做、
2	给老爸打电话说，给个答复的问题，最后是分手的结局。也是，早说早解脱吧！
```

### 4/16

```
1	从租房到公司,就一个小时的时间,后面的时候,从7.30或者7.40出发,到这里8.40左右。不要太赶了。
2	今天任务，就是看基础mybatis，按别人说的做。
3	项目经理有说，写检索报告。交给小妹去写。
4	回去把资料合并下
5	另外,中午订个时间,12点15分去热饭。留点时间出来和菜菜聊天。
6	没有注释，进行分层
7	Mybatis  column 表示配置数据库的字段，property配置实体类的字段 
8	Mybatis的语法OGNL表达式	
数组	array[索引] (String[])			  array[索引].属性名(Message[]) 
List  list[索引]List(<String>)   			List[索引].属性名(List(<Message>)
Map  _parameter.key(Ma<String,String>) 	   key.属性名(Map<String,Message>)
	Foreach标签  <foreach collection="array" index="i" item="item">
	数组  i:索引  item:属性名
    list  i:索引
    Map   i:key值
9	log4j日志输出级别: debug	info warn error 从低到高
10	新领导邮箱 赵思远zhaosy@chinamobilesz.com
11	事物的提交,commit mybatis和jdbc,看完第4节,今天回去把代码写好。增删，批量删，查 jsp，ognl表达式
12	闹的好凶,4/15号 蠢货
13	好邪门,大小写问题,listServlet和ListServlet问题
14	删除一个,批量删除,另外一个,在家给自己半个小时的锻炼时间,如果有下雨的话.
15	日志log4j
    log4j.rootLogger=DEBUG,Console
    log4j.appender.Console=org.apache.log4j.ConsoleAppender
    log4j.appender.Console.layout=org.apache.log4j.PatternLayout
    log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n
    log4j.logger.org.apache=INFO 正版

16	JSP中文乱码问题解决,js乱码解决,编码问题,charSet="UTF-8"
```

### 4/17

```
1	https://wenku.baidu.com/view/f496e2d27d1cfad6195f312b3169a4517723e5f2.html 系统安装
2	springmvc+spring+mybatis    vertice大数据   mysql多数据源 提高系统吞吐量 redis集群,进行数据优化缓存
3	mybatis的一对一,一对多问题,没弄就忘了。
4	回去一对一，一对多的视频资料哦。
```

### 4/18

```java
// mybatis的一对一方法 一种继承,一种直接在类里面添加对象 返回的都是list集合
第一种
public class OrdersUser extends Orders {
	private String username;
	private String address;
	}
	List<OrdersUser> getItemsList(@Param("start")int start, @Param("pageSize")  int pageSize);
	    <select id="getItemsList" resultType="OrdersUser">
           SELECT o.id,o.user_id,o.createtime,u.username,u.username,u.address
           FROM orders o
           LEFT JOIN user u on o.user_id=u.id LIMIT #{start},#{pageSize}
    </select>
      
      
    用户表
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址
	
	//附加对象List
	private List<Orders> ordersList;
    }
    
    // 一个订单属于一个用户
	第二种
	public class Orders {
	private Integer id;
	private Integer userId;
	private String number;
	private Date createtime;
	private String note;
	private User user;
	}
		<!-- 
		//一对一关联 查询  以订单为中心 关联用户
	public List<Orders> selectOrders();
	 -->
	 <resultMap type="Orders" id="order">
	 	<result column="id" property="id"/>
	 	<result column="user_id" property="userId"/>
	 	<result column="number" property="number"/>
	 	<!-- 一对一 -->
	 	<association property="user" javaType="User">
	 		<id column="user_id" property="id"/>
	 		<result column="username" property="username"/>
	 	</association>
	 </resultMap>
	 <select id="selectOrders" resultMap="order">
	 	SELECT 
	 	o.id,
	    o.user_id, 
	    o.number,
	 	o.createtime,
	 	u.username 
	 	FROM orders o 
	 	left join user u 
	 	on o.user_id = u.id
	 </select>
	
		 	//一对多关联
	public List<User> selectUserList(); -->
	<resultMap type="User" id="user">
		<id column="user_id" property="id"/>
		<result column="username" property="username"/>
		<!-- 一对多  orders 表示里面多个集合的对象 property表示orders的属性字段-->
		<collection property="ordersList" ofType="Orders"> 
			<id column="id" property="id"/>
			<result column="number" property="number"/>
		</collection>
	</resultMap>
	<select id="selectUserList" resultMap="user">
		SELECT 
	 	o.id,
	    o.user_id, 
	    o.number,
	 	o.createtime,
	 	u.username 
	 	FROM user u
	 	left join orders o 
	 	on o.user_id = u.id
	</select>
	List<Orders> getItems(@Param("start")int start,@Param("pageSize") int pageSize);
	    <resultMap id="order_user" type="orders" autoMapping="true">
        <id column="id" property="id"/>
        <association property="user" javaType="User" autoMapping="true">
            <!--column 关联字段  property为javabean的字段名-->
            <id column="user_id" property="id"/>
        </association>
    </resultMap>

    <select id="getItems" resultMap="order_user">
           SELECT o.id,o.user_id,o.number,o.createtime,u.username,u.address
            FROM orders o
            LEFT JOIN user u
            on o.user_id=u.id LIMIT #{start},#{pageSize}
    </select>
    
    一对多:用户与订单 和多对一就是sql语句进行左右互换
    在User里面添加List<Orders>order 返回的是一个map集合,在xml中resultType="Map集合"
    <resultMap id ="Map集合" type="当前类的名字" >
    	<id column ="id名字" property="javaBean属性名"/>
    	<result column="" property=""/>
    	<collection javaType="所对应的集合list"(可以省略) ofType="集合里面所对应的类" property="所对应的属性"/>
    	<id column ="中间的连接点,本数据库中的外键对应的别的数据库的注解的字段列" property="javabean的属性"/>
    </resultMap>
    
      
1	回家的mybatis的资料,进行整理,昨天的也进行整理,
2	后面的资料如何,把资料整理看看 tomcat特级视频讲解
3	springboot点餐系统 还未完成的任务,
4	最好有ssm的综合项目就好.
5	着重看springboot点餐系统。回去下载虚拟机 centos 7.3  还要vartialbox 官网下载 ,不需要下载,直接安装在虚拟机中  数据库设置编码 utf8mb4,开发环境
6	消息推送websocket 
7	下载的,idea,有webapp
8	git学习，看完这个项目后弄
9	今天晚上任务,把今天看视频的代码写下来,疑问点百度,自己总结。字段类型问题
```

### 4/19

```
1	明天上午把环境搭配好,把今天的东西全部消化掉。
2	下午的话，把资料往后面看
3	虚拟机没找到ip路径  虚拟网络打钩，
4	maven项目导入pom没有依赖
5	上午在弄那个cm掌上管理的,下周一开会,需要知识库和监控部分的代码。
6	今天晚上代码。把昨天的消化掉。
7	Hibernate 能够出色地自动生成主键。Hibernate/EBJ 3 注释也可以为主键的自动生成提供丰富的支持，允许实现各种策略。
其生成规则由@GeneratedValue设定的.这里的@id和@GeneratedValue都是JPA的标准用法, JPA提供四种标准用法,由@GeneratedValue的源代码可以明显看出.
JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
TABLE：使用一个特定的数据库表格来保存主键。
SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
IDENTITY：主键由数据库自动生成（主要是自动增长型）
AUTO：主键由程序控制。
在指定主键时，如果不指定主键生成策略，默认为AUTO。
@Id
相当于
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 
identity:
使用SQL Server 和 MySQL 的自增字段，这个方法不能放到 Oracle 中，Oracle 不支持自增字段，要设定sequence（MySQL 和 SQL Server 中很常用）。
Oracle就要采用sequence了.
 
同时,也可采用uuid,native等其它策略.(相关用法,上网查询)
```

### 4/20

```
1	springboot日志问题
2	测试问题,
3	Mysql数据库更改时间有问题
4	还有方法问题.前面加上名字
5	Linux下查看mysql、apache是否安装,并卸载。
	指令 ps -ef|grep mysql 得出结果
6	timestamp与本地时间相差八个小时.
7	最讨厌搞这些屁事.回去下载个画图工具,在说,上班时间不管。
8	不是代码,是思想。BigDecimal实现精确加减乘除运算	
9	浏览器里面安装jsonview  json视图
10	lambda表达式
11	上下班时间，2个多小时的时间，看下资料，不要看小说了，MMP  ，太耗时间了。
12	虚拟机里面进行修改域名和端口号，要能够连接的ip 路径在/usr/local/nignx/conf/nginx.conf  重启 nignx -s reload
	修改本机的host
13	今明,后三天任务,后端与前端联调.
14	mysql数据库迁移
		创建新的数据库
#mysql -u root -p123456
mysql>CREATE DATABASE `newdb` DEFAULT CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI;

复制数据库，使用mysqldump及mysql的命令组合，一次性完成复制
#mysqldump db1 -u root -p123456 --add-drop-table | mysql newdb -u root -p123456
注意-p123456参数的写法：-p后面直接跟密码，中间没有空格)
以上是在同一台MySQL服务器上复制数据库的方法。如果要复制到远程另一台MySQL服务器上，可以使用mysql的“ -h 主机名/ip”参数。前提是mysql允许远程连接，且远程复制的传输效率和时间可以接受。
不在同一个mysql服务器上
#mysqldump db1 -uroot -p123456 --add-drop-table | mysql -h 192.168.1.22 newdb -u root -p123456

15	service没有测试,回去想办法设置好。
```

### 4/21

```
1	周六,在家打游戏,陪菜菜,到吃了个自助烧烤,太吃亏了,肚子受不了。
```

### 4/22

```
1	在家玩了一天，打游戏，下次的话，周六或者周末时间，上午抽3个小时的时间出来，看资料。要不然一天都废了。
```

### 4/23

```
1	项目经理过来,找技术支持,最重要的是springboot的资源,今天把controller层写好.
2	进入mysql目录,在linux上面,直接输入 mysql -u root - p 后面会提示输入密码!
3	问题点所在,在安卓页面中,黑客输入网址,进行网络攻击,获取到数据,请求的url值
4	又白费了一天,4数据库连接不上去.
5	回去剩余代码,sell
```

### 4/24

```
1	把reder戒了,listen english  上下班的时候
2	今天任务,继续写sell代码。
3	回去把maven项目的资料路径进行改变，改变成D盘参数
4	nginx服务器修改 里面的参数,需要连接到本地 vim /usr/local/nginx/conf/nginx.conf
location /sell/ {  proxy_pass http://172.20.10.8:8080/sell/ 端口号修改 //172.20.10.8:8080 本地电脑的端口号
记得重新启动 nginx -s reload 
5	不能用端口号进行访问,需要用sell.com进行访问,先进行修改虚拟机的地址  {
        listen       80;
        server_name  sell.com;
     还需要修改本机的host地址server:C:\Windows\System32\drivers\etc\hosts
6	nginx反向代理,使用域名代替iP地址出错.

7	C:\Users\jl250\VirtualBox VMs\centos7.3_1\centos7.3-disk001.vmdk
8	dto  
9	回去直接代码.看到6-5 写完5的项目
10	不去弄虚拟机,花费在上面的时间太多了.
11	上午时间,卸载5.5,重新安装5.7版本Mysql OK
12	下午继续点餐系统,把资源给他 copy
13	导maven项目的时候,把.idea的文件夹删除就不需要进行更改maven了.
```

### 4/25

```
1	lambda表达式,今天下班路上看.        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
2	今天晚上点餐代码,继续
```

### 4/26

```
1	先把点餐的项目写好,至少2次,后面用mybatis重新再跑一遍,在后面看毕向东的视频资料,基础方面的。
2	下午在进行测试。商品库存问题
3	有时间，就先睡吧，把晚上的补回来。
4	有些事情，不要去强求，伤的是自己。
5	明天拿ipad过来，上下班看java基础资料。下班推迟10分钟回
```

### 4/27

```
1	IDEA的小技巧 等待去完成的时候用//TODO 会显示特定颜色  快捷键,进行收放方法 ctrl+shift+. 所有方法得收放ctrl+shif+ +,和ctrl+shift+ -
2	上下班,3个任务,点餐系统,java基础,普通话学习
3	不用按fn就是f1本身的功能,控制面板-->硬件和声音-->调整移动设备-->功能行-->功能键
```

### 4/28

```
1	把BuyOrderController 在重新写一遍.service和dao.
2	没事跑源码里面去看看.optional判断不为空 (! optional.isparent)
3	Gson解析json,fromJson(把对象,list,map之类的转换成json),toJson(把list,map,对象转换成json格式)

//对象转成json
	Student student = new Student();
		student.setName("xuanyouwu");
		student.setAge(26);
		String jsonStr = gson.toJson(student);
		log("---->javabean convert jsonStr:" + jsonStr);
		
		//List Map转Json字符串
	List<String> list = Arrays.asList("1", "a", "3", "rt", "5");
		log("---->list convert jsonStr:" + gson.toJson(list));
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("name", "xuanyouwu");
		content.put("age", "26");
		log("---->map convert jsonStr:" + gson.toJson(content));
		
		
	//把json转换为对象
	String studentJsonStr="{\"name\":\"xuanyouwu\",\"age\":26}";

		Student student1 = gson.fromJson(studentJsonStr, Student.class);
		log("------->json convert JavaBean:"+student1);
		//把json转换为list
		String listJsonStr = "[\"1\",\"a\",\"3\",\"rt\",\"5\"]";
		Type type = new TypeToken<ArrayList<String>>() {
		}.getType();
		ArrayList<String> sList=gson.fromJson(listJsonStr, type);
		log("------->json convert List:"+sList);
4	知识点,不懂得地方,不行,做一遍做两遍,多打debug模式,项目中用到的技术点,不会的,空闲时间看百度资料.
5	还有一个,带饭的时候,那个碗要扣紧。要不然会有油汤流出来
6	注释的时候，记得1.2.3.4点写好，小点的话，写1.1，1.2，或者1.2.1，要不然后面看起来太吃亏了
7	优酷视频，15分钟逻辑学
8	不是很理解的代码，多写下，用脑袋去想想。
9	晚上回去看15分钟逻辑学,多想想逻辑问题。orderServiceImpl的代码重新敲一遍。
```

### 4/29

```
从1月份开始写的每日总结，回去看看在台式电脑里面有没有，以后至少进行备份一份。
从今天开始放假3天,今天主要是在家玩,本来下午打算去打篮球,因为下雨就没过去了,在家打游戏,时间耗费太长。
```

### 4/30

```
她过来了,聚会时间,我,她,钟江华(他朋友),钟裘武,外面聚餐,仙湖植物园,旅游,聚餐,探鱼。
```

### 5/1

```
1	在家打游戏,时间耗费太长,弄了个血浆鸭。总结经验，后面周六，周末时间，一天17个小时的休息时间，拿出每天至少5个小时的学习时间，晚上拿出一个小时的时间去跑步，除非下雨，就不用出去，另外的玩之类的，生活还是不要改不了。
2	把数据线拿回家里面去,换一根。
```

### 5/2

```
1	mysql设置成开机启动 ?
2	时间戳格式转换成long类型?
3	中午时间,早点睡,醒来了,就自己看电脑
4	160就医密码JIAOLIN123 
5	(1)就医的,龙华人民医院,可以提前7天进行预约,预约时间为当天的下午3点钟
6	(2)北京大学深圳医院,提前3天预约,也是下午3点.
7	(3)深圳市宝安区人民医院提前8天,晚上7点预约 (4)深圳市人民医院,提前15天预约 具体时间不详(5) 深圳市第二人民医院,提前7天预约 具体时间不详(6)深圳市中医院提前4天.具体时间不详  (7)深圳宝安人民医院 提前8天,晚上7点预约(8)深圳市南山区人民医院 提前4天预约,具体时间不详 (9)深圳市宝安中医院（集团）提前18天预约.
8	这个周六时间,广东省牙科医疗中心,9.00-11.00	
9	房租
10	送花,口红
11	每天中午抽个20分钟出来看牙齿矫正预约资料. 需要咨询的问题。
```

### 5/3

```
1	把视频先看完,
2	微信服务端，文档吃透 
3	文思账号奥德赛			尹枫 ws-yinfeng ZCD)Nf/1 YF-CSZHGLPT
						杨龙 ws-yanglong PbRnQzz1 YF-CSZHGLPT 
						杨文豪 ws-yangwh B#h!fd?} YF-CSZHGLPT 
						焦林 ws-jiaolin B3XO.K3I YF-CSZHGLPT 
						李娜 ws-lina !&pSI7l] YF-CSZHGLPT
4	选定去第二人民医院，距离近，
5	natapp.cn 账号和密码 13145904403 密码:JIAOLIN123@

第一步
https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx11e1b47354ffa340&redirect_uri=http://i8hunm.natappfree.cc/sell/weixin/auth&response_type=code&scope=snsapi_base &state=STATE#wechat_redirect



https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx11e1b47354ffa340&redirect_uri=http://i8hunm.natappfree.cc/sell/weixin/auth&response_type=code&scope=SCOPE&state=STATE#wechat_redirect

获取2 code
http://i8hunm.natappfree.cc/sell/weixin/auth?code=?


通过code获取access_token
https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code

appid		wx11e1b47354ffa340
APPsecret	0cb56638a7f7159edca06047f5f46d9b

//通过response拿到openid

RestTemplte  restTemplate=new ();
restTemplate.getForObject(url,String.class)
springboot:@bean注解 @@ConfigurationProperties(prefix = "wechat")注解 在yml文件中看
	
```

### 5/4

```
1	ip地址设置 lcwifi的ip地址是183.233.81.228 中国移动的不会改变
2	微信客户端打不开网址
3	把service作为一个bean 在方法上打上注解@Bean
://以%3A%2F%2F 代替
https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx11e1b47354ffa340&redirect_uri=http%3A%2F%2Fi8hunm.natappfree.cc%2Fsell%2Fwechat%2FuserInfo&response_type=code&scope=snsapi_base&state=https%3A%2F%2Fwww.baidu.com#wechat_redirect


4	Scope 参数错误或没有 Scope 权限
```

### 5/5

```
1	所说的任务没有去完成,没有去动过。
2	时间没有分配好。
3	在家打一天游戏
4	思想和行为不一致
5	早上的跑步时间和下午到运动的时间有了,坚持,加油。
```

### 5/6

```
1	运动时间,是有了，下午跑步，另外，每周六周末的时间，自己定一个时间表，和计划表，严格按照那上面的去执行，
2	定时间，现在的周六周末时间，玩游戏，只有中午12点到18点，6个小时的时间，另外的时间，不要去开游戏。执行下去
```

### 5/7

```
1	Scope 参数错误或没有 Scope 权限 需要服务号的权限,没有权限操作不了,代码还是全部写好,只要能通过就行。
2	顺便看看后面的章节目录，讲的是些什么， 第九章，卖家订单  第十章，商品上下架
```

### 5/8

```
1	发excle文档给她,
2	人民医院去看医生,后面就不回来了,直接在家里面打卡。矫正问题，顺带下午早点到家的话，把平安银行卡进行激活。
3	文档事情，不用管，本来就会。
4	最主要还是需要写代码，点餐系统记得写完。
5	把后面几章的资料copy过来。点餐系统的
6	微信支付指的是用网页发起请求,进行支付
7	freemark技术 modelandview  map.put("response",response) ${response.id}
8	前端代码
9	查询当前文件夹命令 linux中du -h --max-depth=1 * 
	查询系统文件大小命令df -h
10	授权+支付
	授权,
11	excle文档自动换行 开始-->自动换行  单元格内的字体自动换行为alt+enter键 
12	微信测试号 appid:wxca39ca302b5b2505 appsecret:1e04c45cf0195187a556d9a9ebce645e
13	话不要说第三遍
14	配置地址,vim config里面
15	前端进行build 构建一次 npm run build 拷贝到项目路径下面去 cp -r dist/* /opt/data/wwroot/sell
16	今天下午把授权搞定,支付的话,尽量多做
```

### 5/9

```
1	视频尽量往后面看,
2	游戏卸载掉,就不要去打了,
3	看到朋友圈的说说,心里很感慨

4	好心人提供的CSDN的下载账号
	账号：qq_19387791
	密码：CSDN.ikrka.com
```

### 5/10

```
1	微信支付接口拿不到,放弃,appId能够拿到
2	需要商户号mch_id,和API秘钥key和Appsecret--secret,
3	有红色下划线,在代码中,没有错误,那就出在idea工具中,使用inspections 坚持,autowiring for bean class  把error改成warn
4	把后面的做完了,49元一个月的微信支付的,需要买一个月玩玩。
5	另外带几个牙签过来公司，太难受了，里面塞了点东西。
6	支付总结过程  后端发起支付，需要5个参数，mchId，mchKey，Appsecret，keyPath证书路径，notifyUrl异步通知路径 -->需要在网页端-->根据创建的订单,填写参数到pay.html中-->进行异步消息的通知-->还需要进行微信退款,在orderService中进行调用
7	URL进行解码,bejson.com
8	前端需要拷贝文件到另外一个目录,cp-r dist/* /opt/data/wwwroot/sell
9	回去看看git上面的视频,有支付+视频说明优酷网
10	卖家端地址:sell.springboot.cn/sell/seller/order/list
11	测试环境统一 	Assert.assertTrue("测试所有",student.getAge()>28); 错误的时候,有提示信息. 比较统一

数据库 jkapp  cm_prd  sso  192.168.75.61:3306/sso  
						192.168.75.57  jkapp  jk_1234
						
						zskdb  192.168.133.198:3306/zskdb 
						zskdbuser/zsk_1234
```

### 5/11

```
1	数据库迁移已经OK
2	freemark步骤 先导入pom文件,后在controller层返回视图ModelAndView,new ModelAndView ("order/test",map);
3	freemark模板引擎,回去要看视频,摹课网
4	html 标签 <html>
		<head>
			  <meat charSet="UTF-8"></meat>
    <title>微信点餐系统</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">g
		</head>
		<body> ibootstrap.cn 里面的代码直接复制</body>
			</html>		
5	看到9-3#,回去把第9章解决掉,有时间看看freemark模板技术。
6	小问题就不要找人解决了,一个人情,不值得  如果不是项目的事情,尴尬 
7	ifream 标签弹框问题下班看资料
```

### 5/12

```
1	家里面natapp  http://r3t94f.natappfree.cc
```

### 5/13

```
1	上午在家弄火锅,炖猪脚。
2	下午找阿松过去吃饭了，顺带打下游戏。		
```

## 五月份第三周

```
1	需要完成的任务,有springboot点餐系统大结局。
```



### 5/14

```
1	呆会查查,牙周怎么引起的。
2	耳塞没带，想想干些别的。星期四下午预约时间，中医院。
3	有时候是觉得真烦，弄个牙齿而已。
4	今天把电脑带回家,不要的东西删除掉.
5	www.office.com
6	xshell和xftp安装
```

### 5/15

```
1	MSCV120.DLL缺少,已经装了microsoft2013,需要装x64位的,要不然会报错，已经解决问题
2	window下启动mysql 到mysql的bin目录中,输入 mysql -u -p 在按enter键,输入密码就可以进入
3	查看mysql的版本号,mysql --version 
4	项目部署方面,有tomcat和java -jar两种,第二种用命令mvn clean package -Dmaven.test.skip=true-->可以在build中创建一个<finalName>sell</finalName> 名字为sell.jar-->启动的时候是java -jar sell.jar 已经OK 在进行端口的更改,java -jar -Dserver.port=8090 sell.jar
-->后面也可以进行开发环境和生产环境的发布,java -jar -Dserver.port=8090 -Dspring.profiles.active=prod sell.jar
5	回去写代码,在这边看视频资料
6	freemark 字段为空,就给一个默认不显示的值 在后面加!""
7	还剩下,第十一,十二,十三章,十一为卖家类目开发,十二位分布式session,十三为分布式锁。
8	时间不够，只写后台代码，前端代码直接用给的模板。
9	没有给参数的话，就直接用来注释掉，像pom的参数一样。
10	周六和周日看看情况，要不要过去长沙。
11	周五晚上晚点回，一起走，吃完饭后，打开电脑看资料到12点。
12	周六和周末早上跑步的时候，照样去。一天一个小时的时间，另外，下午抽3个小时的时间出来学习资料，如果不去别的地方转的话。
13	人力资源的问题，借钱问题，老爸老妈，姐，学春，林松，乐洋。
14	今晚回去第九章，订单完结...,第十章后台代码，商品上下架
```

### 5/16

```
1	第十一章,把十一的代码写完. 为什么要try，catch 方便记录日志定位问题,有了try.catch,你可以记录非常详细的日志信息,
2	今天晚上青椒炒小鱼仔
3	真想打死自己，找了这么久的bug，没去看主要的英语意思，错误一直存在。
```

### 5/17

```
1	第十二章视频,看完,把代码写完
2	实际情况,第十一章资料没有写完,第十二章视频,看了7/10,来回上班路上看的,加油.
3	今天任务,把项目放git上面去,
4	每年生日的时候,送给老爸老妈,蛋糕.想办法去网上看看.那种送到家的.
5	githubdesktop github桌面客户端 git客户端,还有git程序
```

### 5/18

```
1	第十三章视频,redis分布式锁和缓存 把代码写完,只负责后台,
2	学完这个项目,在重新写一遍这个代码,把git学了。
```

### 5/19

```
1	早上跑步回来玩会，中午弄个饭吃，下午2点到5点的时间看代码,敲代码时间，不要打游戏。
```

### 5/20

```
1	早上跑步回来玩会，中午弄个饭吃，下午2点到5点的时间看代码和敲代码时间，不要打游戏。
2	下次需要送手表，玫瑰花
```



## 五月第四周

```
1	主要把点餐代码重新写一遍,理清思路.
2	下次写需求的时候,就关于现在的全网监控app中的四个管理模块进行增删改查,并把对应的管理模块中的接口加上redis缓存对待。
```

### 5/21

```
1	送了一个最大的礼物给她,然而她不接收,并且严重的拒绝了。后面手术做了，好分好散吧。
2	文章改成README.MD，今日任务，中午加微信吧，适可而止吧，能聊的话。
3	把QQ不认识的全部删除掉，清理一遍。OK
4	全局处理异常出现错误。没效果，标点符号没事，另外的是包名写错了，正常会出现@M标志
```

