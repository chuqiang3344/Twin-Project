package izhonghong.App;

import com.tyaer.basic.utils.ExcelReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Twin on 2016/8/5.
 */
public class test {
    public static void main(String[] args) {
        ExcelReader excelReader = new ExcelReader();
        List<String> list=new ArrayList<String>();
        String[][] table = excelReader.readExceltoTable("./file/MAC心跳监控异常审查.xls",3);
        for (int i = 1; i < table.length; i++) {
            String name3 = table[i][2];
            list.add(name3);
        }
        table = excelReader.readExceltoTable("./file/MAC心跳监控异常审查.xls",2);
        List<String> list2=new ArrayList<String>();
        for (int i = 1; i < table.length; i++) {
            String name = table[i][1];
            list2.add(name);
        }
        for (String s : list) {
            if(list2.contains(s)){
                System.out.println(s+"\t"+s);
            }else{
                System.out.println(s);
            }
        }

    }
}
