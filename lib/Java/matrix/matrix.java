int height = board.length;
int width = board[0].length();
       int[][] sums = new int[height + 1][width + 1];
       for (int r = 0; r < height; ++r)
           for (int c = 0; c < width; ++c) {
               //sums[r + 1][c + 1] = sums[r + 1][c];
               //if (board[r].charAt(c) == 'o')
               //    ++sums[r + 1][c + 1];
		sums[r + 1][c + 1] = sums[r + 1][c] + input[r][c];//������ǵ�r��ǰc�еĺ�(1 * c)
           }
       for (int r = 0; r < height; ++r)
           for (int c = 0; c < width; ++c) {
               sums[r + 1][c + 1] += sums[r][c + 1]; //�������ǰr��ǰc�еľ��еĺ�
           }
       int res = 1000;
       for (int r1 = 0; r1 < height; ++r1)
           for (int r2 = r1; r2 < height; ++r2)
               for (int c1 = 0; c1 < width; ++c1)
                   for (int c2 = c1; c2 < width; ++c2) {
                       int cnt = sums[r2 + 1][c2 + 1] - sums[r2 + 1][c1] - sums[r1][c2 + 1] + sums[r1][c1]; //������Ǿ���r1,c1,r2,c2���Ǳ�����ĺ�