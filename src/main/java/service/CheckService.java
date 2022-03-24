package service;

import dao.AddDao;
import dao.CheckDao;
import entity.Add;
import panel.CheckPanel;
import util.CheckRepeatUtil;

import java.util.Arrays;
import java.util.List;

public class CheckService {

    private static CheckDao dao = new CheckDao();

    public int[] checkResult(){
        CheckPanel checkPanel = CheckPanel.instance;
        List<Add> allData = new AddDao().getAll();

        //获取输入的数据
        Integer TN1 = Integer.valueOf(checkPanel.TN1.getText());
        Integer TN2 = Integer.valueOf(checkPanel.TN2.getText());
        Integer TN3 = Integer.valueOf(checkPanel.TN3.getText());
        Integer TN4 = Integer.valueOf(checkPanel.TN4.getText());
        Integer TN5 = Integer.valueOf(checkPanel.TN5.getText());
        Integer TN6 = Integer.valueOf(checkPanel.TN6.getText());
        Integer TN7 = Integer.valueOf(checkPanel.TN7.getText());



        int[] InputData = new int[7];
        InputData[0] = TN1;
        InputData[1] = TN2;
        InputData[2] = TN3;
        InputData[3] = TN4;
        InputData[4] = TN5;
        InputData[5] = TN6;
        InputData[6] = TN7;

        //调用查重工具
        CheckRepeatUtil checkRepeatUtil = new CheckRepeatUtil();
        List<int[]> result = checkRepeatUtil.checkRepeat(InputData,allData);
        System.out.println(result);

        //存取重复数据的id
        int[] resultId = new int[result.size()];
        for (int i = 0;i < result.size();i++){
                resultId[i] = result.get(i)[0];
        }

        return resultId;
    }


    public List<Add> getResult(){
        CheckService service = new CheckService();
        int[] id = Arrays.copyOf(service.checkResult(),service.checkResult().length);

        return CheckDao.getIdAll(id);
    }
}
