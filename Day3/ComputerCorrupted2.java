import java.util.regex.*;
import java.util.*;
import java.io.*;
public class ComputerCorrupted2{
    

    public static void main(String[] args){
            String wholeLine = "";
        try(BufferedReader br = new BufferedReader(new FileReader("PuzzleInputData.txt"))){
            String line;

                while((line = br.readLine())!= null){
                    wholeLine+=line;
                }

        }catch(IOException e){}

        boolean isEnabled = true;
        // String regex = "do\\(\\)(?:(?!don't\\(\\)).)*?mul\\((\\d{1,3}),(\\d{1,3})\\)";
        // String regex = "(?:^|do\\(\\)(?:(?!don't\\(\\)).)*?)mul\\((\\d{1,3}),(\\d{1,3})\\)";
        String regex = "do\\(\\)|don't\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(wholeLine);

        int total = 0;

        while(matcher.find()){
            String match = matcher.group();

                if(match.equals("do()")){
                    isEnabled = true;
                }else if(match.equals("don't()")){
                    isEnabled = false;
                }  else if (isEnabled && matcher.group(1) != null && matcher.group(2) != null) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));
                    total += num1 * num2;
                }

          
        }
        System.out.println(total);
    }
}
