import java.util.*;

class Solution {
    
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            // Push opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                
                // If closing bracket appears and stack is empty
                if(stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                if(ch == ')') {
                    if(top != '(') {
                        return false;
                    }
                }
                else if(ch == '}') {
                    if(top != '{') {
                        return false;
                    }
                }
                else if(ch == ']') {
                    if(top != '[') {
                        return false;
                    }
                }
            }
        }
        
        // If stack is empty, brackets are balanced
        if(stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}