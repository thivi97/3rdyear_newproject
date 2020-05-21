package com.model;

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

import com.service.InheritanceModel;
public class Inheritance {
		
		    private int count = 0;
		    private String className = "";
		    private int No_of_direct_inheritances = 0;
		    private int No_of_indirect_inheritances = 0;
		    private int Total_inheritances = 0;
		    private int Ci = 0;

		    private int inheritNon = 0;
		    private int inheritOne = 1;
		    private int inheritTwo = 2;
		    private int inheritThree = 3;
		    private int inheritMore = 4;
		    
		    private String code ;
		   

		    //REGEX PATTERNS
		    private String INHERITANCE_CLASS = "\\w*\\sextends\\s\\w*";
		    private String INHERITANCE_INTERFACE = "implements|,";
		    private String FIND_INHERITANCE_INTERFACE = "implements[\\s\\w*,]*";
		    private String FIND_CLASS = "class\\s\\w*";

		    List<InheritanceNode> nodeList = new ArrayList<InheritanceNode>();

		    List<String> classList = new ArrayList<String>();

		    List<InheritanceModel> inheritanceModelList = new ArrayList<InheritanceModel>();

		    public Inheritance() {
		    }
		    private static final Inheritance obj = new Inheritance();

		    public static Inheritance getInstance() {
		        return obj;
		    }
		    public void setCode(String code) {
		    	this.code = code;
		    }
		    private void reset() {
		        className = "";
		        No_of_direct_inheritances = 0;
		        No_of_indirect_inheritances = 0;
		        Total_inheritances = 0;
		        Ci = 0;
		    }

		    public int[] getWeights() {
		        int weights[] = {inheritNon, inheritOne, inheritTwo, inheritThree, inheritMore};
		        return weights;
		    }

		    public void setWeights(int inheritNon, int inheritOne, int inheritTwo, int inheritThree, int inheritMore) {
		        this.inheritNon = inheritNon;
		        this.inheritOne = inheritOne;
		        this.inheritTwo = inheritTwo;
		        this.inheritThree = inheritThree;
		        this.inheritMore = inheritMore;
		    }

		    public List<InheritanceModel> getComplexity() {
		        loadDatatoList(code);
		        inheritanceModelList.removeAll(inheritanceModelList);
		        count = 0;
		        String Lines[] = code.split("\\r?\\n");
		       
		        for (String line : Lines) {
		            //direct inheritance
		            Pattern directInheritancePattern = Pattern.compile(INHERITANCE_CLASS);
		            Matcher directInheritanceMatcher = directInheritancePattern.matcher(line);
		            while (directInheritanceMatcher.find()) {

		                if (isUserDefindClass(directInheritanceMatcher.group().split(" ")[2])) {
		                    No_of_direct_inheritances++;
		                }
		                //indirect inheritance
		                No_of_indirect_inheritances += getIndirectInheritance(directInheritanceMatcher.group().split(" ")[2]);

		            }

		            //find class name
		            Pattern classNamePattern = Pattern.compile(FIND_CLASS);
		            Matcher classNameMatcher = classNamePattern.matcher(line);
		            if (classNameMatcher.find()) {
		                className = classNameMatcher.group().replaceFirst("class ", "");
		            }

		            Total_inheritances = No_of_direct_inheritances + No_of_indirect_inheritances;

		            if (Total_inheritances == 1) {
		                Ci = inheritOne;
		            } else if (Total_inheritances == 2) {
		                Ci = inheritTwo;
		            } else if (Total_inheritances == 3) {
		                Ci = inheritThree;
		            } else if (Total_inheritances > 3) {
		                Ci = inheritMore;
		            } else {
		                Ci = inheritNon;
		            }

		            count++;
		            InheritanceModel obj = new InheritanceModel(count, className, No_of_direct_inheritances, No_of_indirect_inheritances, Total_inheritances, Ci);
		            inheritanceModelList.add(obj);
		            reset();
		        }

		        return inheritanceModelList;
		    }

		    private void loadDatatoList(String fileListPath) {

		        
		    	String Lines[] = code.split("\\r?\\n");
		            for (String line : Lines) {

		                //create node
		                Pattern nodePattern = Pattern.compile(INHERITANCE_CLASS);
		                Matcher nodeMatcher = nodePattern.matcher(line);
		                if (nodeMatcher.find()) {
		                	InheritanceNode obj = new InheritanceNode();
		                    obj.setClassName(nodeMatcher.group().split(" ")[0]);
		                    obj.setSuperClass(nodeMatcher.group().split(" ")[2]);
		                    obj.setChildClass("");

		                    nodeList.add(obj);
		                }

		                //find class name
		                Pattern classNamePattern = Pattern.compile(FIND_CLASS);
		                Matcher classNameMatcher = classNamePattern.matcher(line);
		                if (classNameMatcher.find()) {
		                    classList.add(classNameMatcher.group().replaceFirst("class ", ""));
		                }
		            }
		        }
		    

		    private boolean isUserDefindClass(String className) {

		        for (int i = 0; i < classList.size(); i++) {
		            if (classList.get(i).equals(className)) {
		                return true;
		            }
		        }
		        return false;
		    }

		    private int getIndirectInheritance(String className) {
		        int indirectInheritanceLevel = 0;
		        for (int i = 0; i < nodeList.size(); i++) {
		            if (nodeList.get(i).getClassName().equals(className)) {
		                if (isUserDefindClass(nodeList.get(i).getSuperClass())) {
		                    indirectInheritanceLevel++;
		                    getIndirectInheritance(nodeList.get(i).getSuperClass());
		                }
		            }
		        }

		        return indirectInheritanceLevel;
		    }
		   
		  
		
	

}
