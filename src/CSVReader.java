import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    /**
     * Liest eine Matrix aus einer CSV-Datei aus und verarbeitet sie so, dass am Ende ein
     * zweidimensionales Double-Array zurückgegeben wird um im Code mit der Matrix zu arbeiten.
     * WICHTIG: Die Matrix muss so geschrieben sein, dass die einzelnen Elemente durch ein Komma
     * und die einzelnen Reihen durch einen Zeilenumbruch getrennt sind!
     * @param fileName
     * @return double[][] matrix - vollständige Matrix als zweidimensionales Double Array
     */
    public static double[][] readMatrixFromCSV(String fileName) {
        List<String> lines = readLinesFromCSV(fileName);
        return parseMatrix(lines);
    }

    /**
     * Liest einen Vektor aus einer CSV-Datei aus und verarbeitet ihn so, dass am Ende ein
     * Double-Array zurückgegeben wird um im Code mit dem Vektor zu arbeiten.
     * WICHTIG: Ein Vektor muss so geschrieben werden, dass die einzelnen Elemente mit
     * Kommas von getrennt werden!
     * @param fileName Der Pfad und Dateiname der CSV-Datei
     * @return double[] vector - vollständiger Vektor als Double Array
     */
    public static double[] readVectorFromCSV(String fileName) {
        List<String> lines = readLinesFromCSV(fileName);
        return parseVector(lines);
    }

    /**
     * Liest eine Datei und gibt die einzelnen Zeilen mit ihren Inhalten
     * als Liste von Strings zurück.
     * @param fileName Der Pfad und Dateiname der Datei
     * @return List<String> lines - Liste von Strings
     */
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

    /**
     * Nimmt die einzelnen Zeilen und teilt sie in Reihen und Zeilen auf.
     * Konvertiert die aufgeteilten Elemente in Fließkommazahlen um und schreibt
     * sie in der richtigen Reihenfolge als Matrix in ein zweidimensionales Double Array.
     * @param lines Liste von Strings mit ihren Elementen
     * @return double[][] matrix - vollständige Matrix als zweidimensionales Double Array
     */
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

    /**
     * Nimmt die einzelnen Zeilen und teilt sie in einzelne Elemente auf.
     * Konvertiert die aufgeteilten Elemente in Fließkommazahlen um und schreibt
     * sie in der richtigen Reihenfolge als Vektor in ein Double Array.
     * @param lines Liste von Strings mit ihren Elementen
     * @return double[] vector - vollständiger Vektor als Double Array
     */
    private static double[] parseVector(List<String> lines) {
        String[] values = lines.get(0).split(",");
        int length = values.length;
        double[] vector = new double[length];

        for (int i = 0; i < length; i++) {
            vector[i] = Double.parseDouble(values[i]);
        }
        return vector;
    }
}