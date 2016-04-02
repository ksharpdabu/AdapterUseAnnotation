package info.dabu.adapteruseannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import info.dabu.adapteruseannotation.DelegateAdapter;

/**
 * 注解
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DelegateAdapters {

    Class< ? extends DelegateAdapter>[]  delegateAdapters();
}
