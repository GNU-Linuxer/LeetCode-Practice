// 127. Word Ladder (Hard)
// https://leetcode.com/problems/word-ladder/

import java.util.*;

// Solution is correct but exceeds time limit
public class Q127H_Correct_NonOptimal {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.indexOf(endWord) == -1) {
            return 0;
        }
        wordList.add(beginWord);
        // Build a Graph (using adjacency list data structure) that connects two words if it differs by no more than 1 letter
        boolean[][] graph = new boolean[wordList.size()][wordList.size()]; // graph[i][j] = true means wordList.get(i) and wordList.get(j) differs from 1, false otherwise
        Set<String> visited = new HashSet<String>();
        constructGraph(graph, wordList);

        Queue<String> queue1 = new LinkedList<String>();
        queue1.add(beginWord);
        int layer = 1;
        while(!queue1.isEmpty()) {
            Queue<String> queue2 = new LinkedList<String>();
            while(!queue1.isEmpty()) {
                String top = queue1.remove();
                if(!visited.contains(top)) {
                    visited.add(top);
                    if(top.equals(endWord)) {
                        return layer;
                    }
                    List<String> neighbors = getNeighbors(graph, top, wordList);
                    for(String s : neighbors) {
                        queue2.add(s);
                    }
                }
            }
            layer++;
            queue1 = queue2;
        }
        return 0;
    }

    public List<String> getNeighbors(boolean[][] graph, String s, List<String> wordList) {
        int i = wordList.indexOf(s);
        List<String> result = new LinkedList<String>();
        for(int j = 0; j < wordList.size(); j ++) {
            if(graph[i][j]) {
                result.add(wordList.get(j));
            }
        }
        return result;
    }

    public void constructGraph(boolean[][] graph, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i ++) {
            for(int j = 0; j < wordList.size(); j ++) {
                if(i != j) {
                    if(compareStrings(wordList.get(i), wordList.get(j))) {
                        graph[i][j] = true;
                    }
                }
            }
        }
    }

    public boolean compareStrings(String st1, String st2) {
        int difference = 0;
        for(int i = 0; i < st1.length(); i ++) {
            if(st1.charAt(i) != st2.charAt(i)) {
                difference ++;
            }
        }
        return difference == 1;
    }

    public static void main(String[] args){
        Q127H_Correct_NonOptimal test1 = new Q127H_Correct_NonOptimal();
        List<String> stringList = new LinkedList<>();
        stringList.add("hot");
        stringList.add("dot");
        stringList.add("dog");
        stringList.add("lot");
        stringList.add("log");
        stringList.add("cog");

        System.out.println(test1.ladderLength("hit", "cog", stringList));
    }
}
