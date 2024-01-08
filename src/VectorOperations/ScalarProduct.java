package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScalarProduct extends VectorOperation {

    public ScalarProduct(double[] vectorA, double[] vectorB) {
        super(vectorA, vectorB);
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length * vectorB.length);

        for (int i = 0; i < vectorA.length; i++) {
            final int row = i;
            executor.execute(() -> result[row] = scalarProductAtIndex(row));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 0;
        for (double j : result) {
            i =  i + (int)j;
        }
        result = new double[]{i};
    }

    private double scalarProductAtIndex(int index) {
        return vectorA[index] * vectorB[index];
    }
}