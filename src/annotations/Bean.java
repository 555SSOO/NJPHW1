package annotations;

import constants.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Pogledati AttributeInfo za osnovne informacije!
 * <p>
 * ElementType.TYPE se odnosi na upotrebu samo na klasama.
 * <p>
 * Ako postoji vise parametara koje nemaju default onda je upotreba kljuceva svih parametara obavezna.
 * Npr. upotreba @ClassInfo("Neka vrednost") nije moguca ako imamo vise param. bez default vrednosti i morali bi
 * da navedemo nesto ovako @ClassInfo(value = "Neka vrednost", author = "Zika")
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Bean {
    Scope scope() default Scope.PROTOTYPE;
}
