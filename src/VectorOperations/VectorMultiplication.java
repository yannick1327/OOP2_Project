package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class VectorMultiplication extends VectorOperation {

    public VectorMultiplication(double[] vectorA, double[] vectorB) {
        super(vectorA, vectorB);
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length);

        for (int i = 0; i < vectorA.length; i++) {
            final int index = i;
            executor.execute(() -> result[index] = multiplyVectorsAtIndex(index));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double multiplyVectorsAtIndex(int index) {
        return vectorA[index] * vectorB[index];
    }
}