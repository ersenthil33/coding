import java.util.*;

class Solution {
    
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        result.add("");   // Start with empty string
        
        for (int i = 0; i < digits.length(); i++) {
            
            List<String> temp = new ArrayList<>();
            String letters = map.get(digits.charAt(i));
            
            for (int j = 0; j < result.size(); j++) {
                
                String current = result.get(j);
                
                for (int k = 0; k < letters.length(); k++) {
                    
                    // Using string concatenation (slower than StringBuilder)
                    String newCombination = current + letters.charAt(k);
                    temp.add(newCombination);
                }
            }
            
            result = temp;   // Replace old list
        }
        
        return result;
    }
}