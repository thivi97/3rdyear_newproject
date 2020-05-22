package com.model;

import java.util.ArrayList;

public class Coupling {

	private String fileName;
	
	public static int[] weights = new int[13];

	private LineCoupling line;
	private int[] lineWeight = new int[14];
	private int Nr;
	private int Nmcms;
	private int Nmcmd;
	private int Nmcrms;
	private int Nmcrmd;
	private int Nrmcrms;
	private int Nrmcrmd;
	private int Nrmcms;
	private int Nrmcmd;
	private int Nmrgvs;
	private int Nmrgvd;
	private int Nrmrgvs;
	private int Nrmrgvd;
	
	private int totr;
	private int totmcms;
	private int totmcmd;
	private int totmcrms;
	private int totmcrmd;
	private int totrmcrms;
	private int totrmcrmd;
	private int totrmcms;
	private int totrmcmd;
	private int totmrgvs;
	private int totmrgvd;
	private int totrmrgvs;
	private int totrmrgvd;
	private int[] sum;
	private int finalValue;
	
	private ArrayList<LineCoupling> classList;
	private ArrayList<LineCoupling> classObjectList;
	private ArrayList<LineCoupling> classObjectList_DF;
	private ArrayList<LineCoupling> MethodList;
	private ArrayList<LineCoupling> methodSetFull;
	private ArrayList<LineCoupling> calledMethodList;
	private ArrayList<LineCoupling> calledMethodList_DF;
	private ArrayList<LineCoupling> globalVariableSet;
	private ArrayList<LineCoupling> globalVariableListInReg;
	private ArrayList<LineCoupling> globalVariableListInRec;
	private ArrayList<LineCoupling> regularMethods;
	private ArrayList<LineCoupling> systemMethods;
	private ArrayList<LineCoupling> recursiveMethods;
	private ArrayList<LineCoupling> recursiveMethodCalls;
	private ArrayList<LineCoupling> regularInRegularMethods;
	private ArrayList<LineCoupling> recursiveInRegularMethods;
	private ArrayList<LineCoupling> recursiveInRecursiveMethods;
	private ArrayList<LineCoupling> regularInRecursiveMethods;

	private ArrayList<LineCoupling> objectList;
	private ArrayList<LineCoupling> inReg_DF;
	private ArrayList<LineCoupling> inRec_DF;
	private ArrayList<LineCoupling> regularInRegularMethods_DF;
	private ArrayList<LineCoupling> recursiveInRegularMethods_DF;
	private ArrayList<LineCoupling> recursiveInRecursiveMethods_DF;
	private ArrayList<LineCoupling> regularInRecursiveMethods_DF;
	private ArrayList<LineCoupling> globalVariableList_DF;
	private ArrayList<LineCoupling> globalVariableListInReg_DF;
	private ArrayList<LineCoupling> globalVariableListInRec_DF;

	public Coupling(String fileName) {
		this.setFileName(fileName);
		this.MethodList = null;
		this.calledMethodList = null;
		this.regularMethods = null;
		this.recursiveMethods = null;
		this.regularInRegularMethods = null;
		this.methodSetFull = null;
		this.sum = new int[13];

		if(!(weights[0] > 0)) {
			setDefaultWeights();
		}
	}
	
	public static void setDefaultWeights() {
		weights[0] = 2;
		weights[1] = 2;
		weights[2] = 3;
		weights[3] = 3;
		weights[4] = 4;
		weights[5] = 4;
		weights[6] = 5;
		weights[7] = 3;
		weights[8] = 4;
		weights[9] = 1;
		weights[10] = 2;
		weights[11] = 1;
		weights[12] = 2;
				
	}

	
	public static void setCustomWeights(int Wr, int Wmcms, int Wmcmd, int Wmcrms, int Wmcrmd, int Wrmcrms, int Wrmcrmd, int Wrmcms, int Wrmcmd, int Wmrgvs, int Wmrgvd, int Wrmrgvs, int Wrmrgvd) {
		weights[0] = Wr;
		weights[1] = Wmcms;
		weights[2] = Wmcmd;
		weights[3] = Wmcrms;
		weights[4] = Wmcrmd;
		weights[5] = Wrmcrms;
		weights[6] = Wrmcrmd;
		weights[7] = Wrmcms;
		weights[8] = Wrmcmd;
		weights[9] = Wmrgvs;
		weights[10] = Wmrgvd;
		weights[11] = Wrmrgvs;
		weights[12] = Wrmrgvd;
				
	}

	public LineCoupling getLine() {
		return line;
	}

	public int[] getLineWeight() {
		return lineWeight;
	}

	public void setLine(LineCoupling line) {
		this.line = line;
	}

	public void setLineWeight(int[] lineWeight) {
		this.lineWeight = lineWeight;
	}

	public static int[] getWeights() {
		return weights;
	}

	public static void setWeights(int[] weights) {
		Coupling.weights = weights;
	}

	public int getNr() {
		return Nr;
	}

	public void setNr(int nr) {
		Nr = nr;
	}

	public int getNmcms() {
		return Nmcms;
	}

	public void setNmcms(int nmcms) {
		Nmcms = nmcms;
	}

	public int getNmcmd() {
		return Nmcmd;
	}

	public void setNmcmd(int nmcmd) {
		Nmcmd = nmcmd;
	}

	public int getNmcrms() {
		return Nmcrms;
	}

	public void setNmcrms(int nmcrms) {
		Nmcrms = nmcrms;
	}

	public int getNmcrmd() {
		return Nmcrmd;
	}

	public void setNmcrmd(int nmcrmd) {
		Nmcrmd = nmcrmd;
	}

	public int getNrmcrms() {
		return Nrmcrms;
	}

	public void setNrmcrms(int nrmcrms) {
		Nrmcrms = nrmcrms;
	}

	public int getNrmcrmd() {
		return Nrmcrmd;
	}

	public void setNrmcrmd(int nrmcrmd) {
		Nrmcrmd = nrmcrmd;
	}

	public int getNrmcms() {
		return Nrmcms;
	}

	public void setNrmcms(int nrmcms) {
		Nrmcms = nrmcms;
	}

	public int getNrmcmd() {
		return Nrmcmd;
	}

	public void setNrmcmd(int nrmcmd) {
		Nrmcmd = nrmcmd;
	}

	public int getNmrgvs() {
		return Nmrgvs;
	}

	public void setNmrgvs(int nmrgvs) {
		Nmrgvs = nmrgvs;
	}

	public int getNmrgvd() {
		return Nmrgvd;
	}

	public void setNmrgvd(int nmrgvd) {
		Nmrgvd = nmrgvd;
	}

	public int getNrmrgvs() {
		return Nrmrgvs;
	}

	public void setNrmrgvs(int nrmrgvs) {
		Nrmrgvs = nrmrgvs;
	}

	public int getNrmrgvd() {
		return Nrmrgvd;
	}

	public void setNrmrgvd(int nrmrgvd) {
		Nrmrgvd = nrmrgvd;
	}

	public int getTotr() {
		return totr;
	}

	public void setTotr(int totr) {
		this.totr = totr;
	}

	public int getTotmcms() {
		return totmcms;
	}

	public void setTotmcms(int totmcms) {
		this.totmcms = totmcms;
	}

	public int getTotmcmd() {
		return totmcmd;
	}

	public void setTotmcmd(int totmcmd) {
		this.totmcmd = totmcmd;
	}

	public int getTotmcrms() {
		return totmcrms;
	}

	public void setTotmcrms(int totmcrms) {
		this.totmcrms = totmcrms;
	}

	public int getTotmcrmd() {
		return totmcrmd;
	}

	public void setTotmcrmd(int totmcrmd) {
		this.totmcrmd = totmcrmd;
	}

	public int getTotrmcrms() {
		return totrmcrms;
	}

	public void setTotrmcrms(int totrmcrms) {
		this.totrmcrms = totrmcrms;
	}

	public int getTotrmcrmd() {
		return totrmcrmd;
	}

	public void setTotrmcrmd(int totrmcrmd) {
		this.totrmcrmd = totrmcrmd;
	}

	public int getTotrmcms() {
		return totrmcms;
	}

	public void setTotrmcms(int totrmcms) {
		this.totrmcms = totrmcms;
	}

	public int getTotrmcmd() {
		return totrmcmd;
	}

	public void setTotrmcmd(int totrmcmd) {
		this.totrmcmd = totrmcmd;
	}

	public int getTotmrgvs() {
		return totmrgvs;
	}

	public void setTotmrgvs(int totmrgvs) {
		this.totmrgvs = totmrgvs;
	}

	public int getTotmrgvd() {
		return totmrgvd;
	}

	public void setTotmrgvd(int totmrgvd) {
		this.totmrgvd = totmrgvd;
	}

	public int getTotrmrgvs() {
		return totrmrgvs;
	}

	public void setTotrmrgvs(int totrmrgvs) {
		this.totrmrgvs = totrmrgvs;
	}

	public int getTotrmrgvd() {
		return totrmrgvd;
	}

	public void setTotrmrgvd(int totrmrgvd) {
		this.totrmrgvd = totrmrgvd;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<LineCoupling> getClassList() {
		return classList;
	}

	public void setClassList(ArrayList<LineCoupling> classList) {
		this.classList = classList;
	}

	public ArrayList<LineCoupling> getClassObjectList() {
		return classObjectList;
	}

	public void setClassObjectList(ArrayList<LineCoupling> classObjectList) {
		this.classObjectList = classObjectList;
	}

	public ArrayList<LineCoupling> getClassObjectList_DF() {
		return classObjectList_DF;
	}

	public void setClassObjectList_DF(ArrayList<LineCoupling> classObjectList_DF) {
		this.classObjectList_DF = classObjectList_DF;
	}

	public void setEndLineNumber(int lineNumber, int number) {
		this.MethodList.get(lineNumber).setEndLineNumber(number);
	}

	public void setMethodList(ArrayList<LineCoupling> methodList) {
		this.MethodList = new ArrayList<LineCoupling>(methodList);
	}

	public void setCalledMethodList(ArrayList<LineCoupling> calledMethodList) {
		this.calledMethodList = new ArrayList<LineCoupling>(calledMethodList);
	}

	public ArrayList<LineCoupling> getGlobalVariableSet() {
		return globalVariableSet;
	}

	public void setGlobalVariableSet(ArrayList<LineCoupling> globalVariableSet) {
		this.globalVariableSet = globalVariableSet;
	}

	public ArrayList<LineCoupling> getGlobalVariableListInReg() {
		return globalVariableListInReg;
	}

	public void setGlobalVariableListInReg(ArrayList<LineCoupling> globalVariableList) {
		this.globalVariableListInReg = globalVariableList;
	}

	public ArrayList<LineCoupling> getGlobalVariableListInRec() {
		return globalVariableListInRec;
	}

	public void setGlobalVariableListInRec(ArrayList<LineCoupling> globalVariableListInRec) {
		this.globalVariableListInRec = globalVariableListInRec;
	}

	public ArrayList<LineCoupling> getSystemMethods() {
		return systemMethods;
	}

	public void setSystemMethods(ArrayList<LineCoupling> systemMethods) {
		this.systemMethods = systemMethods;
	}

	public void setRegularMethods(ArrayList<LineCoupling> regularMethods) {
		this.regularMethods = new ArrayList<LineCoupling>(regularMethods);
	}

	public void setRecursiveMethods(ArrayList<LineCoupling> recursiveMethods) {
		this.recursiveMethods = new ArrayList<LineCoupling>(recursiveMethods);
	}

	public void setRecursiveMethodCalls(ArrayList<LineCoupling> recursiveMethodCalls) {
		this.recursiveMethodCalls = recursiveMethodCalls;
	}

	public void setRegularInRegularMethods(ArrayList<LineCoupling> regularToRegularMethods) {
		this.regularInRegularMethods = new ArrayList<LineCoupling>(regularToRegularMethods);
	}

	public void setRecursiveInRegularMethods(ArrayList<LineCoupling> recursiveInRegularMethods) {
		this.recursiveInRegularMethods = recursiveInRegularMethods;
	}

	public ArrayList<LineCoupling> getMethodList() {
		return MethodList;
	}

	public ArrayList<LineCoupling> getCalledMethodList() {
		return calledMethodList;
	}

	public ArrayList<LineCoupling> getRegularMethods() {
		return regularMethods;
	}

	public ArrayList<LineCoupling> getRecursiveMethods() {
		return recursiveMethods;
	}

	public ArrayList<LineCoupling> getRecursiveMethodCalls() {
		return recursiveMethodCalls;
	}

	public ArrayList<LineCoupling> getRegularInRegularMethods() {
		return regularInRegularMethods;
	}

	public ArrayList<LineCoupling> getRecursiveInRegularMethods() {
		return recursiveInRegularMethods;
	}

	public ArrayList<LineCoupling> getMethodSetFull() {
		return methodSetFull;
	}

	public void setMethodSetFull(ArrayList<LineCoupling> methodSetFull) {
		this.methodSetFull = methodSetFull;
	}

	public ArrayList<LineCoupling> getRecursiveInRecursiveMethods() {
		return recursiveInRecursiveMethods;
	}

	public void setRecursiveInRecursiveMethods(ArrayList<LineCoupling> recursiveInRecursiveMethods) {
		this.recursiveInRecursiveMethods = recursiveInRecursiveMethods;
	}

	public ArrayList<LineCoupling> getRegularInRecursiveMethods() {
		return regularInRecursiveMethods;
	}

	public void setRegularInRecursiveMethods(ArrayList<LineCoupling> regularInRecursiveMethods) {
		this.regularInRecursiveMethods = regularInRecursiveMethods;
	}

	public ArrayList<LineCoupling> getCalledMethodList_DF() {
		return calledMethodList_DF;
	}

	public void setCalledMethodList_DF(ArrayList<LineCoupling> calledMethodList_DF) {
		this.calledMethodList_DF = calledMethodList_DF;
	}

	public ArrayList<LineCoupling> getRegularInRegularMethods_DF() {
		return regularInRegularMethods_DF;
	}

	public void setRegularInRegularMethods_DF(ArrayList<LineCoupling> regularInRegularMethods_DF) {
		this.regularInRegularMethods_DF = regularInRegularMethods_DF;
	}

	public ArrayList<LineCoupling> getRecursiveInRegularMethods_DF() {
		return recursiveInRegularMethods_DF;
	}

	public void setRecursiveInRegularMethods_DF(ArrayList<LineCoupling> recursiveInRegularMethods_DF) {
		this.recursiveInRegularMethods_DF = recursiveInRegularMethods_DF;
	}

	public ArrayList<LineCoupling> getRecursiveInRecursiveMethods_DF() {
		return recursiveInRecursiveMethods_DF;
	}

	public void setRecursiveInRecursiveMethods_DF(ArrayList<LineCoupling> recursiveInRecursiveMethods_DF) {
		this.recursiveInRecursiveMethods_DF = recursiveInRecursiveMethods_DF;
	}

	public ArrayList<LineCoupling> getRegularInRecursiveMethods_DF() {
		return regularInRecursiveMethods_DF;
	}

	public void setRegularInRecursiveMethods_DF(ArrayList<LineCoupling> regularInRecursiveMethods_DF) {
		this.regularInRecursiveMethods_DF = regularInRecursiveMethods_DF;
	}

	public ArrayList<LineCoupling> getObjectList() {
		return objectList;
	}

	public void setObjectList(ArrayList<LineCoupling> objectList) {
		this.objectList = objectList;
	}

	public ArrayList<LineCoupling> getInReg_DF() {
		return inReg_DF;
	}

	public void setInReg_DF(ArrayList<LineCoupling> inReg_DF) {
		this.inReg_DF = inReg_DF;
	}

	public ArrayList<LineCoupling> getInRec_DF() {
		return inRec_DF;
	}

	public void setInRec_DF(ArrayList<LineCoupling> inRec_DF) {
		this.inRec_DF = inRec_DF;
	}

	public ArrayList<LineCoupling> getGlobalVariableList_DF() {
		return globalVariableList_DF;
	}

	public void setGlobalVariableList_DF(ArrayList<LineCoupling> globalVariableList_DF) {
		this.globalVariableList_DF = globalVariableList_DF;
	}

	public ArrayList<LineCoupling> getGlobalVariableListInReg_DF() {
		return globalVariableListInReg_DF;
	}

	public void setGlobalVariableListInReg_DF(ArrayList<LineCoupling> globalVariableListInReg_DF) {
		this.globalVariableListInReg_DF = globalVariableListInReg_DF;
	}

	public ArrayList<LineCoupling> getGlobalVariableListInRec_DF() {
		return globalVariableListInRec_DF;
	}

	public void setGlobalVariableListInRec_DF(ArrayList<LineCoupling> globalVariableListInRec_DF) {
		this.globalVariableListInRec_DF = globalVariableListInRec_DF;
	}
	
	//calculation
	public void setFinalValue() {
		
		totr = weights[0] * Nr;
		setTotr(totr);
		totmcms = weights[1] * Nmcms;
		setTotmcms(totmcms);
		totmcmd = weights[2] * Nmcmd;
		setTotmcmd(totmcmd);
		totmcrms = weights[3] * Nmcrms;
		setTotmcrms(totmcrms);
		totmcrmd = weights[4] * Nmcrmd;
		setTotmcrmd(totmcrmd);
		totrmcrms = weights[5] * Nrmcrms;
		setTotrmcrms(totrmcrms);
		totrmcrmd = weights[6] * Nrmcrmd;
		setTotrmcrmd(totrmcrmd);
		totrmcms = weights[7] * Nrmcms;
		setTotrmcms(totrmcms);
		totrmcmd = weights[8] * Nrmcmd;
		setTotrmcmd(totrmcmd);
		totmrgvs = weights[9] * Nmrgvs;
		setTotmrgvs(totmrgvs);
		totmrgvd = weights[10] * Nmrgvd;
		setTotmrgvd(totmrgvd);
		totrmrgvs = weights[11] * Nrmrgvs;
		setTotmrgvs(totmrgvs);
		totrmrgvd = weights[12] * Nrmrgvd;
		setTotrmrgvd(totrmrgvd);
		
		finalValue = totr + totmcms + totmcmd + totmcrms + totmcrmd + totrmcrms + totrmcrmd
				 + totrmcms + totrmcmd + totmrgvs + totmrgvd + totrmrgvs + totrmrgvd;

	}

	public int getFinalValue() {
		return finalValue;
	}
	
	public void setSum(int[] sum) {
		this.sum = sum;
	}
	
	public int[] getSum() {
		return this.sum;
	}
}
