package com.sandbox.maven;

import com.sandbox.maven.entity.Calculator;

public class Driver {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		double m = 4;
		double n = 12;
		
		System.out.println(m + " + " + n + " = " + calculator.add(m, n));
		System.out.println(m + " - " + n + " = " + calculator.subtract(m, n));
	}
}
