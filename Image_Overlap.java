public class Image_Overlap {
    /**
     * Brute Solution - Misunderstand the question
     * The image can shift any bits, but I thought it was only 1 bit.
     * @param img1
     * @param img2
     * @return
     */
    public int largestOverlap(int[][] img1, int[][] img2) {
        int largest = 0;
        int n = img1.length;
        int count = 0;
        int[][] img1Copy1 = new int[n][n];
        int[][] img1Copy2 = new int[n][n];
        int[][] img1Copy3 = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1 && img2[i][j] == 1)
                    count++;
                img1Copy1[i][j] = img1[i][j];
                img1Copy2[i][j] = img1[i][j];
                img1Copy3[i][j] = img1[i][j];
            }
        largest = count;
        Pair upReturn = up(img1, img2);
        int up = upReturn.count;
        if (up > largest)
            largest = up;
        int upLeft = left(img1, img2);
        if (upLeft > largest)
            largest = upLeft;
        int upRight = right(upReturn.matrix, img2);
        if (upRight > largest)
            largest = upRight;
        Pair downReturn = down(img1Copy1, img2);
        int down = downReturn.count;
        if (down > largest)
            largest = down;
        int downLeft = left(img1Copy1, img2);
        if (downLeft > largest)
            largest = downLeft;
        int downRight = right(downReturn.matrix, img2);
        if (downRight > largest)
            largest = downRight;
        int left = left(img1Copy2, img2);
        if (left > largest)
            largest = left;
        int right = right(img1Copy3, img2);
        if (right > largest)
            largest = right;
        return largest;
    }

    public Pair up(int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = 0;
        int[][] upCopy = new int[n][n];
        for (int i = 0, j = 1; i < n - 1; i++, j++)
            for (int k = 0; k < n; k++) {
                if (img1[j][k] == 1) {
                    img1[i][k] = 1;
                    upCopy[i][k] = 1;
                }
                if (img1[i][k] == 1 && img2[i][k] == 1)
                    count++;
            }
        for (int i = 0; i < n; i++) {
            upCopy[n - 1][i] = img1[n - 1][i];
            img1[n - 1][i] = 0;
        }
        return new Pair(count, upCopy);
    }

    public int left(int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = 0;
        for (int i = 0, j = 1; i < n - 1; i++, j++)
            for (int k = 0; k < n; k++) {
                if (img1[k][j] == 1)
                    img1[k][i] = 1;
                if (img1[i][k] == 1 && img2[i][k] == 1)
                    count++;
            }
        for (int i = 0; i < n; i++)
            img1[i][n - 1] = 0;
        return count;
    }

    public Pair down(int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = 0;
        int[][] downCopy = new int[n][n];
        for (int i = n - 1, j = n - 2; j >= 0; i--, j--)
            for (int k = 0; k < n; k++) {
                if (img1[j][k] == 1) {
                    img1[i][k] = 1;
                    downCopy[i][k] = 1;
                }
                if (img1[i][k] == 1 && img2[i][k] == 1)
                    count++;
            }
        for (int i = 0; i < n; i++) {
            downCopy[0][i] = img1[0][i];
            img1[0][i] = 0;
        }
        return new Pair(count, downCopy);
    }

    public int right(int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = 0;
        for (int i = n - 1, j = n - 2; j >= 0; i--, j--)
            for (int k = 0; k < n; k++) {
                if (img1[k][j] == 1)
                    img1[k][i] = 1;
                if (img1[k][i] == 1 && img2[k][i] == 1)
                    count++;
            }
        for (int i = 0; i < n; i++)
            img1[i][0] = 0;
        return count;
    }

    class Pair {
        int count;
        int[][] matrix;

        Pair(int c, int[][] m) {
            count = c;
            matrix = m;
        }
    }
}
