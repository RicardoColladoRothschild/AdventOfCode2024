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


	public static void main(String[] args){
		List<List<String>> dataInput = new ArrayList<>();
		String wholeLine = "";
		int rowCounter = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("puzzleInput.txt"))){
			String line = "";
			while((line = br.readLine()) != null){
				String[] dataLineArray = line.trim().split("");
					rowCounter = countRow(line.trim());
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

		System.out.println("Row counter: " + rowCounter);
	}

 }