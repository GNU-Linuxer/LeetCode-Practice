// 79. Word Search (Medium)
// https://leetcode.com/problems/word-search/

public class Q79M {
    public boolean exist(char[][] board, String word) {
        boolean[] foundWord = new boolean[1];
        for(int r = 0; r < board.length; r ++) {
            for(int c = 0; c < board[0].length; c ++) {
                if(board[r][c] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(dfs(board, r, c, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, String word, int wordIdx, boolean[][] visited) {
        if(wordIdx >= word.length()) {
            return true;
        }
        // Out of grid area bound
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        if(visited[r][c]) {
            return false;
        }
        if(board[r][c] != word.charAt(wordIdx)) {
            return false;
        }
        visited[r][c] = true; // Choose this letter
        if(dfs(board, r - 1, c, word, wordIdx + 1, visited)||
                dfs(board, r + 1, c, word, wordIdx + 1, visited)||
                dfs(board, r, c + 1, word, wordIdx + 1, visited)||
                dfs(board, r, c - 1, word, wordIdx + 1, visited)) {
            return true;
        } else {
            visited[r][c] = false; // Un-choose this letter
            return false;
        }
    }

    public static void main(String[] args) {
        Q79M test1 = new Q79M();
        char[][] arr1 = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(test1.exist(arr1, "ABCESEEEFS"));
    }
}
