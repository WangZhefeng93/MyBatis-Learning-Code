package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.Book;

public interface IBookDao {
    //验证一级缓存的存在性：根据图书的id查询相应的图书信息
    public Book findBookById(int id);

    //验证从缓存读取数据的依据是SQL的id：根据图书的id查询相应的图书信息
    public Book findBookById2(int id);

    //验证增删改操作会清空一级缓存：根据图书的id修改相应的图书信息
    public void updateBookById(Book book);
}
