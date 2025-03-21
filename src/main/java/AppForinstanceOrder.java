import com.itheima.dao.OrderDao;
import com.itheima.dao.impl.OrderDaoImpl;
import com.itheima.factory.OrderDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForinstanceOrder {
    public static void main(String[] args) {
        /*//通过静态工厂创建对象
        OrderDao orderDao = OrderDaoFactory.getOrderDao();
        orderDao.save();*/
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao = (OrderDao) context.getBean("orderDao");
        orderDao.save();
    }
}
