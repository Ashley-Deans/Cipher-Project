import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int[] cnt = {0};
        String inputString = "";
        String outputString = "";
        //Hashmap for searching by letter
        Map<Character, Integer> letterKeyMap = new HashMap<Character, Integer>() {
            {
                for (char ch = 'A'; ch <= 'Z'; ++ch){
                    put(ch, cnt[0]);
                    cnt[0]++;
                }
            }
        };
        cnt[0] = 0;

        //Hashmap for searching by number
        Map<Integer, Character> numberKeyMap = new HashMap<Integer, Character>() {
            {
                for (char ch = 'F'; ch <= 'Z'; ++ch){
                    put(cnt[0], ch);
                    cnt[0]++;
                }
                for (char ch = 'A'; ch <= 'E'; ++ch){
                    put(cnt[0], ch);
                    cnt[0]++;
                }
            }
        };

        System.out.println("Enter the string you'd like to encrypt.");
        Scanner sc= new Scanner(System.in);
        inputString = sc.nextLine();

        //increments the character that is being encrypting from the string
		for(int i =0; i < inputString.length(); i++){
            outputString = searchForPosition(inputString.charAt(i), letterKeyMap, numberKeyMap, outputString);
        }
        System.out.println("Decrypted String: " + inputString + "\nEncrypted String: " + outputString);

    }

    public static String searchForPosition(char c, Map letterKeyMap, Map numberKeyMap, String outputString){
        int position = 0;
        //searches for letter in the hashmap
        if (letterKeyMap.containsKey(Character.toUpperCase(c))){
            //returns the alphabetical number position
            position = (int) letterKeyMap.get(Character.toUpperCase(c));
            //adds the encrypted character to the string
            outputString = outputString + numberKeyMap.get(position);
        }
        else{
            // uncomment to allow spaces and symbols
            // outputString = outputString + c;
        }
        return outputString;
    }


}