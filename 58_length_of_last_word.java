class Solution {
    public int lengthOfLastWord(String s) {
        int n = 0;
        boolean isvalid = false;

        for (int i = s.length() - 1; i >= 0; --i) {
            if (!Character.isLetter(s.charAt(i))) {
                if (isvalid)
                    return n;
            } else {
                n++;
                isvalid = true;
            }
        }

        return n;
    }
}