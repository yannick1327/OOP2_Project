import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    /**
     * Liest eine Matrix aus der FileInput.csv Datei aus und verarbeitet sie so, dass am Ende ein zweidimensionales
     * Double-Array zurückgegeben wird um im Code mit der Matrix zu arbeiten.
     * @param fileName
     * @return double[][] matrix
     */
    public static double[][] readMatrixFromCSV(String fileName) {
        List<String> lines = readLinesFromCSV(fileName);
        return parseMatrix(lines);
    }

    public static double[] readVectorFromCSV(String fileName) {
        List<String> lines = readLinesFromCSV(fileName);
        return parseVector(lines);
    }

    private static List<String> readLinesFromCSV(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    private static double[][] parseMatrix(List<String> lines) {
        int numRows = lines.size();
        int numCols = lines.get(0).split(",").length;

        double[][] matrix = new double[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] values = lines.get(i).split(",");
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Double.parseDouble(values[j]);
            }
        }

        return matrix;
    }

    private static double[] parseVector(List<String> lines) {
        String[] values = lines.get(0).split(",");
        int length = values.length;
        double[] vector = new double[length];

        for (int i = 0; i < length; i++) {
            vector[i] = Double.parseDouble(values[i]);
        }

        return vector;
    }





    /**
     * Liest einen Vektor aus der SecondInput.csv Datei aus und verarbeitet ihn so, dass am Ende ein
     * Double-Array zurückgegeben wird um im Code mit dem Vektor zu arbeiten.
     * WICHTIG: Ein Vektor muss so geschrieben werden, dass die einzelnen Elemente mit
     * Zeilenumbrüchen von oben nach unten getrennt werden!
     * @param fileName
     * @param vectorIndex der Index des Vektors (0 für den ersten Vektor, 1 für den Zweiten)
     * @return double[] vector
     */

}
