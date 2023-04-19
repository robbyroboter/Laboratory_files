import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_1 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, IOException {

        int countLat=0, countDoubPrepin=0, countPrepin=0, countRavSkob=0, countDifSkob=0;
        int crug=0, figur=0, kvad=0;
        int y=0,x=0, num_y=0, num_x=0;
        String S;

        System.out.print("Введите любое слово для пункта б): ");
        String str = scan.nextLine();

        String line = new String();
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

        // Заполнение массива символов из листа
        String string=list.toString().replaceAll(",", "");
        char[] array = string.substring(1, string.length()-1).replaceAll(" ", "").toCharArray();


        // а,в
        for (int i = 0; i < list.size()-1; i++) {
            if (array[i]>='a' && array[i]<='z') countLat++;
            if (array[i]=='.' || array[i]=='…' || array[i]==',') countPrepin++;
        }

        // б

        //Создание записывателя в файл
        FileOutputStream file_Out_Str  = new FileOutputStream(file,true);

        for (char c : array) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (c == str.charAt(j)) count++;
            }
            S="\nСимвол " + c + " встречается в массиве " + count + " раз";
            byte[] data_S=S.getBytes();
            file_Out_Str.write(data_S);
        }
        // г(1)
        for (int i=0;i<array.length-1;i++){
            if((array[i]=='(' & array[i+1]==')') || (array[i]=='{' & array[i+1]=='}') || (array[i]=='[' & array[i+1]==']')) countRavSkob++;
        }
//
        // г(2)
        for (char c : array) {
            if (c == '(') crug++;
            if (c == '[') kvad++;
            if (c == '{') figur++;

            if (crug > 0 & (c == ']' || c == '}')) {
                countDifSkob++;
                crug = 0;
            }
            if (kvad > 0 & (c == ')' || c == '}')) {
                countDifSkob++;
                kvad = 0;
            }
            if (figur > 0 & (c == ']' || c == ')')) {
                countDifSkob++;
                figur = 0;
            }
        }

        // д
        for (int i=0;i<array.length-1;i++){
            if((array[i]=='.' & array[i+1]=='.') || (array[i]==',' & array[i+1]==',') || (array[i]==':' & array[i+1]==':') || (array[i]==';' & array[i+1]==';')) countDoubPrepin++;
        }

        // e
        //Присвоение переменных

        System.out.print("Введите для пункта е) k: ");
        int k = scan.nextInt();
        System.out.print("Введите для пункта е) n: ");
        int n = scan.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i]) & y==0){
                y=Character.getNumericValue(array[i]);
                num_y=i;
                i++;
                continue;
            }

            if (Character.isDigit(array[i])){
                x=Character.getNumericValue(array[i]);
                num_x=i;
                break;
            }
        }

        S="\nm= "+y +", k="+ k+", x= "+x +", n="+n;
        byte[] data_S=S.getBytes();
        file_Out_Str.write(data_S);
        System.out.println();

        // Просмотр условий из е)
        if (y<k & k<x & x<n){
            S="\nУсловие m<k<x<n выполняется";
            byte[] data_S1=S.getBytes();
            file_Out_Str.write(data_S1);
        }
        else{
            S="\nУсловие m<k<x<n невыполняется";
            byte[] data_S1=S.getBytes();
            file_Out_Str.write(data_S1);
        }

        if (Character.isDigit(array[num_y]) & Character.isDigit(array[num_y+1])  & Character.isDigit(array[num_x]) & (Character.isDigit(array[num_x+1]) & num_x+1<=array.length-1)){
            S="\nУсловие: 'S(m),S(m+1),S(k),S(x),S(x+1)-цифры' - выполняется";
            byte[] data_S1=S.getBytes();
            file_Out_Str.write(data_S1);
            int xPl, mPl;
            xPl=Character.getNumericValue(array[num_x+1]);
            mPl=Character.getNumericValue(array[num_y+1]);

            if ((y>k & mPl>k)&(k>x & k>xPl)) {
                S="\nУсловие: 'S(m),S(m+1)>S(k); S(x),S(x+1)<S(k)' - выполняется";
                byte[] data_S2=S.getBytes();
                file_Out_Str.write(data_S2);
            }
            else{
                S="\nУсловие: 'S(m),S(m+1)>S(k); S(x),S(x+1)<S(k)' - невыполняется";
                byte[] data_S2=S.getBytes();
                file_Out_Str.write(data_S2);
            }
        }
        else{
            S="\nУсловие: 'S(m),S(m+1),S(k),S(x),S(x+1)-цифры' - невыполняется";
            byte[] data_S1=S.getBytes();
            file_Out_Str.write(data_S1);
        }


        S="\nКоличество строчных латинских букв: "+countLat;
        data_S=S.getBytes();
        file_Out_Str.write(data_S);

        S="\nКоличество знаков препинания: "+countPrepin;
        data_S=S.getBytes();
        file_Out_Str.write(data_S);

        S="\nКоличество пар знаков препинания стоящих рядом: "+countDoubPrepin;
        data_S=S.getBytes();
        file_Out_Str.write(data_S);

        S="\nКоличество соседних одинаковых скобок: "+countRavSkob;
        data_S=S.getBytes();
        file_Out_Str.write(data_S);

        S="\nКоличество закрытых разных скобок: "+countDifSkob;
        data_S=S.getBytes();
        file_Out_Str.write(data_S);

        file_Out_Str.close();

    }
}