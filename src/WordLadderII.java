import java.util.*;

public class WordLadderII {
    private List<List<String>> res;
    private Map<String, List<String>> neighbors;
    private Map<String, Integer> dis;
    private Set<String> dict;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();

        dict = new HashSet<>(wordList);
        dict.add(beginWord);

        neighbors = getNeighbors();

        dis = new HashMap<>();

        bfs(beginWord, endWord);
        dfs(beginWord, endWord, new ArrayList<>());

        return res;
    }

    private Map<String, List<String>> getNeighbors() {
        Map<String, List<String>> m = new HashMap<>();

        for (String word: dict) {
            m.put(word, new ArrayList<>());

            char[] charArr = word.toCharArray();

            for (int i = 0; i < charArr.length; i++) {
                char cur = charArr[i];

                for (char n = 'a'; n < 'z'; n++) {
                    if (n != cur) {
                        charArr[i] = n;
                        String str = new String(charArr);
                        if (dict.contains(str)) {
                            m.get(word).add(str);
                        }
                    }
                }

                charArr[i] = cur;
            }
        }

        return m;
    }

    private void bfs(String beginWord, String endWord) {
        dis.put(beginWord, 0);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curWord = q.poll();
                int d = dis.get(curWord);
                boolean flag = false;
                List<String> nextNodes = neighbors.get(curWord);
                for (int j = 0; j < nextNodes.size(); j++) {
                    String node = nextNodes.get(j);
                    if (!dis.containsKey(node)) {
                        dis.put(node, d + 1);

                        if (node.equals(endWord))
                            flag = true;
                    }
                }

                if (flag)
                    break;
            }
        }
    }

    private void dfs(String beginWord, String endWord, List<String> cur) {
        cur.add(beginWord);

        if (beginWord.equals(endWord)) {
            System.out.println(beginWord);
            res.add(new ArrayList<>(cur));
            //cur.remove(cur.size() - 1);
            return;
        }

        List<String> nextNodes = neighbors.get(beginWord);

        for (int i = 0; i < nextNodes.size(); i++) {
            String node = nextNodes.get(i);
            if (dis.containsKey(node) && dis.get(node) == dis.get(beginWord) + 1) {
                dfs(node, endWord, cur);
            }
        }

        cur.remove(cur.size() - 1);
    }

    public static void main(String arg[]) {
        WordLadderII sol = new WordLadderII();
        List<String> word = new ArrayList<>();
        word.add("hot");
        word.add("dot");
        word.add("dog");
        word.add("lot");
        word.add("log");
        word.add("cog");
        sol.findLadders("hit", "cog", word);
    }


}