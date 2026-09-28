class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Solution 1 : Using sorting
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n-1; i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;

        //Solution 2: Using Hashmap

        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i= 0 ;i<n ; i++){
            if(map.containsKey(nums[i])){    //if curr number is already present in the hashmap then we have found a duplicate
                return true;
            }
            else{
                map.put(nums[i], i); //if number is encountered for the first time then put it in the hashmap
            }
        }

        return false;
    }
