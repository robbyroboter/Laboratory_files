import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_12 {

    public static void main(String[] args) throws IOException {
        String line;
        ArrayList<Object> list = new ArrayList<>();

        File file= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_12.txt");

        //Переменные для чтения файла
        FileInputStream file_In_Str  = new FileInputStream(file);
        InputStreamReader fRe=new InputStreamReader(file_In_Str);
        BufferedReader file_BR = new BufferedReader(fRe);

        //Переменные для записи данных в файл
        FileOutputStream file_Out_Str = new FileOutputStream(file,true);
        OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
        BufferedWriter file_BW = new BufferedWriter(fWr);

        file_BW.newLine();

        // Регулярное выражения и их замены
        String[] Patt = {"квартира", "количество", "улица", "город"};
        String[] ZamPatt = {"кв.", "кол-во", "ул.", "г."};

        Pattern pat1;
        Matcher mat1;

        //Создание массивов
        while((line = file_BR.readLine()) != null) {

            String[] str=line.split("\\.");

            // То же самое что ниже
//            for (String c : str) {
//                list.add(c);
//            }
            Collections.addAll(list, str);
        }

        file_BW.newLine();
        //Перевод листа в массив строк
        String[] array = list.toArray(new String[list.size()]);

        for (int i=0;i<array.length;i++){
            for (int j=0;j<Patt.length;j++){
                pat1=Pattern.compile(Patt[j]);
                mat1=pat1.matcher(array[i]);
                if (mat1.find()) array[i]=mat1.replaceAll(ZamPatt[j]);
            }
        }

        // Вывод изменённого массива строк
        for (String s : array) {
            file_BW.write("\n"+s);
        }
        file_BW.close();
    }
}
