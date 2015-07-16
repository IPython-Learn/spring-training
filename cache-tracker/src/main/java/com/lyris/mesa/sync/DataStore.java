package com.lyris.mesa.sync;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DataStore {

    @Expose
    private SalesforceConnect salesforce;
    @Expose
    private FtpConnect ftp;
    @Expose
    private LhqConnect lhq;
    @Expose
    private SchemaConnect schema;
    @Expose
    private FileConnect file;

    public static enum DataType {
        SALESFORCE("salesforce"), FTP("ftp"), LHQ("lhq"), SCHEMA("schema"), FILE("file");        
        private final String value;        
        private static Map<String, DataType> constants = new HashMap<String, DataType>();

        static {
            for (DataType c : DataType.values())
                constants.put(c.value, c);
        }

        private DataType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    @JsonIgnore
    public DataType getType() {
        DataType type = null;        
        int i = 0;
        
        if (salesforce != null) {
        	i++;
        	type = DataType.SALESFORCE;
        } if (ftp != null) {
        	i++;
        	type = DataType.FTP;
        } if (lhq != null) {
        	i++;
        	type = DataType.LHQ;
        } if(file != null) {
        	i++;
        	type = DataType.FILE;
        }
        if(schema != null) {
        	i++;
        	type = DataType.SCHEMA;
        }
        if (i < 1)
            throw new IllegalArgumentException("Data store must specify one type of connection, Salesforce, FTP or LHQ or File or Schema");
        else if (i > 1)
            throw new IllegalArgumentException("More than one type of connection specified, only one is allowed");
        else
            return type;
    }

    public SalesforceConnect getSalesforce() {
        return salesforce;
    }

    public void setSalesforce(SalesforceConnect salesforce) {
        this.salesforce = salesforce;
    }

    public FtpConnect getFtp() {
        return ftp;
    }

    public void setFtp(FtpConnect ftp) {
        this.ftp = ftp;
    }

    public LhqConnect getLhq() {
        return lhq;
    }

    public void setLhq(LhqConnect lhq) {
        this.lhq = lhq;
    }

    public SchemaConnect getSchema() {
		return schema;
	}

	public void setSchema(SchemaConnect schema) {
		this.schema = schema;
	}

	public FileConnect getFile() {
		return file;
	}

	public void setFile(FileConnect file) {
		this.file = file;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

}