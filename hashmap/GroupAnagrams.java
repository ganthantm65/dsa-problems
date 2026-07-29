package hashmap;

import java.util.*;

public class GroupAnagrams {

    static List<List<String>> findGroupAnagram(List<String> lst) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : lst) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);

            String key = new String(charArr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        List<String> lst = Arrays.asList(
                "eat", "tea", "tan", "ate", "nat", "bat"
        );

        List<List<String>> result = findGroupAnagram(lst);

        System.out.println(result);
    }
}