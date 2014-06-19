package org.refactory.matching.greql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.uni_koblenz.jgralab.gretl.SysOut;

public class TestResult {
	
	ArrayList<String> graphElements;
	
	public TestResult(){
		FileReader result;
		FileReader graph;
		BufferedReader res;
		BufferedReader gra;
		try {
			result=new FileReader("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/Vergleich.txt");
			graph=new FileReader("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/Graph");
			res=new BufferedReader(result);
			gra=new BufferedReader(graph);
			graphElements=new ArrayList<String>();
			boolean endNotReached=true;
			while (endNotReached){
				try {
					String toAdd=gra.readLine();
					if (toAdd!=null){
						graphElements.add(toAdd);
					}
					else{
						endNotReached=false;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					endNotReached=false;
				}
			}
			System.out.println(graphElements);
			endNotReached=true;
			while (endNotReached){
				try {
					String toTest=res.readLine();
					if (toTest!=null){
						if(analyzeLine(toTest)){
							System.out.println(true);
							System.out.println("----");
						}
						else{
							endNotReached=false;
						}
					}
					else{
						endNotReached=false;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Analyiert ein gefundenes Ergebnis
	 * @param toTest
	 * @return
	 */
	public boolean analyzeLine(String toTest){
		boolean result=true;
		String[] parts=toTest.split(",");
		for (int i=1;i<parts.length;i++){
			parts[i]=parts[i].trim();
			System.out.println(parts[i]);
			if (parts[i].startsWith("Path: ")){
				if (testLegalPath(parts[i])){
					if (testInMM(parts[i])){
						
					}
					else{
						result=false;
					}
				}
				else{
					result=false;
				}
			}
			else{
				// ist Node
			}
		}
		if (testWhole(parts)){
			
		}
		else{
			result=false;
		}
		return result;
	}
	
	/**
	 * Testet nur EXWRC
	 * @param toTest
	 * @return
	 */
	public boolean testWhole(String[] toTest){
		boolean result=true;
		String containerContainer=toTest[1];
		String origContainer=toTest[2];
		String newContainer=toTest[3];
		String extract=toTest[4];
		String movedReference=toTest[5];
		String source=toTest[6].substring(6);
		String[] s=source.split("-");
		String sourceCC=s[0].trim();
		String sourceOC=s[s.length-1].trim();
		String target=toTest[7].substring(6);
		String[] t=target.split("-");
		String targetCC=t[0].trim();
		String targetNC=t[t.length-1].trim();
		String extracts=toTest[8].substring(6);
		String[] e=extracts.split("-");
		String extractsOC=e[0].trim();
		String extractsE=e[e.length-1].trim();
		String moved=toTest[9].substring(6);
		String[] m=moved.split("-");
		String movedNC=m[0].trim();
		String movedE=m[m.length-1].trim();
		String containerReference=toTest[10].substring(6);
		String[] c=containerReference.split("-");
		String containerReferenceMR=c[0].trim();
		String containerReferenceNC=c[c.length-1].trim();
		String referer=toTest[11].substring(6);
		String[] r=referer.split("-");
		String refererOC=r[0].trim();
		String refererMR=r[r.length-1].trim();
		if (!(containerContainer.equals(sourceCC))){
			return false;
		}
		if (!(containerContainer.equals(targetCC))){
			return false;
		}
		if (!(origContainer.equals(sourceOC))){
			return false;
		}
		if (!(origContainer.equals(extractsOC))){
			return false;
		}
		if (!(origContainer.equals(refererOC))){
			return false;
		}
		if (!(newContainer.equals(targetNC))){
			return false;
		}
		if (!(newContainer.equals(movedNC))){
			return false;
		}
		if (!(newContainer.equals(containerReferenceNC))){
			return false;
		}
		if (!(extract.equals(extractsE))){
			return false;
		}
		if (!(extract.equals(movedE))){
			return false;
		}
		if (!(movedReference.equals(containerReferenceMR))){
			return false;
		}
		if (!(movedReference.equals(refererMR))){
			return false;
		}
		return result;
	}
	
	/**
	 * Setzt Connections zusammen
	 * @param toTest
	 * @return
	 */
	public boolean testInMM(String toTest){
		boolean result=true;
		String[] parts=toTest.split(":");
		for (int i=1;i<parts.length;i++){
			String[] parts2=parts[i].split("-");
			String toFind="\""+parts2[1].trim()+"\" \""+parts2[0].trim()+"\" \""+parts2[2].trim()+"\"";
			if (!findInGraph(toFind)){
				result=false;
			}
		}
		return result;
	}
	
	/**
	 * Testet ob String in ArrayList graphElements vorhanden ist
	 * @param toTest
	 * @return
	 */
	public boolean findInGraph(String toTest){
		boolean find=false;
		for (int i=0;i<graphElements.size();i++){
			if (graphElements.get(i).contains(toTest)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Testet ob aufeinanderfolgende Kante wirklich aufeinander folgen
	 * also von der Form a->b b->c
	 * @param toTest
	 * @return
	 */
	public boolean testLegalPath(String toTest){
		String[] parts=toTest.split(":");
		if (parts.length>2){
			for (int i=1;i<parts.length-1;i++){
				String[] p1=parts[i].split("-");
				String[] p2=parts[i+1].split("-");
				if (!(p1[2].trim().equals(p2[0].trim()))){
					return false;
				}
			}
			return true;
		}
		else{
			return true;
		}
	}
	
	public static void main(String[] args){
		new TestResult();
	}
}
