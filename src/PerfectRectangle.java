/*
https://leetcode.com/problems/perfect-rectangle/
hard
solution:
遍历数组，将顶点放入集合中，已经存在就删除。这样可以把出现偶数次的顶点删除， 最后留下4个只出现一次的顶点，面积如果符合要求，返回真
http://www.cnblogs.com/grandyang/p/5825619.html
 */

import java.util.Set;
import java.util.HashSet;

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> s = new HashSet<>();
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE, yMin = Integer.MAX_VALUE, yMax = Integer.MIN_VALUE, area = 0;

        for (int[] rec: rectangles) {
            String l_d = String.valueOf(rec[0]) + "," + String.valueOf(rec[1]);
            String l_u = String.valueOf(rec[0]) + "," + String.valueOf(rec[3]);
            String r_u = String.valueOf(rec[2]) + "," + String.valueOf(rec[3]);
            String r_d = String.valueOf(rec[2]) + "," + String.valueOf(rec[1]);
            if (s.contains(l_u))
                s.remove(l_u);
            else s.add(l_u);

            if (s.contains(l_d))
                s.remove(l_d);
            else s.add(l_d);

            if (s.contains(r_u))
                s.remove(r_u);
            else s.add(r_u);

            if (s.contains(r_d))
                s.remove(r_d);
            else s.add(r_d);

            xMin = Math.min(xMin, rec[0]);
            xMax = Math.max(xMax, rec[2]);
            yMin = Math.min(yMin, rec[1]);
            yMax = Math.max(yMax, rec[3]);

            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
        }

        String l_u = String.valueOf(xMin) + "," + String.valueOf(yMax);
        String l_d = String.valueOf(xMin) + "," + String.valueOf(yMin);
        String r_u = String.valueOf(xMax) + "," + String.valueOf(yMax);
        String r_d = String.valueOf(xMax) + "," + String.valueOf(yMin);

        if (!s.contains(l_u) || !s.contains(l_d) || !s.contains(r_u) || !s.contains(r_d) || s.size() != 4)
            return false;

        return area == (xMax - xMin) * (yMax - yMin);
    }
}
