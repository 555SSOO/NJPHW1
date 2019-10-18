package dependency;


import annotations.Autowire;
import annotations.Bean;
import constants.Scope;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DependencyInjectionEngine {


    private List<Object> instantiatedSingletons = new ArrayList<>();

    public void instantiateAllMembers(Object parentInstance){


//        Class implementationToInitialize = DependencySupplier.getImplementation(parentInstance.getClass());

        // If the class is already instantiated as a singleton
        if(getInstantiatedSingletons().contains(parentInstance)){
            System.out.println("This class is already instantiated as a singleton!");
            return;
        }

        // Instantiate all the autowired fields in the class
        instantiateFields(parentInstance);

    }

    @SuppressWarnings("unchecked")
    private void instantiateFields(Object parentInstance) {

        Arrays.asList(parentInstance.getClass().getDeclaredFields()).forEach(
                field -> {
                    Autowire autowireAnnotation = field.getAnnotation(Autowire.class);
                    if(Objects.nonNull(autowireAnnotation)){

                        System.out.println(field.getName());

                        try {
                            Class classField = Class.forName(field.getType().toString());
                            Constructor<?> constructor = classField.getConstructor();
                            Object object = constructor.newInstance();

                            addToListIfSingleton(object);

                            field.setAccessible(true);
                            field.set(parentInstance, object);

                            if(autowireAnnotation.verbose()){
                                System.out.println("Initialized" + field.getType() + " " +  field.getName() +
                                        " in " + field.getDeclaringClass() +  " on " + LocalDateTime.now() +
                                        " with <param.instance.hashCode");
                            }

                            instantiateAllMembers(object);

                        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                            System.out.println("Could not instantiate a type");
                            e.printStackTrace();
                        }

                    }
                }
        );



    }

    private void addToListIfSingleton(Object instance){

        Bean beanAnnotation = instance.getClass().getAnnotation(Bean.class);
        if(Objects.nonNull(beanAnnotation) && beanAnnotation.scope().equals(Scope.SINGLETON)){
            getInstantiatedSingletons().add(instance);
            System.out.println("Added to list of singletons");
        }

    }

    private List<Object> getInstantiatedSingletons() {
        return instantiatedSingletons;
    }
}
