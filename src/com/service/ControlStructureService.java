/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.model.controlstructure;
import com.util.controlCommonConstants;

/**import
 *
 * @author MAC
 */
public class ControlStructureService {
      public List<controlstructure> calculateComplexityDueToControlStructures(List<controlstructure> statmentList)
			throws Exception {
		
                controlCommonConstants common = new controlCommonConstants();
		List<String> controlCommons = common.getControlStructures();
		
		for(String x : controlCommons) {
			System.out.println(x);
		}
          
		boolean switchFlag = false;
		int switchIndex = 0;
		int index = 0;
		int caseCount = 0;
		int switchReturnVal = 0;
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
                
		
		for (controlstructure line : statmentList) {
			int count = 0;

			try {
				Pattern patternIf = Pattern.compile(controlCommonConstants.MATCH_CONTROL_STRUCTURE_TYPE_IF);
				Matcher matcherIf = patternIf.matcher(line.getStatement());

				Pattern patternLoop = Pattern.compile(controlCommonConstants.MATCH_CONTROL_STRUCTURE_TYPE_LOOP);
				Matcher matchLoop = patternLoop.matcher(line.getStatement());

				Pattern patternCatch = Pattern.compile(controlCommonConstants.MATCH_CONTROL_STRUCTURE_TYPE_CATCH);
				Matcher matchCatch = patternCatch.matcher(line.getStatement());
				
				Pattern patternSwitch = Pattern.compile(controlCommonConstants.MATCH_KEYWORD_SWITCH);
				Matcher matchSwitch= patternSwitch.matcher(line.getStatement());
				
				Pattern patterBreakPoint = Pattern.compile(controlCommonConstants.MATCH_NESTING_CONTROL_BREAK);
				Matcher matcherBreakPoint = patterBreakPoint.matcher(line.getStatement());
				
				Pattern patternCase = Pattern.compile(controlCommonConstants.MATCH_KEYWORD_CASE);
				Matcher matcherCase = patternCase.matcher(line.getStatement());
				
				while(matchSwitch.find()) {
					switchFlag = true;
					switchIndex = index;
				}
				
				while(matcherBreakPoint.find()) {
					System.out.println("break point detected");
					switchFlag = false;
					hmap.put(index, caseCount);
					switchReturnVal = caseCount;
					caseCount = 0;
				}
				
				while( matcherCase.find() ) {
					System.out.println("case detected");
					++caseCount;
				}
				
			
				while (matcherIf.find()) {
					count++;
					// System.out.println("found: " + count + " : " + matcherIf.start() + " - " +
					// matcherIf.end());

					String innerKeyword = controlCommonConstants.MATCH_CONTROL_STRUCTURE_TYPE_BREAKS;

					Pattern innerPattern = Pattern.compile(innerKeyword);
					Matcher innerMatcher = innerPattern.matcher(line.getStatement());

					while (innerMatcher.find()) {
						++count;

					}

				}

				while (matchCatch.find()) {
					count++;
					// System.out.println("found: " + count + " : " + matcherIf.start() + " - " +
					// matcherIf.end());

					String innerKeyword = controlCommonConstants.MATCH_CONTROL_STRUCTURE_TYPE_BREAKS;

					Pattern innerPattern = Pattern.compile(innerKeyword);
					Matcher innerMatcher = innerPattern.matcher(line.getStatement());

					while (innerMatcher.find()) {
						++count;

					}

				}

				while (matchLoop.find()) {
					count += 2;
					// System.out.println("found: " + count + " : " + matcherIf.start() + " - " +
					// matcherIf.end());

					String innerKeyword = controlCommonConstants.MATCH_CONTROL_STRUCTURE_TYPE_BREAKS;

					Pattern innerPattern = Pattern.compile(innerKeyword);
					Matcher innerMatcher = innerPattern.matcher(line.getStatement());

					while (innerMatcher.find()) {
						count += 2;

					}

				}

			} catch (Exception e) {
				System.out.println("Exceptoin : " + e);
			}
			
			++index;
			//line.setWtcs(switchReturnVal);
			
			if( switchReturnVal != 0 ) {
				line.setWtcs(switchReturnVal);
				switchReturnVal = 0;
			}else {
				line.setWtcs(count);
			}
                        
                        
                        
                        
                        
			int controlCount = 0;
						
//			
		        
						
			String subStr = line.getStatement().substring(index);
		        List<String> ControlStructuresX = common.getControlStructures(); 
						
			       for(String x001 : controlCommons) {
					System.out.println(x001);
			            }
						
				String strX[] = subStr.split(",");
				
				  for(int i = 0; i < strX.length; i++) {
				      System.out.println("strx: " + strX[i]);
//						
						  for(String ctype : ControlStructuresX) {
//							S
							if(strX[i].contains(ctype)) {
									
								controlCount++;
								System.out.println("strX[1]" + strX[1]);
								System.out.println("ControlConditions" + ctype);
								}
							
							}
							int total = strX.length;
							
							line.setNC(controlCount);
							
						}

						System.out.println("strX.length => " + strX.length);
						if(strX.length == 1) {
							int cnt1 = 0;
							
							if(cnt1 == 0) {
							   controlCount++;
							}
                                                        line.setNC(controlCount);
						}
						
						
						
					      
					
                                                
                        line.calculateCcs ();
			System.out.println("Ccs  => " + line.getCcs ());
			System.out.println("Wtcs: " + line.getWtcs() + ", NC: " + line.getNC() + ", Ccspps: " + line.getCcspps());
			System.out.println("");                     
		
                }                             
		return statmentList;
	}
      }
      

