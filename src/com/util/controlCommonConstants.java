/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAC
 */
public class controlCommonConstants {
    
       private List<String> controlStructures = new ArrayList<>();
	
    
        public List<String> getControlStructures(){
		controlStructures.add("if");
		controlStructures.add("switch");
		controlStructures.add("case");
		controlStructures.add("for");
		controlStructures.add("while");
		controlStructures.add("do");
		controlStructures.add("else");
		return controlStructures;
	}

    
    
    
    
        private static final String MATCH_KEYWORD_IF = "if[(]|if\\s[(]*?";
	private static final String MATCH_KEYWORD_FOR = "for[(]|for\\s[(]*?";
	private static final String MATCH_KEYWORD_WHILE = "while[(]|while\\s[(]*?";
	private static final String MATCH_KEYWORD_CATCH = "catch[(]|catch\\s[(]*?";
	public static final String MATCH_KEYWORD_SWITCH = "switch[(]|switch\\s[(]*?";
	public static final String MATCH_KEYWORD_CASE = "case\\s";
	private static final String MATCH_ELSE = "else.*?";
	private static final String MATCH_RIGHT_CURLY_BRACKET = "[}]";

	private static final String MATCH_DOUBLE_OR = "[|][|]";
	private static final String MATCH_DOUBLE_AND = "\\&&\\s";
	private static final String MATCH_OR = "[|]";
	private static final String MATCH_AND = "\\&\\s";

	public static final String MATCH_CONTROL_STRUCTURE_TYPE_IF = MATCH_KEYWORD_IF;

	public static final String MATCH_CONTROL_STRUCTURE_TYPE_CATCH = MATCH_KEYWORD_CATCH;

	public static final String MATCH_CONTROL_STRUCTURE_TYPE_LOOP = MATCH_KEYWORD_FOR + "|" + MATCH_KEYWORD_WHILE;

	public static final String MATCH_CONTROL_STRUCTURE_TYPE_BREAKS = MATCH_DOUBLE_OR + "|" + MATCH_DOUBLE_AND + "|"
			+ MATCH_OR + "|" + MATCH_AND;

	// =================== Constants related to nesting control structures =============================//
	public static final String MATCH_NESTING_CONTROL_STRUCTURE = MATCH_KEYWORD_IF + "|" + MATCH_KEYWORD_WHILE + "|"
			+ MATCH_KEYWORD_FOR + "|" + MATCH_ELSE + "|" + MATCH_KEYWORD_SWITCH;

	public static final String MATCH_NESTING_CONTROL_BREAK = MATCH_RIGHT_CURLY_BRACKET;

	public static final String MATCH_NESTING_CONTROL_ELSE = MATCH_ELSE;

	public static final String MATCH_NESTING_SINGLE_LINE_COMMENT = "(?<!http:|https:)\\/\\/.*(?<!\\>)$";
	public static final String MATCH_NESTING_MULTI_LINE_COMMENT_BEGIN = "([/][*])+";
	public static final String MATCH_NESTING_MULTI_LINE_COMMENT_END = "(?:.*)([*][/])+";
    
    
}
