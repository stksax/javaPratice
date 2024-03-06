import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegExp {

    public static String test1(String[] args, String word, int len){
        boolean isPalindrome = true;
        String[] record;
        for (int i = 0; i < len; i++) {
            if (i < (len / 2)) {
                record[i] = args[i]; 
            } else {
                ; 
                if (args[i] != record[len - i - 1]) {
                    isPalindrome = false;
                    break;
                }
            }
        }
        String ans = isPalindrome ? "Y" : "N";
        System.out.println(ans);
    } 

    public static String test2(String[] args, String word){
        boolean containWord = false;
        while (args != null) {
            ;
            if (args == word){
                containWord =true;
                break;
            }
        }
        String ans = containWord ? "Y" : "N";
        System.out.println(ans);
    } 

    public static String test3(String[] args, String word, int round){
        int containWord = 0;
        while (args != null) {
            ;
            if (args == word){
                containWord += 1;
            }
        }
        String ans = containWord > round ? "Y" : "N";
        System.out.println(ans);
    } 

    public static String test4(String[] letter){
        int containLetterA = 0;
        int containLetterB = 0;
        String a = "a";
        String b = "b";
        while (letter != b && letter != null) {
            ;
            if (letter == a){
                containLetterA += 1;
            }
        }

        while (letter != b && letter != null) {
            ;
            if (letter == b){
                containLetterB += 1;
            }
        }
        String ans = containLetterB*2 > containLetterA ? "Y" : "N";
        System.out.println(ans);
    } 
    
    public static void main(String[] args) {
        String str1 = args[1];
        String str2 = args[2];
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            int len = 0;
            while ((line = reader.readLine()) != null) {
                String[] word = line.split(" ");
                len+=1;
            }

            for (int i = 0; i < len; i++){
                test2(word[i], str1);
                test3(word[i], str2, args[3]);
                test4(word[i]);
            }
    
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}