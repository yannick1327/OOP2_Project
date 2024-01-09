package MatrixOperations;

/**
 * Die abstrakte Klasse {@code MatrixOperation} bildet die Grundlage für Matrixoperationen
 * wie Addition, Subtraktion, Multiplikation, Skalarmultiplikation usw.
 * Sie nimmt im Konstruktor entweder zwei Matrizen oder eine Matrix und einen Skalar an.
 * Die Methode {@code performOperation()} muss dabei von jeder erbenden Klasse implementiert werden.
 * @author Leon Rausch
 */
abstract class MatrixOperation{
    protected double[][] matrixA;
    protected double[][] matrixB;
    protected double scalar;
    protected double[][] result;
    protected int rows;
    protected int cols;

    public MatrixOperation(double[][] matrixA, double[][] matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rows = matrixA.length;
        this.cols = matrixA[0].length;
        this.result = new double[rows][cols];
    }

    public MatrixOperation(double[][] matrix, double scalar) {
        this.matrixA = matrix;
        this.scalar = scalar;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.result = new double[rows][cols];
    }

    public abstract void performOperation();

    public double[][] returnResult() {
       return result;
    }
}