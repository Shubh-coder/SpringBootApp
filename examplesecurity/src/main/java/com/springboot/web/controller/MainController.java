package com.springboot.web.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.web.entity.Book;
import com.springboot.web.service.BookService;

import jakarta.annotation.PostConstruct;

@Controller
public class MainController {
	  
	@Autowired
	private BookService bookService;
	
 
	
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("this is home page");
		return "home";
	}
	// showing content of JSP page Response on webserver using Viewpage(src->main->home.jsp page) 
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("this is contact page");
		return "contact";
	}

	
	//  responce of current method for that we use @responseBody Annotations.
	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		int a=10,b=20;
		return "sum of a & b: "+a+b;
	}
	 
	
//--------------------------------------------
  @GetMapping("/books")
  @ResponseBody
  public ResponseEntity<List<Book>> getBooks(){
	  List<Book> list=bookService.getAllBooks();
	  if(list.size()<=0) {
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();     //responseEntity to make response msg.
	  }
	  
	  return ResponseEntity.of(Optional.of(list));
  }
  
  
  
  @GetMapping("/books/{id}")
  @ResponseBody
  public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
         
	    
	     Book book = bookService.getBookById(id);
       
	     if(book==null) {
        	 ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         
	   return ResponseEntity.of(Optional.of(book));
  }
  
  @PostMapping("/books")
  @ResponseBody
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
	  
	  try{
	   Book b=this.bookService.addBook(book);
	   System.out.println(book);
	   return ResponseEntity.of(Optional.of(b));
	  }catch(Exception e)
	  {
		  e.printStackTrace();
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	  }
	  
	   
	  
  }
	
	
  // Delete Handler
  @DeleteMapping("/books/{bookid}")
  @ResponseBody
  public void deleteBook(@PathVariable("bookid") int bid)
  {
	   this.bookService.deletBook(bid);
 
	
  }
  
  
  // update  book hadler
  @PutMapping("/books/{bookId}")
  @ResponseBody
  public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId ) {
	
	  this.bookService.updateBook(book,bookId);
	  return book;
  }
  
	
	  @GetMapping("/books/bookTitle/{title}")
	  
	  @ResponseBody public Book getByTitle(@PathVariable("title") String title) {
	  return this.bookService.getByTitle(title);
	  
	  
	  }
	 
  
}
