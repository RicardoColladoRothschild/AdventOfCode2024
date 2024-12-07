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


	public static void main(String[] args){
		List<List<String>> dataInput = new ArrayList<>();
		String wholeLine = "";
		int rowCounter = 0;
		int countRowReverse = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("inputTest.txt"))){
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
			dataMatriz[i] = dataInput.get(i).split("");

		}

			int diagonalCount = 0;

				for(int i = 0; i < dataMatriz.length; i++){

				}

		System.out.println("Row counter: " + rowCounter);
		System.out.println("Row countRowReverse: " + countRowReverse);
	}

 }