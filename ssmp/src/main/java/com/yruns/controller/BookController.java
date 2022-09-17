package com.yruns.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yruns.pojo.Book;
import com.yruns.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookController
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Book book = bookService.selectById(id);
        Integer code = book != null ? Code.GET_OK:Code.GET_ERR;
        String msg = book != null ? "":"数据查询失败";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> books = bookService.selectAll();
        Integer code = books != null ? Code.GET_OK:Code.GET_ERR;
        String msg = books != null ? "":"数据查询失败";
        return new Result(code, books, msg);
    }

    @GetMapping("/{current}/{size}")
    public Result getPage(@PathVariable int current, @PathVariable int size) {
        IPage<Book> books = bookService.getPage(current, size);
        Integer code = books != null ? Code.GET_OK:Code.GET_ERR;
        String msg = books != null ? "":"数据查询失败";
        assert books != null;
        return new Result(code, books.getRecords(), msg);
    }
    
    
}
