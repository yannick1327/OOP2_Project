package VectorOperations;

abstract class VectorOperation {
    protected double[] vectorA;
    protected double[] vectorB;
    protected double scalar;
    protected double[] result;

    /**
     * Ein Konstruktor der Basisklasse für Vektoroperationen, der
     * zwei Vektoren als Parameter annimmt
     * @param vectorA der erste Vektor der angenommen wird
     * @param vectorB der zweite Vektor der angenommen wird
     * @author Leon Rausch
     */
    public VectorOperation(double[] vectorA, double[] vectorB) {
        this.vectorA = vectorA;
        this.vectorB = vectorB;
        this.result = new double[vectorA.length];
    }

    /**
     * Ein Konstruktor der Basisklasse für Vektoroperationen, der
     * einen Vektor und ein Skalar als Parameter annimmt
     * @param vectorA der erste Vektor der angenommen wird
     * @param scalar das Skalar das angenommen wird
     * @author Leon Rausch
     */
    public VectorOperation(double[] vectorA, double scalar) {
        this.vectorA = vectorA;
        this.scalar = scalar;
        this.result = new double[vectorA.length];
    }

    /**
     * Eine leere Funktion die von Unterklassen überschieben werden kann,
     * um ihre Rechenoperationen auszuführen
     * @author Leon Rausch
     */
    public abstract void performOperation();

    /**
     * Gibt das Ergebnis welches mit "performOperation" berechnet wurde zurück
     * @return das Ergebnis der Rechenoperation
     * @author Leon Rausch
     */
    public double[] returnResult() {
        return result;
    }
}
