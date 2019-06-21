import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> m = new HashMap<>();

        for (int l = 0, r = 0; l < nums.length; l++) {

            while (r < nums.length && r <= l + k) {
                if (m.getOrDefault(nums[r], 0) > 0) {
                    return true;
                }

                for (int h = nums[r] - t; h <= nums[r] + t; h++) {
                    m.put(h, m.getOrDefault(h, 0) + 1);
                }

                r++;
            }

            if (r == nums.length)
                return false;

            for (int h = nums[l] - t; h <= nums[l] + t; h++) {
                m.put(h, m.get(h) - 1);
            }
        }

        return false;
    }
/*
    public static void main(String[] args) {
        ContainsDuplicateIII sol = new ContainsDuplicateIII();
        int[] nums = {1, 5, 9, 1, 5, 9};
        System.out.println(sol.containsNearbyAlmostDuplicate(nums, 2, 3));
    }
*/
}
