public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        if (l % 2 == 1) {
            return findkth(l / 2, nums1, 0, nums2, 0);
        } else {
            return (findkth(l / 2, nums1, 0, nums2, 0) +
                        findkth(l / 2 - 1, nums1, 0, nums2, 0)) / 2.0f;
        }
    }

    public int findkth(int k, int[] a, int ha, int[] b, int hb) {
        if (ha >= a.length) {
            return b[hb + k];
        }
        if (hb >= b.length) {
            return a[ha + k];
        }
        if (k == 0) {
            return min(a[ha], b[hb]);
        }
        if (k == 1) {
            if (a[ha] < b[hb]) {
                return findkth(0, a, ha+1, b, hb);
            } else {
                return findkth(0, a, ha, b, hb+1);
            }
        }
        int stepA = min(k / 2, a.length - ha);
        int stepB = k - stepA;
        if (stepB > b.length - hb) {
            stepB = b.length - hb;
            stepA = k - stepB;
        }
        int numA = a[ha + stepA - 1];
        int numB = b[hb + stepB - 1];
        if (numA < numB) {
            k -=  stepA;
            ha += stepA;
        } else {
            k -= stepB;
            hb += stepB;
        }
        return findkth(k, a, ha, b, hb);
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solver.findMedianSortedArrays(nums1, nums2));
    }
}