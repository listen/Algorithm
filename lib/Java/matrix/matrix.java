int height = board.length;
int width = board[0].length();
       int[][] sums = new int[height + 1][width + 1];
       for (int r = 0; r < height; ++r)
           for (int c = 0; c < width; ++c) {
               //sums[r + 1][c + 1] = sums[r + 1][c];
               //if (board[r].charAt(c) == 'o')
               //    ++sums[r + 1][c + 1];
		sums[r + 1][c + 1] = sums[r + 1][c] + input[r][c];//计算的是第r行前c列的和(1 * c)
           }
       for (int r = 0; r < height; ++r)
           for (int c = 0; c < width; ++c) {
               sums[r + 1][c + 1] += sums[r][c + 1]; //计算的是前r行前c列的举行的和
           }
       int res = 1000;
       for (int r1 = 0; r1 < height; ++r1)
           for (int r2 = r1; r2 < height; ++r2)
               for (int c1 = 0; c1 < width; ++c1)
                   for (int c2 = c1; c2 < width; ++c2) {
                       int cnt = sums[r2 + 1][c2 + 1] - sums[r2 + 1][c1] - sums[r1][c2 + 1] + sums[r1][c1]; //计算的是矩形r1,c1,r2,c2都是闭区间的和