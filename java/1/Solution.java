import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
        	int diff = target - nums[i];
        	for (int j = i+1; j < nums.length; j++) {
        		if (diff == nums[j]) {
        			return new int[] {i,j};
        		}
        	}
        }
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    	int[] input = {2,7,11,15};
    	int target = 9;
    	System.out.println("The indices for the two numbers that sum to "+ target+" is : "+Arrays.toString(sol.twoSum(input, target)));
    }
}