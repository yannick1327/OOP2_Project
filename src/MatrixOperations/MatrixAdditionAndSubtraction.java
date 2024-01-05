package MatrixOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MatrixAdditionAndSubtraction<T extends Number> extends MatrixOperation<T> {

    private boolean isAddition;

    public MatrixAdditionAndSubtraction(T[][] matrixA, T[][] matrixB, boolean isAddition) {
        super(matrixA, matrixB);
        this.isAddition = isAddition;
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(rows * cols);

        for (int i = 0; i < rows; i++) {
            final int row = i;
            executor.execute(() -> {
                for (int j = 0; j < cols; j++) {
                    result[row][j] = isAddition ? addMatricesAtIndex(row, j) : subtractMatricesAtIndex(row, j);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private T addMatricesAtIndex(int row, int col) {
        return (T) new Double(matrixA[row][col].doubleValue() + matrixB[row][col].doubleValue());
    }

    private T subtractMatricesAtIndex(int row, int col) {
        return (T) new Double(matrixA[row][col].doubleValue() - matrixB[row][col].doubleValue());
    }
}
