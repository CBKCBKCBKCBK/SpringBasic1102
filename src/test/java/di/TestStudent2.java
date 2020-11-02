package di;

import com.mycompany.springbasic1102.di.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent2 {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans-config.xml");
        Student s1= (Student)ctx.getBean("s1");
        System.out.println(s1);
//        Student s2=ctx.getBean(Student.class);    //有2個bean的話 此處會發生錯誤
        Student s2=ctx.getBean("s2",Student.class);     //前面加id就可以
        System.out.println(s2);
    }
}
