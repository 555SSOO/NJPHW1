import annotations.Autowire;
import annotations.Bean;
import constants.Scope;
import demo.ClassA;
import demo.impl.ClassBImpl;


// This is the class from which we will start the instancing
@Bean(scope= Scope.SINGLETON)
public class RootInstance {

    // This is an interface that is mapped to a singleton class
    @Autowire()
    ClassA ClassA;

    // This is an implementation that is a prototype
    @Autowire()
    ClassBImpl ClassBImpl;

}
