package jdbc.tx;

import com.mycompany.springbasic1102.jdbc.tx.dao.BookDao;
import com.mycompany.springbasic1102.jdbc.tx.exception.InsufficientAmount;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tx1 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("jdbc-config.xml");
        BookDao bookDao=ctx.getBean("bookDaoImpl",BookDao.class);
        System.out.println(bookDao);    //測試有無此物件
        //  wid=1 顧客的錢包編號
        int wid=1;
        //  bid=1 的書籍價格
        int bid=1;
        //  查詢書籍價格
        int price=bookDao.getPrice(1);
        //  進行交易
        System.out.println("交易開始");
        bookDao.updateStock(bid);
        try {
            bookDao.updateWallet(wid, price);
        } catch (InsufficientAmount ex) {
            Logger.getLogger(Tx1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("交易完成");
    }
}
