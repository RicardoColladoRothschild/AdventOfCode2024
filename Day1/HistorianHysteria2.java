import java.io.*;
import java.util.*;

public class HistorianHysteria{

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

		Arrays.sort();
		Arrays.sort(yOrdered);
		

		HashMap<Integer, Integer> repeatedMapped = new HashMap<>();

		for(int i = 0; i < xOrdered.length; i ++){
			for(int j = 0;  j < yOrdered.length; y++){
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

				//TODO: Still missing, what happen if, a number on the right is more than 1 time in the same line (right) this algorithm will
				//count again numbers of time it repeated in the left (resulting in a invalid sum)


			}
		}



	

	}
}