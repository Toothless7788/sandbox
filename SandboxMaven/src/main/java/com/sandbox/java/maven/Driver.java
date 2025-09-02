package com.sandbox.java.maven;

import com.sandbox.java.maven.entity.Calculator;

public class Driver {
	public static void main(String[] args) {
		System.out.println("This is a sandbox of Maven project");
		
		Calculator calculator = new Calculator();
		
		final double[] ms = {4, 13.5, 0, -1, 20, 5};
		final double[] ns = {0, -15.5, 2, 3, 9, 20.5};
		
		for(int i = 0; i < ms.length; i++) {
			double m = ms[i];
			double n = ns[i];
			
			System.out.println("(" + m + ") + (" + n + ") = " + calculator.add(m, n));
			System.out.println("(" + m + ") - (" + n + ") = " + calculator.subtract(m, n));
			System.out.println("==================================");
		}
	}
}
