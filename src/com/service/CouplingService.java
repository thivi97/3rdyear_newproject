package com.service;
import java.util.ArrayList;

import com.model.CustomFileCoupling;
import com.model.LineCoupling;

public interface CouplingService {

	public String getMethodName(String line);
	public void getClassNames(CustomFileCoupling file);
	public void getObjectSet(CustomFileCoupling file);
	public void setEndLineNumber(CustomFileCoupling file);
	public int getEndLineNumber(CustomFileCoupling file, LineCoupling line);
	public void getMethodSet(CustomFileCoupling file);
	public void getCalledMethodSet_DF(CustomFileCoupling ifile);
	public void getGlobalVariableSet(CustomFileCoupling file);
	public void getGlobalVariableListInReg(CustomFileCoupling file);
	public void getGlobalVariableListInRec(CustomFileCoupling file);
	public void getSystemMethods(CustomFileCoupling file);
	
	public void getRecursiveMethods(CustomFileCoupling file);
	public void getRegularMethods(CustomFileCoupling file);
	public void getRegInReg(CustomFileCoupling file);
	public void getRecInReg(CustomFileCoupling file);
	public void getRecInRec(CustomFileCoupling file);
	public void getRegInRec(CustomFileCoupling file);
	
	public void getObjectSet_DF(CustomFileCoupling ifile);
	public void getSystemMethods_DF(CustomFileCoupling ifile);
	public void getMethods_DF();
	public void getRegInReg_DF();
	public void getRecInReg_DF();
	public void getRecInRec_DF();
	public void getRegInRec_DF();
	public void getGlobalVariableList_DF(CustomFileCoupling ifile);
	public void getGlobalVariableListInReg_DF();
	public void getGlobalVariableListInRec_DF();
	
	public void process1(CustomFileCoupling file);
	public void process2();

}
