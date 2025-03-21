package org.example;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        //3.获取IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //4.获取bean
        BookDao bookDao=(BookDao) context.getBean("bookDao");
        bookDao.save();
        BookService bookService=(BookService) context.getBean("bookService");
        bookService.save();
    }
}
