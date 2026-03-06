class Solution {
    
    public int romanToInt(String s) {
        
        char[] symbols = {'I','V','X','L','C','D','M'};
        int[] values = {1,5,10,50,100,500,1000};
        
        int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            int current = 0;
            
            // Find value using loop (extra runtime)
            for (int j = 0; j < symbols.length; j++) {
                if (s.charAt(i) == symbols[j]) {
                    current = values[j];
                }
            }
            
            if (i + 1 < s.length()) {
                
                int next = 0;
                
                for (int j = 0; j < symbols.length; j++) {
                    if (s.charAt(i + 1) == symbols[j]) {
                        next = values[j];
                    }
                }
                
                if (current < next) {
                    total = total - current;
                } else {
                    total = total + current;
                }
            } 
            else {
                total = total + current;
            }
        }
        
        return total;
    }
}