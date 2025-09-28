package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    private final Metrics metrics;

    public ClosestPair(Metrics metrics) {
        this.metrics = metrics;
    }

    public double findClosest(Point[] points) {
        Point[] pointsByX = points.clone();
        Arrays.sort(pointsByX, Comparator.comparingDouble(p -> p.x));
        Point[] aux = new Point[points.length];
        return closest(pointsByX, aux, 0, points.length - 1);
    }

    private double closest(Point[] pts, Point[] aux, int left, int right) {
        metrics.enterRecursion();
        try {
            if (right - left <= 3) {
                return bruteForce(pts, left, right);
            }

            int mid = (left + right) / 2;
            double d1 = closest(pts, aux, left, mid);
            double d2 = closest(pts, aux, mid + 1, right);
            double d = Math.min(d1, d2);

            // Merge by y
            mergeByY(pts, aux, left, mid, right);

            // Build strip
            int stripSize = 0;
            for (int i = left; i <= right; i++) {
                if (Math.abs(pts[i].x - pts[mid].x) < d) {
                    aux[stripSize++] = pts[i];
                }
            }

            // Check strip
            for (int i = 0; i < stripSize; i++) {
                for (int j = i + 1; j < stripSize && (aux[j].y - aux[i].y) < d; j++) {
                    metrics.incComparisons();
                    d = Math.min(d, dist(aux[i], aux[j]));
                }
            }
            return d;
        } finally {
            metrics.exitRecursion();
        }
    }

    private double bruteForce(Point[] pts, int left, int right) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                metrics.incComparisons();
                min = Math.min(min, dist(pts[i], pts[j]));
            }
        }
        return min;
    }

    private void mergeByY(Point[] pts, Point[] aux, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (pts[i].y <= pts[j].y) {
                aux[k++] = pts[i++];
            } else {
                aux[k++] = pts[j++];
            }
        }
        while (i <= mid) aux[k++] = pts[i++];
        while (j <= right) aux[k++] = pts[j++];
        for (int t = 0; t < k; t++) {
            pts[left + t] = aux[t];
        }
    }

    private double dist(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static class Point {
        public final double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
