package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {8, 2, 1, 5, 2, 5, 8, 8};
        int[] newArr = arr;
        int quantity = 1;

        Arrays.sort(arr);
        for (int i = 1; i < newArr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                quantity++;
            }
        }
        int[][] quantityArr = new int[quantity][2];
        quantityArr[0][0] = newArr[0];
        quantityArr[0][1] = 1;

        int index = 0;
        for (int i = 1; i < newArr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                index++;
                quantityArr[index][0] = arr[i];
                quantityArr[index][1] = 1;
            } else {
                quantityArr[index][1] = quantityArr[index][1] + 1;
            }
        }

        for (int i = 0; i < quantityArr.length; i++){
            for (int j = i; j < quantityArr.length; j++){
                if (quantityArr[i][1] < quantityArr[j][1]){
                    int var = quantityArr[i][1];
                    quantityArr[i][1] = quantityArr[j][1];
                    quantityArr[j][1] = var;

                    var = quantityArr[i][0];
                    quantityArr[i][0] = quantityArr[j][0];
                    quantityArr[j][0] = var;
                }
            }
        }

        for (int i = 1; i < quantityArr.length; i++) {
            if (quantityArr[i][1] == quantityArr[i - 1][1]){
                for (int j = 0; j < arr.length; j++){
                    if(quantityArr[i][0] == arr[j]){
                        int var = quantityArr[i][1];
                        quantityArr[i][1] = quantityArr[i - 1][1];
                        quantityArr[i - 1][1] = var;

                        var = quantityArr[i][0];
                        quantityArr[i][0] = quantityArr[i - 1][0];
                        quantityArr[i - 1][0] = var;
                    } else if(quantityArr[i - 1][0] == arr[j]){
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < quantityArr.length; i++){
            System.out.println(quantityArr[i][0] + " : " + quantityArr[i][1]);
        }

        index = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = quantityArr[index][0];
            j++;
            if (quantityArr[index][1] == j){
                index++;
                j = 0;
            }
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
