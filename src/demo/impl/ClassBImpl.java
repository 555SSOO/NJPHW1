package demo.impl;

import annotations.Bean;
import constants.Scope;

@Bean(scope= Scope.PROTOTYPE)
public class ClassBImpl {
    public ClassBImpl(){}
}
