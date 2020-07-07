package org.peddi.javase.annotations.repeat;
import java.lang.annotation.Repeatable;

/**
 * How to read repeated annotation using reflection
 *  1. Get the container annotation using AnnotatedElement.getAnnotation(Class<T>)
 *  2. Get repeated annotations from the container annotation using AnnotatedElement.getAnnotationsByType(Class<T>) 
 * 
 * @author peddi
 *
 */
@Repeatable(Container.class)
public @interface Schedule {
	String dayOfMonth() default "first";
	String dayOfWeek() default "Fri";
	int hour() default 12; 
}
