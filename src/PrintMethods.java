public class PrintMethods
{
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

   public void printResult(int scalar)
   {
       System.out.println(scalar);
   }
}
