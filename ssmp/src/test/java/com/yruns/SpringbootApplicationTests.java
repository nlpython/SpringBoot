package com.yruns;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yruns.dao.BookDao;
import com.yruns.pojo.Book;
import com.yruns.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;


//    @Test
//    public void testSelectById() {
//        System.out.println(bookService.selectById(2));
//    }

    @Test
    public void testSelectAll() {
        System.out.println(bookService.selectAll());
    }

    @Test
    public void testInsert() {
        Book book = new Book();
        book.setName("aa");
        book.setType("bb");
        bookDao.insert(book);
    }

    @Test
    public void testDeleteById() {
        bookDao.deleteById(36);
    }

    @Test
    public void testSelectPage() {
        Page page = new Page(2, 3);
        System.out.println(bookDao.selectPage(page, null));
    }

    /**
     * 条件查询
     */
    @Test
    public void testSelectById() {
        String name = "Spring";
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        qw.like(name != null, Book::getName, name);
        bookDao.selectList(qw);
    }

}
