


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sanaali
 */
public class User implements Serializable{
    private String email;
    private String password;
    private String fname;
    private String lname;
    private String addr;
    private String ph;
    private String role;

   
    public User(String email, String password, String addr, String fname, String lname, String ph) {
        this.email = email;
        this.password = password;
        this.addr=addr;
        this.fname=fname;
        this.lname=lname;
        this.ph=ph;
        

    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String email, String password, String fname, String lname, String addr, String ph, String role) {
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.ph = ph;
        this.role = role;
    }
    
    public User(){
       
    }

}