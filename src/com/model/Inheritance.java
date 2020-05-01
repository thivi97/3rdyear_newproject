package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.util.Keywords;
import com.util.Line;

public class Inheritance {
	
	static int n = 0;
	static List<String> classNames = new ArrayList<>();
	static List<String> statements = new ArrayList<>();
	static List<Integer> counts = new ArrayList<>();
	static Stack<Character> stack = new Stack<>();
	
	public static void addToClasses(String newLine) {
		String[] words = newLine.split(" ");
		
		for(String word : words) {
			if(word.matches("\\b([A-Za-z][A-Za-z0-9$_]*)\\b") && ! Arrays.asList(Keywords.KEYWORDS).contains(word)) {
				System.out.println("IDENTIFIER :" +word);
				
				if(!classNames.contains(word))
					classNames.add(word);
			}
		}
	}
	
	public static boolean isOutsideClass(String l) {
		String input = l;
		for(Character ch: input.toCharArray()) {
		//	System.out.println(ch);
			if(ch == '{') {
				stack.push('}');
			}
			else if(ch == '[') {
				stack.push(']');
			}
			else if(ch == '(') {
				stack.push(')');
			}
			else {
				if(stack.isEmpty()|| ch != stack.peek()) {
					return false;
				}
				stack.pop();
			}
		}
		
		return stack.isEmpty();
	}
	
	public static int getDI(String line) {
		int count = 0;
		String newLineA = Line.getLine(line);
		String newLine = Line.getRidOfQuotes(newLineA);
		boolean isOutside = isOutsideClass(newLine);
		
		if(newLine.contains("class ")) {
			addToClasses(newLine);
			if(newLine.contains(" extends ")) {
				for(String cls : classNames) {
					if(newLine.contains(" extends " + cls)) {
						++count;
						for(String st : statements) {
							if(st.contains(cls+" extends ")) {
								++count;
							}
						}
					}
					else {
						statements.add(newLine);
					}
				}
			}
		} else if(isOutside && newLine.trim().equals("")) {
			return 0;
		}
		else
			return 0;
		
		counts.add(count);
		System.out.println("Value of counts: " + counts);
		return count;
		
		
	}

}
