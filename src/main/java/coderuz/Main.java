package coderuz;


import coderuz.controller.ContactController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactController  contactController=context.getBean(ContactController.class);
        contactController.start();
    }
}