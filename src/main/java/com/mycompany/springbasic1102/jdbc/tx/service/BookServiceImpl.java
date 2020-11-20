package com.mycompany.springbasic1102.jdbc.tx.service;

import com.mycompany.springbasic1102.jdbc.tx.dao.BookDao;
import com.mycompany.springbasic1102.jdbc.tx.exception.InsufficientAmount;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    //除非所有方法都用到 否則@Transactional不放在類別上
    @Transactional(
            propagation = Propagation.REQUIRED,
            timeout = 2,
            rollbackFor = {InsufficientAmount.class}
//            noRollbackFor = {InsufficientAmount.class}
    )
    @Override
    public void buyOne(Integer wid, Integer bid)throws InsufficientAmount{
        int price = bookDao.getPrice(bid);
        bookDao.updateStock(bid);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(BookServiceImpl.class.getName()).log(Level.SEVERE, "交易超時", ex);
//        }
        bookDao.updateWallet(wid, price);
    }

    @Override
    public void buyMany(Integer wid, Integer... bids) {

    }

}
