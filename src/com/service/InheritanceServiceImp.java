package com.service;

import java.util.ArrayList;

import com.model.CustomFile;
import com.model.Line;
import com.model.Inherit;

public class InheritanceServiceImp implements InheritanceService {

	public boolean isDirectInheritance(Line line) {
		if(line.getLineContent().contains("class") || line.getLineContent().contains("extends")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isIndirectInheritance(Line line) {
		if(line.getLineContent().contains("toString")) {
			return true;
		}else {
			return false;
		}
	}
	
	public void getDirectInheritanceList(CustomFile file) {
		ArrayList<Line> DirectInheritanceSet;
		DirectInheritanceSet = new ArrayList<Line>();
		
		
		for(Line line: file.getLineSet()) {
			if(line.getLineContent().contains("class") && (line.getLineContent().contains("extends"))) {
				DirectInheritanceSet.add(new Line(line.getLineNumber()));
			}
		}
		file.getInheritance().setDirectInheritanceSet(DirectInheritanceSet);
	}
	
	
	public void getIndirectInheritanceList(CustomFile file) {
		ArrayList<Line> IndirectInheritanceSet;
		IndirectInheritanceSet = new ArrayList<Line>();
		
		for(Line line : file.getLineSet()) {
			if(line.getLineContent().contains("toString")) {
				IndirectInheritanceSet.add(new Line(line.getLineNumber()));
			}
		}
		
		file.getInheritance().setIndirectInheritanceSet(IndirectInheritanceSet);
	}
	
	public void process1(CustomFile file) {
		 getDirectInheritanceList(file);
		 getIndirectInheritanceList(file);
		 
		 file.getInheritance().setNdi(0);
		 file.getInheritance().setNidi(0);
	}
	
	public void process2() {
		
		for(CustomFile file : fileList) {
			 getDirectInheritanceList(file);
			 getIndirectInheritanceList(file);
		}
		
		
	}
}
