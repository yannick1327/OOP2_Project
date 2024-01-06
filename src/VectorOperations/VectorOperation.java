package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

abstract class VectorOperation<T extends Number> {
    protected T[] vectorA;
    protected T[] vectorB;
    protected T[] result;

    public VectorOperation(T[] vectorA, T[] vectorB) {
        this.vectorA = vectorA;
        this.vectorB = vectorB;
        this.result = (T[]) new Number[vectorA.length];
    }

    public abstract void performOperation();

    public void printResult() {
        for (T val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}