package com.service;
import com.model.CustomFile;
import com.model.Line;

public interface InheritanceService {

	boolean isDirectInheritance(Line line);
	boolean isIndirectInheritance(Line line);
	
	void getDirectInheritanceList(CustomFile file);
	void getIndirectInheritanceList(CustomFile file);
	
	void process1(CustomFile file);
	void process2();
	
}
