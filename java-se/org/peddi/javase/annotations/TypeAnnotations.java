package org.peddi.javase.annotations;

/**
 * 
 * 
 * As of the Java SE 8 release, annotations can also be applied to the use of types. Here are some examples:

1. Class instance creation expression:
    new @Interned MyObject();
2. Type cast:
    myString = (@NonNull String) str;
3. implements clause:
    class UnmodifiableList<T> implements
        @Readonly List<@Readonly T> { ... }
4. Thrown exception declaration:
    void monitorTemperature() throws
        @Critical TemperatureException { ... }
 *
 * @author peddi
 *
 */

public class TypeAnnotations {

}
