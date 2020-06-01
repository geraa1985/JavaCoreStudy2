package Lesson_5;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            float[] arr = new float[size];
            long a = System.currentTimeMillis();
            fillArr(arr,0);
            long b = System.currentTimeMillis();
            System.out.println("Без разбивки: " + (b - a) + "мс");
            System.out.println("Элемент массива:" + arr[h+50]);
        });

        Thread t2 = new Thread(() -> {
            float[] arr = new float[size];
            float[] a1 = new float[h];
            float[] a2 = new float[h];

            long a = System.currentTimeMillis();

            Thread t3 = new Thread(() -> {
                fillArr(a1,0);
                System.arraycopy(a1, 0, arr, 0, h);
            });

            Thread t4 = new Thread(() -> {
                fillArr(a2,h);
                System.arraycopy(a2, 0, arr, h, h);
            });

            t3.start();
            t4.start();

            try {
                t3.join();
                t4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long b = System.currentTimeMillis();
            System.out.println("С разбивкой: " + (b - a) + "мс");
            System.out.println("Тот же элемент в склеенном массиве:" + arr[h+50]);

        });

        t1.start();
        t2.start();
    }

    static void  fillArr (float[] arr,int x){
        Arrays.fill(arr, 1.0f);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float) (i+x) / 5) * Math.cos(0.2f + (float)(i+x) / 5) * Math.cos(0.4f + (float)(i+x) / 2));
        }
    }
}
