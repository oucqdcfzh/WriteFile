package edu.cn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FileApplication application = context.getBean(FileApplication.class);
        application.service("Hello World!");
        //手动关闭Spring容器
        if(context instanceof AbstractApplicationContext)
        {
            ((AbstractApplicationContext)context).registerShutdownHook();

        }


    }
}
