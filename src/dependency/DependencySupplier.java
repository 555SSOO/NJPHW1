package dependency;

import demo.ClassA;
import demo.impl.ClassAImpl;

import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;

class DependencySupplier {


    // We put our mapping in this map by adding entries
    private static Map<Class, Class> implementationMapping = Map.ofEntries(
            entry(ClassA.class, ClassAImpl.class)
    );

    // Get the implementation class from the interface class by looking it up in the map
    static Class getImplementation(Class interfaceClass){

        // If we get the actual implementation instead of the interface, just return it
        if(!interfaceClass.isInterface()){
            return interfaceClass;
        }

        Class requestedClass = getImplementationMapping().get(interfaceClass);

        if(Objects.nonNull(requestedClass)){
            return requestedClass;
        }
        else {
            throw new RuntimeException("No implementation mapped for the provided interface: " + interfaceClass.getName());
        }

    }

    private static Map<Class, Class> getImplementationMapping() {
        return implementationMapping;
    }
}
