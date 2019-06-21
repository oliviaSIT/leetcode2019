/*
https://leetcode.com/problems/walking-robot-simulation/
easy
solution: direct string
 */

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> ob = new HashSet<>();

        for (int[] item: obstacles) {
            String s = String.valueOf(item[0]) + "," + String.valueOf(item[1]);
            ob.add(s);
        }

        int[][] direct = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int curDirect = 0;//N:0 E:1 S:2 W:3
        int x = 0, y = 0;
        long res = 0;

        for (int command: commands) {
            if (command == -2) { //逆时针
                curDirect--;

                if (curDirect < 0)
                    curDirect = 3;

                continue;
            }

            if (command == -1) { //顺时针
                curDirect++;
                curDirect %= 4;
                continue;
            }

            for (int j = 0; j < command; j++) {
                int nx = x + direct[curDirect][0], ny = y + direct[curDirect][1];
                String s = String.valueOf(nx) + "," + String.valueOf(ny);

                if (ob.contains(s))
                    break;

                x = nx;
                y = ny;

                long len = (long)Math.pow(x, 2) + (long)Math.pow(y, 2);
                res = Math.max(res, len);
            }
        }

        return (int)res;
    }
}
