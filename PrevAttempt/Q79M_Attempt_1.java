// 79. Word Search (Medium)
// https://leetcode.com/problems/word-search/

public class Q79M_Attempt_1 {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r ++) {
            for(int c = 0; c < board[0].length; c ++) {
                if(board[r][c] == word.charAt(0)) {
                    boolean[] foundWord = new boolean[1];
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    dfs(board, r, c, word, 0, foundWord, visited);
                    if(foundWord[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void dfs(char[][] board, int r, int c, String word, int wordIdx, boolean[] foundWord, boolean[][] visited) {
        if(wordIdx >= word.length()) {
            foundWord[0] = true;
            return;
        }
        // Out of grid area
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        if(!visited[r][c] && board[r][c] == word.charAt(wordIdx)) {
            visited[r][c] = true;
            dfs(board, r - 1, c, word, wordIdx + 1, foundWord, visited);
            visited[r][c] = true;
            dfs(board, r + 1, c, word, wordIdx + 1, foundWord, visited);
            visited[r][c] = true;
            dfs(board, r, c + 1, word, wordIdx + 1, foundWord, visited);
            visited[r][c] = true;
            dfs(board, r, c - 1, word, wordIdx + 1, foundWord, visited);
        }
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        Q79M_Attempt_1 test1 = new Q79M_Attempt_1();
        char[][] arr1 = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(test1.exist(arr1, "ABCESEEEFS"));
    }
}
