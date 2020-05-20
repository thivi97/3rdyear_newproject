package com.model;

public class Inheritance {

	private int count;
	private String className;
	private int no_di;
	private int no_ini;
	private int tot_in;
	private int Ci;
	
	
	public Inheritance() {
		
		// TODO Auto-generated constructor stub
	}


	public Inheritance(int count, String className, int no_di, int no_ini, int tot_in, int ci) {
		super();
		this.count = count;
		this.className = className;
		this.no_di = no_di;
		this.no_ini = no_ini;
		this.tot_in = tot_in;
		Ci = ci;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public int getNo_di() {
		return no_di;
	}


	public void setNo_di(int no_di) {
		this.no_di = no_di;
	}


	public int getNo_ini() {
		return no_ini;
	}


	public void setNo_ini(int no_ini) {
		this.no_ini = no_ini;
	}


	public int getTot_in() {
		return tot_in;
	}


	public void setTot_in(int tot_in) {
		this.tot_in = tot_in;
	}


	public int getCi() {
		return Ci;
	}


	public void setCi(int ci) {
		Ci = ci;
	}
	
	
	
	
	
	
	
}
