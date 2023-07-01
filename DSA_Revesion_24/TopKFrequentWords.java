import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> frequencyMap.get(a).equals(frequencyMap.get(b)) ?
                        b.compareTo(a) : frequencyMap.get(a) - frequencyMap.get(b)
        );

        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "banana", "orange", "orange", "orange"};
        int k = 2;
        List<String> topKFrequentWords = topKFrequent(words, k);
        System.out.println("The " + k + " most frequent words are: " + topKFrequentWords);
    }
}
