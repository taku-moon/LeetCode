class Solution {

    public static class Point implements Comparable<Point> {
        int distance;
        int[] point;

        public Point(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }

        @Override
        public int compareTo(Point o) {
            if (this.distance < o.distance) {
                return -1;
            } else if (this.distance == o.distance) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            pq.add(new Point(distance, point));
        }

        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll().point;
        }

        return answer;
    }

}