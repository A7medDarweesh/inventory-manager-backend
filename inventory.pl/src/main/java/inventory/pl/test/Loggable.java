package inventory.pl.test;

import inventory.pl.helpers.FeatureType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Loggable {
String value();
    FeatureType getType() default FeatureType.TEXT;
}
