import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_8 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        File file = new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_8.txt");

        //Переменные для записи данных в файл
        FileOutputStream file_Out_Str = new FileOutputStream(file);
        OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
        BufferedWriter file_BW = new BufferedWriter(fWr);

        //Постановка задачи
        file_BW.write("Условие для 1 половины 1 фигуры: (x>=-7) & (x<=1) & (y>=-0.0*x+0.0) & (y>=-12.49999999999999*x-82.49999999999993) & (y<=-0.125*x+4.125) & (y>=0.8*x+3.2)");
        file_BW.write("\nУсловие для 2 половины 1 фигуры: ((x>=-6.6) & (x<=-2) & (y<=-0.0*x+0.0) & (y>=-6.6666666666666705*x-44.00000000000002) & (y>=-0.5*x-7.0) & (y<=-3.0*x-12.0))");
        file_BW.write("\nУсловие для 1 половины 2 фигуры: ((x>=1) & (x<=3.2) & (y>=14.999999999999988*x-48.999999999999964) & (y>=1.5*x-8.5) & (y>=-7) & (y<=-2) & (y<=0.45454545454545453*x-2.4545454545454546))");
        file_BW.write("\nУсловие для 2 половины 2 фигуры: ((x>=3) & (x<=6) & (y<=14.999999999999988*x-48.999999999999964) & (y<=1.6666666666666667*x-6.333333333333334) & (y<=-5.0*x+27.0) & (y>=0.3333333333333333*x-5.0))");

        file_BW.newLine();

        System.out.println("Введите количество проверяемых точек");
        int n = scan.nextInt();
        Double[][] matrix = new Double[n][2];
        for (int i=0; i<n; i++) {
            System.out.println("Введите координаты х точки " + (i+1));
            double x = scan.nextDouble();
            matrix[i][0]=x;
            System.out.println("Введите координаты y точки " + (i+1));
            double y = scan.nextDouble();
            matrix[i][1]=y;
        }

        //Массив точек для проверки
        for (int i=1; i<=n; i++) {
            file_BW.write("\nТочка "+i+": "+matrix[i-1][0]+", "+matrix[i-1][1]);

        }

        file_BW.newLine();

        //Проверка
        for (int i=0; i<n; i++) {
            double x=matrix[i][0];
            double y=matrix[i][1];
            if ((x>=-7) & (x<=1) & (y>=-0.0*x+0.0) & (y>=-12.49999999999999*x-82.49999999999993) & (y<=-0.125*x+4.125) & (y>=0.8*x+3.2) |
                    ((x>=-6.6) & (x<=-2) & (y<=-0.0*x+0.0) & (y>=-6.6666666666666705*x-44.00000000000002) & (y>=-0.5*x-7.0) & (y<=-3.0*x-12.0))|
                    ((x>=1) & (x<=3.2) & (y>=14.999999999999988*x-48.999999999999964) & (y>=1.5*x-8.5) & (y>=-7) & (y<=-2) & (y<=0.45454545454545453*x-2.4545454545454546))|
                    ((x>=3) & (x<=6) & (y<=14.999999999999988*x-48.999999999999964) & (y<=1.6666666666666667*x-6.333333333333334) & (y<=-5.0*x+27.0) & (y>=0.3333333333333333*x-5.0)))
            {
                file_BW.write("\nТочка (" + i + ") попала в область");
            } else {
                file_BW.write("\nТочка (" + i + ") не попала в область");
            }
        }

        file_BW.close();
    }
}
