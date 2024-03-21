import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegExp {
    
    public static void main(String[] args) {
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                boolean isPalindrome = checkPalindrome(line);

                boolean containStr1 = line.contains(str1) ? true : false;

                boolean containStr2Ntimes = countOccurrences(line, str2) >= s2Count ? true : false;

                boolean containsPattern = checkPattern(line);

                // Print results
                System.out.print((isPalindrome ? "Y" : "N") + ",");
                System.out.print((containStr1 ? "Y" : "N") + ",");
                System.out.print((containStr2Ntimes ? "Y" : "N") + ",");
                System.out.println((containsPattern ? "Y" : "N"));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static int countOccurrences(String str, String subStr) {
        str = str.toLowerCase();
        subStr = subStr.toLowerCase();
        int count = 0;
        int lastIndex = 0;
        while ((lastIndex = str.indexOf(subStr, lastIndex)) != -1) {
            count++;
            lastIndex += subStr.length();
        }
        return count;
    }
    public static boolean checkPattern(String str) {
        int aCount = 0;
        int bCount = 0;
        boolean ans = false;
        int switcha = 0;
        str = str.toLowerCase();
        int i = 0;

        while (i < str.length()){
            if (str.charAt(i) == 'a' && switcha == 0){
                aCount++;
            }
            else if (str.charAt(i) == 'b' && switcha == 0){
                switcha = 1;
                bCount++;
            }
            else if (str.charAt(i) == 'b' && switcha == 1){
                bCount++;
            }
            else if (str.charAt(i) == 'a' && switcha == 1){
                switcha = 0;   
                if (bCount == 2 * aCount){
                    ans = true;
                }
                bCount = 0;
                aCount++;
            }
            i++;
        }
        return ans;
    }
}
