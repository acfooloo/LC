public class Solution {
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return s1.compareTo(s2);
    }

    public int reverse(int x) {
        int signx = 1;
        if (x < 0) {
            signx = -1;
            x = -x;
        }
        String input = Integer.toString(x);
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            result = input.charAt(i) + result;
        }
        if ((signx > 0 && compare(result, "2147483647") <= 0) ||
            (signx < 0 && compare(result, "2147483648") <= 0)) {
            if (signx < 0) {
                result = "-" + result;
            }
            return Integer.parseInt(result);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.reverse(-123));
    }
}