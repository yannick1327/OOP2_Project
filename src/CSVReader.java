import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static List<double[][]> readMatricesFromCSV(String fileName, int rows, int cols) {
        List<double[][]> matrices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] matrixStrings = line.split(";");
                double[][] matrix = new double[rows][cols * matrixStrings.length];

                for (int i = 0; i < matrixStrings.length; i++) {
                    String[] values = matrixStrings[i].split(",");
                    for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                        for (int colIndex = 0; colIndex < cols; colIndex++) {
                            matrix[rowIndex][i * cols + colIndex] = Double.parseDouble(values[colIndex]);
                        }
                    }
                }
                matrices.add(matrix);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrices;
    }

    public static void printMatrices(List<double[][]> matrices) {
        for (double[][] matrix : matrices) {
            System.out.println("Matrix:");
            for (double[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
        }
    }

    public static List<double[]> readVectorsFromCSV(String fileName) {
        List<double[]> vectors = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                double[] vector = new double[values.length];

                for (int i = 0; i < values.length; i++) {
                    vector[i] = Double.parseDouble(values[i]);
                }
                vectors.add(vector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vectors;
    }

    public static void printVectors(List<double[]> vectors) {
        for (double[] vector : vectors) {
            System.out.println("Vector: " + Arrays.toString(vector));
        }
    }
}
