import java.io.*;
import java.util.*;

public class XmasWordFindsolved {

    // Contar patrones X-MAS en forma de cruz
    static int countXMAS(String[][] dataMatriz) {
        int count = 0;

        for (int i = 1; i < dataMatriz.length - 1; i++) { // Evitar bordes
            for (int j = 1; j < dataMatriz[i].length - 1; j++) {
                // Verificar patrón MAS en diagonal superior izquierda a inferior derecha
                boolean masMatch = dataMatriz[i - 1][j - 1].equalsIgnoreCase("M") &&
                                   dataMatriz[i][j].equalsIgnoreCase("A") &&
                                   dataMatriz[i + 1][j + 1].equalsIgnoreCase("S");
                // Verificar patrón SAM en diagonal superior derecha a inferior izquierda
                boolean samMatch = dataMatriz[i - 1][j + 1].equalsIgnoreCase("M") &&
                                   dataMatriz[i][j].equalsIgnoreCase("A") &&
                                   dataMatriz[i + 1][j - 1].equalsIgnoreCase("S");

                // Si ambos patrones están presentes, se cuenta como "X-MAS"
                if (masMatch && samMatch) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<List<String>> dataInput = new ArrayList<>();

        // Leer archivo de entrada
        try (BufferedReader br = new BufferedReader(new FileReader("inputTest2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> row = Arrays.asList(line.trim().split(""));
                dataInput.add(row);
            }
        } catch (IOException ioEx) {
            System.out.println("Error al leer el archivo.");
            return;
        }

        // Convertir la lista a matriz
        String[][] dataMatriz = dataInput.stream()
                                         .map(l -> l.toArray(new String[0]))
                                         .toArray(String[][]::new);

        // Contar patrones X-MAS
        int xmasCount = countXMAS(dataMatriz);

        // Imprimir el resultado
        System.out.println("Número de X-MAS encontrados: " + xmasCount);
    }
}
