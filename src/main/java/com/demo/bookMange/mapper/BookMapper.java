package com.demo.bookMange.mapper;


import com.demo.bookMange.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book")
    List<Book> getAllBooks();

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book getBookById(Long id);

    @Insert("INSERT INTO book(title, author, isbn) VALUES(#{title}, #{author}, #{isbn})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addBook(Book book);

    @Update("UPDATE book SET title = #{title}, author = #{author}, isbn = #{isbn} WHERE id = #{id}")
    void updateBook(Book book);

    @Delete("DELETE FROM book WHERE id = #{id}")
    void deleteBook(Long id);
}
