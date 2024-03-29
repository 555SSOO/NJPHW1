package demo.impl;

import annotations.Autowire;
import annotations.Bean;
import constants.Scope;

@Bean(scope= Scope.PROTOTYPE)
public class ClassBImpl {

    @Autowire(verbose = true)
    ClassCImpl classC;

    @Autowire(verbose = true)
    ClassDImpl classD;

    public ClassBImpl(){}
}
