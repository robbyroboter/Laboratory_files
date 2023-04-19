import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Создание файла

        File file= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_2.txt");
        FileReader fRe=new FileReader(file);
        FileWriter fWr=new FileWriter(file);
        BufferedReader file_BR=new BufferedReader(fRe);
        BufferedWriter file_BW=new BufferedWriter(fWr);

        for (int a=1; a<=9; a++){
            for (int i=1; i<=9; i++){
                if (i<9){
                    if(a*i<10){file_BW.write(a+" * "+i+" = "+a*i+"     ");}
                    if(a*i>=10){file_BW.write(a+" * "+i+" = "+a*i+"    ");}
                }
                if (i==9){
                    if (a*i<10){
                        file_BW.write(a+" * "+i+" = "+a*i+"      ");
                        file_BW.newLine();
                    }
                    if (a*i>=10){
                        file_BW.write(a+" * "+i+" = "+a*i+"      ");
                        file_BW.newLine();
                    }
                }
            }
        }

        file_BW.close();

        //Считывание данных из файла
        while (file_BR.ready()){
            System.out.println(file_BR.readLine());
        }
    }
}
