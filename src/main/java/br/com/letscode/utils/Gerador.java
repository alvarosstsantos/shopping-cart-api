package br.com.letscode.utils;

import java.util.Random;

public class Gerador {
    private static Random rd = new Random();

    public static Long generateRandomLong() {
       return Math.abs(rd.nextLong());
    }
}
