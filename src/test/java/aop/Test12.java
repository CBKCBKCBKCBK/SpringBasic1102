package aop;

import com.mycompany.springbasic1102.aop.BMI;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test12 {
    
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
        BMI bmi = ctx.getBean("BMIImpl", BMI.class); //CalcImpl c要小寫
//        System.out.println(calc.add(2, 3));
//        System.out.println(calc.mul(2, 3));
        
        try {
//            System.out.println(calc.div(4, 0));
            System.out.println(bmi.calc(170.0, 60.0));
        } catch (Exception e) {
        }
        
        ctx.close();
    }
}
