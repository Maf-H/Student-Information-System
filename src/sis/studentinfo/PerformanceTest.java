package sis.studentinfo;
import junit.framework.*;
public class PerformanceTest extends TestCase{
    private static final double tolerance = 0.005;
    public void testAverage() {
        Performance performance = new Performance();
        performance.setNumberOfTests(4);
        performance.set(0, 98);
        performance.set(1, 92);
        performance.set(2, 81);
        performance.set(3, 72);

        assertEquals(92, performance.get(1));
        assertEquals(85.75, performance.average(), tolerance);
    }
    public void testInitialization() {
        Performance performance = new Performance();
        performance.setScores(75, 72, 90, 60);
        assertEquals(74.25, performance.average(), tolerance);
    }
    public void testVariableMethodParams() {
        Performance performance = new Performance();
        performance.setScores(75, 72, 90, 60);
        assertEquals(74.25, performance.average(), tolerance);

        performance.setScores(75, 72, 90, 60, 80);
        assertEquals(75.4, performance.average(), tolerance);
    }
    public void testPartialDimensions() {
        int rows = 3;
        int[][] matrix = new int[rows][];
        matrix[0] = new int[] { 0 };
        matrix[1] = new int[] {1, 2};
        matrix[2] = new int[] {3, 4, 5};

        assertEquals(1, matrix[0].length);
        assertEquals(2, matrix[1].length);
        assertEquals(3, matrix[2].length);
        assertEquals(0, matrix[0][0]);
        assertEquals(2, matrix[1][1]);
        assertEquals(5, matrix[2][2]);
    }
}
