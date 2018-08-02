package chapter5;

/**
 * @author : JasonRen
 * @date : 2018-08-03 上午1:34
 * @email : zhicheng_ren@163.com
 */
public class GetMaxGiftValue {
    public static int getMaxValue1(int[][] gift) {
        if (gift.length < 1 || gift[0].length < 1)
            return 0;
        int rows = gift.length;
        int cols = gift[0].length;
        int[][] maxValues = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0, up = 0;
                if (i > 0)
                    up = maxValues[i - 1][j];
                if (j > 0)
                    left = maxValues[i][j - 1];
                maxValues[i][j] = Math.max(up, left) + gift[i][j];
            }
        }
        return maxValues[rows - 1][cols - 1];
    }

    public static int getMaxValue2(int[][] gift) {
        if (gift.length < 1 || gift[0].length < 1)
            return 0;
        int rows = gift.length;
        int cols = gift[0].length;
        int[] maxValues = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0, up = 0;
                if(i > 0)
                    left = maxValues[j];
                if(j > 0)
                    up = maxValues[j - 1];
                maxValues[j] = Math.max(left, up) + gift[i][j];
            }
        }
        return maxValues[cols - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 10, 3, 8},
            {12, 2, 9, 6},
            {5, 7, 4, 11},
            {3, 7, 16, 5}
        };
        System.out.println(getMaxValue1(matrix));
        System.out.println(getMaxValue2(matrix));
    }
}
