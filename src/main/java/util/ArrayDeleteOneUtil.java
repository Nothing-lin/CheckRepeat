package util;

import java.util.Arrays;

public class ArrayDeleteOneUtil {

    public static int[] deleteAny(int[] A, int B){

        int[] arr = A;
    //把最后一个元素替代指定的元素

        arr[B] = arr[arr.length-1];
        //数组缩容

        arr = Arrays.copyOf(arr, arr.length-1);


//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int InputArrays[] = {1,3,5,3};
        int TemInputArrays[];

        TemInputArrays = Arrays.copyOf(InputArrays,InputArrays.length);

        ArrayDeleteOneUtil ArrayDeleteOneUtil = new ArrayDeleteOneUtil();
        System.out.println(Arrays.toString(ArrayDeleteOneUtil.deleteAny(TemInputArrays,0)));
        System.out.println(Arrays.toString(InputArrays));
    }
}
