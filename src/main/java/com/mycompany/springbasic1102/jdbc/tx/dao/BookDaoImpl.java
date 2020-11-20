package com.mycompany.springbasic1102.jdbc.tx.dao;

import com.mycompany.springbasic1102.jdbc.tx.exception.InsufficientAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPrice(Integer bid) {
        String sql="select price from Book where bid=?";
        Integer price=jdbcTemplate.queryForObject(sql,Integer.class,bid);
        return price;
    }

    @Override
    public void updateStock(Integer bid) {
        String sql="update stock set amount=amount-1 where bid=?";
        jdbcTemplate.update(sql,bid);
    }

    @Override
    public void updateWallet(Integer wid, Integer money) throws  InsufficientAmount{
        //  先得到 Wallet的Money是否足夠?
        String sql="select money from Wallet where wid=?";
        int walletMoney=jdbcTemplate.queryForObject(sql, Integer.class,wid);
        if (walletMoney<money) {
            throw new InsufficientAmount();
        }
        
        //  進行錢包餘額更新
        sql="update wallet set money=money-? where wid=?";
        
        jdbcTemplate.update(sql,money,wid);
    }
    
}