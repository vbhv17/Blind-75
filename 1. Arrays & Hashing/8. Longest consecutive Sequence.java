class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        int result = 0;
        int length;
        Set<Integer> set = new HashSet<>();

        for(int x : nums){
            set.add(x);
        }

        for(int num : set){
            if(!set.contains(num-1)){    //if set contains num-1, then num is not the start of the sequence, its the middle. We want only longest subsequence so we can skip calculating the length of this subsequence
                length = 1;
                while(set.contains(num+length)){  //if next consecutive element is present in the set, increase length
                    length++;
                }
            }
            else{
                continue;
            }
            
            result = Math.max(result, length);
        }
        return result;
    }
}

TC : O(N) SC : O(N)
