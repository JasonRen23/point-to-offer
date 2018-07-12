package chapter2;

/**
 * @author zhicheng
 * @create 2018-07-12 上午11:28
 */


public class PathInMatrix {
    /**
     *
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 要搜索的字符串
     * @return: boolean 是否找到，true是，false否
     *
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || matrix.length != rows * cols || str == null || str.length < 1)
            return false;

        //变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        //记录结果的数组
        int[] pathLength = {0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @Description:        回溯搜索算法
     * @param matrix        输入矩阵
     * @param rows          矩阵行数
     * @param cols          矩阵列数
     * @param str           要搜索的字符串
     * @param visited       访问标技术组
     * @param row           当前处理的行号
     * @param col           当前处理的列号
     * @param pathLength    已经处理的str中字符个数
     * @return: boolean     是否找到，true是，false否
     *
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int row, int col, int[] pathLength){
        if(pathLength[0] == str.length)
            return true;
        boolean hasPath = false;

        //判断位置是否合法
        if(row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]){
            visited[row * cols + col] = true;
            pathLength[0]++;

            //按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if(!hasPath){
                pathLength[0]--;
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {

        //ABCE  //ABCCED
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCCED".toCharArray()) + "[true]");// true

        //ABCE  //SEE
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "SEE".toCharArray()) + "[true]");// true

        //ABCE  //ABCB
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCB".toCharArray()) + "[false]");// false

        //ABCEHJIG  //SLHECCEIDEJFGGFIE
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SLHECCEIDEJFGGFIE".toCharArray()) + "[true]");// true

        //ABCEHJIG  //SGGFIECVAASABCEHJIGQEM
        //SFCSLOPQ  //
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEHJIGQEM".toCharArray()) + "[true]");// true

        //ABCEHJIG  //SGGFIECVAASABCEEJIGOEM
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEEJIGOEM".toCharArray()) + "[false]");// false

        //ABCEHJIG  //SGGFIECVAASABCEHJIGQEMS
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEHJIGQEMS".toCharArray()) + "[false]");// false

        //AAAA  //AAAAAAAAAAAA
        //AAAA
        //AAAA
        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
                "AAAAAAAAAAAA".toCharArray()) + "[true]");// true

        //AAAA  //AAAAAAAAAAAAA
        //AAAA
        //AAAA
        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
                "AAAAAAAAAAAAA".toCharArray()) + "[false]");// false
    }
}
