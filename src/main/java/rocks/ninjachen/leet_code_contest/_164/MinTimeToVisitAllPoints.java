package rocks.ninjachen.leet_code_contest._164;

public class MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalDis = 0;
        for (int i = 1; i < points.length; i++) {
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];
            int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            if ((x1 > x2 && y1 > y2) || (x1 < x2 && y1 < y2)) {
                if (x1 > x2 && y1 > y2) {
                    // swap point1 with point2
                    int tmp = x1;
                    x1 = x2;
                    x2 = tmp;
                    tmp = y1;
                    y1 = y2;
                    y2 = tmp;
                }
                int shareDis = Math.min(x2 - x1, y2 - y1);
                dis -= shareDis;
            }
            totalDis += dis;
        }
        return totalDis;
    }
}
