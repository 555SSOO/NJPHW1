package demo.impl;

import annotations.Autowire;
import annotations.Bean;
import constants.Scope;
import demo.ClassA;


@Bean(scope = Scope.SINGLETON)
public class ClassAImpl implements ClassA {

    @Autowire(verbose = true)
    ClassCImpl classC;

    public ClassAImpl() {
    }

}
