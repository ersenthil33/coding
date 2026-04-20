class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        int l=0,r=n-1;
        while(l<r) {
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            char L=Character.toLowerCase(s.charAt(l));
            char R=Character.toLowerCase(s.charAt(r));
            if(L!=R) return false;
            l++;
            r--;
        }
        return true;
    }
}