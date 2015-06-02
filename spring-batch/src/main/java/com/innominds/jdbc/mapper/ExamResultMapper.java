package com.innominds.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.innominds.jdbc.model.ExamResult;

@Component("examResultMapper")
public class ExamResultMapper implements RowMapper<ExamResult> {

    @Override
    public ExamResult mapRow( ResultSet rs, int rowNum ) throws SQLException {
        
        System.out.println(" ############    ExamResultMapper  ##############  ");
        
        ExamResult result = new ExamResult();
        result.setId( rs.getInt( "id" ) );
        result.setSubject1( rs.getInt( "subject1" ) );
        result.setSubject2( rs.getInt( "subject2" ) );
        result.setSubject3( rs.getInt( "subject3" ) );
        result.setSubject4( rs.getInt( "subject4" ) );

        return result;

    }
}
