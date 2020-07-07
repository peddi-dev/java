package org.peddi.javase.annotations;

/**
 * Predfined Annotations are : 
 *  @Deprecated
 *  @FunctionalInterface
 * 	@Override
 * 	@SuppressWarnings
 *  @SafeVarargs
 * 
 * @author peddi
 *
 */
public class PredefinedAnnotationsDemo {
	
	@SuppressWarnings({"unchecked", "deprecation"})
	@Override
	public String toString() {
		return "Predefined Annotations Demo - @Deprecated @Override @SuppressWarnings @FunctionalInterface @SafeVarargs ";
		
	}

}
