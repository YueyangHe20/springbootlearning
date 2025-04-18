package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService, DisposableBean, InitializingBean {
    //5.删除业务层中使用new的方式创建的dao对象
    //private BookDao bookDao = new BookDaoImpl();
    private BookDao bookDao;
    private UserDao userDao;
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        System.out.println("Book service save ...");
        bookDao.save();
        userDao.save();
    }
    //6.提供对应的set方法

    /**/
    @Override
    public void destroy() throws Exception {
        System.out.println("Book service destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Book service init...");
    }
    /**/
}
