package com.mycompany.springbasic1102.jdbc.tx.exception;

//  餘額不足的例外
public class InsufficientAmount extends Exception{

    public InsufficientAmount() {
        super("餘額不足");
    }
    
}
