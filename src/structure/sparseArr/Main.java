package structure.sparseArr;

import structure.sparseArr.uril.SparseArrUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[10][10];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[3][4] = 2;

        int sparseArrLenght = SparseArrUtil.getSparseArrLenght(arr);

        int[][] sparseArr = SparseArrUtil.getSparseArr(arr.length, arr[0].length, sparseArrLenght);


        SparseArrUtil.assignmentSparseArr(arr,sparseArr);
        SparseArrUtil.writeTxt(sparseArr);
//        arr = SparseArrUtil.assignmentArr(sparseArr);

    }
}
