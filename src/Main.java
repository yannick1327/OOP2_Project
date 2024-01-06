import Enums.TasktypeMatrixoperations;
import Enums.TasktypeVectoroperations;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // Beispielmatrizen
//        int[][] matrixA = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        int[][] matrixB = {{9, 8, 7},
//                {6, 5, 4},
//                {3, 2, 1}};

        // System.out.println("Öffnen Sie die \"Matrix.csv\" oder \"Vektor.csv\" und geben Sie dort die gewünschten Matrizen / Vektoren ein.");


        printMatrix(CSVReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/Matrix.csv", 0));

        printVector(CSVReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/Vector.csv", 1));

        boolean validInput = false;

        while (!validInput)
        {
            System.out.println("Bitte geben Sie \"M\" ein wenn Sie eine Matrixberechnung ausführen wollen \nbzw. \"V\" für die Berechnung einer Vektoroperation ein:");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("M"))
            {
                validInput = true;
                TasktypeMatrixoperations selectedTask = SelectMatrixoperation();
            } else if (input.equalsIgnoreCase("V"))
            {
                validInput = true;
                TasktypeVectoroperations selectedTask = SelectVectoroperation();
            } else
            {
                System.out.println("fehlerhafte Eingabe... Versuchen Sie es erneut.");
            }
        }



        // CSVReader.readMatricesFromCSV();

        // Anzahl der Threads (kann angepasst werden)
        // Gibt zurück wie viele Threads der Runtime zur Verfügung stehen (normalerweise so viele wie viele Threads die CPU hat bei mir 16)
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Ergebnis ausgeben
//        printMatrix(result);
//
//        // Ergebnis in eine Textdatei schreiben
//        writeMatrixToFile(convertIntArrayToDoubleArray(result), "result.txt");
    }

    private static TasktypeMatrixoperations SelectMatrixoperation()
    {
        System.out.println("Geben die die Zahl der Operation ein die sie ausführen möchten.");
        System.out.println("Auswahlmöglichkeiten:");
        int enumerator = 1;
        for (TasktypeMatrixoperations tasktype : TasktypeMatrixoperations.values())
        {
            System.out.println(enumerator + ":" + tasktype);
            enumerator++;
        }

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (Integer.parseInt(input))
        {
            case (1):
                return TasktypeMatrixoperations.MatrixAddition;
            case (2):
              return TasktypeMatrixoperations.MatrixSubtraction;
            case (3):
               return TasktypeMatrixoperations.MatrixProduct;
            case (4):
                return TasktypeMatrixoperations.MatrixVectorProduct;
            case (5):
                return TasktypeMatrixoperations.ScalarMultiplication;
            default :
                System.out.println("fehlerhafte Eingabe... Versuchen Sie es erneut.");
               return TasktypeMatrixoperations.Invalid;
        }
    }

    private static TasktypeVectoroperations SelectVectoroperation()
    {
        System.out.println("Geben die die Zahl der Operation ein die sie ausführen möchten.");
        System.out.println("Auswahlmöglichkeiten:");
        int enumerator = 1;
        for (TasktypeVectoroperations tasktype : TasktypeVectoroperations.values())
        {
            System.out.println(enumerator + ":" + tasktype);
            enumerator++;
        }

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (Integer.parseInt(input))
        {
            case (1):
                return TasktypeVectoroperations.VectorAddidtion;
            case (2):
                return TasktypeVectoroperations.VectorSubstraction;
            case (3):
                return TasktypeVectoroperations.VectorProduct;
            case (4):
                return TasktypeVectoroperations.ScalarMultiplication;
            case (5):
                return TasktypeVectoroperations.ScalarProduct;
            default :
                System.out.println("fehlerhafte Eingabe... Versuchen Sie es erneut.");
               return TasktypeVectoroperations.Invalid;
        }
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void printVector(double[] vector) {
        for (double value : vector) {
            System.out.println(value + " ");
        }
    }

    public static void writeResultToFile(double[] result, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double val : result) {
                writer.write(String.valueOf(val));
                writer.newLine();
            }
            System.out.println("Results written to: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeMatrixToFile(double[][] matrix, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double[] row : matrix) {
                for (double val : row) {
                    writer.write(String.valueOf(val));
                    writer.write(" "); // Trennzeichen zwischen den Elementen
                }
                writer.newLine();
            }
            System.out.println("Matrix written to: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[][] convertIntArrayToDoubleArray(int[][] intArray) {
        int rows = intArray.length;
        int cols = intArray[0].length;

        double[][] doubleArray = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                doubleArray[i][j] = (double) intArray[i][j]; // Umwandlung von int zu double
            }
        }
        return doubleArray;
    }
}