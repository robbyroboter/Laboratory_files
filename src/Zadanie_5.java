import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_5 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line;
        boolean cyril=false,latin=false;
        ArrayList<Object> list = new ArrayList<>();

        File file1= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_5_1.txt");
        File file2= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_5_2.txt");

        //Переменные для чтения файла
        FileInputStream file1_In_Str  = new FileInputStream(file1);
        InputStreamReader fRe=new InputStreamReader(file1_In_Str);
        BufferedReader file_BR = new BufferedReader(fRe);

        FileOutputStream file2_Out_Str  = new FileOutputStream(file2,true);
        OutputStreamWriter fWr=new OutputStreamWriter(file2_Out_Str);
        BufferedWriter file2_BW=new BufferedWriter(fWr);

        //Создание массивов
        while((line = file_BR.readLine()) != null) {

            String[] str=line.split("\\.");

            // То же самое что ниже
//            for (String c : str) {
//                list.add(c);
//            }
            Collections.addAll(list, str);
        }

        file2_BW.newLine();
        //Перевод листа в массив строк
        String[] array = list.toArray(new String[list.size()]);

        for (int i=0;i<array.length;i++){

            cyril=false; latin=false;
            String [] subArray = array[i].split(" ");
            for (int j=0;j<subArray.length;j++){

                //Проверка на латинские слова
                if (Pattern.matches(".*\\p{IsLatin}.*", subArray[j])){
                    latin=true;
                }

                //Проверка на кириллические слова
                if (Pattern.matches(".*\\p{InCyrillic}.*", subArray[j])){
                    cyril=true;
                }

                //Если условия выполняются то предложение записывается в файл
                if (latin && cyril){
                    file2_BW.write(array[i]);
                    file2_BW.write('.');
                    file2_BW.newLine();
                    break;
                }
            }
        }
        file2_BW.close();
    }
}