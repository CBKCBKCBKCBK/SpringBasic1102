package com;

public class Star {
    public static void main(String[] args) {
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if(i>=j&9-i>=j+3){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
        
    }
    
}
/**
 * i4j2 i5j1 i6j0
 */