package VectorOperations;

abstract class VectorOperation {
    protected double[] vectorA;
    protected double[] vectorB;
    protected double scalar;
    protected double[] result;

    public VectorOperation(double[] vectorA, double[] vectorB) {
        this.vectorA = vectorA;
        this.vectorB = vectorB;
        this.result = new double[vectorA.length];
    }

    public VectorOperation(double[] vectorA, double scalar) {
        this.vectorA = vectorA;
        this.scalar = scalar;
        this.result = new double[vectorA.length];
    }

    public abstract void performOperation();

    public double[] returnResult() {
        return result;
    }
}
