package MatrixOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ScalarMultiplication<T extends Number> extends MatrixOperation<T> {

    public ScalarMultiplication(T[][] matrix, T scalar) {
        super(matrix, scalar);
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(rows * cols);

        for (int i = 0; i < rows; i++) {
            final int row = i;
            executor.execute(() -> {
                for (int j = 0; j < cols; j++) {
                    result[row][j] = multiplyMatrixElementByScalar(row, j);
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

    private T multiplyMatrixElementByScalar(int row, int col) {
        return (T) new Double(matrixA[row][col].doubleValue() * scalar.doubleValue());
    }
}