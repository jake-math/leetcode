package solutions.grind75.week3;

class kClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointAndDistance> heap = new PriorityQueue<>(new PointAndDistanceComparator());

        for (int[] point : points) {
            double distance = calcDistance(point);
            heap.add(new PointAndDistance(point, distance));
        }

        int index = 0;
        int[][] sol = new int[k][2];

        while (index < k) {
            PointAndDistance curr = heap.poll();
            sol[index] = curr.getPoint();
            index++;
        }

        return sol;
    }

    private double calcDistance(int[] point) {
        int x = point[0];
        int y = point[1];

        return Math.sqrt(x * x + y * y);
    }

    private class PointAndDistance {

        int[] point;
        double distance;

        private PointAndDistance(int[] point, double distance) { 
            this.point = point;
            this.distance = distance;
        }

        public int[] getPoint() {
            return this.point;
        }

        public double getDistance() {
            return this.distance;
        }
    }

    private class PointAndDistanceComparator implements Comparator<PointAndDistance> {
    
        @Override
        public int compare(PointAndDistance p1, PointAndDistance p2) {
            return Double.compare(p1.distance, p2.distance);
        }
    }
}
