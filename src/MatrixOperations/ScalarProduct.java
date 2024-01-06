package MatrixOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//
// sehr wahrscheinlich bullshit und genau das gleiche wie die Klasse ScalarMultiplication
//

public class ScalarProduct<T extends Number> extends MatrixOperation<T> {

    public ScalarProduct(T[][] matrix, T scalar) {
        super(matrix, scalar);
    }

    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(rows * cols);

        for (int i = 0; i < rows; i++) {
            final int row = i;
            executor.execute(() -> {
                for (int j = 0; j < cols; j++) {
                    result[row][j] = scalarProductAtIndex(row, j);
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

    private T scalarProductAtIndex(int row, int col) {
        return (T) Double.valueOf(matrixA[row][col].doubleValue() * scalar.doubleValue());
    }
}