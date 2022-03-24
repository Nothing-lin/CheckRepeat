package util;

import entity.Add;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数据查重：正式版
 */
public class CheckRepeatUtil {
    public List<Integer> resultArrays = new ArrayList<Integer>();//临时结果列表数组，发现相同数据，剩下的数据装进这个容器中进一步处理
    protected List<int[]> finalResultArrays = new ArrayList<int[]>();//最终装载和返回重复数据的容器


    public int[] goalArray;//获取目标数组
    public int[] InputArrays;//我们要输入查重的数据
    public int[][] DataArrays;//数据库中的数据

    //临时装载数组，方便处理不影响原来的值
    public int TemInputArrays[];
    public int TemDataArrays[];

    //一个变量判断数据对比是是不是一样
    public boolean equals = false;

    //初始化一个方法：当一对数据判断一样后，需要这个方法把一样的数据删除，留下剩下的再重复比较
    ArrayDeleteOneUtil arrayDeleteOneUtil = new ArrayDeleteOneUtil();

    //查询方法需要知道数据库的数据，输入数据，两个数值
    public List<int[]> checkRepeat(int[] A,List<Add> B){

        this.InputArrays = A;
        this.DataArrays = new int[B.size()][8];

        //将list数据转为二维数组
        for (int i = 0;i < B.size();i++){

            this.DataArrays[i][0] = B.get(i).getId();
            this.DataArrays[i][1] = B.get(i).getTN1();
            this.DataArrays[i][2] = B.get(i).getTN2();
            this.DataArrays[i][3] = B.get(i).getTN3();
            this.DataArrays[i][4] = B.get(i).getTN4();
            this.DataArrays[i][5] = B.get(i).getTN5();
            this.DataArrays[i][6] = B.get(i).getTN6();
            this.DataArrays[i][7] = B.get(i).getTN7();

        }


        //第一个for循环获取数据库中的一条数组数据
        for (int i = 0;i < DataArrays.length;i++){
            //定义临时数组，因为匹配到相同要删除相同再进行比对，为了不影响原来的数值，使用临时数组
            //不要直接赋值（=），赋值前后的值会相互影响，用复制的形式
            TemInputArrays = Arrays.copyOf(InputArrays, InputArrays.length);
            TemDataArrays = ArrayDeleteOneUtil.deleteAny(Arrays.copyOf(DataArrays[i], DataArrays[i].length),0);

            //这是装载删除重复数据后数据的容器，查完第一条数据后清空，查第二条
            resultArrays.clear();

            //第二个for循环是循环输入的数据，第一个，第二个分别和数据库的某条数据一一对比
            for (int j = 0;j < TemInputArrays.length;j++){
                //判断上一次循环是不是处理了重复的数字，是的话，剩下的重新从0开始匹配查询
                if (equals){
                    j = 0;
                    equals = false;
                }

                //第三个循环是处理数据库中挑出的那条数组中的每个数据
                for (int k =0;k < TemDataArrays.length;k++){
                    //判断这个数据和那个数据是不是相同
                    if (TemInputArrays[j] == TemDataArrays[k]){
                        //把一样的数据挑进结果数组中等待处理
                        resultArrays.add(TemInputArrays[j]);

                        //删除一样的数据，再处理一样数据以外的数据,去除一样的数据，留下剩下的再处理
                        TemInputArrays = ArrayDeleteOneUtil.deleteAny(TemInputArrays, j);
                        TemDataArrays = ArrayDeleteOneUtil.deleteAny(TemDataArrays, k);

                        //释放匹配成功的信号，让数据从头开始匹配剩下的数据
                        equals = true;
                        //停止后面的循环进入输入数据循环
                        break;
                    }
                }
                //呼应上面的，不能缺少，不然对部分数据会漏查
                if (equals){
                    j=0;
                }

            }


            //数据库中抽取出的某一条数据处理完毕之后，对处理结果进行处理
            //因为由于for循环的原因，上面的数据如果是一样的，那么会导致最后一个数据没办法进行判断，所以跳出第一个数据处理循环后，再处理最后一个数据是不是一样
            //这里会执行的前提是6个数，其中有5个是一样的，最后一个数上面的代码无法执行，于是在这里执行

            //先看看是不是上面处理后只剩下一个数组只有一个数字
            if (TemInputArrays.length == 1 && TemDataArrays.length == 1){
                //是的话，再看看输入和数据库的这最后一个数据是不是一样的
                if (TemInputArrays[0] == TemDataArrays[0]) {
                    //一样就把这个数加入存储一样数的结果集中
                    resultArrays.add(TemInputArrays[0]);//其实resultArray用来测试用的

                    //到这里对一某一数据已经一一对应核查完毕，清空结果集数组，给下次循环使用
                    resultArrays.clear();

                    if(DataArrays[i][7] == InputArrays[6]) {
                        //能匹配到这里，说明数据是一样的，我们直接获取数据库中对应的这个数据信息
                        goalArray = DataArrays[i];
                        //把这个匹配到一样的数据存入数据库中
                        finalResultArrays.add(goalArray);
                    }
                }

            }



        }

        return finalResultArrays;

    }


//    public static void main(String[] args) {
//
//        int[] Input = {8, 6, 7, 5};
//        int[][] DataArrays = {
//                {1, 3, 5, 3},
//                {5, 6, 7, 8},
//                {1, 3, 5, 3},
//                {3, 3, 1, 5},
//                {6, 5, 7, 8},
//                {7, 5, 6, 8}
//        };
//
//        CheckRepeatUtil checkRepeatUtil = new CheckRepeatUtil();
////        List<int[]> result =  checkRepeatUtil.checkRepeat(Input,DataArrays);
//
//        for (int i = 0; i < result.size(); i++) {
//            for (int j = 0; j < result.get(i).length; j++) {
//                System.out.print("[" + result.get(i)[j] + "]");
//                System.out.print("、");
//            }
//            System.out.println();
//        }
//
//    }
}
