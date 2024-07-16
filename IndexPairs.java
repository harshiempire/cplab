import java.util.*;

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        // Initializing Trie and putting all words from the words array into the Trie.
        Trie trie = new Trie();
        for (String s : words) {
            Trie cur = trie;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }
                cur = cur.children[c - 'a'];
            }
            cur.end = true;  // Mark there is a word
        }

        int len = text.length();
        List<int[]> list = new ArrayList<>();

        // Checking each substring of text individually.
        for (int i = 0; i < len; i++) {
            Trie cur = trie;
            char cc = text.charAt(i);
            int j = i;  // j is our moving index

            while (cur.children[cc - 'a'] != null) {
                cur = cur.children[cc - 'a'];
                if (cur.end) {
                    // There is a word ending here, put it into our list
                    list.add(new int[]{i, j});
                }
                j++;
                if (j == len) {
                    // Reach the end of the text, we stop
                    break;
                } else {
                    cc = text.charAt(j);
                }
            }
        }

        // Put all the pairs from list into array
        int size = list.size();
        int[][] res = new int[size][2];
        int i = 0;
        for (int[] r : list) {
            res[i] = r;
            i++;
        }
        return res;
    }
}

class Trie {
    Trie[] children;
    boolean end;  // Indicate whether there is a word

    public Trie() {
        end = false;
        children = new Trie[26];
    }
}

class IndexPairs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String org = sc.nextLine();
        String dict[] = sc.nextLine().split(" ");
        int res[][] = new Solution().indexPairs(org, dict);
        for (int[] ans : res) {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

