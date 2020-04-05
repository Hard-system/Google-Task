package lectures;

import java.util.*;
import java.util.stream.Collectors;
//Solved by HardSystem
//This solution is not the best, try to improve it :)
public class Lecture11 {

    public static void main(String[] args) {
        String[] dict = { "able", "ale", "apple", "bale", "kangaroo"};
        String word = "abppplee";
        String longestWord = longestWord(dict, word);
        System.out.println(longestWord);
    }

    private static String longestWord(String[] dict, String word) {
        Map<List<Integer>, String > correctWord = new HashMap<>();
        Map<Integer, String > first = new HashMap<>();
        for (String wordDict : dict) {
            List<Integer> order = new ArrayList<>();
            for (int u = 0; u < word.length(); u++) {
                first.put(u, Character.toString(word.charAt(u)));
            }
            for (int j = 0; j < wordDict.length(); j++) {
                for (Map.Entry<Integer, String> entry : first.entrySet()) {
                    if (Character.toString(wordDict.charAt(j)).equals(entry.getValue())) {
                        first.replace(entry.getKey(), "");
                        order.add(entry.getKey());
                        break;
                    }
                    first.replace(entry.getKey(), "");
                }
            }
            correctWord.put(order, wordDict);
        }
        List<String> collect = correctWord.entrySet().stream()
                .filter(listStringEntry -> listStringEntry.getKey().size() == listStringEntry.getValue().length())
                .map(Map.Entry::getValue).collect(Collectors.toList());
        return Collections.max(collect, Comparator.comparing(String::length));
    }


}
