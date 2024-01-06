package VectorOperations;

abstract class VectorOperation<T extends Number> {
    protected T[] vectorA;
    protected T[] vectorB;
    protected T scalar;
    protected T[] result;

    public VectorOperation(T[] vectorA, T[] vectorB) {
        this.vectorA = vectorA;
        this.vectorB = vectorB;
        this.result = (T[]) new Number[vectorA.length];
    }

    public VectorOperation(T[] vectorA, T scalar) {
        this.vectorA = vectorA;
        this.scalar = scalar;
        this.result = (T[]) new Number[vectorA.length];
    }

    public abstract void performOperation();

    public void printResult() {
        for (T val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
