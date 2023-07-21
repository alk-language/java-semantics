package ro.uaic.info.alk.types;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation used for Alk values to be able to properly
 * format error messages. If an exception is thrown, we can identify
 * the type and thus the proper user-friendly type name.
 *
 * @author Alexandru Lungu
 * @since 5.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeName
{
    /**
     * Retrieve the user-friendly name of the data type.
     *
     * @return   A lower-case string with the name of a data-type.
     */
    String value();
}
