import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line;
        ArrayList<Object> list = new ArrayList<>();

        File file1= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_4_1.txt");
        File file2= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_4_2.txt");

        //Переменные для чтения файла
        FileInputStream file1_In_Str  = new FileInputStream(file1);
        InputStreamReader fRe=new InputStreamReader(file1_In_Str);

        FileWriter fWr=new FileWriter(file2);
        BufferedWriter file2_BW=new BufferedWriter(fWr);

        BufferedReader file_BR = new BufferedReader(fRe);

        while((line = file_BR.readLine()) != null) {

            String[] str=line.split(" ");

            // То же самое что ниже
//            for (String c : str) {
//                list.add(c);
//            }
            Collections.addAll(list, str);
        }


        //Перевод листа в массив строк
        String[] array = list.toArray(new String[list.size()]);

        for (int i=0;i<array.length-1;i++){
            for (int j=array[i].length()-1;j>0;j--){

                //Если символы
                if (array[i].charAt(j)==',' || array[i].charAt(j)=='_'|| array[i].charAt(j)=='.'|| array[i].charAt(j)==';'|| array[i].charAt(j)==':' || array[i].charAt(j)=='!' || array[i].charAt(j)=='?' || array[i].charAt(j)=='\\'){
                    file2_BW.write(array[i]);
                    file2_BW.newLine();
                    file2_BW.write(array[i+1]);
                    file2_BW.newLine();
                    i++;
                    break;
                }

                //Если латинские и русские буквы в слове
                else if (((array[i].charAt(j)>='а' && array[i].charAt(j)<='я') && (array[i].charAt(j-1)>='a' && array[i].charAt(j-1)<='z')) || ((array[i].charAt(j)>='a' && array[i].charAt(j)<='z') && (array[i].charAt(j-1)>='а' && array[i].charAt(j-1)<='я')) || ((array[i].charAt(j)>='А' && array[i].charAt(j)<='Я') && (array[i].charAt(j-1)>='A' && array[i].charAt(j-1)<='Z')) || ((array[i].charAt(j)>='A' && array[i].charAt(j)<='Z') && (array[i].charAt(j-1)>='А' && array[i].charAt(j-1)<='Я')) || ((array[i].charAt(j)>='а' && array[i].charAt(j)<='я') && (array[i].charAt(j-1)>='A' && array[i].charAt(j-1)<='Z')) || ((array[i].charAt(j)>='A' && array[i].charAt(j)<='Z') && (array[i].charAt(j-1)>='а' && array[i].charAt(j-1)<='я')) || ((array[i].charAt(j)>='А' && array[i].charAt(j)<='Я') && (array[i].charAt(j-1)>='a' && array[i].charAt(j-1)<='z')) || ((array[i].charAt(j)>='a' && array[i].charAt(j)<='z') && (array[i].charAt(j-1)>='А' && array[i].charAt(j-1)<='Я'))){
                    file2_BW.write(array[i]);
                    file2_BW.newLine();
                    break;
               }
            }
        }

        file2_BW.close();
    }
}
