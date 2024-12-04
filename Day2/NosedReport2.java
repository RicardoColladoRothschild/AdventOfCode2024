import java.io.*;
import java.util.*;

public class NosedReport2 {

    
    static boolean isSecure(int[] nums) {
        boolean increased = false, decreased = false;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            
            if (Math.abs(diff) > 3 || diff == 0) return false;

            
            if (diff > 0) {
                if (decreased) return false;
                increased = true;
            } else if (diff < 0) {
                if (increased) return false;
                decreased = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> dataInput = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader("puzzleInput.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.trim().split("\\s+");
                List<Integer> row = new ArrayList<>();
                for (String num : dataLine) row.add(Integer.parseInt(num));
                dataInput.add(row);
            }
        } catch (IOException ex) {
            System.out.println("Exeption IO happen: " + ex.getMessage());
            return;
        }

        
        int secureCount = 0;

        for (List<Integer> report : dataInput) {
            int[] original = report.stream().mapToInt(Integer::intValue).toArray();

            
            if (isSecure(original)) {
                secureCount++;
                continue;
            }

           
            boolean anulador = false;
            for (int i = 0; i < original.length; i++) {
                int[] modified = new int[original.length - 1];
                System.arraycopy(original, 0, modified, 0, i);
                System.arraycopy(original, i + 1, modified, i, original.length - i - 1); 
                if (isSecure(modified)) {
                    anulador = true;
                    break;
                }
            }

            if (anulador) secureCount++;
        }

        System.out.println("Secure count: " + secureCount);
    }
}
