package com.openid.kim;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;

import net.spring4.chap01.Project;
/**
 * Hello world!
 *
 */

@ApplicationScope
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String configLocation = "classPath:spring-servlet.xml";
        
        AbstractApplicationContext aac = new GenericXmlApplicationContext(configLocation);
        Project pr = aac.getBean("sampleProject",Project.class);
        
        pr.build();
    }
}
