package demo.impl;

import annotations.Autowire;
import annotations.Service;

@Service
public class ClassCImpl {

    @Autowire(verbose = true)
    ClassDImpl classD;

    public ClassCImpl(){}
}
