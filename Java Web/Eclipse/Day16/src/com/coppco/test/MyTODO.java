package com.coppco.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTODO {
	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	public enum Status {
		STARTED, NOT_STARTED
	}

	String author() default "xxxx";

	Priority priority() default Priority.LOW;

	Status status() default Status.NOT_STARTED;
}
