import java.util.HashMap;

class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println("majorityElement " + majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    private int majorityElement(int[] nums) {
        int size = nums.length / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.containsKey(nums[i]) ? hashMap.get(nums[i]) + 1 : 1);
            if (hashMap.get(nums[i]) > size)
                return nums[i];
        }
        return -1;
    }
}