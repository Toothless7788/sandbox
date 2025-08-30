package com.sandbox.java.maven.functional;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sandbox.java.maven.entity.Calculator;
import com.sandbox.java.maven.utils.ReflectionHelper;

public class CalculatorTest {
	private final static Logger log = LoggerFactory.getLogger(CalculatorTest.class);
	private ReflectionHelper<Calculator> helper;
	
	@BeforeEach
	public void setUp() throws ClassNotFoundException {
		if(helper == null) {
			helper = new ReflectionHelper<Calculator>("com.sandbox.java.maven.entity.Calculator");
		}
	}
	
	@Test
	public void testAdd() {
		final Calculator calculator = new Calculator();
		
		final double[] ms = new double[] {
				0, 
				1, 
				-10
		};
		final double[] ns = new double[] {
				0, 
				2, 
				5
		};
		final double[] results = new double[] {
				0, 
				3, 
				-5
		};
		
		try {
			for(int i = 0; i < results.length; i++) {
				assertEquals(results[i], calculator.add(ms[i], ns[i]));
			}
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSubtract() {
		final Calculator calculator = new Calculator();
		
		final double[] ms = new double[] {
				0, 
				1, 
				-10
		};
		final double[] ns = new double[] {
				0, 
				-2, 
				5
		};
		final double[] results = new double[] {
				0, 
				3, 
				-15
		};
		
		try {
			for(int i = 0; i < results.length; i++) {
				assertEquals(results[i], calculator.subtract(ms[i], ns[i]));
			}
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
