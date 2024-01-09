package VectorOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VectorAdditionAndSubtraction extends VectorOperation {

    /**
     * Eine Eigenschaft die steuert ob die Rechenoperation addiert oder subtrahiert
     * @author Yannick Diehl
     */
   private final boolean isAddition;

    /**
     * Konstruktor der zwei Vektoren und einen Wahrheitswert annimmt und
     * die Vektoren werden an den Konstruktor der Oberklasse weitergegeben
     * der interne Wahrheitswert der Klasse wird von dem eingegeben Wahrheitswert gesetzt
     * @param vectorA
     * @param vectorB
     * @param isAddition
     * @author Yannick Diehl
     */
    public VectorAdditionAndSubtraction(double[] vectorA, double[] vectorB, boolean isAddition) {
        super(vectorA, vectorB);
        this.isAddition = isAddition;
    }

    /**
     * Diese Methode führt die Rechenoperation aus mit den Werten die in
     * den Eigenschaften der Basisklasse gespeichert sind aus. Sie überschreibt
     * die eine leere Methode der Basisklasse.
     * Mit dem Boolean isAddition wird gesteuert ob eine Addition oder Subtraktion durchgeführt wird
     * @author Yannick Diehl
     */
    @Override
    public void performOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(vectorA.length);

        if (isAddition) {
            for (int i = 0; i < vectorA.length; i++) {
                final int index = i;
                executor.execute(() -> result[index] = addVectorsAtIndex(index));
            }
        } else {
            for (int i = 0; i < vectorA.length; i++) {
                final int index = i;
                executor.execute(() -> result[index] = subtractVectorsAtIndex(index));
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Eine Unterfunktion die nur die addition durchführt
     * @authors Yannick Diehl
     */
    private double addVectorsAtIndex(int index) {
        return vectorA[index] + vectorB[index];
    }

    /**
     * Eine Unterfunktion die nur die subtraktion durchführt
     * @authors Yannick Diehl
     */
    private double subtractVectorsAtIndex(int index) {
        return vectorA[index] - vectorB[index];
    }
}
