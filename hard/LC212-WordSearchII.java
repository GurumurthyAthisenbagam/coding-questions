/**

Finds multiple words in a grid.
uses: Trie, DFS and backtracking

Trie = for loading all words
DFS for checking character in neighbours
backtracking for not visiting same node multiple times

complexity
gird is mxn
we look in 4 directions and look for 'w' number of words 

O(mn * w * 4^w)
 */


class TrieNode { 
    HashMap<Character, TrieNode> children; 
    boolean isWord = false;

    TrieNode() {
        children = new HashMap();
        isWord = false;
    }
}

class Solution {

    boolean[][] visited;
    HashSet<String> res = new HashSet<>();
    TrieNode head = new TrieNode();
    int ROWS ;
    int COLS ;

    void addWords(String[] words) {
        
        for(int i =0; i<words.length; i++) {
            TrieNode cur = head;
            for(Character ch: words[i].toCharArray()){
                if(!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new TrieNode());
                }
                cur = cur.children.get(ch);
            }
            cur.isWord = true;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {

    addWords(words); // build trie
    ROWS =  board.length;
    COLS =  board[0].length;

    visited = new boolean[ROWS][COLS];

    for(int i=0; i<ROWS; i++) {
        for(int j=0; j<COLS; j++) {
            dfs(board,i,j,head, "");
        }
    }

    return new ArrayList(res);
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS || visited[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        TrieNode currNode = node.children.get(board[r][c]);
        word+= (char) board[r][c];
        if(currNode.isWord) {
            res.add(word);
        }
        visited[r][c] = true;

        dfs(board,r,c-1,currNode, word);
        dfs(board,r,c+1,currNode, word);
        dfs(board,r-1,c,currNode, word);
        dfs(board,r+1,c,currNode, word);

        visited[r][c] = false;
    }
}
