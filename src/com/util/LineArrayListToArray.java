package com.util;

import java.util.ArrayList;

import com.model.LineCoupling;

public class LineArrayListToArray {
	
	public static LineCoupling[] convert(ArrayList<LineCoupling> list) {
		LineCoupling[] newList = new LineCoupling[list.size()];
		
		for(int i = 0; i < list.size(); ++i) {
			newList[i] = list.get(i);
		}
		
		return newList;	
	}
	
}
