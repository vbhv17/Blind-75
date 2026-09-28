class Solution {
    public boolean isAnagram(String s, String t) {
        //Solution using HashMap

        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);   //If character is already present in hashmap then increase its count by 1, if its encountered for the first time then add it and set count to 1
        }

        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch) || map.get(ch) == 0){ //if character is not present in hashmap or if count of character is 0 (multiple occurence not found)
                return false; 
            }

            map.put(ch, map.get(ch) -1);
        }
        return true;

        //Solution using 26 length Array
        if(s.length() != t.length()){
            return false;
        }

        int count[] = new int[26]; //chars a-z can be represented in a 26 length array using ascii values 

        for(int i = 0 ; i<s.length(); i++){
            count[s.charAt(i) - 'a']+=1;
        }

        for(int i = 0 ; i<t.length(); i++){
            if(count[t.charAt(i) - 'a'] == 0){
                return false;
            }

            count[t.charAt(i) - 'a']-=1;
        }

        return true;
    }
}
