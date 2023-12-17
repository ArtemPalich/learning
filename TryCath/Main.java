package com.TryCath;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//1
        try {
            String str = null;
            str.length();
        } catch (NullPointerException exc) {
            System.out.println("1. exception: " + exc);
        }

//2
        try {
            int[] arr = new int[5];
            arr[10] = 7;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("2. exception: " + exc);
        }
//3
        try {
           throwCustomException();
        } catch (CustomException exc) {
           exc.printStackTrace();
        }
//4
        try {
            int result = 7 / 0;
        } catch (ArithmeticException exc) {
            CustomException2 customException = new CustomException2("My custom exception", exc);
            System.out.println("4.exception: " + customException);
        }
//5
        try {
            throwRandomException();
        } catch (Exception exc) {
            System.out.println("Exception: " + exc);
        }






}

    public static class CustomException extends Exception {
        CustomException(String message) {
            super(message);
        }
    }


    public static void throwCustomException() throws CustomException {
        throw new CustomException("3. own exception (Кирилица слетела) !");
    }

    public static class CustomException2 extends Exception {
        CustomException2(String message, Throwable cause) {
            super(message, cause);
        }
    }


        public static void throwRandomException() throws Exception {
            Random random = new Random();
            int choice = random.nextInt(3);

            if (choice == 0) {
                throw new NullPointerException();
            } else if (choice == 1) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (choice == 2) {
                throw new IllegalArgumentException();
            }
        }

}

