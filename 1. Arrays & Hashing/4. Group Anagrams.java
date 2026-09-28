class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //Solution 1: Using Sorting
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());


        //Solution 2: Without Sorting, Using 26 length frequency Array
        // 1. Iterate over each string in input array and build its ASCII array, of 01s and 1s
        // 2. Iterate over this built array and check which indexes are 1 -> will give the sorted string
        // 3. Check if this sorted string is already present in the hashMap, if yes, add current string to its List, if not add sorted string to hashmap current string to its list 
        // 4. in the end return the values part of the hashmap

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            int count[] = new int[26];
            char word[] = s.toCharArray();

            for(char ch : word){
                count[ch - 'a' ]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<26; i++){
                int cnt = count[i];
                while(cnt > 0){
                    sb.append(i + 'a');
                    cnt--;
                }
            }

            String key = new String(sb);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());

    }
}
