package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VectorScalarMultiplication<T extends Number> extends VectorOperation<T> {

    private T scalar;

    public VectorScalarMultiplication(T[] vector, T scalar) {
        super(vector, null);
        this.scalar = scalar;
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length);

        for (int i = 0; i < vectorA.length; i++) {
            final int index = i;
            executor.execute(() -> result[index] = multiplyVectorAtIndex(index));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private T multiplyVectorAtIndex(int index) {
        return (T) new Double(vectorA[index].doubleValue() * scalar.doubleValue());
    }
}
