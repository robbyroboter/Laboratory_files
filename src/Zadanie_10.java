import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_10 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        double x, greh, xone, reazlt, itog_greh, sum_riad=0;
        int step;
        long fac;

        File file= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_10.txt");

        //Переменные для записи данных в файл
        FileOutputStream file_Out_Str = new FileOutputStream(file);
        OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
        BufferedWriter file_BW = new BufferedWriter(fWr);

        System.out.print("Введите x: ");
        x=scan.nextDouble();

        while (x>=1){
                System.out.print("x не должен быть больше или равен 1, повторите ввод: ");
                x=scan.nextDouble();
           }

        System.out.print("Введите отрицательную степень погрешности (от -2 до -4): ");
        step=scan.nextInt();

        while (step<-4 || step>-2){
            System.out.print("Вы ввели неправильную степень, повторите ввод: ");
            step=scan.nextInt();
        }
        greh=pow(10,step);
//        System.out.println("Погрешность " + greh);
        xone=pow(sin(x),2);
        //System.out.println("Синус икса " + xone);

        for (int i=1; i<=99;i++) {
            fac = 2 * i;
            for (long j = (fac - 1); j > 1; j--) {
                fac = fac * j;
            }
            reazlt=pow(-1,i+1)*((pow(2,2*i-1)*pow(x,2*i))/fac);
//            System.out.println("р " + reazlt);
            sum_riad=sum_riad+reazlt;
//            System.out.println("sum " + sum_riad);
            if (abs(xone-sum_riad)<greh){
                itog_greh=xone-sum_riad;

                file_BW.write("Функция f(x)=sin^2(x) для х="+x+" равняется "+xone);
                file_BW.write("\nРезультаты определения значений функции f(x)= pow(-1,i+1)*((pow(2,2*i-1)*pow(x,2*i))/fac) с помощью ряда Маклорена");
                file_BW.write("\nПогрешность итерационной процедуры "+greh);
                file_BW.write("\nЗначение функции по Маклорену\t\t Погрешность, %\t\t Число итераций");
                file_BW.write("\n\t"+sum_riad+"\t\t"+itog_greh+"\t\t"+i);
                break;
            }
        }
        file_BW.close();
    }
}
