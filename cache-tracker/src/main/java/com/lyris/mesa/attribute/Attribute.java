package com.lyris.mesa.attribute;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Attribute of a stored data item
 * 
 */
/**
 * @author tchilders
 *
 */
@Generated("org.jsonschema2pojo")
public class Attribute {

    /**
     * name of the attribute
     * 
     */
    @Expose
    private String name;
    /**
     * the data type of an attribute
     * 
     */
    @Expose
    private Attribute.Type type;
    /**
     * is each value of this attribute unique?
     * 
     */
    @Expose
    private Boolean unique;
    /**
     * is this attribute required to have a value?
     * 
     */
    @Expose
    private Boolean required;
    /**
     * can this attribute have a null value?
     * 
     */
    @Expose
    private Boolean nullable;
    /**
     * is this attribute used as a key for retrieval?
     * 
     */
    @Expose
    private Boolean privateKey;
    /**
     * String attributes only, maximum length
     * 
     */
    @Expose
    private Long maxLength;
    /**
     * default value for this attribute
     * 
     */
    @SerializedName("default")
    @Expose
    private String _default;


    /**
     * @param name
     * @param type
     * @param unique
     * @param required
     * @param nullable
     * @param privateKey
     * @param maxLength
     * @param defaultValue
     */
    public Attribute(String name, Type type, Boolean unique, Boolean required, Boolean nullable, Boolean privateKey, Long maxLength, String defaultValue) {
        super();
        this.name = name;
        this.type = type;
        this.unique = unique;
        this.required = required;
        this.nullable = nullable;
        this.privateKey = privateKey;
        this.maxLength = maxLength;
        this._default = defaultValue;
    }

    /**
     * name of the attribute
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * name of the attribute
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * the data type of an attribute
     * 
     */
    public Attribute.Type getType() {
        return type;
    }

    /**
     * the data type of an attribute
     * 
     */
    public void setType(Attribute.Type type) {
        this.type = type;
    }

    /**
     * is each value of this attribute unique?
     * 
     */
    public Boolean getUnique() {
        return unique;
    }

    /**
     * is each value of this attribute unique?
     * 
     */
    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    /**
     * is this attribute required to have a value?
     * 
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * is this attribute required to have a value?
     * 
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * can this attribute have a null value?
     * 
     */
    public Boolean getNullable() {
        return nullable;
    }

    /**
     * can this attribute have a null value?
     * 
     */
    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    /**
     * is this attribute used as a key for retrieval?
     * 
     */
    public Boolean getPrivateKey() {
        return privateKey;
    }

    /**
     * is this attribute used as a key for retrieval?
     * 
     */
    public void setPrivateKey(Boolean privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * String attributes only, maximum length
     * 
     */
    public Long getMaxLength() {
        return maxLength;
    }

    /**
     * String attributes only, maximum length
     * 
     */
    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * default value for this attribute
     * 
     */
    public String getDefault() {
        return _default;
    }

    /**
     * default value for this attribute
     * 
     */
    public void setDefault(String _default) {
        this._default = _default;
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

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        STRING("string"),
        BIGSTRING("bigstring"),
        BLOB("blob"),
        INTEGER("integer"),
        BIGINTEGER("biginteger"),
        DOUBLE("double"),
        FLOAT("float"),
        DATE("date"),
        TIMESTAMP("timestamp");
        private final String value;
        private static Map<String, Attribute.Type> constants = new HashMap<String, Attribute.Type>();

        static {
            for (Attribute.Type c: Attribute.Type.values()) {
                constants.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static Attribute.Type fromValue(String value) {
            Attribute.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}