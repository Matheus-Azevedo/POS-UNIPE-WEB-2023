package com.example.teste;

public class Main {
    public static void main(String[] args) {
        Valores valores = new Valores();
        for (int i = 1; i <= 10; i++) {
            System.out.println(valores.ins(i));
        }
        System.out.println(valores.size());
        System.out.println(valores.del(0));
        System.out.println(valores.del(1));
        System.out.println(valores.del(2));
        System.out.println(valores.del(3));
        System.out.println(valores.del(4));
        System.out.println(valores.del(5));
        System.out.println(valores.del(6));
        System.out.println(valores.del(7));
        System.out.println(valores.del(8));
        System.out.println(valores.del(9));
        System.out.println(valores.del(10));
        System.out.println(valores.size());
    }
}