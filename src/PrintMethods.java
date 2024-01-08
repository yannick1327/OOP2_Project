public class PrintMethods
{
    public void printResult(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public void printResult(double[] vector) {
        for (double value : vector) {
            System.out.println(value + " ");
        }
    }

   public void printResult(int scalar)
   {
       System.out.println(scalar);
   }
}
