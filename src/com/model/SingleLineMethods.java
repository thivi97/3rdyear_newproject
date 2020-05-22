package com.model;

public class SingleLineMethods {
	private int lineNumber;
	private String statement;
	private int cm; //complexity
	private int wmrt; //weight due to method return type (void: 0, primitive: 1, composite: 2)
	private int wpdtp; //weight of primitive data types: 1
	private int npdtp; //no of primitive data types
	private int wcdtp; //weight of composite data types: 2
	private int ncdtp; //no of composite data types
	
	int primitive_method,composite_method,primitive_parameters,composite_parameters;
	String line;
	
	
	
	public int getPrimitive_method() {
		return primitive_method;
	}
	public void setPrimitive_method(int primitive_method) {
		this.primitive_method = primitive_method;
	}
	public int getComposite_method() {
		return composite_method;
	}
	public void setComposite_method(int composite_method) {
		this.composite_method = composite_method;
	}
	public int getPrimitive_parameters() {
		return primitive_parameters;
	}
	public void setPrimitive_parameters(int primitive_parameters) {
		this.primitive_parameters = primitive_parameters;
	}
	public int getComposite_parameters() {
		return composite_parameters;
	}
	public void setComposite_parameters(int composite_parameters) {
		this.composite_parameters = composite_parameters;
	}
	
	
	
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public SingleLineMethods() {
		this.wpdtp = 1;
		this.wcdtp = 2;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public int getCm() {
		return cm;
	}
	public void setCm(int cm) {
		this.cm = cm;
	}
	public int getWmrt() {
		return wmrt;
	}
	public void setWmrt(int wmrt) {
		this.wmrt = wmrt;
	}
	public int getWpdtp() {
		return wpdtp;
	}
	public void setWpdtp(int wpdtp) {
		this.wpdtp = wpdtp;
	}
	public int getNpdtp() {
		return npdtp;
	}
	public void setNpdtp(int npdtp) {
		this.npdtp = npdtp;
	}
	public int getWcdtp() {
		return wcdtp;
	}
	public void setWcdtp(int wcdtp) {
		this.wcdtp = wcdtp;
	}
	public int getNcdtp() {
		return ncdtp;
	}
	public void setNcdtp(int ncdtp) {
		this.ncdtp = ncdtp;
	}
	public void calculateCM() {
		this.cm = this.wmrt + (this.wpdtp * this.npdtp) + (this.wcdtp * this.ncdtp);
	}
	@Override
	public String toString() {
		return "SingleLineMethods [lineNumber=" + lineNumber + ", statement=" + statement + ", cm=" + cm + ", wmrt="
				+ wmrt + ", wpdtp=" + wpdtp + ", npdtp=" + npdtp + ", wcdtp=" + wcdtp + ", ncdtp=" + ncdtp + "]";
	}
}
