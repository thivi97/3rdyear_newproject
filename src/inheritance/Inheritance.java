package inheritance;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inheritance {

	String keyword1 = "extends";
	String keyword2 = "implements";
	
	ArrayList<String> line;
	ArrayList<Integer> key;
	
	public Inheritance(ArrayList<String> lines) {
		this.line = lines;
		key = new ArrayList<Integer>(lines.size());
	}
	
	public int extendsKey(String line) {
		Pattern p = Pattern.compile(keyword1);
		Matcher m = p.matcher(line);
		
		int extendsKey = 0;
		while(m.find()) {
			extendsKey++;
		}
		
		return extendsKey;
		
	}
	
	public int implementsKey(String line) {
		Pattern p = Pattern.compile(keyword2);
		Matcher m = p.matcher(line);
		
		int implementsKey = 0;
		if(m.find()) {
			implementsKey = implementsKey + 2;
		}
		
		return implementsKey;
	}
	
	
	public void calc() {
		int i;
		for(i = 0; i < line.size();i++) {
			int extendsKeys = extendsKey(line.get(i));
			int implementsKeys = implementsKey(line.get(i));
			
			key.add(extendsKeys + implementsKeys);
		}
	}
	
	public ArrayList<Integer> inheritkeyline(){
		calc();
		return key;
				
	}
	
	public int tot() {
		int total = 0;
		int i;
		for(i = 0; i < key.size();i++) {
			total = total + key.get(i);
		}
		
		return total;
	}
	
	
	
	
}
