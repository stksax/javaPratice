import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RegExp {
    
    public static void main(String[] args) {
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);

        boolean check = true;
        
        
        int ans3count = 0;
        int len = 0;
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                String line_text = line;
                String[] word = line_text.split(" ");
                boolean containStr1 = false;
                boolean containStr2 = false;
                if (line_text.contains(str1)){
                    containStr1 = true;
                }
                
                containStr2 = line_text.contains(str2);
                if (containStr2){
                    ans3count+=1;
                }
                len+=1;

                String ans2 = containStr1 ? "Y" : "N";
                System.out.println("The ans2:"+ans2);
            }
            
            String[] cc = new String[len];
            //correct this
            while ((line = reader.readLine()) != null) {
                String line_text = line;
                String[] word = line_text.split(" ");
                for (int i = 0; i < len; i++) {
                    if (i < (len / 2)) {
                        cc[i] = line; // You probably want to assign the current line to cc[i]
                    } else {
                        cc[i] = line; // It's not clear what c[len - i] is, so adjust accordingly

                        // Check if elements at corresponding positions are equal
                        if (!cc[i].equals(cc[len - i - 1])) {
                            check = false;
                            break; // No need to continue if a mismatch is found
                        }
                    }
                }
            }
            reader.close();
            //correct this

        } catch (IOException e) {
            e.printStackTrace();
        }

        String ans1 = check ? "Y" : "N";
        
        String ans3 = ans3count>s2Count ? "Y" : "N";
        
        //For your testing of input correctness
        System.out.println("The ans3count:"+ans3count); 
        System.out.println("The ans1:"+ans1);

        System.out.println("The ans3="+ans3);
    }
}