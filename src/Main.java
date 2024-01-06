
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Beispielmatrizen
//        int[][] matrixA = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        int[][] matrixB = {{9, 8, 7},
//                {6, 5, 4},
//                {3, 2, 1}};

        System.out.println("Öffnen Sie die \"Matrix.csv\" oder \"Vektor.csv\" und geben Sie dort die gewünschten Matrizen / Vektoren ein.");
        System.out.println("Nachdem Sie das getan haben, geben Sie \"M\" ein wenn Sie eine Matrixberechnung ausführen wollen bzw. \"V\" für die Berechnung einer Vektoroperation ein:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("M")) {
            System.out.println("Welche Matrixoperation möchten Sie ausführen? Auswahlmöglichkeiten:");
        } else if (input.equalsIgnoreCase("V")) {

        } else {
            System.out.println("fehlerhafte Eingabe... Versuchen Sie es erneut.");
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

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
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