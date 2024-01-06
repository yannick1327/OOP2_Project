package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class VectorAdditionAndSubtraction<T extends Number> extends VectorOperation<T> {

    boolean isAddition;
    
    public VectorAdditionAndSubtraction(T[] vectorA, T[] vectorB, boolean isAddition) {
        super(vectorA, vectorB);
        this.isAddition = isAddition;
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length);

        if (isAddition) {
            for (int i = 0; i < vectorA.length; i++) {
                final int index = i;
                executor.execute(() -> result[index] = addVectorsAtIndex(index));
            }
        } else {
            for (int i = 0; i < vectorA.length; i++) {
                final int index = i;
                executor.execute(() -> result[index] = subtractVectorsAtIndex(index));
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private T addVectorsAtIndex(int index) {
        return (T) Double.valueOf(vectorA[index].doubleValue() + vectorB[index].doubleValue());
    }

    private T subtractVectorsAtIndex(int index) {
        return (T) Double.valueOf(vectorA[index].doubleValue() - vectorB[index].doubleValue());
    }
}
