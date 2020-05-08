public class StraightLine {

    /*
    * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

    Example 1:

    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true
    Example 2:

    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false
    */
    public static void main(String[] args) {
        StraightLine straightLine = new StraightLine();
        int[][] arr = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println("checkStraightLine " + straightLine.checkStraightLine(arr));
    }

    private boolean checkStraightLine(int[][] coordinates) {

        final double firstSlope = calculateSlope(coordinates[0], coordinates[1]);

        for (int i = 1; i < coordinates.length - 1; i++) {
            double currentSlope = calculateSlope(coordinates[i], coordinates[i + 1]);

            if (firstSlope != currentSlope) {
                return false;
            }
        }
        return true;
    }

    private double calculateSlope(int[] point1, int[] point2) {
        if ((point1[0] - point2[0]) == 0) return 0;
        return (double) (point2[1] - point1[1]) / (point2[0] - point1[0]);
    }

}
