import dependency.DependencyInjectionEngine;

public class EntryPoint {

    public static void main(String[] args) {
        DependencyInjectionEngine dependencyInjectionEngine = new DependencyInjectionEngine();
        dependencyInjectionEngine.instantiateAllMembers(new RootInstance());
    }

}
