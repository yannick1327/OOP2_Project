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

class VectorOperationAddition<T extends Number> extends VectorOperation<T> {

    public VectorOperationAddition(T[] vectorA, T[] vectorB) {
        super(vectorA, vectorB);
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length);

        for (int i = 0; i < vectorA.length; i++) {
            final int index = i;
            executor.execute(() -> result[index] = addVectorsAtIndex(index));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private T addVectorsAtIndex(int index) {
        return (T) new Double(vectorA[index].doubleValue() + vectorB[index].doubleValue());
    }
}

class VectorOperationScalarMultiplication<T extends Number> extends VectorOperation<T> {
    private T scalar;

    public VectorOperationScalarMultiplication(T[] vector, T scalar) {
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
