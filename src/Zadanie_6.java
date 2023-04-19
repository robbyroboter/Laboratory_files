import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_6 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int count = 0;
        String line, S;
        ArrayList<Object> list = new ArrayList<>();

        //Клиники

        String[] Kliniks = {"ГКП №1", "ГКП №2"};
        int[] Klinik_doctors = new int[2];

        File file = new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_6.txt");

        //Переменные для чтения файла
        FileInputStream file_In_Str = new FileInputStream(file);
        InputStreamReader fRe = new InputStreamReader(file_In_Str);
        BufferedReader file_BR = new BufferedReader(fRe);

        //Переменные для записи данных в файл
        FileOutputStream file_Out_Str = new FileOutputStream(file, true);
        OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
        BufferedWriter file_BW = new BufferedWriter(fWr);

        //Создание массивов
        while ((line = file_BR.readLine()) != null) {

            String[] str = line.split("\\.");

            // То же самое что ниже
//            for (String c : str) {
//                list.add(c);
//            }
            Collections.addAll(list, str);
        }

        file_BW.write("\n");
        //Перевод листа в массив строк
        String[] array = list.toArray(new String[list.size()]);

        for (int k=0;k<Kliniks.length;k++){
            for (int i = 0; i < array.length; i++) {
                String[] subArray = array[i].split(",");

                if (subArray[2].equals(Kliniks[k])){
                    if ((Integer.parseInt(subArray[3])>=700 && Integer.parseInt(subArray[3])<=1400) && Integer.parseInt(subArray[4])>=10){
                        Klinik_doctors[k]+=1;
                    }
                }
            }
        }

        // Вывод результатов в файл
        for (int i=0;i<Kliniks.length;i++){

            file_BW.write("\nДокторов подходящих по критериям в больнице " + Kliniks[i]+" - "+Klinik_doctors[i]);
        }
        file_BW.close();
    }
}

//    Борисов Борис Борисович, хирург, "ГКП №2", 1400, 15.
//    Хлестаков Дмитрий Игоревич, ортопед, "ГКП №1", 700, 5.
//    Николаев Павел Романович, кардиолог, "ГКП №2", 1100, 10.
//    Царев Василий Шарифович, кардиолог, "ГКП №1", 1100, 7.