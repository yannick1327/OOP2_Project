import Enums.TasktypeMatrixoperations;
import Enums.TasktypeVectoroperations;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //System.out.println("Bitte geben sie eine Zahl ein die mit dem Vektor / der Matrix verrechnet werden soll.");
        // System.out.println("Öffnen Sie die \"Vektor.csv\" und geben Sie dort den gewünschten Vektor ein.");
        //System.out.println("Öffnen Sie die \"FirstInput.csv\" und geben Sie dort die gewünschte Matrix ein.");
        PrintMethods printMethods = new PrintMethods();
        CSVReader csvReader = new CSVReader();

        printMethods.printResult(csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv"));
        printMethods.printResult(csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv"));

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
            System.out.println("Das Programm ist nun beendet.");
        }
    }

    private static TasktypeMatrixoperations SelectMatrixoperation()
    {
        System.out.println("Geben die die Zahl der Operation ein die sie ausführen möchten.");
        System.out.println("Auswahlmöglichkeiten:");
        int enumerator = 1;
        for (TasktypeMatrixoperations taskType : TasktypeMatrixoperations.values())
        {
            if (taskType == TasktypeMatrixoperations.Invalid) continue;
            System.out.println(enumerator + ":" + taskType);
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
        scanner.reset();
        return returnValue;
    }

    private static TasktypeVectoroperations SelectVectoroperation()
    {
        System.out.println("Geben die die Zahl der Operation ein die sie ausführen möchten.");
        System.out.println("Auswahlmöglichkeiten:");
        int enumerator = 1;
        for (TasktypeVectoroperations taskType : TasktypeVectoroperations.values())
        {
            if (taskType == TasktypeVectoroperations.Invalid) continue;
            System.out.println(enumerator + ":" + taskType);
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
        scanner.reset();
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
        //double[] result = calculationClass.returnResult();
        PrintMethods printMethods = new PrintMethods();
        //printMethods.printResult(result);

        System.out.println("Geben sie \"J\" ein das Ergebnis auch in die CSV Datei geschrieben werden soll.");
        System.out.println("Nach der Eingabe wird das Programm beendet.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("J")){
            // writeResultToFile();
            System.out.println("t1v");
        }
        scanner.reset();
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
        //double[] result = calculationClass.returnResult();
        PrintMethods printMethods = new PrintMethods();
        //printMethods.printResult(result);

        System.out.println("Geben sie \"J\" ein das Ergebnis auch in die CSV Datei geschrieben werden soll.");
        System.out.println("Nach der Eingabe wird das Programm beendet.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("J")){
            // writeResultToFile();
            System.out.println("t1m");
        }
        scanner.reset();
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

//class MyThread extends Thread {
//    @Override
//    public void run() {
//        // Code, den der Thread ausführen soll
//    }
//}
//
//class MyRunnable implements Runnable {
//    @Override
//    public void run() {
//        // Code, den der Thread ausführen soll
//    }
//}
