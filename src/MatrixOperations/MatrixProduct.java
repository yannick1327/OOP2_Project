package MatrixOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Die Klasse {@code MatrixProduct} führt das Matrixprodukt zweier Matrizen aus.
 * Sie erbt von der abstrakten Klasse {@code MatrixOperation}.
 * @author Leon Rausch
 */
public class MatrixProduct extends MatrixOperation {

    public MatrixProduct(double[][] matrixA, double[][] matrixB) {
        super(matrixA, matrixB);
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(rows * cols);

        for (int i = 0; i < rows; i++) {
            final int row = i;
            executor.execute(() -> {
                for (int j = 0; j < cols; j++) {
                    result[row][j] = multiplyMatricesAtIndex(row, j);
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

    private double multiplyMatricesAtIndex(int row, int col) {
        double sum = 0.0;
        for (int k = 0; k < matrixA[0].length; k++) {
            sum += matrixA[row][k] * matrixB[k][col];
        }
        return sum;
    }
}
