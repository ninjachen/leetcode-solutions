package rocks.ninjachen.leet_code_solutions;

/**
 * https://leetcode.com/contest/weekly-contest-153/problems/distance-between-bus-stops/
 */
public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        DistanceBetweenBusStops s = new DistanceBetweenBusStops();
        int[] distance = {1,2,3,4};
        int distanceShortest = s.distanceBetweenBusStops(distance, 0 , 3);
        System.out.println(distanceShortest);
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int distance1 = 0;
        for (int i = start; i != destination; i = (i + 1) % n) {
            distance1 += distance[i];
        }
        int distance2 = 0;
        for (int i = destination; i != start; i = (i + 1) % n) {
            distance2 += distance[i];
        }
        return distance1 < distance2 ? distance1 : distance2;
    }
}
