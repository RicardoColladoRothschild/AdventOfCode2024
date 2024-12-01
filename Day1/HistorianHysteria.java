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


		Arrays.sort(xOrdered);
		Arrays.sort(yOrdered);
		// System.out.println("Array X ordenado: " + Arrays.toString(xOrdered));
        // System.out.println("Array Y ordenado: " + Arrays.toString(yOrdered));

		int sumDif = 0;

			for(int i = 0; i < xOrdered.length; i ++){
				int dif = Math.abs(xOrdered[i] - yOrdered[i]);
				sumDif += dif;
			}

			System.out.println(sumDif);

	}
}