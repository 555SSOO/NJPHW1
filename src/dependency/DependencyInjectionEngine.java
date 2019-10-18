package dependency;


import annotations.Bean;
import constants.Scope;

import java.util.ArrayList;
import java.util.List;

public class DependencyInjectionEngine {


    private List<Class> initializedSingletons = new ArrayList<>();

    public void initializeClass(Class classToInitialize){


        Class implementationToInitialize = DependencySupplier.getImplementation(classToInitialize);

        // If the class is already initialized as a singleton
        if(getInitializedSingletons().contains(implementationToInitialize)){
            System.out.println("This class is already initialized as a singleton!");
            return;
        }


//        Field[] fields = implementationToInitialize.getDeclaredFields();

        // iterating over an array
//        for (int i = 0; i < fields.length; i++) {
//            Annotation[] an = fields[i].getDeclaredAnnotations();
//            for (int j = 0; j < an.length; j++) {
//                System.out.println(an[j].toString());
//            }
//        }

        Bean beanAnnotationForClass = (Bean) implementationToInitialize.getAnnotation(Bean.class);

        if(beanAnnotationForClass.scope().equals(Scope.SINGLETON)){
            getInitializedSingletons().add(implementationToInitialize);
            System.out.println("Added to list of singletons");
            return;
        }

        System.out.println("its a prototype");
    }

    private List<Class> getInitializedSingletons() {
        return initializedSingletons;
    }
}
