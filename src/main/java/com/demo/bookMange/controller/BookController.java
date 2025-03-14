package com.demo.bookMange.controller;

import com.demo.bookMange.entity.Book;
import com.demo.bookMange.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    // 显示所有书籍（支持 /books 和 /books/）
    @GetMapping({"/", ""}) // 修正路径
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        System.out.println("Books from service: " + books); // 打印日志
        model.addAttribute("books", books);
        return "index"; // 返回 index.html 页面
    }
/*
    // 显示所有书籍
    @GetMapping("/")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }*/

    // 显示添加书籍页面
    @GetMapping("/add")
    public String showAddForm() {
        return "add";
    }

    // 保存新书籍
    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    // 显示编辑书籍页面
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id).orElse(new Book());
        model.addAttribute("book", book);
        return "edit";
    }

    // 更新书籍
    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/";
    }

    // 删除书籍
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
