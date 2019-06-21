import java.util.*;

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        Map<Integer, Integer> m = new HashMap<>(); // {time, how many rooms}

        for (Interval interval: intervals) {
            int st = interval.st, ed = interval.ed;
            m.put(st, m.getOrDefault(st, 0) + 1);
            m.put(ed, m.getOrDefault(ed, 0) - 1);
        }

        int res = 0, rooms = 0;

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            res = Math.max(res, rooms += entry.getValue());
        }
        return res;
    }
}

class Interval {
    int st, ed;

    public Interval(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }
}
