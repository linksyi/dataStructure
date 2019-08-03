package structure.sparseArr.uril;

import java.io.*;

public class SparseArrUtil {
    /**
     * 获取稀疏素组长度
     *
     * @param arr
     * @return
     */
    public static int getSparseArrLenght(int[][] arr) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    length++;
                }
            }
        }
        return length;
    }

    /**
     * 获取稀疏数组
     *
     * @param length
     * @return
     */
    public static int[][] getSparseArr(int length, int length1, int num) {
        int[][] sparseArr = new int[++num][3];
        sparseArr[0][0] = length;
        sparseArr[0][1] = length1;
        sparseArr[0][2] = 3;
        return sparseArr;
    }

    /**
     * 给稀疏数组赋值
     *
     * @param arr
     * @param sparseArr
     */
    public static void assignmentSparseArr(int[][] arr, int[][] sparseArr) {
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = arr[i][j];
                    num++;
                }
            }
        }
    }

    /**
     * 将稀疏数组保存进文件
     *
     * @param sparseArr
     * @throws IOException
     */
    public static void writeTxt(int[][] sparseArr) throws IOException {
        File file = new File("F:\\Dome\\dataArr\\arr.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                if ((j + 1) >= sparseArr[i].length) {
                    out.write(String.valueOf(sparseArr[i][j]));
                } else {
                    out.write(sparseArr[i][j] + ",");
                }
            }
            if ((i + 1) <= sparseArr[i].length){
                out.newLine();
            }
        }
        out.flush();
        out.close();
    }

    /**
     * 通过稀疏数组给原数组赋值
     *
     * @param sparseArr
     * @return
     */
    public static int[][] assignmentArr(int[][] sparseArr) {
        int length1 = sparseArr[0][0];
        int length2 = sparseArr[0][1];
        int[][] arr = new int[length1][length2];

        for (int i = 1; i < sparseArr.length; i++) {
            int longitudinal = sparseArr[i][0];
            int transverse = sparseArr[i][1];
            int data = sparseArr[i][2];
            arr[longitudinal][transverse] = data;
        }

        return arr;
    }

    /**
     * 通过文件给原数组赋值
     *
     * @param arr
     * @throws IOException
     */
    public static void readerTxt(int[][] arr) throws IOException {
        File file = new File("F:\\Dome\\dataArr\\arr.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
