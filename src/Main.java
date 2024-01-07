import Enums.TasktypeMatrixoperations;
import Enums.TasktypeVectoroperations;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Beispielmatrizen
//        int[][] matrixA = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        int[][] matrixB = {{9, 8, 7},
//                {6, 5, 4},
//                {3, 2, 1}};

        // Anzahl der Threads (kann angepasst werden)
        // Gibt zurück wie viele Threads der Runtime zur Verfügung stehen (normalerweise so viele wie viele Threads die CPU hat bei mir 16)
        // int numThreads = Runtime.getRuntime().availableProcessors();
        // ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        //System.out.println("Bitte geben sie eine Zahl ein die mit dem Vektor / der Matrix verrechnet werden soll.");
        // System.out.println("Öffnen Sie die \"Vektor.csv\" und geben Sie dort den gewünschten Vektor ein.");
        //System.out.println("Öffnen Sie die \"FileInput.csv\" und geben Sie dort die gewünschte Matrix ein.");


        printMatrix(CSVReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FileInput.csv"));

        printVector(CSVReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv"));

        boolean validInput = false;

        while (!validInput)
        {
            System.out.println("Bitte geben Sie \"M\" ein wenn Sie eine Matrixberechnung ausführen wollen \nbzw. \"V\" für die Berechnung einer Vektoroperation ein:");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("M"))
            {
                TasktypeMatrixoperations selectedTask = SelectMatrixoperation();
                if (selectedTask != TasktypeMatrixoperations.Invalid){
                    validInput = true;
                    RunSelectedTask(selectedTask);
                    break;
                }

            } else if (input.equalsIgnoreCase("V"))
            {
                TasktypeVectoroperations selectedTask = SelectVectoroperation();
                if (selectedTask != TasktypeVectoroperations.Invalid){
                    validInput = true;
                    RunSelectedTask(selectedTask);
                    break;
                }
            } else
            {
                System.out.println("fehlerhafte Eingabe... Versuchen Sie es erneut.");
            }
            scanner.close();
        }
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

        TasktypeMatrixoperations returnValue;
        switch (Integer.parseInt(input))
        {
            case 1:
                returnValue = TasktypeMatrixoperations.MatrixAddition;
                break;
            case 2:
                returnValue = TasktypeMatrixoperations.MatrixSubtraction;
                break;
            case 3:
                returnValue = TasktypeMatrixoperations.MatrixProduct;
                break;
            case 4:
                returnValue = TasktypeMatrixoperations.MatrixVectorProduct;
                break;
            case 5:
                returnValue = TasktypeMatrixoperations.ScalarMultiplication;
                break;
            default:
                System.out.println("fehlerhafte Eingabe... Versuchen Sie es erneut.");
                returnValue = TasktypeMatrixoperations.Invalid;
                break;
        }
        scanner.close();
        return returnValue;
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

        TasktypeVectoroperations returnValue;
        switch (Integer.parseInt(input))
        {
            case (1):
                returnValue = TasktypeVectoroperations.VectorAddidtion;
                break;
            case (2):
                returnValue = TasktypeVectoroperations.VectorSubstraction;
                break;
            case (3):
                returnValue = TasktypeVectoroperations.VectorProduct;
                break;
            case (4):
                returnValue = TasktypeVectoroperations.ScalarMultiplication;
                break;
            case (5):
                returnValue = TasktypeVectoroperations.ScalarProduct;
                break;
            default :
                System.out.println("fehlerhafte Eingabe... Versuchen Sie es erneut.");
                returnValue = TasktypeVectoroperations.Invalid;
        }
        scanner.close();
        return returnValue;
    }

    private static void RunSelectedTask(TasktypeVectoroperations selectedTask)
    {
        if (selectedTask == TasktypeVectoroperations.Invalid) {
            return;
        }

        switch (selectedTask){
            case VectorAddidtion :
                //TODO eingabe in die CVS fordern

                //VectorAdditionAndSubtraction calculationClass = new VectorAdditionAndSubtraction<>(,,true);
                break;
            case VectorSubstraction:
                //TODO eingabe in die CVS fordern

                //VectorAdditionAndSubtraction calculationClass = new VectorAdditionAndSubtraction<>(,,false);
                break;
            case VectorProduct:
                //TODO eingabe in die CVS fordern

                //VectorProduct calculationClass = new VectorProduct();
                break;
            case ScalarMultiplication:
                //TODO eingabe in die CVS fordern

                //ScalarMultiplication calculationClass = new ScalarMultiplication<>();
                break;
            case ScalarProduct:
                //TODO eingabe in die CVS fordern

                //VectorScalarMultiplication calculationClass = new VectorScalarMultiplication<>();
                break;
        }

        //calculationClass.performOperation();
        //calculationClass.returnResult();
        //TODO das result in der Console ausgeben

        System.out.println("Geben sie \"J\" ein das Ergebnis auch in die CSV Datei geschrieben werden soll.");
        System.out.println("Nach der Eingabe wird das Programm beendet.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("J")){
            // writeResultToFile();
        }
    }

    private static void RunSelectedTask(TasktypeMatrixoperations selectedTask)
    {
        if (selectedTask == TasktypeMatrixoperations.Invalid) {
            return;
        }

        switch (selectedTask){
            case MatrixAddition:
                //TODO eingabe in die CVS fordern


                //MatrixAdditionAndSubtraction calculationClass  = new MatrixAdditionAndSubtraction<>();
                break;
            case MatrixSubtraction:
                //TODO eingabe in die CVS fordern

                //MatrixAdditionAndSubtraction calculationClass  = new MatrixAdditionAndSubtraction<>();
                break;
            case MatrixProduct:
                //TODO eingabe in die CVS fordern

                //MatrixProduct calculationClass = new MatrixProduct();
                break;
            case MatrixVectorProduct:
                //TODO eingabe in die CVS fordern

                // 2ter vektor ist einfach nur eindimesional deshalb der selbe aufruf
                //MatrixProduct calculationClass = new MatrixProduct();
                break;
            case ScalarMultiplication:
                //TODO eingabe in die CVS fordern

                //ScalarMultiplication calculationClass = new ScalarMultiplication<>();
                break;
        }
        //calculationClass.performOperation();
        //calculationClass.returnResult();
        //TODO das result in der Console ausgeben

        System.out.println("Geben sie \"J\" ein das Ergebnis auch in die CSV Datei geschrieben werden soll.");
        System.out.println("Nach der Eingabe wird das Programm beendet.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("J")){
            // writeResultToFile();
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