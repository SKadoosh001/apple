package Homework;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(" 请输入需要打印的行数：");
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int row = 2 * line - 1;

        for (int i = line; i > 0; i--) {
            for (int j = row; j>0;j--){
                if (i+j-1==row){
                    for (int k = 1; k<=row-2*i+2;k++){
                        System.out.print("*");
                        if (k==row-2*i+2){
                            break;
                        }
                        j--;
                    }
                }else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}
