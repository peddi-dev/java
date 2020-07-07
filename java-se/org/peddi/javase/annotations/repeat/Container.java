package org.peddi.javase.annotations.repeat;

/**
 * Containing annotation type
 * Container of repeatable annotation @Schedule
 * @author peddi
 *
 */
public @interface Container {
	
	/**
	 * array type should be Schedule[], but not String
	 * 
	 */
	Schedule[] value();

}
