package demo.impl;

import annotations.Autowire;
import annotations.Service;
import demo.ClassA;


@Service
public class ClassAImpl implements ClassA {

    @Autowire(verbose = true)
    ClassCImpl classC;

    public ClassAImpl() {
    }

}
