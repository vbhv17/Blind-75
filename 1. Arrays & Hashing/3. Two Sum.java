class Solution {
    //Solution 1: Bruteforce
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        for(int i = 0; i<n-1 ; i++){
            for(int j=i+1; j<n ; j++){
                if( nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{};
    }

    //Solution 2: 2 pass using Hashmap
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i =0; i<n ; i++)
            numsMap.put(nums[i], i);

        for(int i = 0; i<n; i++){
            int compliment = target - nums[i];

            if(numsMap.containsKey(compliment) && (i != numsMap.get(compliment))){
                return new int[]{i, numsMap.get(compliment)};
            }
            
        }

        return new int[]{};
        
    }

    //Solution 3: Single pass using HashMap
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i =0; i<n ; i++){
            int compliment = target - nums[i];
            if(numsMap.containsKey(compliment) && (i != numsMap.get(compliment))){
                return new int[]{i, numsMap.get(compliment)};
            }
            numsMap.put(nums[i], i);
        }

        return new int[]{};

    }
}
