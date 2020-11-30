package jpa.single;

import com.mycompany.springbasic1102.jpa.entities.Customer;
import jpa.JPATemplate;
import org.junit.Test;

public class Create extends JPATemplate{
    
    @Test
    public void t1(){
        Customer customer=new Customer();
        customer.setLastName("Tom");
        session.persist(customer);
    }
}
