import java.util.*;
import java.io.*;
import java.util.regex.*;

public class XmasWordFind2{	

	public static void main(String[] args){
		List<List<String>> dataInput = new ArrayList<>();
		String wholeLine = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader("puzzleInput.txt"))){
			String line = "";
			while((line = br.readLine()) != null){
				String[] dataLineArray = line.trim().split("");
					
					
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


		int counterMS = countMS(dataMatriz);
		int counterSM = countSM(dataMatriz);
		int counterMM = countMM(dataMatriz);
		int counterSS = countSS(dataMatriz);
		int counterMAMSAS = countMAMSAS(dataMatriz);
		int tryHarder = countSASMAM(dataMatriz);

		System.out.println("countMS: " + counterMS);
		System.out.println("countSM: " + counterSM);
		System.out.println("countMM: " + counterMM);
		System.out.println("countSS: " + counterSS);
		System.out.println("counterMAMSAS: " + counterMAMSAS);
		System.out.println("tryHarder: " + tryHarder);

		int total = counterMS + counterSM + counterMM + counterSS + counterMAMSAS + tryHarder;
		System.out.println("total: " + total);



		

	}

	// M.S
	// .A.
	// M.S
	static int countMS(String[][] dataMatriz){
		int basicCounter = 0;


		for(int i = 0; i < dataMatriz.length - 3; i++){
			for(int j = 0; j < dataMatriz[i].length - 3; j++){
				String masMatch = dataMatriz[i][j] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j+2];
				String samMatch = dataMatriz[i][j+2] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j];

				if(masMatch.equalsIgnoreCase("MAS") && samMatch.equalsIgnoreCase("SAM")){
					basicCounter++;
				}
			}
		}
		return basicCounter;
	}

	// S.M
	// .A.
	// S.M
	static int countSM(String[][] dataMatriz){
		int basicCounter = 0;


		for(int i = 0; i < dataMatriz.length - 3; i++){
			for(int j = 0; j < dataMatriz[i].length - 3; j++){
				String samMatch = dataMatriz[i][j] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j+2];
				String masMatch = dataMatriz[i][j+2] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j];

				if(samMatch.equalsIgnoreCase("SAM") && masMatch.equalsIgnoreCase("MAS")){
					basicCounter++;
				}
			}
		}
		return basicCounter;
	}

	// M.M
	// .A.
	// S.S
	static int countMM(String[][] dataMatriz){
		int basicCounter = 0;


		for(int i = 0; i < dataMatriz.length - 3; i++){
			for(int j = 0; j < dataMatriz[i].length - 3; j++){
				String masMatch1 = dataMatriz[i][j] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j+2];
				String masMatch2 = dataMatriz[i][j+2] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j];

				if(masMatch1.equalsIgnoreCase("MAS") && masMatch2.equalsIgnoreCase("MAS")){
					basicCounter++;
				}
			}
		}
		return basicCounter;
	}


	// S.S
	// .A.
	// M.M
	static int countSS(String[][] dataMatriz){
		int basicCounter = 0;


		for(int i = 0; i < dataMatriz.length - 3; i++){
			for(int j = 0; j < dataMatriz[i].length - 3; j++){
				String samMatch1 = dataMatriz[i][j] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j+2];
				String samMatch2 = dataMatriz[i][j+2] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j];

				if(samMatch1.equalsIgnoreCase("SAM") && samMatch2.equalsIgnoreCase("SAM")){
					basicCounter++;
				}
			}
		}
		return basicCounter;
	}


	// M.S
	// .A.
	// S.M
	static int countMAMSAS(String[][] dataMatriz){
		int basicCounter = 0;


		for(int i = 0; i < dataMatriz.length - 3; i++){
			for(int j = 0; j < dataMatriz[i].length - 3; j++){
				String mamMatch = dataMatriz[i][j] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j+2];
				String sasMatch = dataMatriz[i][j+2] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j];

				if(mamMatch.equalsIgnoreCase("MAM") && sasMatch.equalsIgnoreCase("SAS")){
					basicCounter++;
				}
			}
		}
		return basicCounter;
	}

	// S.M
	// .A.
	// M.S
	static int countSASMAM(String[][] dataMatriz){
		int basicCounter = 0;


		for(int i = 0; i < dataMatriz.length - 3; i++){
			for(int j = 0; j < dataMatriz[i].length - 3; j++){
				String sasMatch = dataMatriz[i][j] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j+2];
				String mamMatch = dataMatriz[i][j+2] + dataMatriz[i+1][j+1] + dataMatriz[i+2][j];

				if(sasMatch.equalsIgnoreCase("SAS") && mamMatch.equalsIgnoreCase("MAM")){
					basicCounter++;
				}
			}
		}
		return basicCounter;
	}















	//Diagonal Ascendente Derecha (MAS hacia arriba a la derecha y SAM hacia abajo a la derecha

	static int countDiagonalAscendRight(String[][] dataMatriz){
		int counter = 0;

		for(int i = 2; i < dataMatriz.length; i++){
			for(int j = 2; j < dataMatriz[i].length; j++){
				String masMatch = dataMatriz[i][j] + dataMatriz[i-1][j-1] + dataMatriz[i-2][j-2];
				String samMatch = dataMatriz[i][j-2] + dataMatriz[i-1][j-1] + dataMatriz[i-2][j];

				if(masMatch.equalsIgnoreCase("MAS") && samMatch.equalsIgnoreCase("SAM")){
					counter++;
				}
			}
		}
		return counter;
	}



 }