import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_7 {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_7.txt");

        //Переменные для записи данных в файл
        FileOutputStream file_Out_Str = new FileOutputStream(file);
        OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
        BufferedWriter file_BW = new BufferedWriter(fWr);

        file_BW.write("Найти f(x) x>=-3 || x<=3");
        file_BW.write("\nf=tan(x)+sin(x), при х>=1");
        file_BW.write("\nf=(5*pow(x,2)-3), в противном");
        file_BW.newLine();

        double x,f;
        System.out.print("Введите x, который находится в промежутке от -3 до 3: ");
        x=scan.nextDouble();

        while (x<-3 || x>3){
            System.out.print("Введённое вами число выходит за рамки диапозона, введите ещё раз: ");
            x=scan.nextDouble();
        }

        file_BW.write("\nх="+x);

        if (x>=1){
            file_BW.write("\nх>=1");
            f=tan(x)+sin(x);
            file_BW.write("\ntan(x)+sin(x)="+f);
        }
        else {
            file_BW.write("\nпротивный случай");
            f=(5*pow(x,2)-3);
            file_BW.write("\n(5*pow(x,2)-3)="+f);
        }
        file_BW.close();
    }
}
