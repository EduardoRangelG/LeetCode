import java.util.ArrayList;

class Solution {
    public String shortestPalindrome(String s) {
        String s_reversed= new StringBuilder(s).reverse().toString();
        ArrayList<Character> max_coincidence= new ArrayList<>();
        String prefix = "";

        for(int i=0;i<s.length();i++){
            ArrayList<Character> word= new ArrayList<>();

            for(int j=0;j<s.length()-i;j++){
                if (s.charAt(j)==s_reversed.charAt(i+j)){
                    word.add(s.charAt(j));
                    }else{
                        break;
                        }}
            
            if (word.size()>max_coincidence.size()){
                max_coincidence=new ArrayList<>(word);
                prefix=s.substring(max_coincidence.size());
            }}
        
        String prefix_reversed=new StringBuilder(prefix).reverse().toString();
        StringBuilder middle = new StringBuilder();
        for (char c : max_coincidence) {
            middle.append(c);
        }
        
        String palindrome= prefix_reversed+middle.toString()+prefix;
        return palindrome;
            }
    }

public class Problem3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String input1 = "aacecaaa";
        String result1 = solution.shortestPalindrome(input1);
        System.out.println(result1);

        String input2 = "abcd";
        String result2 = solution.shortestPalindrome(input2);
        System.out.println(result2);
    }
}
