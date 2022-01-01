// 472. Concatenated Words (Hard)
// https://leetcode.com/problems/concatenated-words/

import java.util.*;

public class Q472H_NonOptimal {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words[0] == null) {
            return new ArrayList<String>();
        }

        int longestWord = Integer.MIN_VALUE;

        // Cue: all words are unique: use Set
        Set<String> wordsSet = new HashSet<String>();
        for (String str : words) {
            // Constraint is 0 <= words[i].length <= 1000
            // Hence we need to check empty string case and skip it
            if (str.length() != 0) {
                longestWord = Math.max(longestWord, str.length());
                wordsSet.add(str);
            }
        }

        // Sort words by length (no need to sort alphabetically afterwards)
        //List<String> sortedWords = Arrays.asList(words);
        //sortedWords.sort(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase));
        //sortedWords.sort(Comparator.comparing(String::length));
        //int longestWord = sortedWords.get(sortedWords.size()-1).length();

        //sortedWords = null;

        //Set<String> resultSet = new HashSet<String>();
        List<String> resultList = new LinkedList<String>();

        for (String str : wordsSet) {
            for (String strSec : wordsSet) {
                concatenate(wordsSet, str + strSec, longestWord, resultList);
            }
        }

        //return new LinkedList<String>(resultSet);
        return resultList;
    }


    private void concatenate(Set<String> wordsSet, String currWord, int longestWord, List<String> resultSet) {
        if (currWord.length() > longestWord || wordsSet.stream().noneMatch(str -> (currWord.startsWith(str)))) {
            return;
        }
        if (wordsSet.contains(currWord)) {
            resultSet.add(currWord);
        }
        for (String str : wordsSet) {
            concatenate(wordsSet, currWord + str, longestWord, resultSet);
        }
    }

    public static void main(String[] args) {
        Q472H_NonOptimal test1 = new Q472H_NonOptimal();
        String[] arr1 = {"dog", "cat", "catdogdog"};
        System.out.println(test1.findAllConcatenatedWordsInADict(arr1));
    }

}
