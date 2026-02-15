class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();
        int open = 0;

        // First pass: remove extra ')'
        for (char c : s.toCharArray()) {

            if (c == '(') {
                open++;
                sb.append(c);
            } 
            else if (c == ')') {

                if (open > 0) {   // only keep if matching '(' exists
                    open--;
                    sb.append(c);
                }
            } 
            else {
                sb.append(c); // letters
            }
        }

        // Second pass: remove extra '(' from right
        StringBuilder result = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {

            char c = sb.charAt(i);

            if (c == '(' && open-- > 0) {
                continue; // skip extra '('
            }

            result.append(c);
        }

        return result.reverse().toString();
    }
}
