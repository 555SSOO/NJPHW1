package demo.impl;

import annotations.Autowire;
import annotations.Bean;
import constants.Scope;

@Bean(scope= Scope.SINGLETON)
public class ClassCImpl {

    @Autowire(verbose = true)
    ClassDImpl classD;

    public ClassCImpl(){}
}
