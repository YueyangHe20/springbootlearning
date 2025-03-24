package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.awt.print.Book;
import java.util.*;

public class BookDaoImpl implements BookDao{
    //    //可以用private访问
    //    private BookDaoImpl() {
    //        System.out.println("book DAo construtor is running...");
    //    }
    private int connectionNum;
    private String databaseName;
    private int[] array;
    private List<String> bookList;
    private Set<String> set;
    private Map<String, String> map;
    public Properties properties;

    public void setConnectionNum(int connectionNum) {
            this.connectionNum = connectionNum;
    }
    public void setDatabaseName(String databaseName) {
            this.databaseName = databaseName;
    }
    public void setArray(int[] array) {this.array = array;}
    public void setBookList(List<String> bookList) {this.bookList = bookList;}
    public void setSet(Set<String> set) {this.set = set;}
    public void setMap(Map<String, String> map) {this.map = map;}
    public void setProperties(Properties properties) {this.properties = properties;}

    @Override
    public void save() {
        System.out.println("Book DAO save ..."+databaseName+","+connectionNum);
        System.out.println("遍历array"+array);
        System.out.println("遍历bookList"+bookList);
        System.out.println("遍历set"+set);
        System.out.println("遍历map"+map);
        System.out.println("遍历properties"+properties);
    }

    //销毁示例代码
    // 表示bean初始化的操作
    public void init(){
        System.out.println("Book DAO init ...");
    }
    //表示bean销毁前的操作
    public void destroy(){
        System.out.println("Book DAO destroy ...");
    }

}
