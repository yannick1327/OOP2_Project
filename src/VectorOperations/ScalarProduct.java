package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScalarProduct extends VectorOperation {

    /**
     * Konstruktor der zwei Vektoren annimmt und
     * diese an den Konstruktor der Oberklasse weitergegeben
     * @param vectorA der erste Vektor der Rechenoperation
     * @param vectorB der zweite Vektor der Rechenoperation
     * @author Yannick Diehl
     */
    public ScalarProduct(double[] vectorA, double[] vectorB) {
        super(vectorA, vectorB);
    }

    /**
     * Diese Methode führt die Rechenoperation aus mit den Werten die in
     * den Eigenschaften der Basisklasse gespeichert sind aus. Sie überschreibt
     * die eine leere Methode der Basisklasse.
     * @author Yannick Diehl
     */
    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length * vectorB.length);

        for (int i = 0; i < vectorA.length; i++) {
            final int row = i;
            executor.execute(() -> result[row] = scalarProductAtIndex(row));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 0;
        for (double j : result) {
            i =  i + (int)j;
        }
        result = new double[]{i};
    }

    /**
     * @authors Yannick Diehl
     */
    private double scalarProductAtIndex(int index) {
        return vectorA[index] * vectorB[index];
    }
}