package ro.uaic.info.alk.util.functions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface BuiltInMethodAnno
{

    int[] paramNumber();
}
