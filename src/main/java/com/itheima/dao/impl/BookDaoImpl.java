package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookDaoImpl implements BookDao{
//    //可以用private访问
//    private BookDaoImpl() {
//        System.out.println("book DAo construtor is running...");
//    }

    @Override
    public void save() {
        System.out.println("Book DAO save ...");
    }


     //销毁示例代码
    //表示bean初始化的操作
    public void init(){
        System.out.println("Book DAO init ...");
    }

    //表示bean销毁前的操作
    public void destroy(){
        System.out.println("Book DAO destroy ...");
    }

}
