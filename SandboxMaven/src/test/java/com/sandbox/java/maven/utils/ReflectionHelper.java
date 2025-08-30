package com.sandbox.java.maven.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionHelper <T> {
	private final Class<?> clazz;
	private int verbose = 0;    // Verbose level: 0 - the most quiet one; Verbose level: 1 - a bit printing; ...
	
	private final static Logger log = LoggerFactory.getLogger(ReflectionHelper.class);
	
	public ReflectionHelper(String className) throws ClassNotFoundException {
		clazz = Class.forName(className);
	}
	
	public ReflectionHelper(Class<?> classInstance) throws ClassNotFoundException {
		clazz = classInstance;
	}
	
	/**
	 * A brute way to update the field of an instance
	 * 
	 * @param instance The instance whose field to be updated - if the field is static, it will be ignored and null should be passed
	 * @param fieldName
	 * @param newValue
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public void setField(T instance, String fieldName, Object newValue) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = clazz.getDeclaredField(fieldName);
		
		field.setAccessible(true);    // Even if the field is private, it will still be updated
		field.set(instance, newValue);
		
		if(verbose > 2) {
			log.info("Field " + fieldName + " updated");
		}
	}
	
	public Field getField(T instance, String fieldName) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			
			return field;
		} catch (NoSuchFieldException e) {
			return null;
		} catch (SecurityException e) {
			log.info("Unable to get field due to security issue: " + e.getMessage());
			return null;
		}
	}
	
	public boolean isFieldExisted(T instance, String fieldName) {
		return getField(instance, fieldName) != null;
	}
	
	public Class<?> getFieldType(T instance, String fieldName) throws Exception {
		Field field = getField(instance, fieldName);
		
		if(field == null) {
			throw new Exception("Unable to get field: " + fieldName);
		}
		
		return field.getType();
	}
	
	/**
	 * Get the specified method
	 * Only works on public/visible methods
	 * If method cannot be found (due to security or method does not exist), null will be returned
	 * 
	 * @param instance The instance to get the method from
	 * @param methodName The name of the method
	 * @param parameterTypes An array of Class<?> of parameter types of this method
	 * @return The method instance or null
	 */
	public Method getMethod(T instance, String methodName, Class<?>... parameterTypes) {
		try {
			Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
			
			return method;
		} catch (NoSuchMethodException e) {
			return null;
		} catch (SecurityException e) {
			log.info("Unable to get method due to security issue: " + e.getMessage());
			return null;
		}
	}
	
	public boolean isMethodExisted(T instance, String methodName, Class<?>... parameterTypes) {
		return getMethod(instance, methodName, parameterTypes) != null;
	}
	
	public Class<?> getMethodReturnType(T instance, String methodName, Class<?>... parameterTypes) throws Exception {
		Method method = getMethod(instance, methodName, parameterTypes);
		
		if(method == null) {
			throw new Exception("Unable to get method: " + methodName);
		}
		
		return method.getReturnType();
	}
	
	public Class<?> getClazz() {
		return clazz;
	}
	
	public static void main(String[] args) { 
		try {
			ReflectionHelper<String> helper = new ReflectionHelper<String>("java.lang.String");
			log.info(String.valueOf(helper.getClazz()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}