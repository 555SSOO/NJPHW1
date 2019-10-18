import annotations.Autowire;
import demo.ClassX;
import demo.impl.ClassYImpl;

public class RootInstance {

    @Autowire()
    ClassX classX;

    @Autowire()
    ClassYImpl classYImpl;

}
