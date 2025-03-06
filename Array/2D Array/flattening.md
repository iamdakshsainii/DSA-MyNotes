public int[] flatten2DTo1D(int[][] grid) {
    int n = grid.length;
    int n2 = n * n;
    int[] flatArray = new int[n2];
    int index = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            flatArray[index++] = grid[i][j];
        }
    }
    return flatArray;
}
