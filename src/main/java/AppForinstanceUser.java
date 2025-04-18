import com.itheima.dao.UserDao;
import com.itheima.factory.UserDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForinstanceUser {
    public static void main(String[] args) {
//        //创建实例工厂对象
//        UserDaoFactory userDaoFactory = new UserDaoFactory();
//        //通过实例工厂对象创建对象
//        UserDao userDao = userDaoFactory.getUserDao();
//        userDao.save();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }
}
