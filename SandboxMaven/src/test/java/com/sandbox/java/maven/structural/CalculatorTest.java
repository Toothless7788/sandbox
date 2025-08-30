package com.sandbox.java.maven.structural;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sandbox.java.maven.entity.Calculator;
import com.sandbox.java.maven.utils.ReflectionHelper;

public class CalculatorTest {
	private final static Logger log = LoggerFactory.getLogger(CalculatorTest.class);
	private ReflectionHelper<Calculator> helper;
	private Calculator calculator;
	
	@BeforeEach
	public void setUp() throws ClassNotFoundException {
		if(helper == null) {
			helper = new ReflectionHelper<Calculator>(Calculator.class);
		}
		if(calculator == null) {
			calculator = new Calculator();
		}
	}
	
	@Test
	public void testAddExists() {
		final String methodName = "add";
		final Class<?>[] parameterTypes = {double.class, double.class};
		final Class<?> returnType = double.class;
		
		assertTrue(helper.isMethodExisted(calculator, methodName, parameterTypes));
		try {
			assertEquals(returnType, helper.getMethodReturnType(calculator, methodName, parameterTypes));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSubtractExists() {
		final String methodName = "subtract";
		final Class<?>[] parameterTypes = {double.class, double.class};
		final Class<?> returnType = double.class;
		
		assertTrue(helper.isMethodExisted(calculator, methodName, parameterTypes));
		try {
			assertEquals(returnType, helper.getMethodReturnType(calculator, methodName, parameterTypes));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
