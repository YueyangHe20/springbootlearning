package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
//    //可以用private访问
//    private BookDaoImpl() {
//        System.out.println("book DAo construtor is running...");
//    }

    @Override
    public void save() {
        System.out.println("Book DAO save ...");
    }
}
