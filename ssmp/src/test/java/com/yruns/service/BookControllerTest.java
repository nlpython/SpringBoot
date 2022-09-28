package com.yruns.service;

import com.yruns.pojo.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * BookControllerTest
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc   // 开启MVC虚拟调用
public class BookControllerTest {

    @Autowired
    private BookCase bookCase;

    @Test
    public void testInsertRandom() {
        System.out.println(bookCase);
    }

    @Test
    void testBookController(@Autowired MockMvc mvc) throws Exception {
        // http://localhost:8080/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/1");
        ResultActions perform = mvc.perform(builder);

        // 设定预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本次调用时成功：code 200
        ResultMatcher ok = status.isOk();
        // 匹配
        perform.andExpect(ok);

        // json数据匹配
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json(
                "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"type\": \"计算机理论\",\n" +
                "        \"name\": \"Spring实战 第五版\",\n" +
                "        \"description\": \"Spring入门经典教程，深入理解Spring原理技术内幕\",\n" +
                "        \"online\": null,\n" +
                "        \"deleted\": 0,\n" +
                "        \"version\": 1\n" +
                "    },\n" +
                "    \"code\": 20041,\n" +
                "    \"msg\": \"\"\n" +
                "}"
        );
        perform.andExpect(json);
    }
}
