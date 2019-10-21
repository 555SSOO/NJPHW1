package demo.impl;

import annotations.Bean;
import constants.Scope;

@Bean(scope= Scope.PROTOTYPE)
public class ClassDImpl {
    public ClassDImpl(){}
}
