package com.model;

public class InheritanceNode {
	
	private String classname;
	private String superclass;
	private String childclass;
	
	public InheritanceNode() {
		
		// TODO Auto-generated constructor stub
	}

	public InheritanceNode(String classname, String superclass, String childclass) {
		super();
		this.classname = classname;
		this.superclass = superclass;
		this.childclass = childclass;
	}

	
	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSuperclass() {
		return superclass;
	}

	public void setSuperclass(String superclass) {
		this.superclass = superclass;
	}

	public String getChildclass() {
		return childclass;
	}

	public void setChildclass(String childclass) {
		this.childclass = childclass;
	}
	
	
	
	
	
	

}
