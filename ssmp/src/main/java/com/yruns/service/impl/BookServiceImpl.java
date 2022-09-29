package com.yruns.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yruns.dao.BookDao;
import com.yruns.pojo.Book;
import com.yruns.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BookServiceImpl
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    @Cached(name="book_", key = "#id", expire = 3600)
    @CacheRefresh(refresh = 60)  // 设置缓存15s刷新一次（从数据库中自动查询，更新内存中的数据）
    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public List<Book> selectByName(String name) {
        return bookDao.selectByName(name);
    }

    @Override
    public IPage<Book> getPage(int current, int size) {
        IPage page = new Page(current, size);
        return bookDao.selectPage(page, null);
    }
}
