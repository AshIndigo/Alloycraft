package com.ashindigo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a mod that it uses IndigoApi 
 * <p>
 * (No use right now but it would be nice people marked their mod with this)
 * </p>
 * @author Ash Indigo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IndigoMod {

}
