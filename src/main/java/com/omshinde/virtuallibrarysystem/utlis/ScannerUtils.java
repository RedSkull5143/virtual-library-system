package com.omshinde.virtuallibrarysystem.utlis;

import java.util.Scanner;

public class ScannerUtils {
    private final Scanner sc=new Scanner(System.in);

    public int getIntInput(String message){
        System.out.print(message+ " ");
        return sc.nextInt();
    }
}
