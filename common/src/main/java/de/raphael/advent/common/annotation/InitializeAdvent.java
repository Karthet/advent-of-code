package de.raphael.advent.common.annotation;

import de.raphael.advent.common.Programm;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
public @interface InitializeAdvent {
    String name();
    String day();
    String year();
    Class<? extends Programm> programm1();
    Class<? extends Programm> programm2();
}
