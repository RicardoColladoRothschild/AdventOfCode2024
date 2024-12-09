import java.util.*;
import java.io.*;

public class Solved {    

    public static void main(String[] args) {
        List<List<String>> dataInput = new ArrayList<>();
        
        // Cargar el archivo de entrada
        try (BufferedReader br = new BufferedReader(new FileReader("puzzleInput.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLineArray = line.trim().split("");
                List<String> subArrayTemp = new ArrayList<>();
                
                for (String s : dataLineArray) {
                    subArrayTemp.add(s);
                }
                
                dataInput.add(subArrayTemp);
            }
        } catch (IOException ioEx) {
            System.out.println("Error leyendo el archivo de entrada.");
        }

        String[][] dataMatriz = new String[dataInput.size()][];
        for (int i = 0; i < dataInput.size(); i++) {
            dataMatriz[i] = dataInput.get(i).toArray(new String[0]);
        }

        // Contadores
        int total = countAllPatterns(dataMatriz);

        // Resultado
        System.out.println("Total de patrones X-MAS encontrados: " + total);
    }

    // Función principal para contar patrones relevantes
    static int countAllPatterns(String[][] dataMatriz) {
        int count = 0;
        count += countXMasDiagonals(dataMatriz);
        count += countXMasTriangles(dataMatriz);
        count += countCrossPatterns(dataMatriz);
        return count;
    }

    // Buscar diagonales
    static int countXMasDiagonals(String[][] dataMatriz) {
        int counter = 0;
        
        for (int i = 2; i < dataMatriz.length; i++) {
            for (int j = 2; j < dataMatriz[i].length; j++) {
                // Diagonales hacia arriba a la derecha
                if (i >= 2 && j >= 2) {
                    String masMatch = dataMatriz[i][j] + dataMatriz[i - 1][j - 1] + dataMatriz[i - 2][j - 2];
                    String samMatch = dataMatriz[i][j - 2] + dataMatriz[i - 1][j - 1] + dataMatriz[i - 2][j];
                    if (masMatch.equalsIgnoreCase("MAS") && samMatch.equalsIgnoreCase("SAM")) {
                        counter++;
                    }
                }
            }
        }
        
        return counter;
    }

    // Buscar patrones en forma de triángulos invertidos
    static int countXMasTriangles(String[][] dataMatriz) {
        int counter = 0;

        for (int i = 2; i < dataMatriz.length - 1; i++) {
            for (int j = 0; j < dataMatriz[i].length - 2; j++) {
                // Verificar patrón en triángulo invertido
                String mas1 = dataMatriz[i][j] + dataMatriz[i - 1][j + 1] + dataMatriz[i - 2][j + 2];
                String mas2 = dataMatriz[i][j + 2] + dataMatriz[i - 1][j + 1] + dataMatriz[i - 2][j];
                
                if (mas1.equalsIgnoreCase("MAS") || mas2.equalsIgnoreCase("MAS")) {
                    counter++;
                }
            }
        }
        
        return counter;
    }

    // Contar patrones en forma cruzada
    static int countCrossPatterns(String[][] dataMatriz) {
        int counter = 0;

        for (int i = 2; i < dataMatriz.length; i++) {
            for (int j = 2; j < dataMatriz[i].length; j++) {
                // Buscar patrones cruzados centrados en la posición actual
                String masMatch = dataMatriz[i][j] + dataMatriz[i - 1][j - 1] + dataMatriz[i - 2][j - 2];
                String samMatch = dataMatriz[i][j - 2] + dataMatriz[i - 1][j - 1] + dataMatriz[i - 2][j];
                
                if (masMatch.equalsIgnoreCase("MAS") && samMatch.equalsIgnoreCase("SAM")) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
