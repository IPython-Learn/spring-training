package com.innominds.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.innominds.jdbc.model.TargetTable;

/**
 * This useful to save our own login to save into database. <br>
 * Ex: auto-wire dataSource and write own logic.<br>
 * NOTE: we are not using this for now.
 */
@Component( "compositeWriter" )
public class CompositeWriter implements ItemWriter<TargetTable> {

    @Override
    public void write( List<? extends TargetTable> items ) throws Exception {
        System.out.println( "###########     CompositeWriter     ##############" );

        for ( TargetTable examResult : items ) {
            System.err.println( examResult );
        }
    }
}
