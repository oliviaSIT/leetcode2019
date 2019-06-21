/*
https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
hard
solution: array记录val，这是第几个相同的Val, map 记录 val, 以及所有val在array中的位置
https://zxi.mytechroad.com/blog/hashtable/leetcode-381-insert-delete-getrandom-o1-duplicates-allowed/
 */

import java.util.*;

public class InsertDeleteGetrandomDulplicates {
    public class Entry {
        public int value;
        public int index;

        public Entry(int val, int i) {
            this.value = val;
            this.index = i;
        }
    }

    private Map<Integer, List<Integer>> m;
    private List<Entry> vals;
    private Random rand;

    /** Initialize your data structure here. */
    public InsertDeleteGetrandomDulplicates() {
        m = new HashMap<>();
        vals = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        List<Integer> l = m.getOrDefault(val, new ArrayList<>());
        l.add(vals.size());
        m.put(val, l);
        vals.add(new Entry(val, l.size()-1));
        return l.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!m.containsKey(val))
            return false;

        List<Integer> l = m.get(val);
        int index_evict = l.get(l.size() - 1);
        Entry lastEntry = vals.get(vals.size() - 1);
        m.get(lastEntry.value).set(lastEntry.index, index_evict);
        vals.set(index_evict, lastEntry);
        vals.remove(vals.size() - 1);
        l.remove(l.size() - 1);
        if (l.size() == 0)
            m.remove(val);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size())).value;
    }
}
