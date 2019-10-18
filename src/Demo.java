import annotations.Autowire;
import annotations.Bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Bean()
public class Demo {




//    @Autowire("Ovo je neki atribut")
//    int att = 1;
//
//    /**
//     * @deprecated Opisni tekst zasto je nesto izaslo iz upotrebe i referenca na zamenski kod
//     */
//    @Deprecated
//    public static void deprecatedHW() {
//        System.out.println("Hello world");
//    }
//
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public static void main(String[] args) {
//        try {
//
//        	// Dva nacina dolazenja do "meta podataka" neke klase u vidu instace klase Class
//            Class cl = Class.forName("AnnotationDemo");
////			Class c1 = AnnotationDemo.class;
//
//            Bean ci = (Bean) cl.getAnnotation(Bean.class);
//            System.out.println("Anotacija ove klase: " + ci);
//            System.out.println("Autor: " + ci.author());
//            System.out.println("Verzija: " + ci.version());
//
//            Method m = cl.getDeclaredMethod("f");
//            Component mi = m.getAnnotation(Component.class);
//            System.out.println("Anotacija metode f(): " + mi);
//            System.out.println("Depricated: " + mi.depricated());
//            System.out.println("Version: " + mi.version());
//
//            Field fl = cl.getDeclaredField("att");
//            Autowire ai = fl.getAnnotation(Autowire.class);
//            System.out.println("Anotacija atributa att: " + ai);
//            System.out.println("value: " + ai.value());
//
//            AnnotationDemo.deprecatedHW();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    @Component(depricated = false, version = "1.0")
//    public void f() {
//        System.out.println("Ovo je metoda f().");
//    }
}
