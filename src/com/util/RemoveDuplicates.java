package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import com.model.LineCoupling;
 
public class RemoveDuplicates 
{
    public static ArrayList<LineCoupling> initiate(ArrayList<LineCoupling> lineSet) {
 
        LinkedHashSet<LineCoupling> hashSet = new LinkedHashSet<>(lineSet);
         
        ArrayList<LineCoupling> listWithoutDuplicates = new ArrayList<>(hashSet);
         
        return listWithoutDuplicates;
    }
}
