package com.service;
import java.util.ArrayList;

import com.model.CustomFile;
import com.model.Line;

public interface InheritanceService {

	boolean isDirectInheritance(Line line);
	boolean isIndirectInheritance(Line line);
	
	void getDirectInheritanceList(CustomFile file);
	void getIndirectInheritanceList(CustomFile file);
	
	void process1(CustomFile file);
	void process2(ArrayList<CustomFile> fileList);
	void process3(ArrayList<CustomFile> fileList);
	
}
