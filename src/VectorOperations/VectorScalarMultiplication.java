package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VectorScalarMultiplication extends VectorOperation {

    public VectorScalarMultiplication(double[] vector, double scalar) {
        super(vector, scalar);
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

    private double multiplyVectorAtIndex(int index) {
        return vectorA[index] * scalar;
    }
}
