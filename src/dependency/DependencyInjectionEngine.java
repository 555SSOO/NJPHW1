package dependency;

import annotations.Autowire;
import annotations.Bean;
import annotations.Service;
import constants.Scope;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class DependencyInjectionEngine {

    private final static Logger LOG = Logger.getLogger(DependencyInjectionEngine.class.getName());

    private List<Object> instantiatedSingletons = new ArrayList<>();

    public void instantiate(Object parentInstance) {
        // Instantiate all the autowired fields in the class
        instantiateFields(parentInstance);
    }

    private void instantiateFields(Object parentInstance) {
        // Go trough each field in the class
        Arrays.asList(parentInstance.getClass().getDeclaredFields()).forEach(
                field -> {
                    // If the field is annotated as autowire, instantiate it, otherwise ignore it
                    Autowire autowireAnnotation = field.getAnnotation(Autowire.class);
                    if (Objects.nonNull(autowireAnnotation)) {

                        // Try to get the object from the singleton list
                        Object singleton = getFromSingletonList(field.getType());

                        // If the class is not in the singleton list, instantiate it
                        if (Objects.isNull(singleton)) {
                            Object object = instantiateClass(field, parentInstance, autowireAnnotation);
                            instantiate(object);
                        }
                        // Else set the field from the singleton list
                        else {
                            setField(field, parentInstance, singleton);
                        }

                    }
                }
        );
    }

    @SuppressWarnings("unchecked")
    private Object instantiateClass(Field field, Object parentInstance, Autowire autowireAnnotation) {
        try {
            // Get the implementation class from the supplier
            Class classToInstantiate = DependencySupplier.getImplementation(field.getType());
            // Get the constructor so we can create an object
            Constructor<?> constructor = classToInstantiate.getConstructor();
            // Create an object from the class (instantiate the class)
            Object object = constructor.newInstance();
            // If the class is a singleton, add it to the list
            addToListIfSingleton(object);
            // Bind the new object to the parent instance field
            setField(field, parentInstance, object);
            // If verbose is set, print out some info
            if (autowireAnnotation.verbose()) {
                System.out.println("Initialized " + object.getClass() + " " + field.getName() +
                        " in " + field.getDeclaringClass() + " on " + LocalDateTime.now() +
                        " with " + object.hashCode());
            }
            return object;
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            LOG.severe("Could not instantiate a type");
            return null;
        }
    }

    private void setField(Field field, Object parentInstance, Object object) {
        try {
            // Make the field in the parent class accessible so we can bind it to the instance we created
            field.setAccessible(true);
            // Bind the parent field to the instance
            field.set(parentInstance, object);
        } catch (IllegalAccessException e) {
            LOG.severe("Could not set the fields on the parent instance");
        }
    }

    private Object getFromSingletonList(Class type) {
        // This returns the first object of the class type, or null if there isn't one
        return getInstantiatedSingletons().stream().filter(object -> object.getClass().equals(type)).findFirst().orElse(null);
    }

    private void addToListIfSingleton(Object instance) {
        // If the class is annotated as a singleton, put it in the list
        Bean beanAnnotation = instance.getClass().getAnnotation(Bean.class);

        // TODO better solution for this?
        Service serviceAnnotation = instance.getClass().getAnnotation(Service.class);
        if ((Objects.nonNull(beanAnnotation) && beanAnnotation.scope().equals(Scope.SINGLETON)) || Objects.nonNull(serviceAnnotation)) {
            getInstantiatedSingletons().add(instance);
        }
    }

    private List<Object> getInstantiatedSingletons() {
        return instantiatedSingletons;
    }
}
