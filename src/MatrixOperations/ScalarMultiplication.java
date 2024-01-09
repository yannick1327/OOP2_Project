package MatrixOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Die Klasse {@code ScalarMultiplication} führt die Skalarmultiplikation einer Matrix mit einem Skalar aus.
 * Sie erbt von der abstrakten Klasse {@code MatrixOperation}.
 * @author Leon Rausch
 */
public class ScalarMultiplication extends MatrixOperation {

    public ScalarMultiplication(double[][] matrix, double scalar) {
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

    private double multiplyMatrixElementByScalar(int row, int col) {
        return matrixA[row][col] * scalar;
    }
}