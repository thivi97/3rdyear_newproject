package com.model;

import com.model.CheckInsideBrackets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mac
 */
public class CountConditions {
     private final String code;
    private final String split;
    private final int increment;

    public CountConditions(String code, String split, int increment) {

        this.code = code; 
        this.split = split; 
        this.increment = increment; 
    }

    public int getCount() {

        int count = 0; 

        String[] words = code.split(split); 

        
        for (int i = 0; i < words.length; i++) {

            words[i] = words[i] + "zzz"; 

         
            if (words[i].charAt(0) == '(' || words[i].charAt(1) == '(') {
                count = count + increment; 

                
                CheckInsideBrackets brackets = new CheckInsideBrackets(words[i]);
                String get = brackets.getRound();

                
                for (int j = 0; j < get.length() - 1; j++) {
                   
                    if ((get.charAt(j) == '&' && get.charAt(j + 1) != '&') || (get.charAt(j) == '|' && get.charAt(j + 1) != '|')) {
                        count = count + increment;
                    }

                    
                    if ((get.charAt(j) == '&' && get.charAt(j + 1) == '&') || (get.charAt(j) == '|' && get.charAt(j + 1) == '|')) {
                        count = count + increment;
                    }

                    
                    if ((get.charAt(j) == '&' && get.charAt(j + 1) == '&') || (get.charAt(j) == '|' && get.charAt(j + 1) == '|')) {
                        j++;
                    }
                }
            }
        }
        return count; 
    }

    public int getCountForCatch() {
        int count = 0; 

        String[] words = code.split(split); 

        
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i] + "zzz"; 

           
            if (words[i].charAt(0) == '(' || words[i].charAt(1) == '(') {
                count = count + increment; 
            }
        }

        return count;
    }
}
