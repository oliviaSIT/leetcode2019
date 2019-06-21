import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return res;
        }

        dict.remove(beginWord);
        dict.remove(endWord);

        Map<String, Integer> steps = new HashMap<>();//how many steps to get the word
        steps.put(beginWord, 1);
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int step = 0;
        boolean found = false;

        while (!q.isEmpty() && !found) {
            step++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String str = q.poll();
                char[] cur = str.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char temp = cur[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == temp) {
                            continue;
                        }

                        cur[j] = c;
                        String newStr = String.valueOf(cur);
                        if (newStr.equals(endWord)) {
                            found = true;
                            if (!parents.containsKey(newStr)) {
                                parents.put(newStr, new ArrayList<>());
                            }

                            parents.get(newStr).add(str);
                        } else {
                            // Not a new word, but another transform
                            // with the same number of steps
                            if (steps.containsKey(newStr) && step < steps.get(newStr)) {
                                if (!parents.containsKey(newStr)) {
                                    parents.put(newStr, new ArrayList<>());
                                }

                                parents.get(newStr).add(str);
                            }

                            if (!dict.contains(newStr)) {

                                continue;
                            }
                        }

                        dict.remove(newStr);
                        q.offer(newStr);
                        if (steps.containsKey(newStr)) {
                            steps.replace(newStr, steps.get(str) + 1);
                        } else {
                            steps.put(newStr, steps.get(str) + 1);
                        }

                        if (!parents.containsKey(newStr)) {
                            parents.put(newStr, new ArrayList<>());
                        }

                        parents.get(newStr).add(str);

                    }

                    cur[j] = temp;
                }
            }
        }

        if (found) {
            List<String> ans = new ArrayList<>();
            ans.add(endWord);
            getPath(beginWord, endWord, parents, ans, res);
        }
        return res;
    }

    private void getPath(String beginWord, String word, Map<String, List<String>> parents, List<String> ans, List<List<String>> res) {
        if (word.equals(beginWord)) {
            Collections.reverse(ans);
            res.add(new ArrayList<>(ans));
            Collections.reverse(ans);
            return;
        }

        for (String str : parents.get(word)) {
            ans.add(str);
            getPath(beginWord, str, parents, ans, res);
            ans.remove(ans.size() - 1);
        }
    }
/*
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

*/
}