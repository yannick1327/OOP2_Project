import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Beispielmatrizen
        int[][] matrixA = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] matrixB = {{9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}};

        // Größe der Matrizen
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        // Ergebnismatrix initialisieren
        int[][] result = new int[rowsA][colsB];

        // Anzahl der Threads (kann angepasst werden)
        // Gibt zurück wie viele Threads der Runtime zur Verfügung stehen (normalerweise so viele wie viele Threads die CPU hat bei mir 16)
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Multiplikation in Threads aufteilen
        for (int i = 0; i < rowsA; i++) {
            final int row = i;
            executor.submit(() -> multiplyRowByMatrix(matrixA, matrixB, result, row));
        }

        // Warten, bis alle Threads abgeschlossen sind
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ergebnis ausgeben
        printMatrix(result);
    }

    private static void multiplyRowByMatrix(int[][] matrixA, int[][] matrixB, int[][] result, int row) {
        for (int colB = 0; colB < matrixB[0].length; colB++) {
            for (int k = 0; k < matrixA[0].length; k++) {
                result[row][colB] += matrixA[row][k] * matrixB[k][colB];
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}