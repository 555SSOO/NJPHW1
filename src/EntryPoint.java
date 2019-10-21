import dependency.DependencyInjectionEngine;

public class EntryPoint {

    public static void main(String[] args) {
        // Init the dependency injection engine
        DependencyInjectionEngine dependencyInjectionEngine = new DependencyInjectionEngine();
        // Pass it the root instance to instantiate everything under it
        dependencyInjectionEngine.instantiate(new RootInstance());
    }

}
