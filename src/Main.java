import Enums.TasktypeMatrixoperations;
import Enums.TasktypeVectoroperations;
import MatrixOperations.MatrixAdditionAndSubtraction;
import MatrixOperations.MatrixProduct;
import MatrixOperations.ScalarMultiplication;
import VectorOperations.VectorAdditionAndSubtraction;
import VectorOperations.VectorProduct;
import VectorOperations.VectorScalarMultiplication;

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
                scanner.reset();
                TasktypeMatrixoperations selectedTask = SelectMatrixoperation();
                if (selectedTask != TasktypeMatrixoperations.Invalid){
                    validInput = true;
                    RunSelectedTask(selectedTask);
                    break;
                }

            } else if (input.equalsIgnoreCase("V"))
            {
                scanner.reset();
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
            System.out.println(enumerator + ": " + taskType);
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
            System.out.println(enumerator + ": " + taskType);
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

        CSVReader csvReader = new CSVReader();
        Scanner scanner = new Scanner(System.in);

        if (selectedTask == TasktypeVectoroperations.VectorAddidtion){
            System.out.println("Bitte geben die in die \"FirstInput.csv\" einen Vektor ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" einen zweiten Vektor ein der zu dem ersten addiert werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C"))  return;
            double[] firstInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[] secondInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //VectorAdditionAndSubtraction calculationClass = new VectorAdditionAndSubtraction<>(firstInput,secondInput,false);

        } else if (selectedTask == TasktypeVectoroperations.VectorSubstraction) {
            System.out.println("Bitte geben die in die \"FirstInput.csv\" einen Vektor ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" einen zweiten Vektor ein der vom ersten subtrahiert werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C"))  return;
            double[] firstInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[] secondInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //VectorAdditionAndSubtraction calculationClass = new VectorAdditionAndSubtraction<>(firstInput,secondInput,true);

        } else if (selectedTask == TasktypeVectoroperations.VectorProduct) {
            System.out.println("Bitte geben die in die \"FirstInput.csv\" einen Vektor ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" einen zweiten Vektor, mit dem das Kreuzprodukt gebildet werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;
            double[] firstInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[] secondInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //VectorProduct calculationClass = new VectorProduct(firstInput,secondInput);

        } else if (selectedTask == TasktypeVectoroperations.ScalarMultiplication){
            System.out.println("Bitte geben die in die \"FirstInput.csv\" einen Vektor ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" ein Skalar ein, mit dem eine Skalarmultiplikation durchgeführt werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;

            double[] firstInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[] secondInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //ScalarMultiplication calculationClass = new ScalarMultiplication<>();

        } else if (selectedTask == TasktypeVectoroperations.ScalarProduct) {
            System.out.println("Bitte geben die in die \"FirstInput.csv\" ein Skalar ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" einen Vektor ein, mit dem das Skalarprodukt gebildet werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;
            double[] firstInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[] secondInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //VectorScalarMultiplication calculationClass = new VectorScalarMultiplication<>(firstInput,secondInput[0]);
        } else {

           System.out.println("%% Ein Fehler ist aufgetreten beim matching des selectedTasks. %%");
        }

        //calculationClass.performOperation();
        //double[] result = calculationClass.returnResult();
        PrintMethods printMethods = new PrintMethods();
        //printMethods.printResult(result);

        System.out.println("Geben sie \"J\" ein das Ergebnis auch in die CSV Datei geschrieben werden soll.");
        System.out.println("Nach der Eingabe wird das Programm beendet.");

        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("J")){
            //writeResultToFile(result);
        }
        scanner.reset();
    }

    private static void RunSelectedTask(TasktypeMatrixoperations selectedTask)
    {
        if (selectedTask == TasktypeMatrixoperations.Invalid) {
            return;
        }

        CSVReader csvReader = new CSVReader();
        Scanner scanner = new Scanner(System.in);

        if(selectedTask == TasktypeMatrixoperations.MatrixAddition){
            System.out.println("Bitte geben die in die \"FirstInput.csv\" eine Matrix ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" eine Matrix ein, die zur ersten addiert werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;
            double[][] firstInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[][] secondInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //MatrixAdditionAndSubtraction calculationClass  = new MatrixAdditionAndSubtraction(firstInput,secondInput,true);

        } else if (selectedTask == TasktypeMatrixoperations.MatrixSubtraction) {
            System.out.println("Bitte geben die in die \"FirstInput.csv\" eine Matrix ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" eine Matrix ein, von der ersten subtrahiert werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;
            double[][] firstInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[][] secondInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //MatrixAdditionAndSubtraction calculationClass  = new MatrixAdditionAndSubtraction<>(firstInput,secondInput,false);

        } else if (selectedTask == TasktypeMatrixoperations.MatrixProduct) {
            System.out.println("Bitte geben die in die \"FirstInput.csv\" eine Matrix ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" eine Matrix ein, mit dem das Matrixprodukt gebildet werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;
            double[][] firstInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[][] secondInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //MatrixProduct calculationClass = new MatrixProduct(firstInput,secondInput);

        } else if (selectedTask == TasktypeMatrixoperations.MatrixVectorProduct) {
            System.out.println("Bitte geben die in die \"FirstInput.csv\" eine Matrix ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" einen Vektor ein, mit dem das Matrix-Vector-Produkt gebildet werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;
            double[][] firstInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[] rawSecondInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            double[][] secondInput = new double[][]{};
            secondInput[0][0] = rawSecondInput[0];
            secondInput[1][0] = rawSecondInput[1];
            secondInput[2][0] = rawSecondInput[2];

            PrintMethods temp = new PrintMethods();
            temp.printResult(secondInput);

            //MatrixProduct calculationClass = new MatrixProduct(firstInput,secondInput);

        } else if (selectedTask == TasktypeMatrixoperations.ScalarMultiplication) {
            System.out.println("Bitte geben die in die \"FirstInput.csv\" ein Skalar ein.");
            System.out.println("Bitte geben die in die \"SecondInput.csv\" eine Matrix ein, mit der das Skalarprodukt gebildet werden soll.");
            System.out.println("Bestätigen sie ihre Eingaben indem sie \"C\" eingeben.");

            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("C")) return;
            double[] firstInput = csvReader.readVectorFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/FirstInput.csv");
            double[][] secondInput = csvReader.readMatrixFromCSV(System.getProperty("user.dir") + "/src/CSV-Files/SecondInput.csv");

            //ScalarMultiplication calculationClass = new ScalarMultiplication<>(secondInput,firstInput[0]);

        } else {
            System.out.println("%% Ein Fehler ist aufgetreten beim matching des selectedTasks. %%");
        }

        //calculationClass.performOperation();
        //double[][] result = calculationClass.returnResult();
        PrintMethods printMethods = new PrintMethods();
        //printMethods.printResult(result);

        System.out.println("Geben sie \"J\" ein das Ergebnis auch in die CSV Datei geschrieben werden soll.");
        System.out.println("Nach der Eingabe wird das Programm beendet.");

        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("J")){
            // writeMatrixToFile(result);
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
