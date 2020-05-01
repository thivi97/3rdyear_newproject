package com.model;

import java.io.Serializable;

public class Register implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String fname;
    private String lname;
    private String uname;
    private String email;
    private String password;
    private String conpassword;
    
    public String getFname(){
        return fname;
    }
    
    public void setFname(String fname){
        this.fname = fname;
    }
    
    public String getLname(){
        return lname;
    }
    
    public void setLname(String lname){
        this.lname = lname;
    }
    
    public String getUname(){
        return uname;
    }
    
    public void setUname(String uname){
        this.uname = uname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

	public String getConpassword() {
		return conpassword;
	}

	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}

    
    
    
	
}
