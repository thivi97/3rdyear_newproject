package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.model.Inheritance;
import com.model.InheritanceNode;

public class InheritanceService {
	
	private int count = 0;
	private String classname = "";
	private int no_di = 0;
	private int no_ini = 0;
	private int tot_in = 0;
	private int ci = 0;
	
	
	private int inheritnon = 0;
	private int inheritone = 1;
	private int inherittwo = 2;
	private int inheritthree = 3;
	private int inheritmore = 4;
	
	private String code;
	
	//patterns
	private String INHERITANCE_CLASS = "\\w*\\sextends\\s\\w*";
	private String INHERITANCE_INTERFACE = "implements|,";
    private String FIND_INHERITANCE_INTERFACE = "implements[\\s\\w*,]*";
    private String FIND_CLASS = "class\\s\\w*";
    
    List<InheritanceNode> nodeList = new ArrayList<InheritanceNode>();
    List<String> classList = new ArrayList<String>();
    List<Inheritance> inheritancemodel = new ArrayList<Inheritance>();
    
    public InheritanceService() {
    	
    }
    
    private static final Inheritance obj = new Inheritance();
    
    public static Inheritance getInstance() {
    	return obj;
    }
    
    public void setCode(String code) {
    	this.code = code;
    }
    
    private void reset() {
    	classname = "";
    	no_di =0;
    	no_ini = 0;
    	tot_in = 0;
    	ci = 0;
    }
    
    public int[] getWeights() {
    	int weights[] = {inheritnon,inheritone,inherittwo,inheritthree,inheritmore};
    	return weights;
    }
    
    public void setWeights(int inheritnon,int inheritone,int inherittwo,int inheritthree,int inheritmore) {
    	this.inheritnon = inheritnon;
    	this.inheritone = inheritone;
    	this.inherittwo = inherittwo;
    	this.inheritthree = inheritthree;
    	this.inheritmore = inheritmore;
    	
    }
    
    public List<Inheritance> getComplexity(){
    	loadDatatoList(code);
    	inheritancemodel.removeAll(inheritancemodel);
    	count = 0;
    	
    	String Lines[] = code.split("\\r?\\n");
    	for(String line : Lines) {
    		//direct inheritance
    		Pattern directInheritancePattern = Pattern.compile(INHERITANCE_CLASS);
    		Matcher directInheritanceMatcher = directInheritancePattern.matcher(line);
    		while(directInheritanceMatcher.find()) {
    			if(isUserDefindClass(directInheritanceMatcher.group().split(" ")[2])) {
    				no_di++;
    			}
    			
    			no_ini += getIndirectInheritance(directInheritanceMatcher.group().split(" ")[2]);
    		}
    		
    		//find class name
    		Pattern classNamePattern = Pattern.compile(FIND_CLASS);
    		Matcher classNameMatcher = classNamePattern.matcher(line);
    		if(classNameMatcher.find()) {
    			classname = classNameMatcher.group().replaceFirst("class ", ""); 
    		}
    		
    		tot_in = no_di + no_ini;
    		
    		if(tot_in == 1) {
    			ci = inheritone;
    		} else if(tot_in == 2) {
    			ci = inherittwo;
    		}else if(tot_in == 3) {
    			ci = inheritthree;
    		}else if(tot_in > 3) {
    			ci = inheritmore;
    		}else {
    			ci = inheritnon;
    		}
    		
    		count ++;
    		Inheritance obj = new Inheritance(count,classname,no_di,no_ini,tot_in,ci);
    		inheritancemodel.add(obj);
    		reset();
    	}
    	return inheritancemodel;
    	
    	
    }
    
    
    private void loadDatatoList(String fileListPath) {
    	String Lines[] = code.split("\\r?\\n");
    	for(String line : Lines) {
    		Pattern nodePattern = Pattern.compile(INHERITANCE_CLASS);
    		Matcher nodeMatcher = nodePattern.matcher(line);
    		if(nodeMatcher.find()) {
    			InheritanceNode obj = new InheritanceNode();
    			
    			obj.setClassname(nodeMatcher.group().split(" ")[0]);
    			obj.setSuperclass(nodeMatcher.group().split(" ")[2]);
    			obj.setChildclass("");
    			
    			nodeList.add(obj);
    		}
    		
    		Pattern classNamePattern = Pattern.compile(FIND_CLASS);
    		Matcher classNameMatcher = classNamePattern.matcher(line);
    		if(classNameMatcher.find()) {
    			classList.add(classNameMatcher.group().replaceFirst("class ", ""));
    		}
    	}
    }
    
    private boolean isUserDefindClass(String classname) {
    	for(int i = 0; i < classList.size(); i++) {
    		if(classList.get(i).equals(classname)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private int getIndirectInheritance(String classname) {
    	int indirectInheritanceLevel = 0;
    	for(int i = 0; i < nodeList.size();i++) {
    		if(nodeList.get(i).getClassname().equals(classname)) {
    			if(isUserDefindClass(nodeList.get(i).getSuperclass())) {
    				indirectInheritanceLevel++;
    				
    				getIndirectInheritance(nodeList.get(i).getSuperclass());
    			}
    		}
    	}
    	
    	return indirectInheritanceLevel;
    }
	

}
