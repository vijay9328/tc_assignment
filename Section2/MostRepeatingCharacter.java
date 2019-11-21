package com.vijay.datastructures;

import java.io.CharConversionException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MostRepeatingCharacter {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the String : ");
		String input=scan.nextLine();
		Set<Character> inputSet=new TreeSet<Character>();
		for(Character c:input.toCharArray()) {
			inputSet.add(c);
		}
		Map<Character,Integer> inputMap=new HashMap<Character, Integer>();
		for(Character c:inputSet) {
			inputMap.put(c, input.replaceAll("[^"+c+"]", "").length());
		}
		int max=0;
		Map.Entry<Character, Integer> output = null;
		for(Map.Entry<Character, Integer> m:inputMap.entrySet()) {
			if(m.getValue()>max) {
				max=m.getValue();
				output=m;
			}
		}
		System.out.println(output.getKey()+","+output.getValue());
	}
	
}
