package com.vijay.datastructures;

public class ReverseString {

	public static void main(String[] args) {
		String input="This is a sTring";
		String[] inputArray=input.split(" ");
		for(String s:inputArray) {
			StringBuilder builder=new StringBuilder();
			builder.append(s);
			System.out.print(builder.reverse()+" ");	
		}

	}

}
