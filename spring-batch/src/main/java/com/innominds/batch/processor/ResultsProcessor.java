package com.innominds.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.innominds.jdbc.model.ExamResult;
import com.innominds.jdbc.model.TargetTable;

/**
 * 
 * Perform manipulations before sending it to writer
 *
 */
@Component("resultProcessor")
public class ResultsProcessor implements ItemProcessor<ExamResult, TargetTable> {

    @Override
    public TargetTable process( ExamResult item ) throws Exception {
        TargetTable targetTable = new TargetTable();

        targetTable.setSumofRow( item.getSubject1() + item.getSubject2() + item.getSubject3() + item.getSubject4() );
        targetTable
                .setMaxmumValue( Math.max( Math.max( item.getSubject1(), item.getSubject2() ), Math.max( item.getSubject3(), item.getSubject4() ) ) );

        return targetTable;
    }
}
