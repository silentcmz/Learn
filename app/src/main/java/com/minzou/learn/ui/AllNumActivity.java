package com.minzou.learn.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.minzou.learn.Constant;
import com.minzou.learn.R;
import com.minzou.learn.base.BaseActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minzou on 2017/7/12.
 */

public class AllNumActivity extends BaseActivity {

    private JSONArray array = new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mTv = (TextView) findViewById(R.id.mTv);
        for (int i = 1; i < 10; i++) {
            //二星直选 出12
            mTv.setText(two_D_Out_12(Constant.twoStar1, i, "做号 二星直选"));
        }

        for (int i = 1; i < 10; i++) {
            //二星混选 出12
            mTv.setText(two_D_Out_12(Constant.twoStar2_eXX, i, "做号 二星混选"));
        }

        for (int i = 1; i < 10; i++) {
            //三星直选 出123
            mTv.setText(two_D_Out_12(Constant.threeStar1, i, "做号 三星直选"));
        }

        for (int i = 1; i < 10; i++) {
            //三星混选 出123
            mTv.setText(two_D_Out_12(Constant.threeStar2_eXXX, i, "做号 三星混选"));
        }

    }

    private String result;
    private String allResult;
    private JSONObject object;

    /**
     * @param temNum 出多少个数
     * @return
     */

    private String two_D_Out_12(String[] nums, int temNum, String question) {
        allResult = "";
        List<int[]> list = combination(Constant.num, temNum);
        for (int a = 0; a < list.size(); a++) {
            int[] temp = list.get(a);
//                java.text.DecimalFormat df = new java.text.DecimalFormat("00");//将输出格式化
//                System.out.print(df.format(temp[j]) + " ");
            switch (temNum) {
                case 1:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + "--" + result);
                    allResult += result + "\n";
                    break;
                case 2:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "") || nums[j].contains(temp[1] + "")) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + "" + temp[1] + "--" + result);
                    allResult += result + "\n";
                    break;
                case 3:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "") || nums[j].contains(temp[1] + "") || nums[j].contains(temp[2] + "")) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + "" + temp[1] + "" + temp[2] + "--" + result);
                    allResult += result + "\n";
                    break;
                case 4:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 5:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 6:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 7:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                || nums[j].contains(temp[6] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5] + "" + temp[6]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + temp[6] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 8:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                || nums[j].contains(temp[6] + "")
                                || nums[j].contains(temp[7] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5] + "" + temp[6] + "" + temp[7]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + temp[6] + ""
                            + temp[7] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 9:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                || nums[j].contains(temp[6] + "")
                                || nums[j].contains(temp[7] + "")
                                || nums[j].contains(temp[8] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5] + "" + temp[6] + "" + temp[8]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + temp[6] + ""
                            + temp[7] + ""
                            + temp[8] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
            }
        }
        saveToSDCard(this, "minzou.askdb", array.toString());
        System.out.println(array.toString());

        return allResult;
    }

    /**
     * 三星直选
     * 1码出123
     */
    private String three_D_Out1_123() {
        allResult = "";
        for (int i = 0; i < 10; i++) {
            result = "";
            for (int j = 0; j < Constant.threeStar1.length; j++) {
                if (Constant.threeStar1[j].contains(i + "")) {
                    result += Constant.threeStar1[j] + " ";
                }
            }
            System.out.println(i + "--" + result);
            allResult += result + "\n";
        }

        return allResult;
    }

    /**
     * @param a:组合数组
     * @param m:生成组合长度
     * @return :所有可能的组合数组列表
     */
    private List<int[]> combination(int[] a, int m) {
        List<int[]> list = new ArrayList<>();
        int n = a.length;
        boolean end = false; // 是否是最后一种组合的标记
        // 生成辅助数组。首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。
        int[] tempNum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < m) {
                tempNum[i] = 1;
            } else {
                tempNum[i] = 0;
            }
        }
//        printVir(tempNum);// 打印首个辅助数组
        list.add(createResult(a, tempNum, m));// 打印第一种默认组合
        int k = 0;//标记位
        while (!end) {
            boolean findFirst = false;
            boolean swap = false;
            // 然后从左到右扫描数组元素值的"10"组合，找到第一个"10"组合后将其变为"01"
            for (int i = 0; i < n; i++) {
                int l = 0;
                if (!findFirst && tempNum[i] == 1) {
                    k = i;
                    findFirst = true;
                }
                if (tempNum[i] == 1 && tempNum[i + 1] == 0) {
                    tempNum[i] = 0;
                    tempNum[i + 1] = 1;
                    swap = true;
                    for (l = 0; l < i - k; l++) { // 同时将其左边的所有"1"全部移动到数组的最左端。
                        tempNum[l] = tempNum[k + l];
                    }
                    for (l = i - k; l < i; l++) {
                        tempNum[l] = 0;
                    }
                    if (k == i && i + 1 == n - m) {//假如第一个"1"刚刚移动到第n-m+1个位置,则终止整个寻找
                        end = true;
                    }
                }
                if (swap) {
                    break;
                }
            }
//            printVir(tempNum);// 打印辅助数组
            list.add(createResult(a, tempNum, m));// 添加下一种默认组合
        }
        return list;
    }

    // 根据辅助数组和原始数组生成结果数组
    public int[] createResult(int[] a, int[] temp, int m) {
        int[] result = new int[m];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (temp[i] == 1) {
                result[j] = a[i];
//                System.out.println("result[" + j + "]:" + result[j]);
                j++;
            }
        }
        return result;
    }

    // 打印整组数组
    public void print(List<int[]> list) {
        System.out.println("具体组合结果为:");
        for (int i = 0; i < list.size(); i++) {
            int[] temp = (int[]) list.get(i);
            for (int j = 0; j < temp.length; j++) {
//                java.text.DecimalFormat df = new java.text.DecimalFormat("00");//将输出格式化
//                System.out.print(df.format(temp[j]) + " ");
                System.out.print(temp[j] + "");
            }
            System.out.println();
        }
    }

    // 打印辅助数组的方法
    public void printVir(int[] a) {
        System.out.println("生成的辅助数组为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }


    /**
     * 保存json到本地
     *
     * @param mActivity
     * @param filename
     * @param content
     */

    public static File dir = new File(Environment.getExternalStorageDirectory() + "/json/");


    public static void saveToSDCard(Activity mActivity, String filename, String content) {

        String en = Environment.getExternalStorageState();

        //获取SDCard状态,如果SDCard插入了手机且为非写保护状态

        if (en.equals(Environment.MEDIA_MOUNTED)) {

            try {

                dir.mkdirs(); //create folders where write files

                File file = new File(dir, filename);


                OutputStream out = new FileOutputStream(file);

                out.write(content.getBytes());

                out.close();
                Log.e("111", "保存成功");

            } catch (Exception e) {

                e.printStackTrace();
                Log.e("111", "保存失败");

            }

        } else {

            //提示用户SDCard不存在或者为写保护状态

            Log.e("111", "SDCard不存在或者为写保护状态");

        }

    }
}
