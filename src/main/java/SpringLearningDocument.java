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

/**/