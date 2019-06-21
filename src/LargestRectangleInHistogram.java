import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> s = new Stack<>(); // restore the left side of histogram
        int res = 0;

        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? -1 : heights[i];

            while (!s.isEmpty() && cur < heights[s.peek()]) {
                int h = heights[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                res = Math.max(res, h * w);
            }

            s.push(i);
        }

        return res;
    }
}
