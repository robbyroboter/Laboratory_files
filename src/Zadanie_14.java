import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_14 {

    static ArrayList<double[]> arrayList=new ArrayList<double[]>();
    static int M=0;
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //Переменные для чтения файла
        File file= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_14.txt");
        FileReader fR  = new FileReader(file);
        BufferedReader file_BR = new BufferedReader(fR);
        //Переменные для записи файла
        FileWriter fW  = new FileWriter(file,true);
        BufferedWriter file_BW = new BufferedWriter(fW);

        String[] masStr;
        int count=0, N=0;

        while (file_BR.ready()){
            String S=file_BR.readLine();
            if (count==0) N=Integer.valueOf(S);
            if(count>N){
                masStr=S.split("\t");
                arrayList.add(new double[masStr.length]);
                for (int i=0;i<masStr.length;i++){
                    arrayList.get(M)[i]=Double.parseDouble(masStr[i]);
                }
                M++;
            }
            count++;
        }

        double[][] Obrab_Chisl=new double[3][arrayList.get(0).length]; //Двумерный массив для записи мин,макс, ср знач.

        for (int i=0;i<arrayList.get(0).length;i++){
            double max=arrayList.get(0)[i], min=arrayList.get(0)[i];

            for (int j=0;j<M;j++){
                if(arrayList.get(j)[i]>max) max=arrayList.get(j)[i];
                if(arrayList.get(j)[i]<min) min=arrayList.get(j)[i];
                Obrab_Chisl[2][i]+=arrayList.get(j)[i]/M;
            }

            Obrab_Chisl[0][i]=max;
            Obrab_Chisl[1][i]=min;
        }

        String Rezult="";
        file_BW.newLine();
        file_BW.newLine();

        // Запись резуьтатов в файл
        for (int i=0;i<3;i++){
            if (i==0) Rezult+="max\t";
            else if (i==1) Rezult+="min\t";
            if (i==2) Rezult+="srznach\t";

            for (int j=0;j<arrayList.get(0).length;j++) Rezult+=String.format("%.4e\t", Obrab_Chisl[i][j]);
            file_BW.write(Rezult);
            file_BW.newLine();

            Rezult="";
        }

        //Расчёт отклонений
        String RezultTwo="";
        file_BW.newLine();
        file_BW.newLine();

        for (int i=0;i<arrayList.get(0).length;i++){
            RezultTwo+=i+1+": otklonenie\t";

            for (int j=0;j<M;j++){
                RezultTwo+=String.format("%.4e\t", arrayList.get(j)[i]-Obrab_Chisl[2][i]);
            }
            file_BW.write(RezultTwo);
            file_BW.newLine();

            RezultTwo="";
        }

        file_BW.close();
    }
}
