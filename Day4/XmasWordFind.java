import java.util.*;
import java.io.*;
import java.util.regex.*;

public class XmasWordFind{


	static int countRow(String matriz) {
    String regex = "(?=xmas)"; 

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(matriz);

    int totalInRowCounts = 0;
    while (matcher.find()) {
        totalInRowCounts++;
    }

    return totalInRowCounts;
}

	static int countRowReverse(String oneLine){
		String regex = "(?=samx)";

			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(oneLine);

			int totalReverseRowCount = 0;

				while(matcher.find()){
					totalReverseRowCount++;
				}

				return totalReverseRowCount;
	}

	static int countDiagonalRight(String[][] dataMatriz){

		int diagonalCount = 0;
		for (int i = 0; i < dataMatriz.length - 3; i++) {
		            for (int j = 0; j < dataMatriz[i].length - 3; j++) {
		                String diagonalWord = dataMatriz[i][j] + dataMatriz[i + 1][j + 1] +
		                                      dataMatriz[i + 2][j + 2] + dataMatriz[i + 3][j + 3];
		                if (diagonalWord.equalsIgnoreCase("XMAS")) {
		                    diagonalCount++;
		                }
		            }
		        }

		        return diagonalCount;
	}

	static int countDiagonalLeft(String[][] dataMatriz) {
    int diagonalCount = 0;
    for (int i = 0; i < dataMatriz.length - 3; i++) { 
        for (int j = 3; j < dataMatriz[i].length; j++) { 
            String diagonalWord = dataMatriz[i][j] + dataMatriz[i + 1][j - 1] +
                                  dataMatriz[i + 2][j - 2] + dataMatriz[i + 3][j - 3];
            if (diagonalWord.equalsIgnoreCase("XMAS")) {
                diagonalCount++;
            }
        }
    }
    return diagonalCount;
}

  
    static int countDiagonalReverseUpRight(String[][] dataMatriz) {
        int count = 0;
        int rows = dataMatriz.length;
        int cols = dataMatriz[0].length;
        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                String word = dataMatriz[i][j] + dataMatriz[i - 1][j + 1] + dataMatriz[i - 2][j + 2] + dataMatriz[i - 3][j + 3];
                if (word.equalsIgnoreCase("XMAS")) {
                    count++;
                }
            }
        }
        return count;
    }

   
    static int countDiagonalReverseUpLeft(String[][] dataMatriz) {
        int count = 0;
        int rows = dataMatriz.length;
        int cols = dataMatriz[0].length;
        for (int i = 3; i < rows; i++) {
            for (int j = 3; j < cols; j++) {
                String word = dataMatriz[i][j] + dataMatriz[i - 1][j - 1] + dataMatriz[i - 2][j - 2] + dataMatriz[i - 3][j - 3];
                if (word.equalsIgnoreCase("XMAS")) {
                    count++;
                }
            }
        }
        return count;
    }

	static int countVertical(String[][] dataMatriz){
		int verticalCounter = 0;


			for(int i = 0; i < dataMatriz.length - 3; i++){
				for(int j = 0; j < dataMatriz[i].length; j ++){
					String xmasWord = dataMatriz[i][j] + dataMatriz[i+1][j] + dataMatriz[i+2][j] + dataMatriz[i+3][j]; 
					if(xmasWord.equalsIgnoreCase("XMAS")){
						verticalCounter++;
					}
				}
			}
			return verticalCounter;
	}

	static int countVerticalReverse(String[][] dataMatriz) {
    int verticalCounter = 0;

    for (int j = 0; j < dataMatriz[0].length; j++) { 
        for (int i = dataMatriz.length - 1; i >= 3; i--) { 
            String xmasWord = dataMatriz[i][j] + 
                              dataMatriz[i - 1][j] + 
                              dataMatriz[i - 2][j] + 
                              dataMatriz[i - 3][j];
            if (xmasWord.equalsIgnoreCase("XMAS")) {
                verticalCounter++;
            }
        }
    }
    return verticalCounter;
}


	public static void main(String[] args){
		List<List<String>> dataInput = new ArrayList<>();
		String wholeLine = "";
		int rowCounter = 0;
		int countRowReverse = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("puzzleInput.txt"))){
			String line = "";
			while((line = br.readLine()) != null){
				String[] dataLineArray = line.trim().split("");
					rowCounter += countRow(line.trim());
					countRowReverse += countRowReverse(line.trim());
 					List<String> subArrayTemp = new ArrayList<>();

					if(dataLineArray.length > 0){
						for(int i = 0; i < dataLineArray.length; i++){
							subArrayTemp.add(dataLineArray[i]);
						}
					}
					dataInput.add(subArrayTemp);
			}

			
		}catch(IOException ioEx){
		 System.out.println("Ha ocurrido algun error durante la lectura del file"); 
		} 

		String[][] dataMatriz = new String[dataInput.size()][];
		for(int i = 0; i < dataInput.size(); i++){
			dataMatriz[i] = dataInput.get(i).toArray(new String[0]);

		}

			int diagonalCount = countDiagonalRight(dataMatriz);
			int diagonalCountLeft = countDiagonalLeft(dataMatriz);
			int verticalCounter = countVertical(dataMatriz);
			int verticalReverse = countVerticalReverse(dataMatriz);
			int countDiagonalReverse = countDiagonalReverseUpRight(dataMatriz);
			int countDiagonalReverseU_left = countDiagonalReverseUpLeft(dataMatriz);

		System.out.println("Row counter: " + rowCounter);
		System.out.println("Row countRowReverse: " + countRowReverse);
		System.out.println("diagonalCount: " + diagonalCount);
		System.out.println("diagonalCountLeft: " + diagonalCountLeft);
		System.out.println("verticalCounter: " + verticalCounter);
		System.out.println("verticalReverse: " + verticalReverse);
		System.out.println("countDiagonalReverseUpRight: " + countDiagonalReverse);
		System.out.println("countDiagonalReverseU_left: " + countDiagonalReverseU_left);
		
		int totalCount = rowCounter + countRowReverse + diagonalCount + diagonalCountLeft + verticalCounter + verticalReverse + countDiagonalReverse + countDiagonalReverseU_left;
		System.out.println("Total: " + totalCount);
	}

 }