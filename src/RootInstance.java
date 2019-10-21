import annotations.Autowire;
import annotations.Bean;
import constants.Scope;
import demo.ClassA;
import demo.impl.ClassBImpl;

// This is the class from which we will start the instancing
@Bean(scope= Scope.SINGLETON)
class RootInstance {

    // This is an interface that is mapped to a singleton class
    @Autowire(verbose=true)
    ClassA classA;

    // This is an implementation that is a prototype
    @Autowire(verbose=true)
    ClassBImpl classBImpl;

}
