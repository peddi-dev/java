package org.peddi.javase.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

/**
 * meta-annotations:
 * Annotations that apply to other annotations are called meta-annotations
 * Several meta-annotations are defined in the java.lang.annotaion package
 * 
 * @Retention - Specifies how the marked annotation is stored.
 * 		RetentionPolicy.SOURCE - available only at source level, ignored by compiler
 * 		RetentionPolicy.CLASS -  available in the class file, retained by compiler, but ignored by the JVM
 * 		RetentionPolicy.RUNTIME - available at runtime , retained by JVM
 * @Documented - If annotation type T is defined with this meta annotation then
 *               whenever T applied on an element, that element should be documented using javadoc tool
 *  
 *  
 * @Target - Indicates what kind of elements can use the given annotation
 *  ElementType.ANNOTATION_TYPE can be applied to an annotation type.
 *  ElementType.CONSTRUCTOR can be applied to a constructor.
 *  ElementType.FIELD can be applied to a field or property.
 *  ElementType.LOCAL_VARIABLE can be applied to a local variable.
 *  ElementType.METHOD can be applied to a method-level annotation.
 *  ElementType.PACKAGE can be applied to a package declaration.
 *  ElementType.PARAMETER can be applied to the parameters of a method.
 *  ElementType.TYPE can be applied to any element of a class.
 * 
 * @Inherited - Indicates that the annotation type can be inherited from the super class
 * 
 * @Repeatable - Annotation type with this meta annotation can be applied more than once on an element
 * 
 * 
 * 
 * 
 * 
 * @author peddi
 *
 */

@Retention(RetentionPolicy.CLASS)
@Documented
@Inherited
@Target( {ElementType.TYPE, ElementType.METHOD})
public @interface MetaAnnotaionsDemo {

}
