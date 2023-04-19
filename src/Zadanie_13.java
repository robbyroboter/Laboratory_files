import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_13 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scan = new Scanner(new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_13_1.txt"));

        File file1= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_13_1.txt");
        File file2= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_13_2.txt");

        //Переменные для записи данных в файл2
        FileOutputStream file2_Out_Str = new FileOutputStream(file2);
        OutputStreamWriter fWr2 = new OutputStreamWriter(file2_Out_Str);
        BufferedWriter file2_BW = new BufferedWriter(fWr2);

        //Переменные для записи данных во временный файл
        FileOutputStream fileTemp_Out_Str = new FileOutputStream("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_13_temp.txt");
        OutputStreamWriter fWrTmp = new OutputStreamWriter(fileTemp_Out_Str);
        BufferedWriter fileTemp_BW = new BufferedWriter(fWrTmp);

        while(scan.hasNextInt()){
            int mainDiag=0,subDiag=0;
            //Создание двумерного массива из файла
            int N = scan.nextInt();
            int[][] matrix = new int[N][N];

            //Заготовка для обратной матрицы
            double[][] revmatrix = new double[N][N];
            int det=0;

            //Заполнение массива
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scan.nextInt();
                }
                System.out.println();
            }

            mainDiag=matrix[0][0];
            subDiag=matrix[0][N-1];

            //Проверка диагоналей
            for (int i = 1; i < N; i++) {
                mainDiag-=matrix[i][i];
            }
            int k=1;
            for (int i = N-2; i >= 0; i--) {
                subDiag-=matrix[k][i];
                k++;
            }

            if (mainDiag%2==0 & subDiag%2==0){
                //Вывод оригинальной матрицы во 2 файл
                for (int i=0;i< matrix.length;i++) {
                    for (int j = 0; j < N; j++) {
                        file2_BW.write(matrix[i][j]+" ");
                    }
                    file2_BW.newLine();
                }

                file2_BW.newLine();
                //Заполнение и вывод обратной матрицы во временный файл

                if (N==2){
                    det=(matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]);
                    if (det!=0){
                        revmatrix[0][0]= pow(-1,1+1)*matrix[1][1];
                        revmatrix[1][0]= pow(-1,1+2)*matrix[1][0];
                        revmatrix[0][1]= pow(-1,2+1)*matrix[0][1];
                        revmatrix[1][1]= pow(-1,2+2)*matrix[0][0];

                        for (int i=0;i<revmatrix.length;i++){
                            for (int j=0;j<revmatrix[i].length;j++){
                                revmatrix[i][j]=(1.0 /det)*revmatrix[i][j];
                            }
                        }

                        //Заполнение временного файла
                        for (int i=0;i< revmatrix.length;i++) {
                            for (int j = 0; j < N; j++) {
                                fileTemp_BW.write(revmatrix[i][j]+" ");
                            }
                            fileTemp_BW.newLine();
                        }
                        fileTemp_BW.newLine();

                    }
                    else{
                        fileTemp_BW.write("Обратной матрицы не существует");
                        fileTemp_BW.newLine();
                        fileTemp_BW.newLine();
                    }
                }

                else if (N==3){
                    det=((matrix[0][0]*matrix[1][1]*matrix[2][2])+(matrix[0][1]*matrix[1][2]*matrix[2][0])+(matrix[0][2]*matrix[1][0]*matrix[2][1]))-((matrix[0][2]*matrix[1][1]*matrix[2][0])+(matrix[0][0]*matrix[1][2]*matrix[2][1])+(matrix[0][1]*matrix[1][0]*matrix[2][2]));
                    if (det!=0){
                        revmatrix[0][0]= pow(-1,1+1)*(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1]);
                        revmatrix[1][0]= pow(-1,1+2)*(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0]);
                        revmatrix[2][0]= pow(-1,1+3)*(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]);
                        revmatrix[0][1]= pow(-1,2+1)*(matrix[0][1]*matrix[2][2]-matrix[0][2]*matrix[2][1]);
                        revmatrix[1][1]= pow(-1,2+2)*(matrix[0][0]*matrix[2][2]-matrix[0][2]*matrix[2][0]);
                        revmatrix[2][1]= pow(-1,2+3)*(matrix[0][0]*matrix[2][1]-matrix[0][1]*matrix[2][0]);
                        revmatrix[0][2]= pow(-1,3+1)*(matrix[0][1]*matrix[1][2]-matrix[0][2]*matrix[1][1]);
                        revmatrix[1][2]= pow(-1,3+2)*(matrix[0][0]*matrix[1][2]-matrix[0][2]*matrix[1][0]);
                        revmatrix[2][2]= pow(-1,3+3)*(matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0]);

                        for (int i=0;i<revmatrix.length;i++){
                            for (int j=0;j<revmatrix[i].length;j++){
                                revmatrix[i][j]*= 1.0 /det;
                            }
                        }

                        //Заполнение временного файла
                        for (int i=0;i< revmatrix.length;i++) {
                            for (int j = 0; j < N; j++) {
                                fileTemp_BW.write(revmatrix[i][j]+" ");
                            }
                            fileTemp_BW.newLine();
                        }
                        fileTemp_BW.newLine();

                    }
                    else{
                        fileTemp_BW.write("Обратной матрицы не существует");
                        fileTemp_BW.newLine();
                        fileTemp_BW.newLine();
                    }
                }
            }
            else {
                for (int i=0;i< matrix.length;i++) {
                    for (int j = 0; j < N; j++) {
                        fileTemp_BW.write(matrix[i][j]+" ");
                    }
                    fileTemp_BW.newLine();
                }
                fileTemp_BW.newLine();
            }
        }
        fileTemp_BW.close();
        file2_BW.close();
        scan.close();


        //Перезапись информации из врмеенного файла в изначальный


        //Переменные для записи данных в файл1
        FileOutputStream file1_Out_Str = new FileOutputStream(file1);
        OutputStreamWriter fWr1 = new OutputStreamWriter(file1_Out_Str);
        BufferedWriter file1_BW = new BufferedWriter(fWr1);

        //Переменные для чтения временного файла
        File fileTemp= new File("D:\\практика вуз\\Информатика\\Lab_10_files\\Zadanie_13_Temp.txt");
        FileInputStream fileTemp_In_Str  = new FileInputStream(fileTemp);
        InputStreamReader fReTmp=new InputStreamReader(fileTemp_In_Str);
        BufferedReader fileTemp_BR = new BufferedReader(fReTmp);

        while (fileTemp_BR.ready()){
            String s=fileTemp_BR.readLine();
            file1_BW.write(s);
            file1_BW.newLine();
        }
        fileTemp_BR.close();
        file1_BW.close();
        fileTemp.delete();


        //Выведение резельтатов в программу


        //Переменные для чтения файла1
        FileInputStream file1_In_Str  = new FileInputStream(file1);
        InputStreamReader fRe1=new InputStreamReader(file1_In_Str);
        BufferedReader file1_BR = new BufferedReader(fRe1);

        //Переменные для чтения файла2
        FileInputStream file2_In_Str  = new FileInputStream(file2);
        InputStreamReader fRe2=new InputStreamReader(file2_In_Str);
        BufferedReader file2_BR = new BufferedReader(fRe2);

        System.out.println("Первый файл:");

        String line1=file1_BR.readLine();
        while (line1!=null){
            System.out.println(line1);
            line1=file1_BR.readLine();
        }
        file1_BR.close();
        System.out.println("-----------------------------");

        System.out.println("Второй файл:");

        String line2=file2_BR.readLine();
        while (line2!=null){
            System.out.println(line2);
            line2=file2_BR.readLine();
        }
        file2_BR.close();
    }
}

//3
//4 6 5
//2 1 4
//2 4 1
//2
//3 3
//1 1
//3
//7 2 4
//3 1 4
//1 6 2