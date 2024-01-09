package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VectorScalarMultiplication extends VectorOperation {

    /**
     * Konstruktor der einen Vektor und ein Skalar annimmt
     * Diese werden auch an den Konstruktor der Oberklasse weitergegeben
     * @param vector der Vektor der weitergeben wird
     * @param scalar das Skalar das weitergeben wird
     * @author Leon Rausch
     */
    public VectorScalarMultiplication(double[] vector, double scalar) {
        super(vector, scalar);
    }


    /**
     * Diese Methode führt die Rechenoperation aus mit den Werten die in
     * den Eigenschaften der Basisklasse gespeichert sind. Sie überschreibt
     * die eine leere Methode der Basisklasse.
     * @author Leon rausch
     */
    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length);

        for (int i = 0; i < vectorA.length; i++) {
            final int index = i;
            executor.execute(() -> result[index] = multiplyVectorAtIndex(index));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double multiplyVectorAtIndex(int index) {
        return vectorA[index] * scalar;
    }
}
