package com.ashindigo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a mod for Auto-Json creation (Or some other use)
 * @author Ash Indigo
 */
@Deprecated // May be scraped
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UtilsJson {

}
