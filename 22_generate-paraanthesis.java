import java.util.*;

class Solution {
    
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        
        generate("", n * 2, result);
        
        return result;
    }
    
    
    public void generate(String current, int length, List<String> result) {
        
        if(current.length() == length) {
            
            if(isValid(current)) {
                result.add(current);
            }
            
            return;
        }
        
        generate(current + "(", length, result);
        generate(current + ")", length, result);
    }
    
    
    public boolean isValid(String s) {
        
        int balance = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(c == '(') {
                balance++;
            }
            else {
                balance--;
            }
            
            if(balance < 0) {
                return false;
            }
        }
        
        return balance == 0;
    }
}