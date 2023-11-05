package cn.qiu.domain;

import java.io.Serializable;

/*
 * 书籍实体类
 */
public class Book_inf implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;// 书籍id
	private String title;// 书籍名称
	private String author;// 作者
	private String publisher;
	private int category;// 分类

	public Book_inf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book_inf(String id, String title, String author, String publisher, int category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}
	
	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}
	
	public String getpublisher() {
		return publisher;
	}

	public void setpublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getcategory() {
		return category;
	}

	public void setcategory(int category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", publisher=" + publisher + ", category=" + category + "]";
	}

}
