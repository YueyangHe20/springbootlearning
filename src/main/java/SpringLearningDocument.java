public class SpringLearningDocument {

}
/*
What spring can do ?
 1.Microsevices 微服务的开发
 2.Reactive --Spring‘s asynchronous(异步),
  nonblocking(非阻塞) architecture means you can
  get more from your computinmg resources
 3.Cloud
 4.web app
 5.Serverless Scale up on demand amd scale to zero when there's
 no demand
 6.Event Driven
 7.Batch Automated tasks(自动化任务).Offline processing of data at a time to
 suit you（在适合的时间处理数据）
 */

/*
Spring技术有哪些？
Spring project(Spring 全家桶官网https://spring.io/projects)
目前已经学习：
1.Spring Framework
2.Spring boot
3.Spring cloud
*/

/*Spring发展史 EJB Spring
 * 1.Spring  1.0 纯配置的开发
 * 2.Spring 2.0 引入了注解
 * 3.Spring 3.0 可以不用配置
 * 4.Spring 4.0 紧跟JDK对部分API进行调整
 * 5.Spring 5.0 全面支持JDK8.0*/

/*Spring Framework系统架构
 * 4.x最后模块（5.x没有在官方文档）
 *
 * 1.Core Container(4) 核心容器
 * ￥Bean/Core/Context/SpEL
 *
 * 2.AOP面向切面的编程<作用在不惊动原始程序的情况下增强程序>
 *
 * 3.Aspect：AOP思想实现
 *
 * 4.Data Access/Integration 数据访问和数据集成(5)
 * ￥JDBC/ORM/OXM/JMS/Transactions事务 事务是Transaction的重点
 *
 * 5.Web(5)
 * ￥WebSocket/Servlet/Web/Portlet
 *
 * 6.Test:单元测试和集成测试
 * */

/*Spring Core Container核心概念(IOC<Inversion of Control>控制反转，DI<dependency injection>依赖注入和bean)
*
* IOC(Inversion of Control)控制反转
*   使用对象睡觉哦，由主动呢哇产生对象转为由外部提供对象，此过程中对象创建控制权有程序内部转移到外部，此思想称为控制反转
*
* Spring技术对IOC思想进行了实现
*   Spring提供了一个容器，称为IOC容器，用来充当IOC思想中的“外部”
*   IOC容器负责对象的创建、初始化等一系列工作，被创建或被管理的对象在IOC容器中统称为Bean
*
* DI(Denpendency Injection)依赖注入
*   在容器中建立bean与bean之间的依赖关系的整个过程，称为依赖注入
*
* 目标：充分解耦
*   使用IOC容器管理bean(IOC)
*   在IOC容器内将有依赖关系的bean进行关系绑定(DI)
*
* 最终效果
*   使用对象时不仅可以使用直接从IOC容器中获取，并且获取到的bean已经绑定了所有的依赖关系
*
* 补充(耦合和内聚分析，从这开始有原创性申明)
*
*7种耦合
*1.内容耦合（Content Coupling）：一个模块直接使用另一个模块的内部数据或者控制流程时。
*比如当一个类直接调用访问另一个类的属性信息。
*
*2.公共耦合（Common Coupling）：当两个或更多模块共享同一个全局数据结构或全局变量时，
* 这些模块被认为具有公共耦合。公共环境包括全局变量、共享数据结构、或存储介质上的文件等。
* 模块间通过访问这些共享的数据结构或全局变量进行交互。这种耦合方式比较紧密，因为模块间的
* 共享数据使得它们的依赖关系更加显著。与数据耦合不同，公共耦合涉及的全局数据结构可能会被
* 多个模块同时读写，增加了模块间的耦合度。
*
*3.外部耦合（External Coupling）： 当多个模块共享一个外部传来的数据结构或者全局变量时。
* 如 I/O 将模块耦合到特定的设备、格式、 通信协议上。
*
*4.控制耦合（Control Coupling）： 当一个模块控制着另一个模块的逻辑流程（比如通过传递控制
* 参数）时。存在流程控制，说明控制参数会决定接下来的流程。典型的例子就是计算电费，有个参数
* ，是计算平均的还是最高的，平局和最高是两个独立的计算模块，因此，这两个计算模块分别和计算
* 电费模块耦合。
*
*5.标记耦合（Stamp Coupling）：又叫特征耦合，当把整个数据结构作为参数传递，而被调用的模块只
* 需要使用其中一部分数据元素时，就出现了特征耦合。
*
* 6.数据耦合（Data Coupling）： 当模块间的交互仅仅通过参数来传递基本数据类型时。这是最佳的
* 耦合方式。如上面的赋值操作，或者如下的电费计算。
*
* 7.无耦合（No Coupling）： 模块之间没有任何直接的关系，是最理想的状态，但在实际应用中很难完
* 全实现。（也经常说6种耦合7种内聚，所以也可以说这不算是一种耦合）
———————————
* 版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
原文链接：https://blog.csdn.net/m0_62056231/article/details/137977538
*
*7种内聚
* 7种内聚
*
* 1.偶然内聚（Coincidental Cohesion）： 模块内部各个部分之间没有明显的关联，仅仅是偶然放在一起，
* 这是最低级别的内聚。通常会导致代码难以维护和理解。这里提一嘴，我认为代码生成器就是一种偶然内聚，
* 只是因为其他模块都有执行若干不相干的语句，我们将之提取，并作为独立模块。
*
* 2.逻辑内聚（Logical Cohesion）： 当一个模块中的元素被组织在一起，因为它们在逻辑上分类相似，通
* 常通过一个控制语句（如 if-else 或 switch）来选择执行。一些不相干的功能被组织在同一个模块中，
* 通过外部参数来控制实现哪个功能。简单记为，通过逻辑语句联系在一起的内聚。
*
* 3.时间内聚（Temporal Cohesion）： 模块中的元素相关联，因为它们需要在同一时间段内被执行。顾名思义，
* 就是单纯在时段上重合，也称为瞬时内聚，关键词就是同时执行。
*
* 4.过程内聚（Procedural Cohesion）： 当模块中的元素协同工作执行一个任务序列，彼此之间按照特定顺序
* 执行。例如：先写姓名 → 电话 → 家庭住址，先后顺序符合客户需求。关键词就是特定顺序执行。
*
* 5.通信内聚（Communication Cohesion）： 模块中的所有功能都操作相同的数据结构。即指模块内各个组成部分
* 都使用相同的数据结构或产生相同的数据结构。例如：一个模块根据员工生日计算员工年龄和退休时间。
*
* 6.顺序内聚（Sequential Cohesion）： 当一个模块内的操作必须按特定顺序执行，输出数据成为下一步操作的输
* 入数据时。前 一功能元素的输出就是下一功能元素的输入。例如：先计算员工的年龄再计算退休时间。例如某要完成
* 获取订单信息的功能，前一个功能获取用户信息，后一个执行计算均价操作，显然该模块内两部分紧密关联。过程内聚
* 顺序内聚的区别是：顺序内聚中是数据流从一个处理单元流到另一个处理单元，而过程内聚是控制流从一个动作流向另一个动作。
*
* 7.功能内聚（Functional Cohesion）： 当一个模块内的所有功能都是围绕一个单一的功能组织的，这是最高级别的内聚。
* ALL for ONE，所有处理元素只为完成某一个功能，缺一不可。
————————————————
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
原文链接：https://blog.csdn.net/m0_62056231/article/details/137977538
*
* 内聚性和耦合性分析
*
* 低<----------------------------->高(耦合性)
* 无直接耦合 数据耦合 标记耦合 控制耦合 外部耦合 公共耦合 内容耦合
* 强<----------------------------->弱(模块独立性)
*
* 高<----------------------------->低(内聚性)
*功能内聚 顺序内聚 通信内聚 过程内聚 时间内聚 逻辑内聚 偶然内聚
* 强<----------------------------->弱(模块独立性)
* */

/*IOC 入门案例
*
*IOC 入门案例思路分析
* 1.管理什么?(Service与Dao)
* 2.如何将被管理的对象那个告知IoC容器?(配置)
* 3.被管理的对象交给IOC容器，如何获取到IoC容器?(接口)
* 4.IoC容器得到后，如何从容器中获取bean?(接口方法)
* 5.使用Spring导入哪些坐标?(pom.xml)
*
* IOC入门案例
* 0.applicationContect.xml文件配置完成
* <!--1.导入spring的坐标spring-context，对应版本6.0.0-->
  <!--2.配置bean-->
  <!--bean标签表示配置bean
    id属性表示给bean起名字
    class属性表示给bean定义类型-->
    3.获取IOC容器
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    4.获取bean
        BookDao bookDao=(BookDao) context.getBean("bookDao");
        bookDao.save();
        BookService bookService=(BookService) context.getBean("bookService");
        bookService.save();
*  */

/*DI 入门案例
*
* DI入门案例思路分析
* 1.基于IOC管理bean
* 2.Service中使用new形式创建的Dao对象是否保留?(否)原因：有了实现类必定耦合度高<内容浦和：一个模块直接调用另一个模块内的属性 >
* 3.Service中需要的Dao对象如何进入到Service中?(提供方法)
* 4.Service与Dao间的关系如何描述?(配置)
*
* DI入门案例
* //5.删除业务层中使用new的方式创建的dao对象
    //private BookDao bookDao = new BookDaoImpl();
    private BookDao bookDao;
*  //6.提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
 * 在applicationContext.xml中完成配置哦
 * <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl">
        <!--    7.配置service于dao的关系-->
        <!--property标签表示的配置bean的属性
        name属性表示配置哪一个具体的属性<理解为setBookDao>
        ref属性表示参照哪一个bean<理解为bean的关系>-->
    <property name="bookDao" ref="bookDao"/>
    </bean>
* */

/*bean 基础配置<bean基础配置 bean别名配置 bean作用范围配置>
*
* bean基础配置
* 格式
* <beans>
    <bean>
    </bean>
</beans>
*属性列表
id:bean的id，使用容器可以通过id值获取对应的bean，在一个容器中id值唯一
class:bean的类型，即配置的bean的全路径名称
name:别名，在getbean的时候可以引用，推荐使用id，用空格(space)逗号(,)分号（;）
*实例
* <bean id="bookDao" name="bookService2 RE"  class="com.itheima.dao.impl.BookDaoImpl"/>
<bean id="bookService" class="com.itheima.service.impl.BookServiceImpl">
</bean>
*
* 作用范围<是否是单例对象>
bean的属性配置scope

功能
定义bean的作用范围，可选范围如下
singleton:单例(默认)
prototype:非单例

示例
<bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" scope="prototype"/>

为什么bean默认的是单例？
单例是每次创建的对象是同一个
非单例每次都会创建一个新对象，多次调用方法会生成多个对象，数据量过多

适合交给容器进行管理的bean<多次复用的对象>
表现层对象
业务层对象
数据层对象
工具对象

不适合交给容器进行管理的bean
封装实体的域对象
* */

/*bean的实例化（一）构造方法(bean是如何创建的 实例化bean的三种方式)
*
*bean的本质上就是对象，创建bean使用构造方法完成
*调用的是无参的构造方法
*
提供可访问的构造方法
//    //可以用private访问
//    private BookDaoImpl() {
//        System.out.println("book DAo construtor is running...");
//    }

    @Override
    public void save() {
        System.out.println("Book DAO save ...");
    }

配置
<bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" scope="prototype"/>
P.S.配置无任何变化
无参构构造方法不存在，将抛出异常BeanCreationEception
* */

/*实例化bean的三种方式(二)静态工厂(了解)
* 静态工厂
public class OrderDaoFactory {
    public static OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }
}
* 配置
 <bean id="orderDao" class="com.itheima.factory.OrderDaoFactory" factory-method="getOrderDao"/>
* */

/*实例化bean的三种方式(三)实例工厂(了解)
*
实例工厂
public class UserDaoFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}

配置
<!--方式三:使用实例化工厂实例化bean-->
    <bean id="userFactory" class="com.itheima.factory.UserDaoFactory"/>
    <bean id="userDao" factory-bean="userFactory" factory-method="getUserDao"/>
* */

/*实例化bean的第四种方式(FactoryBean)
*
FactoryBean
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    //代替原始实例工厂中创建对象的方法
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

配置
 <bean id="userDao" class="com.itheima.factory.UserDaoFactoryBean"/><!--    方式四:使用FactoryBean实例化bean-->
* */

/*bean 的生命周期(配置和接口两种控制方式)
* 生命周期:从创建到消亡的完整过程
* bean生命周期:bean从创建到销毁的整体过程
* bean的生命周期控制:在bean创建后到销毁前做一些事情
*
* 代码分析
* @Override
    public void save() {
        System.out.println("Book DAO save ...");
    }

    //表示bean初始化的操作
    public void init(){
        System.out.println("Book DAO init ...");
    }

    //表示bean销毁前的操作
    public void destroy(){
        System.out.println("Book DAO destroy ...");
    }
    *
    * applicationContect.xml的配置
    <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" scope="singleton" init-method="init" destroy-method="destroy"/>
    输出结果:有初始化方法输出，无销毁方法输出
    原因:java虚拟机执行完代码就关闭了
    *
    * 关闭的两种方法close()和registerShutDownHook
    //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //销毁方法在ClassPathXmlApplication暴力关闭方法
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();
        context.close();//可以与“context.registerShutdownHook();”替换，区别close暴力直接关闭，勾子可以放在任何地方
    这两种实际开发中不太需要
    *
    * 使用接口控制BookServiceImpl为例子
    public class BookServiceImpl implements BookService, DisposableBean, InitializingBean{
    //5.删除业务层中使用new的方式创建的dao对象
    //private BookDao bookDao = new BookDaoImpl();
    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("Book service save ...");
        bookDao.save();
    }
    //6.提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Book service destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Book service init...");
    }
    }
使用了 DisposableBean, InitializingBean接口控制关闭和开启,需要重写destory()和afterPropertiesSet()方法
afterPropertiesSet()是在类属性设置以后开始出初始化控制
*
* bean生命周期
初始化容器
 1.创建对象
 2.执行构造方法
 3.执行属性注入(set操作)
 4.执行bean初始化方法
使用bean
1.执行业务操作
关闭/销毁容器
1.执行bean的销毁方法
*
* bean销毁时机
容器关闭前触发bean的销毁

关闭容器的方式
手工关闭容器
ConfigurableApplicationContext接口close()操作
注册关闭钩子，在虚拟机退出前先关闭容器再退出虚拟机
ConfigurableApplicationContext接口close()操作
    * */

/*依赖注入（两种方式）
*
思考:向一个类中传递数据的方式有几种？
普通方法(set方法)
构造方法

思考:
简单类型(基本数据类型与String)
引用类型

依赖注入方式
setter注入(官方命名)
简单类型
引用类型
构造器注入(官方命名)
简单类型
引用类型
*
JAVA四种引用类型:强引用，软引用，虚引用，弱引用

ava设计这四种引用的主要目的有两个：
可以让程序员通过代码的方式来决定某个对象的生命周期；
有利用垃圾回收。

JVM去负责Java的分配和内存回收,一个对象是否可以被回收，主要看是否有引用指向此对象.

强引用
强引用是最普遍的一种引用，我们写的代码，99.9%都是强引用,比如:
Object o = new Object();
只要某个对象有强引用与之关联，这个对象永远不会被回收，即使内存不足，JVM宁愿抛出OOM(内存溢出)，也不会去回收。
P.S.
-什么是内存溢出，什么是内存泄漏？
-它代表业务代码执行时，所需要占用的内存空间。这段业务代码中创建了两个1M的对象，一起会占用2M内存。当对象使用完之后，
-这两个对象并没有释放，因此内存中会留下2M的内存空间一直被占用。而我们的业务代码在程序中会被反复执行，每次执行都
-会留下2M不被释放，反复执行多次之后，随着时间的累积，就会有大量的对象用完不被释放，导致这些对象不能得到回收而发
-生内存溢出，这种情况就叫做内存泄漏。
-也就说，在我们的业务代码执行过程中，有些对象它应该被回收，但是又有其他对象引用引用它，因此，GC不能自动回收。所
-以，该回收的垃圾对象没有被回收，垃圾对象越堆越多，可用内存越来越少，若可用内存无法存放新的垃圾对象，最终导致内存
-泄漏。内存泄漏最终会导致内存溢出。

软引用
创建一个软引用:
SoftReference<Student> studentSoftReference= new SoftReference<Student>(new Student());
软引用就是把对象用SoftReference包裹一下，当我们需要从软引用对象获得包裹的对象，只要get一下就可以了：
SoftReference<Student> studentSoftReference= new SoftReference<Student>(new Student());
Student student = studentSoftReference.get();
System.out.println(student);
软引用的特点：
当内存不足，会触发JVM的GC，如果GC后，内存还是不足，就会把软引用的包裹的对象给干掉，也就是只有在内存不足，JVM才会回收该对象。
软引用的用处:
比较适合用作缓存，当内存足够，可以正常的拿到缓存，当内存不够，就会先干掉缓存，不至于马上抛出OOM。

弱引用
弱引用的使用和软引用类似，只是关键字变成了WeakReference
WeakReference<byte[]> weakReference = new WeakReference<byte[]>(new byte[1024\*1024\*10]);
System.out.println(weakReference.get());
弱引用的特点是不管内存是否足够，只要发生GC，都会被回收;
弱引用在很多地方都有用到，比如ThreadLocal、WeakHashMap。

虚引用
虚引用又被称为幻影引用,我们来看看它的使用:
ReferenceQueue queue = new ReferenceQueue();
PhantomReference<byte[]> reference = new PhantomReference<byte[]>(new byte[1], queue);
System.out.println(reference.get());
虚引用的使用和上面说的软引用、弱引用的区别还是挺大的,它的特点1.无法来获取对一个对象的真实引用。2.引用必须与
ReferenceQueue一起使用，当GC准备回收一个对象，如果发现它还有虚引用，就会在回收之前，把这个虚引用加入到与之关联的ReferenceQueue中。
虚引用存在的意义:
创建虚引用对象，我们除了把包裹的对象传了进去，还传了一个ReferenceQueue(一个队列).
当发生GC，虚引用就会被回收，并且会把回收的通知放到ReferenceQueue中
虚引用有什么用:
在NIO(多路复用模式)中，就运用了虚引用管理堆外内存.
*
setter注入-引用类型
在bean中定义引用类型属性并提供可访问的set方法
//5.删除业务层中使用new的方式创建的dao对象
    //private BookDao bookDao = new BookDaoImpl();
    private BookDao bookDao;
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
在配置中使用property标签属性ref属性注入引用类型对象
<bean id="bookService" name="bookService2 RE" class="com.itheima.service.impl.BookServiceImpl">
<!--    7.配置service于dao的关系-->
        <!--property标签表示的配置bean的属性
        name属性表示配置哪一个具体的属性<理解为setBookDao>
        ref属性表示参照哪一个bean<理解为bean的关系>-->
    <property name="bookDao" ref="bookDao"/>
</bean>
<bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" scope="singleton" init-method="init" destroy-method="destroy"/>
*
setter注入-简单类型
在bean中定义引用类型属性并提供可访问的set方法

在配置中使用property标签value属性注入简单数据类型

*/

/*
构造方法注入-引用注入
BookService类中的代码(未测试代码仅学习理解用)
public class BookServiceImpl implements BookService{
private BookDao bookDao;
private UserDao userDao;
//构造器
public BookServiceImpl(BookDao bookDao1,UserDao userDao1){
this.bookDao=bookDao1;
this.userDao=UserDao1;
//为了理解配置文件中name在构造器注入中和之前不同
}
}
applicationContect.xml配置
<bean id="bookService" name="bookService2 RE" class="com.itheima.service.impl.BookServiceImpl">
        <constructor-arg name="bookDao1" ref="bookDao"><!-形参与构造器注入名字相同，耦合度较高->
        <constructor-arg name="userDao1" ref="userDao"><!-形参与构造器注入名字相同，耦合度较高->
</bean>
*
构造方法注入-简单注入
BookService类中的代码(未测试代码仅学习理解用)
public class BookServiceImpl implements BookService{
private String databaseName;
private int connectNum;
//构造器
public BookServiceImpl(String databaseName,int connectNum){
this.databaseName=databaseName;
this.connectNum=connectNum;
//为了理解配置文件中name在构造器注入中和之前不同
}
}
applicationContect.xml配置
<bean id="bookService" name="bookService2 RE" class="com.itheima.service.impl.BookServiceImpl">
        <constructor-arg name="databaseName" value="mysql"><!-形参与构造器注入名字相同，耦合度较高->
        <constructor-arg name="connectNum" value="1000"><!-形参与构造器注入名字相同，耦合度较高->
</bean>
***构造器改输入名字bean也要改，耦合度极高
*解决方案(applicationContect.xml配置)
<bean id="bookService" name="bookService2 RE" class="com.itheima.service.impl.BookServiceImpl">
        <constructor-arg type="java.lang.String" value="mysql"><!-形参与构造器注入名字相同，耦合度较高->
        <constructor-arg type="int" value="1000"><!-形参与构造器注入名字相同，耦合度较高->
</bean>
*存在问题有两个String会有冲突，解决形参名称问题，上述方法解决了形参耦合问题
*解决方案
<bean id="bookService" name="bookService2 RE" class="com.itheima.service.impl.BookServiceImpl">
        <constructor-arg type="java.lang.String" index="0" value="mysql"><!-形参与构造器注入名字相同，耦合度较高->
        <constructor-arg type="java.lang.String" index="1" value="1000"><!-形参与构造器注入名字相同，耦合度较高->
</bean>
*依靠位置index解决问题
 */

/*依赖注入方式选择
* 1.强制依赖使用构造器进行,使用setter注入有概率不进行注入导致null对象出现
* 2.可选依赖使用setter注入进行，灵活性强
* 3.Spring框架倡导使用构造器，第三方框架大多数采用构造器注入的形式进行数据初始化，相对严谨
* 4.如果有必要可以两者同时使用，使用构造器注入完成强制依赖的注入，使用setter注入完成可选依赖的注入
* 5.实际开发过程中还需要更根据实际情况分析，如果受控对象没有提供setter方法就必须使用构造器注入
* 6.自己开发的模块推荐使用setter注入
* */

/*依赖自动装配
*IOC容器更具bean所依赖的资源在容器中自动查找并注入到bean中的过程称为自动装配
*
*自动装配的方式
* 按类型(常用)
* 按名称
* 按构造方法
* 不启动自动装配
*
* 自动装配代码
* BookServiceImpl类
public class BookServiceImpl implements BookService{
private BookDao bookDao;
public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
}
* applicationContect.xml配置
<bean id="bookService" name="bookService2 RE" class="com.itheima.service.impl.BookServiceImpl" autowire="byType"/>
 与上面的区别直接封口，用autowire属性指定方法，set方法一定不能缺，防止映射不成功，符合IOC思想
*
*依赖自动装配特征
* 自动装配用于引用类型依赖注入，不能对简单类型进行操作
* 使用按类型装配时(byType)必须保障容器中相同类型的bean唯一，推荐使用
* 使用按名称装配时(byName)必须保障容器中具有指定不成的bean,因变量名与配置耦合，不推荐使用
* 自动装配优先级低于setter注入和构造器注入，同时出现时自动装配失效
*  */

/*集合注入
* 数组
* List
* Set
* Map
* Properties
* 代码注释
*   <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" scope="singleton" init-method="init" destroy-method="destroy"><!--    方式一:构造方法实例化对象bean-->
        <property name="databaseName" value="mysql"/>
        <property name="connectionNum" value="100"/>
        <property name="array">
            <array>
                <value>100</value>
                <value>200</value>
                <value>300</value>
            </array>
        </property>
        <property name="bookList">
            <list>
                <value>100</value>
                <value>200</value>
                <value>300</value>
            </list>
        </property>
        <property name="set">
            <set>
                <value>100</value>
                <value>200</value>
                <value>300</value>
            </set>
        </property>
        <property name="map">
            <map>
                <entry key="1" value="1"/>
                <entry key="2" value="2"/>
                <entry key="3" value="3"/>
            </map>
        </property>
        <property name="properties">
            <props>
                <prop key="1">1</prop>
                <prop key="2">2</prop>
                <prop key="3">3</prop>
            </props>
        </property>
    </bean>
*   */

/*加载property文件
* xml代码
* 1.开启context命名空间
* <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
"
>
* 添加的代码三行:
* xmlns:context="http://www.springframework.org/schema/context"
* http://www.springframework.org/schema/context
* http://www.springframework.org/schema/context/spring-context.xsd
* 2.使用context命名空间，加载指定properties文件
* <context:property-placeholder location="jdbc.properties">
*3.使用${}读取加载的属性值
* <property name="username" value="${jdbc.username}">
*
* 加载properties文件的5种情况
* 1.不加载系统属性
* <context:property-placeholder location="jdbc.properties" system-properties-never="Never"/>
* 2.加载多个properties文件
* <context:property-placeholder location="jdbc.properties,msg.properties"/>
* 3.加载所有properties文件
* <context:property-placeholder location="jdbc.properties"/>
* 4.加载properties文件标准格式
* <context:property-placeholder location="classpath:*.properties"/>
* 5.从类路径或jar包中搜索并加载properties文件
* <context:property-placeholder location="classpath*:*.properties"/>
* */