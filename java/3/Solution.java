import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int begin, end, ptr = 0, maxlen = 0;
        HashMap<Character, Integer> idx = new HashMap<Character, Integer>(); //Solution.java uses unchecked or unsafe operations. This comes up in Java 5 and later if you're using collections without type specifiers (e.g., Arraylist() instead of ArrayList<String>()). It means that the compiler can't check that you're using the collection in a type-safe way, using generics.
        while (i < s.length()) {
        	while (i < s.length() && !idx.containsKey(s.charAt(i))) {
        		idx.put(s.charAt(i), i);
        		i++;
        	}
        	if (maxlen < idx.size()) {
        		begin = ptr;
        		end = i - 1;
        		maxlen = idx.size();
        	}
        	if (i == s.length()) {
        		break;
        	}
        	ptr = idx.get(s.charAt(i)) + 1;
        	idx = new HashMap<Character, Integer>();
        	i = ptr;
        }
        return maxlen;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s = "abcabcbb";
    	System.out.println(sol.lengthOfLongestSubstring(s));
    }
}