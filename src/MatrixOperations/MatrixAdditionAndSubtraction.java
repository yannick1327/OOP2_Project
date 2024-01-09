package MatrixOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Die Klasse {@code MatrixAdditionAndSubtraction} führt je nach Eingaben des Nutzers
 * die Addition oder Subtraktion zweier Matrizen aus.
 * Sie erbt von der abstrakten Klasse {@code MatrixOperation}.
 * @author Leon Rausch
 */
 public class MatrixAdditionAndSubtraction extends MatrixOperation {

    private boolean isAddition;

    public MatrixAdditionAndSubtraction(double[][] matrixA, double[][] matrixB, boolean isAddition) {
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

    private double addMatricesAtIndex(int row, int col) {
        return matrixA[row][col] + matrixB[row][col];
    }

    private double subtractMatricesAtIndex(int row, int col) {
        return matrixA[row][col] - matrixB[row][col];
    }
}
