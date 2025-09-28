package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestPairTest {

    @Test
    void testSmallCase() {
        Metrics metrics = new Metrics();
        ClosestPair cp = new ClosestPair(metrics);
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(3,4),
                new ClosestPair.Point(7,7),
                new ClosestPair.Point(1,1)
        };
        double result = cp.findClosest(pts);
        assertEquals(Math.sqrt(2), result, 1e-6);
    }

    @Test
    void testTwoPoints() {
        Metrics metrics = new Metrics();
        ClosestPair cp = new ClosestPair(metrics);
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(5,0)
        };
        double result = cp.findClosest(pts);
        assertEquals(5.0, result, 1e-6);
    }
}
