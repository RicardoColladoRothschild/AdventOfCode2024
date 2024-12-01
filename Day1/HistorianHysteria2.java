import java.io.*;
import java.util.*;

public class HistorianHysteria2{

	public static void main(String[] args){
		List<Integer> xListed = new ArrayList<>();
		List<Integer> yListed = new ArrayList<>();


	try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ricardo Collado\\Desktop\\AoC2024\\Day1\\puzzleInput1.txt"))){
			String line;


				while((line = br.readLine()) != null){
					String[] parts = line.trim().split("\\s+");
					if(parts.length == 2){
						xListed.add(Integer.parseInt(parts[0]));
						yListed.add(Integer.parseInt(parts[1]));
					}
				}
		}catch(IOException e){
			System.out.println("Error en la carga del input: "+ e.getMessage());
		}

			int[] xOrdered = xListed.stream().mapToInt(Integer::intValue).toArray();
			int[] yOrdered = yListed.stream().mapToInt(Integer::intValue).toArray();

					//TestCase
				// int[] xOrdered = {3,4,2,1,3,3};
				// int[] yOrdered = {4,3,5,3,9,3};

		Arrays.sort(xOrdered);
		Arrays.sort(yOrdered);
		

		HashMap<Integer, Integer> repeatedMapped = new HashMap<>();

		for(int i = 0; i < xOrdered.length; i ++){
			for(int j = 0;  j < yOrdered.length; j++){
					int keyToCheck = xOrdered[i]; 
				if(!repeatedMapped.containsKey(keyToCheck)){
					if(keyToCheck == yOrdered[j]){
						repeatedMapped.put(keyToCheck, 1);
					}
				}else if(keyToCheck == yOrdered[j]){
						int currentValue = repeatedMapped.get(keyToCheck);
							currentValue++;
							repeatedMapped.put(keyToCheck, currentValue);
				}

				


			}
		}

			int sumMultResult = 0;

			for(Map.Entry<Integer, Integer> entry : repeatedMapped.entrySet()){
				int key = entry.getKey();
				int value = entry.getValue();


				int result = key * value;
				sumMultResult+=result;
			}

				System.out.println(sumMultResult);




	

	}
}