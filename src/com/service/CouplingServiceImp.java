package com.service;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.model.Coupling;
import com.model.CustomFileCoupling;
import com.model.LineCoupling;


public class CouplingServiceImp implements CouplingService {
	
	static ArrayList<CustomFileCoupling> fileList;
	
	//Setting filelist for operations
	public CouplingServiceImp(ArrayList<CustomFileCoupling> fList) {
		fileList = fList;
	}

	//get method name from a line
	@Override
	public String getMethodName(String line) {
		if (line.contains("main") || line.contains("class") || line.contains("if") || line.contains("switch")
				|| line.contains("catch") || line.contains("return") || line.contains(";")) {

		} else if (line.contains("public")) {
			String[] sub = line.split("\\(");
			String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
					.replace("static", "").replace("final", "").trim();
			if (x.split(" ").length > 1) {
				return x.split(" ")[1];
			} else {
				return x;
			}
		}
		return null;
	}

	//get class names in the file
	@Override
	public void getClassNames(CustomFileCoupling file) {
		ArrayList<LineCoupling> classList = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getLineSet()) {

			if (line.getLineContent().contains("class") && line.getLineContent().contains("{")) {
				String[] sub = line.getLineContent().split("\\(");
				String x = sub[0].replace("public", "").replace("class", "").replace("{", "").trim();

				classList.add(new LineCoupling(line.getLineNumber(), x.split(" ")[0]));
			}

		}
		file.getCoupling().setClassList(classList);
	}

	//get objects created in the file
	@Override
	public void getObjectSet(CustomFileCoupling file) {
		ArrayList<LineCoupling> classObjList = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getLineSet()) {

			if (line.getLineContent().contains(" new ")) {
				for (LineCoupling line_class : file.getCoupling().getClassList()) {
					if (line.getLineContent().contains(line_class.getLineContent())) {

						String[] sub = line.getLineContent().split("\\(");
						String x = sub[0].replace(line_class.getLineContent(), "").trim();
						classObjList.add(new LineCoupling(line.getLineNumber(), x.split(" ")[0]));
					}
				}
			}

		}

		file.getCoupling().setClassObjectList(classObjList);
	}

	//get objects created using other filess
	@Override
	public void getObjectSet_DF(CustomFileCoupling ifile) {
		ArrayList<LineCoupling> classObjList_DF = new ArrayList<LineCoupling>();
		for (CustomFileCoupling file : fileList) {

			if (!file.getFileName().equalsIgnoreCase(ifile.getFileName())) {

				for (LineCoupling line : ifile.getLineSet()) {

					for (LineCoupling line_class : file.getCoupling().getClassList()) {

						if (line.getLineContent().contains(" new ")
								&& line.getLineContent().contains(line_class.getLineContent())) {
							String[] sub = line.getLineContent().split("\\(");
							String x = sub[0].replace(line_class.getLineContent(), "").trim();
							classObjList_DF.add(new LineCoupling(line.getLineNumber(), x.split(" ")[0]));
						}

					}

				}

			}
			ifile.getCoupling().setClassObjectList_DF(classObjList_DF);
		}

	}

	//get end line numbers to identify method scope
	@Override
	public int getEndLineNumber(CustomFileCoupling file, LineCoupling line) {
		int endNumber = 0;
		for (LineCoupling line1 : file.getCoupling().getMethodList()) {

			if (line1.getLineNumber() == line.getLineNumber()) {
				endNumber = line1.getEndLineNumber();
				break;
			}

		}
		return endNumber;
	}

	//get user defined method set in the file
	@Override
	public void getMethodSet(CustomFileCoupling file) {

		ArrayList<LineCoupling> methodSet = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getLineSet()) {
			if (line.getLineContent().contains("class") || line.getLineContent().contains("if")
					|| line.getLineContent().contains("switch") || line.getLineContent().contains("catch")
					|| line.getLineContent().contains("return") || line.getLineContent().contains(";")) {

			} else if (line.getLineContent().contains("public")) {
				String[] sub = line.getLineContent().split("\\(");
				String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
						.replace("static", "").replace("final", "").trim();
				if (x.split(" ").length > 1) {
					methodSet.add(new LineCoupling(line.getLineNumber(), x.split(" ")[1]));
				} else {
					methodSet.add(new LineCoupling(line.getLineNumber(), x));
				}
			}
		}
		file.getCoupling().setMethodList(methodSet);
	}

	//set end line numbers
	@Override
	public void setEndLineNumber(CustomFileCoupling file) {

		for (int i = 0; i < file.getCoupling().getMethodList().size(); i++) {

			int opnBrkt = 0;
			int clsBrkt = 0;

			if (i == file.getCoupling().getMethodList().size() - 1) {

				for (int j = file.getCoupling().getMethodList().get(i).getLineNumber() - 1; j < file
						.getLastIndex(); ++j) {

					if (file.getLineSet().get(j).getLineContent().contains("{")
							&& file.getLineSet().get(j).getLineContent().contains("}")) {

					} else if (file.getLineSet().get(j).getLineContent().contains("{")) {
						++opnBrkt;
					} else if (file.getLineSet().get(j).getLineContent().contains("}")) {
						--opnBrkt;
					}

					if (opnBrkt == 0) {
						file.getCoupling().setEndLineNumber(i, ++j);
						break;
					} else {
						continue;
					}
				}

			} else {

				for (int j = file.getCoupling().getMethodList().get(i).getLineNumber() - 1; j < file.getCoupling()
						.getMethodList().get(i + 1).getLineNumber() - 1; ++j) {

					if (file.getLineSet().get(j).getLineContent().contains("{")
							&& file.getLineSet().get(j).getLineContent().contains("}")) {

					} else if (file.getLineSet().get(j).getLineContent().contains("{")) {
						++opnBrkt;
					} else if (file.getLineSet().get(j).getLineContent().contains("}")) {
						--opnBrkt;
					}

					if (opnBrkt == clsBrkt) {
						file.getCoupling().setEndLineNumber(i, ++j);
						break;
					} else {
						continue;
					}

				}

			}

		}

	}

	//Get recursive method calls
	// Senario 1
	@Override
	public void getRecursiveMethods(CustomFileCoupling file) {

		ArrayList<LineCoupling> recursiveMethodSet = new ArrayList<LineCoupling>();
		ArrayList<LineCoupling> recursiveMethodCalls = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getCoupling().getMethodList()) {
			boolean no_recursive = true;

			for (int i = line.getLineNumber(); i < line.getEndLineNumber(); i++) {

				if (file.getLineSet().get(i).getLineContent().contains(line.getLineContent())) {
					no_recursive = false;
					recursiveMethodCalls.add(file.getLineSet().get(i));
				}
			}
			if (no_recursive == false) {
				recursiveMethodSet.add(line);
			}
		}

		file.getCoupling().setRecursiveMethods(recursiveMethodSet);
		file.getCoupling().setRecursiveMethodCalls(recursiveMethodCalls);
	}

	//get regular methods
	@Override
	public void getRegularMethods(CustomFileCoupling file) {

		ArrayList<LineCoupling> regularMethodSet = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getCoupling().getMethodList()) {
			boolean no_recursive = true;

			for (int i = line.getLineNumber(); i < line.getEndLineNumber(); i++) {

				if (file.getLineSet().get(i).getLineContent().contains(line.getLineContent())) {
					no_recursive = false;
				}
			}
			if (no_recursive) {
				regularMethodSet.add(line);
			}
		}

		file.getCoupling().setRegularMethods(regularMethodSet);
	}

	//get system methods
	@Override
	public void getSystemMethods(CustomFileCoupling file) {

		ArrayList<LineCoupling> systemMethodList = new ArrayList<>();

		for (LineCoupling line : file.getLineSet()) {
			if (line.getLineContent().contains("main") || line.getLineContent().contains("class")
					|| line.getLineContent().contains("if") || line.getLineContent().contains("switch")
					|| line.getLineContent().contains("catch") || line.getLineContent().contains("return")
					|| line.getLineContent().contains("new")) {

			} else if (line.getLineContent().contains("(") && line.getLineContent().contains(")")
					&& line.getLineContent().contains(";")) {
				boolean status = true;
				String[] sub = line.getLineContent().split("\\(");
				String method = sub[0].trim();

				for (LineCoupling line_method : file.getCoupling().getMethodList()) {

					if (method.contains(line_method.getLineContent())) {
						status = false;
						break;
					}

				}

				if (status == true) {
					systemMethodList.add(line);
				}
			}
		}

		file.getCoupling().setSystemMethods(systemMethodList);
	}

	//get regular methods, which called by another regular method
	// Senario 2
	@Override
	public void getRegInReg(CustomFileCoupling file) {

		ArrayList<LineCoupling> regInReg = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getCoupling().getRegularMethods()) {
			for (LineCoupling regLine : file.getCoupling().getRegularMethods()) {
				if (line.getLineNumber() != regLine.getLineNumber()) {
					for (int i = line.getLineNumber(); i < getEndLineNumber(file, line); i++) {

						if (file.getLineSet().get(i).getLineContent().contains(regLine.getLineContent())) {
							regInReg.add(file.getLineSet().get(i));
						}

					}
				}

			}
			for (LineCoupling line_sys : file.getCoupling().getSystemMethods()) {

				if (line_sys.getLineNumber() > line.getLineNumber()
						&& line_sys.getLineNumber() < getEndLineNumber(file, line)) {
					regInReg.add(line_sys);
				}

			}
		}
		file.getCoupling().setRegularInRegularMethods(regInReg);
	}

	//get recursive methods, which called by another regular method
	// Senario 4
	@Override
	public void getRecInReg(CustomFileCoupling file) {

		ArrayList<LineCoupling> recInReg = new ArrayList<LineCoupling>();

		for (LineCoupling regLine : file.getCoupling().getRegularMethods()) {

			for (int i = regLine.getLineNumber(); i < getEndLineNumber(file, regLine); i++) {

				for (LineCoupling recLine : file.getCoupling().getRecursiveMethods()) {
					if (file.getLineSet().get(i).getLineContent().contains(recLine.getLineContent())) {
						recInReg.add(file.getLineSet().get(i));
					}
				}

			}

		}
		file.getCoupling().setRecursiveInRegularMethods(recInReg);
	}

	//get recursive methods, which called by another recursive method
	// Senario 6
	@Override
	public void getRecInRec(CustomFileCoupling file) {

		ArrayList<LineCoupling> recInRec = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getCoupling().getRecursiveMethods()) {
			for (LineCoupling recLine : file.getCoupling().getRecursiveMethods()) {
				if (line.getLineNumber() != recLine.getLineNumber()) {
					for (int i = line.getLineNumber(); i < getEndLineNumber(file, line); i++) {

						if (file.getLineSet().get(i).getLineContent().contains(recLine.getLineContent())) {
							recInRec.add(file.getLineSet().get(i));
						}

					}
				}

			}
		}

		file.getCoupling().setRecursiveInRecursiveMethods(recInRec);

	}

	//get regular methods, which called by another recursive method
	// Senario 8
	@Override
	public void getRegInRec(CustomFileCoupling file) {

		ArrayList<LineCoupling> regInRec = new ArrayList<LineCoupling>();

		for (LineCoupling recLine : file.getCoupling().getRecursiveMethods()) {

			for (int i = recLine.getLineNumber(); i < getEndLineNumber(file, recLine); i++) {

				for (LineCoupling regLine : file.getCoupling().getRegularMethods()) {
					if (file.getLineSet().get(i).getLineContent().contains(regLine.getLineContent())) {
						regInRec.add(file.getLineSet().get(i));
					}
				}

			}

			for (LineCoupling line_sys : file.getCoupling().getSystemMethods()) {

				if (line_sys.getLineNumber() > recLine.getLineNumber()
						&& line_sys.getLineNumber() < getEndLineNumber(file, recLine)) {
					regInRec.add(line_sys);
				}

			}

		}

		file.getCoupling().setRegularInRecursiveMethods(regInRec);
	}

	//get global variable set in the file
	@Override
	public void getGlobalVariableSet(CustomFileCoupling file) {

		ArrayList<LineCoupling> variableSet = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getLineSet()) {

			// Check more details on global variables
			if (line.getLineContent().contains("=") && line.getLineContent().contains(";")) {
				if (line.getLineContent().contains("if ") || line.getLineContent().contains("switch ")
						|| line.getLineContent().contains("catch ") || line.getLineContent().contains("return ")
						|| line.getLineContent().contains("private") || line.getLineContent().contains("protected")) {

				} else if (line.getLineContent().contains("byte") || line.getLineContent().contains("short")
						|| line.getLineContent().contains("int") || line.getLineContent().contains("long")
						|| line.getLineContent().contains("float") || line.getLineContent().contains("double")
						|| line.getLineContent().contains("char") || line.getLineContent().contains("boolean")) {

					String value = line.getLineContent().replace("static", "").replace("public", "").trim();
					String[] sub = value.split(" ");
					variableSet.add(new LineCoupling(line.getLineNumber(), sub[1]));
				}
			}
		}

		ArrayList<Integer> removableNumbers = new ArrayList<>();
		for (LineCoupling line : variableSet) {

			for (LineCoupling line_meth : file.getCoupling().getMethodList()) {
				if (line.getLineNumber() > line_meth.getLineNumber()
						&& line.getLineNumber() < line_meth.getEndLineNumber()) {
					removableNumbers.add(line.getLineNumber());
				}
			}

		}
		for (int x : removableNumbers) {

			for (int i = 0; i < variableSet.size(); i++) {

				if (variableSet.get(i).getLineNumber() == x) {
					variableSet.remove(i);
				}

			}

		}

		file.getCoupling().setGlobalVariableSet(variableSet);

	}

	//get global variables referenced by regular methods
	// Senario 10
	@Override
	public void getGlobalVariableListInReg(CustomFileCoupling file) {

		ArrayList<LineCoupling> globalVariableSetInReg = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getCoupling().getGlobalVariableSet()) {

			for (LineCoupling line_reg : file.getCoupling().getRegularMethods()) {

				for (int i = line_reg.getLineNumber(); i < getEndLineNumber(file, line_reg); i++) {
					if (file.getLineSet().get(i).getLineContent().contains(line.getLineContent())
							&& !file.getLineSet().get(i).getLineContent().contains("." + line.getLineContent())) {

						String text = file.getLineSet().get(i).getLineContent();

						String regex = "\\b" + line.getLineContent() + "\\b";

						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(text);

						while (matcher.find()) {
							globalVariableSetInReg.add(file.getLineSet().get(i));
						}
					}
				}

			}

		}

		file.getCoupling().setGlobalVariableListInReg(globalVariableSetInReg);
	}

	//get global variables referenced by recursive methods
	// Senario 12
	@Override
	public void getGlobalVariableListInRec(CustomFileCoupling file) {

		ArrayList<LineCoupling> globalVariableSetInRec = new ArrayList<LineCoupling>();

		for (LineCoupling line : file.getCoupling().getGlobalVariableSet()) {

			for (LineCoupling methodLine : file.getCoupling().getRecursiveMethods()) {

				for (int i = methodLine.getLineNumber(); i < getEndLineNumber(file, methodLine); i++) {

					if (file.getLineSet().get(i).getLineContent().contains(line.getLineContent())
							&& !file.getLineSet().get(i).getLineContent().contains("." + line.getLineContent())) {

						String text = file.getLineSet().get(i).getLineContent();

						String regex = "\\b" + line.getLineContent() + "\\b";

						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(text);

						while (matcher.find()) {
							globalVariableSetInRec.add(file.getLineSet().get(i));
						}

					}

				}

			}

		}

		file.getCoupling().setGlobalVariableListInRec(globalVariableSetInRec);

	}

	//get system methods without other methods from another files
	@Override
	public void getSystemMethods_DF(CustomFileCoupling ifile) {

		ArrayList<LineCoupling> systemMethodList_DF = new ArrayList<>();

		for (CustomFileCoupling file : fileList) {
			if (ifile.getFileName() != file.getFileName()) {
				for (LineCoupling line : ifile.getLineSet()) {
					if (line.getLineContent().contains("main") || line.getLineContent().contains("class")
							|| line.getLineContent().contains("if") || line.getLineContent().contains("switch")
							|| line.getLineContent().contains("catch") || line.getLineContent().contains("return")
							|| line.getLineContent().contains("new")) {

					} else if (line.getLineContent().contains("(") && line.getLineContent().contains(")")
							&& line.getLineContent().contains(";")) {
						boolean status = true;
						String[] sub = line.getLineContent().split("\\(");
						String method = sub[0].trim();

						for (LineCoupling line_method : ifile.getCoupling().getMethodList()) {

							if (method.contains(line_method.getLineContent())) {
								status = false;
								break;
							}

						}

						if (status == true) {
							for (LineCoupling line_meth : file.getCoupling().getMethodList()) {
								if (method.contains(line_meth.getLineContent())) {
									status = false;
									break;
								}
							}

						}

						if (status == true) {
							systemMethodList_DF.add(line);
						}

					}
				}
			}
			file.getCoupling().setSystemMethods(systemMethodList_DF);
		}
	}

	//get called method set which belong to another file
	@Override
	public void getCalledMethodSet_DF(CustomFileCoupling ifile) {
		ArrayList<LineCoupling> calledMethodList_DF = new ArrayList<>();
		for (CustomFileCoupling file : fileList) {
			if (!file.getFileName().equalsIgnoreCase(ifile.getFileName())) {

				for (LineCoupling line : ifile.getLineSet()) {

					for (LineCoupling line_meth : file.getCoupling().getMethodList()) {

						if (line.getLineContent().contains("." + line_meth.getLineContent())) {
							line.setFileName(file.getFileName().split("\\.")[0]);
							calledMethodList_DF.add(line);
						}

					}

				}

				ifile.getCoupling().setCalledMethodList_DF(calledMethodList_DF);
			}
		}

	}

	//get method set which belong to another file
	@Override
	public void getMethods_DF() {

		for (CustomFileCoupling file : fileList) {
			ArrayList<LineCoupling> inReg = new ArrayList<>();
			ArrayList<LineCoupling> inRec = new ArrayList<>();

			for (LineCoupling line : file.getCoupling().getCalledMethodList_DF()) {

				for (CustomFileCoupling tFile : fileList) {

					if (tFile.getFileName().split("\\.")[0].equalsIgnoreCase(line.getFileName())) {

						for (LineCoupling line_meth_reg : tFile.getCoupling().getRegularMethods()) {
							if (line.getLineContent().contains(line_meth_reg.getLineContent())) {
								inReg.add(line);
							}
						}

						for (LineCoupling line_meth_rec : tFile.getCoupling().getRecursiveMethods()) {
							if (line.getLineContent().contains(line_meth_rec.getLineContent())) {
								inRec.add(line);
							}
						}

					}

				}

			}

			file.getCoupling().setInReg_DF(inReg);
			file.getCoupling().setInRec_DF(inRec);

		}

	}

	//A regular method calling another regular method in a different file
	@Override
	public void getRegInReg_DF() {
		for (CustomFileCoupling file : fileList) {
			ArrayList<LineCoupling> regInReg_DF = new ArrayList<>();

			for (LineCoupling line : file.getCoupling().getInReg_DF()) {

				for (LineCoupling line_reg : file.getCoupling().getRegularMethods()) {

					if (line.getLineNumber() > line_reg.getLineNumber()
							&& line.getLineNumber() < line_reg.getEndLineNumber()) {
						regInReg_DF.add(line);
					}

				}

				for (LineCoupling line_sys : file.getCoupling().getSystemMethods()) {

					if (line_sys.getLineNumber() > line.getLineNumber()
							&& line_sys.getLineNumber() < getEndLineNumber(file, line)) {
						regInReg_DF.add(line_sys);
					}

				}

			}
			file.getCoupling().setRegularInRegularMethods_DF(regInReg_DF);
		}
	}

	//A regular method calling a recursive method in a different file
	@Override
	public void getRecInReg_DF() {
		for (CustomFileCoupling file : fileList) {
			ArrayList<LineCoupling> recInReg_DF = new ArrayList<>();
			for (LineCoupling line : file.getCoupling().getInRec_DF()) {

				for (LineCoupling line_reg : file.getCoupling().getRegularMethods()) {

					if (line.getLineNumber() > line_reg.getLineNumber()
							&& line.getLineNumber() < line_reg.getEndLineNumber()) {
						recInReg_DF.add(line);
					}

				}
			}
			file.getCoupling().setRecursiveInRegularMethods_DF(recInReg_DF);
		}
	}

	//A recursive method calling another recursive method in a different file
	@Override
	public void getRecInRec_DF() {
		for (CustomFileCoupling file : fileList) {
			ArrayList<LineCoupling> recInRec_DF = new ArrayList<>();
			for (LineCoupling line : file.getCoupling().getInRec_DF()) {

				for (LineCoupling line_rec : file.getCoupling().getRecursiveMethods()) {

					if (line.getLineNumber() > line_rec.getLineNumber()
							&& line.getLineNumber() < line_rec.getEndLineNumber()) {
						recInRec_DF.add(line);
					}

				}
			}
			file.getCoupling().setRecursiveInRecursiveMethods_DF(recInRec_DF);
		}
	}

	//A recursive method calling a regular method in a different file
	@Override
	public void getRegInRec_DF() {
		for (CustomFileCoupling file : fileList) {
			ArrayList<LineCoupling> regInRec_DF = new ArrayList<>();
			for (LineCoupling line : file.getCoupling().getInReg_DF()) {

				for (LineCoupling line_rec : file.getCoupling().getRecursiveMethods()) {

					if (line.getLineNumber() > line_rec.getLineNumber()
							&& line.getLineNumber() < line_rec.getEndLineNumber()) {
						regInRec_DF.add(line);
					}

				}

				for (LineCoupling line_sys : file.getCoupling().getSystemMethods()) {

					if (line_sys.getLineNumber() > line.getLineNumber()
							&& line_sys.getLineNumber() < getEndLineNumber(file, line)) {
						regInRec_DF.add(line_sys);
					}

				}
			}
			file.getCoupling().setRegularInRecursiveMethods_DF(regInRec_DF);
		}
	}

	//get global variable set which are belong to another file
	@Override
	public void getGlobalVariableList_DF(CustomFileCoupling ifile) {
		ArrayList<LineCoupling> globalVariableList_DF = new ArrayList<>();

		for (CustomFileCoupling file : fileList) {

			if (!ifile.getFileName().equalsIgnoreCase(file.getFileName())) {
				for (LineCoupling line : ifile.getLineSet()) {
					for (LineCoupling line_g : file.getCoupling().getGlobalVariableSet()) {
						if(line.getLineContent().contains("."+line_g.getLineContent())) {
							globalVariableList_DF.add(line);
						}
					}
				}
			}

		}

		ifile.getCoupling().setGlobalVariableList_DF(globalVariableList_DF);

	}

	//A regular method referencing a global variable in a different file 
	@Override
	public void getGlobalVariableListInReg_DF() {
		for (CustomFileCoupling file : fileList) {
			ArrayList<LineCoupling> globalVariableListInReg_DF = new ArrayList<>();
			for (LineCoupling regLine : file.getCoupling().getRegularMethods()) {

				for (LineCoupling gVariable : file.getCoupling().getGlobalVariableList_DF()) {

					if (gVariable.getLineNumber() > regLine.getLineNumber()
							&& gVariable.getLineNumber() < getEndLineNumber(file, regLine)) {
						globalVariableListInReg_DF.add(gVariable);
					}

				}

			}

			file.getCoupling().setGlobalVariableListInReg_DF(globalVariableListInReg_DF);
		}
	}

	//A recursive method referencing a global variable in a different file
	@Override
	public void getGlobalVariableListInRec_DF() {

		for (CustomFileCoupling file : fileList) {
			ArrayList<LineCoupling> globalVariableListInRec_DF = new ArrayList<>();
			for (LineCoupling recLine : file.getCoupling().getRecursiveMethods()) {

				for (LineCoupling gVariable : file.getCoupling().getGlobalVariableList_DF()) {

					if (gVariable.getLineNumber() > recLine.getLineNumber()
							&& gVariable.getLineNumber() < getEndLineNumber(file, recLine)) {
						globalVariableListInRec_DF.add(gVariable);
					}

				}

			}

			file.getCoupling().setGlobalVariableListInRec_DF(globalVariableListInRec_DF);
		}
	}

	//Process for a single file upload
	@Override
	public void process1(CustomFileCoupling file) {

		getClassNames(file);
		getObjectSet(file);
		getMethodSet(file);
		getSystemMethods(file);
		setEndLineNumber(file);
		getGlobalVariableSet(file);
		getRecursiveMethods(file);
		getRegularMethods(file);
		getRegInReg(file);
		getRecInReg(file);
		getRecInRec(file);
		getRegInRec(file);
		getGlobalVariableListInReg(file);
		getGlobalVariableListInRec(file);

		file.getCoupling().setNr(file.getCoupling().getRecursiveMethodCalls().size());
		file.getCoupling().setNmcms(file.getCoupling().getRegularInRegularMethods().size());
		file.getCoupling().setNmcmd(0);
		file.getCoupling().setNmcrms(file.getCoupling().getRecursiveInRegularMethods().size());
		file.getCoupling().setNmcrmd(0);
		file.getCoupling().setNrmcrms(file.getCoupling().getRecursiveInRecursiveMethods().size());
		file.getCoupling().setNrmcrmd(0);
		file.getCoupling().setNrmcms(file.getCoupling().getRegularInRecursiveMethods().size());
		file.getCoupling().setNrmcmd(0);
		file.getCoupling().setNmrgvs(file.getCoupling().getGlobalVariableListInReg().size());
		file.getCoupling().setNmrgvd(0);
		file.getCoupling().setNrmrgvs(file.getCoupling().getGlobalVariableListInRec().size());
		file.getCoupling().setNrmrgvd(0);
		file.getCoupling().setFinalValue();

	}

	//Process for a multi file upload
	@Override
	public void process2() {

		for (CustomFileCoupling file : fileList) {
			getClassNames(file);
			getObjectSet(file);
			getMethodSet(file);
			getSystemMethods(file);
			setEndLineNumber(file);
			getGlobalVariableSet(file);
			getRecursiveMethods(file);
			getRegularMethods(file);
			getRegInReg(file);
			getRecInReg(file);
			getRecInRec(file);
			getRegInRec(file);
			getGlobalVariableListInReg(file);
			getGlobalVariableListInRec(file);
		}

		for (CustomFileCoupling file : fileList) {
			getObjectSet_DF(file);
			getSystemMethods_DF(file);
			getGlobalVariableList_DF(file);
		}

		for (CustomFileCoupling file : fileList) {
			getCalledMethodSet_DF(file);
		}

		getMethods_DF();
		getRegInReg_DF();
		getRecInReg_DF();
		getRecInRec_DF();
		getRegInRec_DF();
		getGlobalVariableListInReg_DF();
		getGlobalVariableListInRec_DF();

		for (CustomFileCoupling file : fileList) {

			file.getCoupling().setNr(file.getCoupling().getRecursiveMethodCalls().size());
			file.getCoupling().setNmcms(file.getCoupling().getRegularInRegularMethods().size());
			file.getCoupling().setNmcmd(file.getCoupling().getRegularInRegularMethods_DF().size());
			file.getCoupling().setNmcrms(file.getCoupling().getRecursiveInRegularMethods().size());
			file.getCoupling().setNmcrmd(file.getCoupling().getRecursiveInRegularMethods_DF().size());
			file.getCoupling().setNrmcrms(file.getCoupling().getRecursiveInRecursiveMethods().size());
			file.getCoupling().setNrmcrmd(file.getCoupling().getRecursiveInRecursiveMethods_DF().size());
			file.getCoupling().setNrmcms(file.getCoupling().getRegularInRecursiveMethods().size());
			file.getCoupling().setNrmcmd(file.getCoupling().getRegularInRecursiveMethods_DF().size());
			file.getCoupling().setNmrgvs(file.getCoupling().getGlobalVariableListInReg().size());
			file.getCoupling().setNmrgvd(file.getCoupling().getGlobalVariableListInReg_DF().size());
			file.getCoupling().setNrmrgvs(file.getCoupling().getGlobalVariableListInRec().size());
			file.getCoupling().setNrmrgvd(file.getCoupling().getGlobalVariableListInRec_DF().size());
			file.getCoupling().setFinalValue();

		}

	}

	//Process for calculations to display results in the table
	public static void process3() {
		
		int count = 0;

		for (CustomFileCoupling file : fileList) {
			int[] sum = new int[13];
			for (LineCoupling line : file.getLineSet()) {

				// col1
				count = 0;
				for (LineCoupling regLine : file.getCoupling().getRecursiveMethodCalls()) {
					if (regLine.getLineNumber() == line.getLineNumber()) {
						count++;
					}
				}

				line.setSum(0, count);
				file.getCoupling();
				line.setColValues(0, count * Coupling.getWeights()[0]);

				// col2
				count = 0;
				for (LineCoupling regLine : file.getCoupling().getRegularInRegularMethods()) {
					if (regLine.getLineNumber() == line.getLineNumber()) {
						count++;
					}
				}

				line.setSum(1, count);
				file.getCoupling();
				line.setColValues(1, count * Coupling.getWeights()[1]);

				// col3
				if (fileList.size() > 1) {
					count = 0;
					for (LineCoupling regLine : file.getCoupling().getRegularInRegularMethods_DF()) {
						if (regLine.getLineNumber() == line.getLineNumber()) {
							count++;
						}
					}
					line.setSum(2, count);
					line.setColValues(2, count * Coupling.getWeights()[2]);
				} else {
					line.setSum(2, 0);
					line.setColValues(2, 0);
				}

				// col4
				count = 0;
				for (LineCoupling regLine : file.getCoupling().getRecursiveInRegularMethods()) {
					if (regLine.getLineNumber() == line.getLineNumber()) {
						count++;
					}
				}
				line.setSum(3, count);
				line.setColValues(3, count * Coupling.getWeights()[3]);

				// col5
				if (fileList.size() > 1) {
					count = 0;
					for (LineCoupling regLine : file.getCoupling().getRecursiveInRegularMethods_DF()) {
						if (regLine.getLineNumber() == line.getLineNumber()) {
							count++;
						}
					}
					line.setSum(4, count);
					line.setColValues(4, count * Coupling.getWeights()[4]);
				} else {
					line.setSum(2, 0);
					line.setColValues(2, 0);
				}

				// col6
				count = 0;
				for (LineCoupling regLine : file.getCoupling().getRecursiveInRecursiveMethods()) {
					if (regLine.getLineNumber() == line.getLineNumber()) {
						count++;
					}
				}
				line.setSum(5, count);
				line.setColValues(5, count * Coupling.getWeights()[5]);

				// col7
				if (fileList.size() > 1) {
					count = 0;
					for (LineCoupling regLine : file.getCoupling().getRecursiveInRecursiveMethods_DF()) {
						if (regLine.getLineNumber() == line.getLineNumber()) {
							count++;
						}
					}
					line.setSum(6, count);
					line.setColValues(6, count * Coupling.getWeights()[6]);
				} else {
					line.setSum(2, 0);
					line.setColValues(2, 0);
				}

				// col8
				count = 0;
				for (LineCoupling regLine : file.getCoupling().getRegularInRecursiveMethods()) {
					if (regLine.getLineNumber() == line.getLineNumber()) {
						count++;
					}
				}
				line.setSum(7, count);
				line.setColValues(7, count * Coupling.getWeights()[7]);

				// col9
				if (fileList.size() > 1) {
					count = 0;
					for (LineCoupling regLine : file.getCoupling().getRegularInRecursiveMethods_DF()) {
						if (regLine.getLineNumber() == line.getLineNumber()) {
							count++;
						}
					}
					line.setSum(8, count);
					line.setColValues(8, count * Coupling.getWeights()[8]);
				} else {
					line.setSum(2, 0);
					line.setColValues(2, 0);
				}

				// col10
				count = 0;
				for (LineCoupling regLine : file.getCoupling().getGlobalVariableListInReg()) {
					if (regLine.getLineNumber() == line.getLineNumber()) {
						count++;
					}
				}
				line.setSum(9, count);
				line.setColValues(9, count * Coupling.getWeights()[9]);

				// col11
				if (fileList.size() > 1) {
					count = 0;
					for (LineCoupling regLine : file.getCoupling().getGlobalVariableListInReg_DF()) {
						if (regLine.getLineNumber() == line.getLineNumber()) {
							count++;
						}
					}
					line.setSum(10, count);
					line.setColValues(10, count * Coupling.getWeights()[10]);
				} else {
					line.setSum(2, 0);
					line.setColValues(2, 0);
				}

				// col12
				count = 0;
				for (LineCoupling regLine : file.getCoupling().getGlobalVariableListInRec()) {
					if (regLine.getLineNumber() == line.getLineNumber()) {
						count++;
					}
				}
				line.setSum(11, count);
				line.setColValues(11, count * Coupling.getWeights()[11]);

				// col13
				count = 0;
				if (fileList.size() > 1) {
					for (LineCoupling regLine : file.getCoupling().getGlobalVariableListInRec_DF()) {
						if (regLine.getLineNumber() == line.getLineNumber()) {
							count++;
						}
					}
					line.setSum(12, count);
					line.setColValues(12, count * Coupling.getWeights()[12]);
				} else {
					line.setSum(2, 0);
					line.setColValues(2, 0);
				}
				line.setFinalValue();

			}

			for (LineCoupling line : file.getLineSet()) {

				for (int i = 0; i < line.getSum().length; i++) {
					sum[i] += line.getSum()[i];
				}

			}
			file.getCoupling().setFinalValue();
			file.getCoupling().setSum(sum);
		}

	}

}
