package com.websystique;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main( String[] args ) {

        try ( ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "batch-job-context.xml" ) ) {
            JobLauncher jobLauncher = (JobLauncher) context.getBean( "jobLauncher" );
            System.out.println( "  jobLauncher  :  " + jobLauncher );
            Job examResultJob = (Job) context.getBean( "examResultJob" );
            System.out.println( " examResultJob " + examResultJob );
            try {
                JobExecution execution = jobLauncher.run( examResultJob, new JobParameters() );
                System.out.println( "Exit Status : " + execution.getStatus() );

            } catch ( Exception e ) {
                e.printStackTrace();
            }
            System.out.println( "  DONE !" );
        }
    }
}
