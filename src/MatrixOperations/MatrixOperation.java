package MatrixOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

abstract class MatrixOperation<T extends Number> {
    protected T[][] matrixA;
    protected T[][] matrixB;
    protected T scalar;
    protected T[][] result;
    protected int rows;
    protected int cols;

    public MatrixOperation(T[][] matrixA, T[][] matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rows = matrixA.length;
        this.cols = matrixA[0].length;
        this.result = (T[][]) new Number[rows][cols];
    }

    public MatrixOperation(T[][] matrix, T scalar) {
        this.matrixA = matrix;
        this.scalar = scalar;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.result = (T[][]) new Number[rows][cols];
    }

    public abstract void performOperation();

    public void printResult() {
        for (T[] row : result) {
            for (T val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}