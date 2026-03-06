class Solution {
    
    public boolean isMatch(String s, String p) {
        return checkMatch(s, p);
    }
    
    public boolean checkMatch(String s, String p) {
        
        // If pattern is empty
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        boolean firstMatch = false;
        
        if (s.length() > 0) {
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                firstMatch = true;
            }
        }
        
        // Check if second character of pattern is '*'
        if (p.length() >= 2 && p.charAt(1) == '*') {
            
            // Two cases:
            // 1. Ignore current char and '*'
            // 2. If first match, move string forward
            
            return (checkMatch(s, p.substring(2)) ||
                   (firstMatch && checkMatch(s.substring(1), p)));
        }
        else {
            return firstMatch && 
                   checkMatch(s.substring(1), p.substring(1));
        }
    }
}