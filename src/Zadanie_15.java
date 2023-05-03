import java.io.*;
import java.util.*;
import java.math.*;

import static java.lang.Math.pow;

class Point {
    final double x;
    final double y;
    public Point(double x1, double y1) {
        x = x1;
        y = y1;
    }
}

public class Zadanie_15 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line;
        ArrayList<Object> list = new ArrayList<>();

        //Переменные для чтения файла
        File file1 = new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_15_Uchastki.txt");
        FileReader fR1 = new FileReader(file1);
        BufferedReader file1_BR = new BufferedReader(fR1);

        File file2 = new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_15_Zaici_Volki.txt");
        FileReader fR2 = new FileReader(file2);
        BufferedReader file2_BR = new BufferedReader(fR2);

        File file3 = new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_15_Vodoemi.txt");
        FileReader fR3 = new FileReader(file3);
        BufferedReader file3_BR = new BufferedReader(fR3);

        //Переменные для записи файла
        File file4= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_15_Itog.txt");
        FileWriter fW4  = new FileWriter(file4,true);
        BufferedWriter file4_BW = new BufferedWriter(fW4);

        //Заполнение массивов

        //Заполнение массива с координатами участка
        double[][] arUch=new double[10][8];

        while((line = file1_BR.readLine()) != null) {

            String[] str=line.split("\\.");

            // То же самое что ниже
//            for (String c : str) {
//                list.add(c);
//            }
            Collections.addAll(list, str);
        }


        String[] array = list.toArray(new String[list.size()]);

        for (int i = 0; i < array.length; i++) {
            String[] subArray = array[i].split(",");
            for (int j=0;j<arUch[i].length;j++){
                arUch[i][j]=Integer.parseInt(subArray[j]);
            }
        }

        list.clear();

        //Заполнение массива с координатами зайцев и волков
        int[][] arZV=new int[4][3];

        while((line = file2_BR.readLine()) != null) {

            String[] str=line.split("\\.");

            // То же самое что ниже
//            for (String c : str) {
//                list.add(c);
//            }
            Collections.addAll(list, str);
        }


        array = list.toArray(new String[list.size()]);

        for (int i = 0; i < array.length; i++) {
            String[] subArray = array[i].split(",");
            for (int j=0;j<arZV[i].length;j++){
                arZV[i][j]=Integer.parseInt(subArray[j]);
            }
        }

        list.clear();

        //Заполнение массива с координатами водоёмов
        int[][] arVod=new int[4][3];

        while((line = file3_BR.readLine()) != null) {

            String[] str=line.split("\\.");

            // То же самое что ниже
//            for (String c : str) {
//                list.add(c);
//            }
            Collections.addAll(list, str);
        }


        array = list.toArray(new String[list.size()]);

        for (int i = 0; i < array.length; i++) {
            String[] subArray = array[i].split(",");
            for (int j=0;j<arVod[i].length;j++){
                arVod[i][j]=Integer.parseInt(subArray[j]);
            }
        }

        file1_BR.close();
        file2_BR.close();
        file3_BR.close();

        //Проверка пересекают ли зайцы, волки и водоёмы зоны

        double[] kb;

        for (int i=0;i<arUch.length;i++){
            int countZV=0, countVod=0;

            //Проверка зон
            for (int j=0;j<arUch[i].length-2;j+=2){
                if (j==6){
                    kb=uravs(arUch[i][j], arUch[i][j+1], arUch[0][0], arUch[0][1]);
                }
                else{
                    kb=uravs(arUch[i][j], arUch[i][j+1], arUch[i][j+2], arUch[i][j+3]);
                }

                //Пересекает ли зону ореал обитания зайцев и волков
                for (int k=0;k<arZV.length;k++){
                    double d=pow(kb[0]*arZV[k][0] - arZV[k][1] + kb[1],2);
                    if (d<=arZV[k][2]*(pow(kb[0],2)+1)){
                        countZV++;
                        break;
                    }
                }

                //Пересекает ли водоёмы
                for (int k=0;k<arVod.length;k++){
                    double d=pow(kb[0]*arVod[k][0] - arVod[k][1] + kb[1],2);
                    if (d>=arVod[k][2]*(pow(kb[0],2)+1)){
                        countVod++;
                        break;
                    }
                }
            }

            //Запись результатов в файл
            file4_BW.newLine();
            file4_BW.write("\t"+i+"\t\t\t"+countZV+"\t\t\t\t"+0+"\t\t\t\t"+countVod);
        }
        file4_BW.close();
    }


    //создание уравнения прямой
    public static double[] uravs(double x1, double y1, double x2, double y2) {

        Point xy1 = new Point(x1, y1);
        Point xy2 = new Point(x2, y2);
        // y = mx+b
        double k = (xy1.y-xy2.y)/(xy1.x-xy2.x);
        double b = -(k*xy1.x)+xy1.y;;
        // -(k*xy2.x)+xy2.y == b;

        return new double[] {k,b};
        //        if (b >= 0) {
//            System.out.println("y = "+k+"x+"+b);
//        } else {
//            System.out.println("y = "+k+"x"+b);
//        }
    }
}


//№ участка	Кол-во зон с животными	% S, занимаемой животными	кол-во водоёмов