package org.peddi.java.se11.lambdas;

public  class CalculatorDemo<T extends  Number> {

    interface  ArithmaticOperation<T extends  Number> {
        T operation(T a, T b );
    }

    public  T operateBinary(T a, T  b, ArithmaticOperation<T> op){
        return  op.operation(a, b);

    }
}
