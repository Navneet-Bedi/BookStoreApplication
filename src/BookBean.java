/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Navneet
 */
public class BookBean {

    private int id;
    private String title;
    private String author;
    private String category;
    private int price;
    private int qty;

    public BookBean() {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.category = "";
        this.price = 0;
        this.qty = 0;
    }

    public BookBean(int id, String title, String author, String category, int price, int qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.qty = qty;
    }

    public BookBean(String title, String author, String category, int price, int qty) {

        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.qty = qty;
    }

    public BookBean(String title, String author, String category, int price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
