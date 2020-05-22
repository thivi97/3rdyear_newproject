/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author MAC
 */
public class controlstructure {
        private int lineNumber,line_weight,no_of_control;
	private String statement;
        private int Ccs ; //Complexity of a program statement with a control structure
	private int Wtcs; //Weight due to control structure type
	private int NC ;  //Number of conditions 
	private int Ccspps;
	String line;
	
	
	
	public int getLine_weight() {
		return line_weight;
	}
	public void setLine_weight(int line_weight) {
		this.line_weight = line_weight;
	}
	public int getNo_of_control() {
		return no_of_control;
	}
	public void setNo_of_control(int no_of_control) {
		this.no_of_control = no_of_control;
	}
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
        
        
        public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
        
        public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
        
        public int getCcs() {
		return Ccs;
	}

	public void setCcs(int Ccs) {
		this.Ccs = Ccs;
	}
        
        public int getWtcs() {
		return Wtcs;
	}

	public void setWtcs(int Wtcs) {
		this.Wtcs = Wtcs;
	}
        
        public int getNC() {
		return NC;
	}

	public void setNC(int NC) {
		this.NC = NC;
	}
        
         public int getCcspps() {
		return Ccspps;
	}

	public void setCcspps(int Ccspps) {
		this.Ccspps = Ccspps;
	}
        
        public void calculateCcs() {
            this.Ccs = (this.Wtcs * this.NC)+ this.Ccspps;
        }
        
         @Override
         public String toString(){
            return "ControlStructure [lineNumber=" + lineNumber + " , statement=" + statement + " , Ccs=" + Ccs +" , Wtcs=" + Wtcs +
                  " , Ccspps=" + Ccspps + "]";
         }
    
}
