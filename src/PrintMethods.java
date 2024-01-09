public class PrintMethods
{
    /**
     * Schreibt eine von drei verschiedenen Arten von Eingaben in die Konsole
     * Die Überladungen dienen dazu eine Matrix, einen Vektor oder ein Skalar zu schreiben.
     * @param matrix die Matrix die in die Konsole geschrieben werden soll
     * @author Yannick Diehl
     */
    public void printResult(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                if (value == (int) value) {
                    int intValue = (int) value;
                    System.out.print(intValue + " ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Schreibt eine von drei verschiedenen Arten von Eingaben in die Konsole
     * Die Überladungen dienen dazu eine Matrix, einen Vektor oder ein Skalar zu schreiben.
     * @param vector der Vektor die in die Konsole geschrieben werden soll
     * @author Yannick Diehl
     */
    public void printResult(double[] vector) {
        for (double value : vector) {
            if (value == (int) value) {
                int intValue = (int) value;
                System.out.print(intValue + " ");
            } else {
                System.out.print(value + " ");
            }
        }
    }

    /**
     * Schreibt eine von drei verschiedenen Arten von Eingaben in die Konsole
     * Die Überladungen dienen dazu eine Matrix, einen Vektor oder ein Skalar zu schreiben.
     * @param scalar das Skalar die in die Konsole geschrieben werden soll
     * @author Yannick Diehl
     */
   public void printResult(int scalar)
   {
       System.out.println(scalar);
   }
}
