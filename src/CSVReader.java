import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    /**
     * Liest eine Matrix aus der Matrix.csv Datei aus und verarbeitet sie so, dass am Ende ein zweidimensionales
     * Double-Array zurückgegeben wird um im Code mit der Matrix zu arbeiten.
     * @param fileName
     * @param matrixIndex
     * @return double[][] matrix
     */
    public static double[][] readMatrixFromCSV(String fileName, int matrixIndex) {
        List<List<Double>> matrixData = readDataFromCSV(fileName, matrixIndex);

        // Convert List<List<Double>> to double[][]
        int rows = matrixData.size();
        int cols = matrixData.get(0).size();
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = matrixData.get(i).get(j);
            }
        }

        return matrix;
    }


    /**
     * Liest einen Vektor aus der Vector.csv Datei aus und verarbeitet ihn so, dass am Ende ein
     * Double-Array zurückgegeben wird um im Code mit dem Vektor zu arbeiten.
     * WICHTIG: Ein Vektor muss so geschrieben werden, dass die einzelnen Elemente mit
     * Zeilenumbrüchen von oben nach unten getrennt werden!
     * @param fileName
     * @param vectorIndex der Index des Vektors (0 für den ersten Vektor, 1 für den Zweiten)
     * @return double[] vector
     */
    public static double[] readVectorFromCSV(String fileName, int vectorIndex) {
        List<List<Double>> vectorData = readDataFromCSV(fileName, vectorIndex);

        // Convert List<List<Double>> to double[]
        int length = vectorData.get(0).size();
        double[] vector = new double[length];
        for (int i = 0; i < length; i++) {
            vector[i] = vectorData.get(0).get(i);
        }

        return vector;
    }

    /**
     * Liest die Daten aus dem ...
     * @param fileName
     * @param dataIndex
     * @return
     */
    private static List<List<Double>> readDataFromCSV(String fileName, int dataIndex) {
        List<List<Double>> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int currentIndex = 0;

            while ((line = reader.readLine()) != null) {
                if (currentIndex == dataIndex) {
                    String[] values = line.split(",");
                    List<Double> dataList = new ArrayList<>();
                    for (String value : values) {
                        dataList.add(Double.parseDouble(value));
                    }
                    data.add(dataList);
                    break;  // Stop after reading the desired data
                }

                currentIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
