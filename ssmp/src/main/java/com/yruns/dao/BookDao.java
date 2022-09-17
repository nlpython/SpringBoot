package com.yruns.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yruns.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<Book>{

    @Insert("insert into tb_book values(null, #{type}, #{name}, #{description}, 0, 1);")
    int save(Book book);

    @Update("update tb_book set type=#{type}, name=#{name}, description=#{description} where id=#{id} and deleted=0;")
    int update(Book book);

    @Delete("delete from tb_book where id=#{id};")
//    @Update("update tb_book set type=#{type}, name=#{name}, description=#{description}, deleted = 1 where id=#{id} and deleted=0;")
    int delete(Integer id);

    @Select("select * from tb_book where id=#{id} and deleted=0;")
    Book selectById(Integer id);

    @Select("select * from tb_book where deleted=0;")
    List<Book> selectAll();

    @Select("select * from tb_book where name like CONCAT('%',#{name},'%') and deleted=0;")
    List<Book> selectByName(String name);

}
