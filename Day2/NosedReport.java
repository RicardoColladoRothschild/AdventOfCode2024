import java.io.*;
import java.util.*;


public class NosedReport{

    public static void main(String[] args){
        List<List<Integer>> dataInput = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("puzzleInput.txt"))){
            String line;


                while((line = br.readLine()) !=null){
                    String[] dataLine = line.trim().split("\\s+");
                    
                    List<Integer> subArrayTemp = new ArrayList<>();
                        if(dataLine.length > 0){
                            for(int i = 0; i < dataLine.length; i++){
                                subArrayTemp.add(Integer.parseInt(dataLine[i]));
                            }
                        }

                        dataInput.add(subArrayTemp);
                }
                int secureCount = 0;
                
                int[][] arrayData = new int[dataInput.size()][];

                for (int i = 0; i < dataInput.size(); i++) {
                    List<Integer> row = dataInput.get(i);
                    arrayData[i] = row.stream().mapToInt(Integer::intValue).toArray(); 
                }
                
                for(int i = 0; i < arrayData.length; i++){
                    int[] temp = arrayData[i];

                    boolean isSecure = true;
                    boolean increased = false;
                    boolean decrease = false;
                    for(int j = 1; j < temp.length; j++ ){
                        int diff = Math.abs(temp[j] - temp[j-1]);

                            if(temp[j] < temp[j-1]){
                                if(increased){
                                    isSecure = false;
                                    System.out.println(Arrays.toString(temp));
                                    break;
                                }else{
                                    decrease = true;
                                }
                            }else if(temp[j] > temp[j-1]){
                                    if(decrease){
                                        isSecure = false;
                                        System.out.println("h" +Arrays.toString(temp));
                                        break;
                                    }else{
                                        increased = true;
                                    }
                            }

                            if(diff > 3 || (diff == 0)){
                                isSecure=false;
                                System.out.println(Arrays.toString(temp));
                                break;
                            }
                    }

                    if(isSecure){
                        secureCount++;
                    }
                }
                System.out.println("secureCount:" + secureCount);

                // for (List<Integer> row : dataInput) {
                //     for (Integer num : row) {
                //         System.out.print(num + " ");
                //     }
                //     System.out.println();
                // }   

        }catch(IOException ex){
            System.out.println("Exeption IO happen");
        }
    }
}