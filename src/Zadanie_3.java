import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line;
        ArrayList<Object> list = new ArrayList<>();

        File file= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_1.txt");

        //Переменные для чтения файла
        FileInputStream file_In_Str  = new FileInputStream(file);
        InputStreamReader fRe=new InputStreamReader(file_In_Str);

        BufferedReader file_BR = new BufferedReader(fRe);

        System.out.print("Массив символов: ");
        while((line = file_BR.readLine()) != null) {

            System.out.println(line);
            char[] chr=line.toCharArray();

            for (char c : chr) {
                list.add(c);
            }
        }

        //Заполнение массива символов
        String string=list.toString().replaceAll(",", "");
        char[] array = string.substring(1, string.length()-1).replaceAll(" ", "").toCharArray();
        //Проверка на прописные символы

        System.out.print("Прописные латинские буквы: ");
        for (int i = 0; i < list.size()-1; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') System.out.print(array[i]);
        }
    }
}
