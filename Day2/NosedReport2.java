import java.io.*;
import java.util.*;


public class NosedReport2{


    static boolean anulador(int[] nums, int numToRemove){
        List<Integer> tempList = new ArrayList<>();

            for(int n : nums){
                tempList.add(n);
            }
            System.out.println("numToRemove: " + numToRemove);
            tempList.remove(Integer.valueOf(numToRemove));

            int[] temp = tempList.stream().mapToInt(Integer::intValue).toArray();
            System.out.println("temp: " + Arrays.toString(temp));

                    boolean isSecure = true;
                    boolean increased = false;
                    boolean decrease = false;

                    for(int j = 1; j < temp.length; j++ ){
                        int diff = Math.abs(temp[j] - temp[j-1]);

                            if(temp[j] < temp[j-1]){
                                if(increased){
                                    isSecure = false;
                                   
                                    break;
                                }else{
                                    decrease = true;
                                }
                            }else if(temp[j] > temp[j-1]){
                                    if(decrease){
                                        isSecure = false;
                                       

                                        break;
                                    }else{
                                        increased = true;
                                    }
                            }

                            if(diff > 3 || (diff == 0)){
                                isSecure=false;
                               
                                break;
                            }
                    }
                    System.out.println("-----------------");
                    return isSecure;
    }

    public static void main(String[] args){
        List<List<Integer>> dataInput = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("puzzleTest.txt"))){
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

                            
                                System.out.println(Arrays.toString(temp));

                            if(diff > 3 || (diff == 0)){
                                boolean isTempPriorSecure = anulador(temp, temp[j-1]);
                                boolean isTempCurrentSecure = anulador(temp, temp[j]);
                                System.out.println(Arrays.toString(temp));
                                System.out.println("isTempCurrentSecure: " + isTempCurrentSecure);
                                System.out.println("isTempPriorSecure: " + isTempPriorSecure);

                                if(isTempPriorSecure || isTempCurrentSecure){
                                    isSecure = true;
                                    break;
                                }else{
                                        isSecure=false;                               
                                        break;
                                    }
                           
                            }

                            if(temp[j] < temp[j-1]){
                                if(increased){
                                    isSecure = false;
                                    
                                    break;
                                }else{
                                    decrease = true;
                                }
                            }else if(temp[j] > temp[j-1]){
                                    if(decrease){
                                        isSecure = false;
                                       
                                        break;
                                    }else{
                                        increased = true;
                                    }
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