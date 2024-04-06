// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo;

public class Calculator {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void doIncrement(){
        count++;
    }

    public void doDecrement(){
        count--;
    }

    public int doSum(int a,int b,int c){
        return a+b+c;
    }

    public int doProduct(int a,int b){
        return a*b;
    }

    public boolean compares(int a,int b){
        return a==b;
    }

}
