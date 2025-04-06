import java.util.LinkedList;
import java.util.Queue;

public class LC994RottenOranges {
    // Leetcode 994
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.remove();
                int row = current[0];
                int column = current[1];
                for (int[] direction : directions) {
                    int r = row + direction[0];
                    int c = column + direction[1];

                    if (r >= 0 && c >= 0 && r < rows && c < columns && grid[r][c] == 1) {
                        // rot the fresh mark as traversed
                        grid[r][c] = 2;
                        freshCount--;
                        // add the rotten
                        queue.offer(new int[] { r, c });
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
