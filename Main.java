package com.metanit;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        FileReader reader = new FileReader("C:\\Users\\honey\\IdeaProjects\\Algoritm_Prima\\src\\com\\metanit\\text.txt");
        Scanner scan = new Scanner(reader);

        String str = new String(scan.nextLine());
        System.out.println(str);

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setGroupingUsed(false);

        int i = 0, count = 0;
        for (String retval : str.split(" ")) {
            count++;
        }
        double[] array = new double[count];

        for (String retval : str.split(" ")) {
            array[i] = Double.parseDouble(retval);
            i++;
        }
        int countOfPoint = (int)array[0]; // количество вершин
        int[][] graph = new int[countOfPoint][countOfPoint];// матрица смежности

        int f=0,l=2;
        for (i = 0; i < countOfPoint; i++){
            for(int j = i; j < countOfPoint; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = f + (int) (Math.random() * 2);
                graph[j][i] = graph[i][j];

            }
        }
        for (i = 0; i < countOfPoint; i++){
            for(int j = 0; j < countOfPoint; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        int max = 10;
        for (i = 0; i < countOfPoint; i++){
            for(int j = i; j < countOfPoint; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = (int) (Math.random() * max);
                    graph[j][i] = graph[i][j];
                }

            }
        }
        System.out.println();
        for (i = 0; i < countOfPoint; i++){
            for(int j = 0; j < countOfPoint; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        Prima t = new Prima();
        t.primMST(graph, countOfPoint);
    }
}