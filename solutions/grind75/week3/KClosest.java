package solutions.grind75.week3;

import java.util.Comparator;
import java.util.PriorityQueue;

class kClosest {
    public int[][] KClosest(int[][] points, int k) {
        PriorityQueue<Point> pointQueue = new PriorityQueue<>(new PointsComparator());
    
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            pointQueue.add(new Point(calcDist(point[0], point[1]), point));
        }

        int[][] sol = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point point = pointQueue.poll();
            sol[i] = point.getPoint();
        }

        return sol;
    }

    public double calcDist(int x, int y) {
        double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return dist;
    }

    public class Point {
        public double distance;
        public int[] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }

        public int[] getPoint() {
            return point;
        }
    }

    public class PointsComparator implements Comparator<Point> {
        
        @Override
        public int compare(Point p1, Point p2) {
            return Double.compare(p1.distance, p2.distance);
        }
    }
}

