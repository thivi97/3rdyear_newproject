package com.util;

public class Line {
	
	public static String getLine(String line) {
		String lines = line;
		
		if(line.contains("//")) {
			if(lines.contains("public class"))
				lines = lines.replace("public class", "class");
			
			String comment = lines.substring(lines.indexOf("/", 0),lines.length());
			
			lines = lines.replace(comment,"");
			
		}
		return lines;
	}
	
	public static String getLineForKeyword(String line) {
		String lines = line;
		
		if(line.contains("//")) {
			String comment = lines.substring(lines.indexOf("/",0), lines.length());
			
			lines = lines.replace(comment, "");
		}
		
		return lines;
	}
	

	public static String getRidOfQuotes(String line) {
		String newLine = line;
		String news = "";
		
		try {
			int flag = 0;
			for(int i = 0;i<newLine.length();i++) {
				if((newLine.charAt(i)+ "").matches("[\"]")) {
					++flag;
				}
				
				if(flag%2 == 0)
					news += newLine.charAt(i);
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		String newestLine = news.replaceAll("[\"]", "").trim();
		
		return newestLine;
	}

}
