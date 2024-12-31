class Solution {
    public int maxNumberOfBalloons(String text) {

        // text = String.toLowerCase(text);//text consists of lower case English letters only

        HashMap<Character,Integer> map = new HashMap<>();
        //Store only characters of Balloon
       // Count the occurrences of each character in the text
        for (char c : text.toCharArray()) {           //map.get(i) won't work because i isn't a valid key.
                                                       //The keys are characters, not indices.
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        int min = Integer.MAX_VALUE;

        min = Math.min(min, map.getOrDefault('b', 0));       // 'b'
        min = Math.min(min, map.getOrDefault('a', 0));       // 'a'
        min = Math.min(min, map.getOrDefault('l', 0) / 2);   // 'l' appears twice
        min = Math.min(min, map.getOrDefault('o', 0) / 2);   // 'o' appears twice
        min = Math.min(min, map.getOrDefault('n', 0));       // 'n'

        return min;
    }
}