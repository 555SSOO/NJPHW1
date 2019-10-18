package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Retention je samo jos jedna anotacija kojom definisemo gde ce se anotacija tacno "zadrzati".
 * SOURCE - Anno. ce biti odbacene prilikom kompajliranja. npr: @Override @SuppressWarnings
 * CLASS - Anno. ce biti zadrzane u .class fajlovima ali nece biti dostupne prilikom refleksije (sto se moze videti
 * iz bajt koda)
 * RUNTIME - Anno. ce biti zadrzane u potpunosti i vidljive tokom refleksije sto ce nam biti bitno na ostatku kursa.
 * <p>
 * <p>
 * Target je anotacija koja definise gde sve mozemo primeniti ovu konkretnu anotaciju (AttributeInfo).
 * Ovo polje moze sadrzati i niz vise ElementType-ova.
 * <p>
 * FIELD oznacava da mozemo primeniti anotaciju na atribute klase.
 * <p>
 * Atributi su definisani kao metode.
 * Ako postoji metoda koja se zove "value" onda nije potrebno eksplicitno navoditi kljuc prilikom upotrebe anotacije.
 * Npr. @AttributeInfo("Neka vrednost") i @AttributeInfo(value = "Neka vrednost") su ista stvar ali jedino izvodljivo
 * ako ime prati predjasnje pravilo.
 * Default vrednosti nam daju mogucnost da ne moramo da navedemo neki parametar tokom primene anotacije.
 * Ako postoji vise parametara koje nemaju default onda je upotreba kljuceva svih parametara obavezna.
 * Npr. upotreba @AttributeInfo("Neka vrednost") nije moguca ako imamo vise param. bez default vrednosti i morali bi
 * da navedemo nesto ovako @AttributeInfo(value = "Neka vrednost", pera = "Zika")
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowire {
    boolean verbose() default false;
}
