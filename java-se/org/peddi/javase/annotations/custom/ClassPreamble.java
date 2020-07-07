package org.peddi.javase.annotations.custom;

import java.lang.annotation.Documented;

// Author: John Doe
// Date: 3/17/2002
// Current revision: 6
// Last modified: 4/12/2004
// By: Jane Doe
// Reviewers: Alice, Bill, Cindy
/**
 *  Custom Annotation
 * @author peddi
 *
 */
@Documented
public @interface ClassPreamble {
	
	String author();
	String date();
	String currentRevision() default "1";
	String lastModified() default "N/A";
	String lastModifiedBy() default "N/A";
	String[] reviewers();

}
