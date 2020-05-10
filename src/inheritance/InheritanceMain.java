package inheritance;

import java.io.*;
import java.util.*;

import inheritance.Inheritance;

public class InheritanceMain {
	
	String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public static void main(String[] args)throws IOException{
		InheritanceMain im = new InheritanceMain();
		String f1 = im.getPath();
		
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		
		int i;
		String lines;
		ArrayList<String> line = new ArrayList<>();
		
		while((lines = br.readLine()) != null) {
			line.add(lines);
		}
		
		Inheritance inheri = new Inheritance(line);
		ArrayList<Integer> count = inheri.inheritkeyline();
		
		for(i = 0; i < line.size(); i++) {
			System.out.println("" + (i+1)+""+line.get(i)+""+count.get(i)+""+count.get(i)+""+(count.get(i)+count.get(i)));
		}
		
		System.out.println("");
		System.out.println("Total is= "+ inheri.tot());
		
	}
	

}
