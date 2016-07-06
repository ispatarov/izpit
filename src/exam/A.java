package exam;
import java.io.*;
import java.util.Scanner;

public class A {
	 private Scanner s = new Scanner(System.in);
	    public int[] a(int[][] arr) {
	        int size = arr.length;
	        int[] newArr = new int[size * size];
	        int index = 0;
	        for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {
	                newArr[index++] = arr[j][i];
	            }
	        }
	        return newArr;
	    }
	    public int[][] a(int[] arr) {
	        int size = (int)Math.sqrt(arr.length);
	        int[][] newArr = new int[size][size];
	        int index = 0;
	        for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {
	                newArr[j][i] = arr[index] * index++;
	            }
	        }
	        return newArr;
	    }
	    private boolean operate() {
	        System.out.print("Menu\n\t1 - Single to double\n\t2 - Double to single\n\t3 - Quit\n>");
	        return dispatchUserInput(s.nextInt());
	    }
	    private boolean dispatchUserInput(int userInput) {
	        switch (userInput) {
	            case 1 :
	                singleToDouble();
	                return true;
	            case 2 :
	                doubleToSingle();
	                return true;
	        }
	        return userInput != 3;
	    }
	    private void singleToDouble() {
	        int size = getSize();
	        size *= size;
	        int arr[] = new int[size];
	        for (int i = 0; i < size; i++) {
	            arr[i] = getNumber();
	        }
	        int[][] newArr = a(arr);
	        print(newArr);
	        save(newArr);
	    }
	    private void doubleToSingle() {
	        int size = getSize();
	        int[][] arr = new int[size][size];
	        for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {
	                arr[i][j] = getNumber();
	            }
	        }
	        int[] newArr = a(arr);
	        print(newArr);
	        save(newArr);
	    }
	    private void print(int[] arr) {
	        System.out.println("New array:\n");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	    private void print(int[][] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr[i].length; j++) {
	                System.out.print(arr[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	    private void save(Object arr) {
	        try {
	            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.txt"));
	            out.writeObject(arr);
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    private int getNumber() {
	        System.out.print("Enter next number\n>");
	        return s.nextInt();
	    }
	    private int getSize() {
	        int size;
	        do {
	            System.out.println("Enter size[2-9]\n>");
	            size = s.nextInt();
	        } while (size < 2 || size > 9);
	        return size;
	    }
	    public static void main(String[] args) {
	        A a = new A();
	        while (a.operate());
	    }
	}
	


