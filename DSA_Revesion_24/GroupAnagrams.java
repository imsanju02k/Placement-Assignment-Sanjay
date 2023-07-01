import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort the characters of the string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Check if the sorted string is already present in the map
            // If not, add it as a new key with an empty list as the value
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            // Add the current string to the list of anagrams for the sorted string
            map.get(sortedStr).add(str);
        }

        // Convert the values of the map to a list and return
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(strs);

        // Print the grouped anagrams
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
