package com.model;

import java.util.ArrayList;

public class Inherit {
	
	private String fileName;
	private Line line;
	private int[] lineweight;
	
	private int Ndi;	//number of direct inheritance
	private int Nidi;	//number of indirect inheritance
	private int Ti;		//number of total inheritance
	private int Ci;		//complexity due to inheritance
	
	
	private ArrayList<Line> DirectInheritanceSet;
	private ArrayList<Line> IndirectInheritanceSet;
	
	
	public Inherit(String fileName) {
		
	}
	
	
	public String getFileName() {
		return fileName;
	}
	
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public Line getLine() {
		return line;
	}
	
	
	public void setLine(Line line) {
		this.line = line;
	}
	
	
	public int[] getLineweight() {
		return lineweight;
	}
	
	
	public void setLineweight(int[] lineweight) {
		this.lineweight = lineweight;
	}
	
	
	
	public int isNdi() {
		return Ndi;
	}
	
	
	public void setNdi(int ndi) {
		Ndi = ndi;
	}
	
	
	public int isNidi() {
		return Nidi;
	}
	
	
	public void setNidi(int nidi) {
		Nidi = nidi;
	}
	
	
	public int getTi() {
		return Ti;
	}
	
	
	public void setTi(int ti) {
		Ti = ti;
		Ti = Nidi + Ndi;
	}
	
	
	public int getCi() {
		return Ci;
	}
	
	
	public void setCi(int ci) {
		Ci = ci;
		if(Ti <= 3) {
			Ti = Ci;
		}else {
			Ci = 4;
		}
	}
	
	
	
	
	public ArrayList<Line> getDirectInheritanceSet() {
		return DirectInheritanceSet;
	}
	
	
	public void setDirectInheritanceSet(ArrayList<Line> directInheritanceSet) {
		DirectInheritanceSet = directInheritanceSet;
	}
	
	
	public ArrayList<Line> getIndirectInheritanceSet() {
		return IndirectInheritanceSet;
	}
	
	
	public void setIndirectInheritanceSet(ArrayList<Line> indirectInheritanceSet) {
		IndirectInheritanceSet = indirectInheritanceSet;
	}
	
	
	
	
	
	

}
