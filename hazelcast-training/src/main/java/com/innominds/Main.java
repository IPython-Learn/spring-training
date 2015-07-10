package com.innominds;

import java.net.InetAddress;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    {
        try {
            System.out.println( InetAddress.getLocalHost().getHostName().replaceAll( "[\\W]", "_" ) );

            System.out.println( InetAddress.getLocalHost().getHostAddress() );
        } catch ( Exception e ) {
            
        }
    }

    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "cache-context.xml" );

        System.out.println( context.getBean( "userTokenMap" ) );

        context.close();
    }
}
