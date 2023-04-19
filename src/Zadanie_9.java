import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_9 {

    public static void main(String[] args) throws IOException {
        int count=0;
        boolean est=false;
        
        File file= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_9.txt");

        //Переменные для чтения файла
        FileInputStream file_In_Str  = new FileInputStream(file);
        InputStreamReader fRe=new InputStreamReader(file_In_Str);

        BufferedReader file_BR = new BufferedReader(fRe);
        StringBuffer sBuf = new StringBuffer(file_BR.readLine());

        //Переменные для записи данных в файл
        FileOutputStream file_Out_Str = new FileOutputStream(file,true);
        OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
        BufferedWriter file_BW = new BufferedWriter(fWr);

        file_BW.newLine();

        for (int i=0;i<sBuf.length()-1;i++){

            //коменты ООО
            if (((sBuf.charAt(i)=='О') && (sBuf.charAt(i+1)=='О') && (sBuf.charAt(i+2)=='О'))){
                count=i+3;
                while (sBuf.charAt(count)!='О') count++;
                if (((sBuf.charAt(count)=='О') && (sBuf.charAt(count+1)=='О') && (sBuf.charAt(count+2)=='О')) ){
                    sBuf.delete(i,count+3);
                    est=true;
                }
            }

            //коменты ООО
            else if (((sBuf.charAt(i)=='А') && (sBuf.charAt(i+1)=='А') && (sBuf.charAt(i+2)=='А'))){
                count=i+3;
                while (sBuf.charAt(count)!='А') count++;
                if (((sBuf.charAt(count)=='А') && (sBuf.charAt(count+1)=='А') && (sBuf.charAt(count+2)=='А')) ){
                    sBuf.delete(i,count+3);
                    est=true;
                }
            }

            //коменты ООО
            else if (((sBuf.charAt(i)=='Б') && (sBuf.charAt(i+1)=='Б') && (sBuf.charAt(i+2)=='Б'))){
                count=i+3;
                while (sBuf.charAt(count)!='Б') count++;
                if (((sBuf.charAt(count)=='Б') && (sBuf.charAt(count+1)=='Б') && (sBuf.charAt(count+2)=='Б')) ){
                    sBuf.delete(i,count+3);
                    est=true;
                }
            }
        }
        if (!est) file_BW.write("\nКомментариев вида ААА...ААА, ООО...ООО, БББ...БББ в тексте нет");
        else {
            file_BW.write("\nСтрока после изменения: ");
            file_BW.write(String.valueOf(sBuf));
        }
        file_BW.close();
    }
}
