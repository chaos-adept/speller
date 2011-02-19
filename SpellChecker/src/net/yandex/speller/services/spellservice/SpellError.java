/**
 * SpellError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.yandex.speller.services.spellservice;

public class SpellError  implements java.io.Serializable {
    private java.lang.String word;

    private java.lang.String[] s;

    private int code;  // attribute

    private int pos;  // attribute

    private int row;  // attribute

    private int col;  // attribute

    private int len;  // attribute

    public SpellError() {
    }

    public SpellError(
           java.lang.String word,
           java.lang.String[] s,
           int code,
           int pos,
           int row,
           int col,
           int len) {
           this.word = word;
           this.s = s;
           this.code = code;
           this.pos = pos;
           this.row = row;
           this.col = col;
           this.len = len;
    }


    /**
     * Gets the word value for this SpellError.
     * 
     * @return word
     */
    public java.lang.String getWord() {
        return word;
    }


    /**
     * Sets the word value for this SpellError.
     * 
     * @param word
     */
    public void setWord(java.lang.String word) {
        this.word = word;
    }


    /**
     * Gets the s value for this SpellError.
     * 
     * @return s
     */
    public java.lang.String[] getS() {
        return s;
    }


    /**
     * Sets the s value for this SpellError.
     * 
     * @param s
     */
    public void setS(java.lang.String[] s) {
        this.s = s;
    }

    public java.lang.String getS(int i) {
        return this.s[i];
    }

    public void setS(int i, java.lang.String _value) {
        this.s[i] = _value;
    }


    /**
     * Gets the code value for this SpellError.
     * 
     * @return code
     */
    public int getCode() {
        return code;
    }


    /**
     * Sets the code value for this SpellError.
     * 
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }


    /**
     * Gets the pos value for this SpellError.
     * 
     * @return pos
     */
    public int getPos() {
        return pos;
    }


    /**
     * Sets the pos value for this SpellError.
     * 
     * @param pos
     */
    public void setPos(int pos) {
        this.pos = pos;
    }


    /**
     * Gets the row value for this SpellError.
     * 
     * @return row
     */
    public int getRow() {
        return row;
    }


    /**
     * Sets the row value for this SpellError.
     * 
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }


    /**
     * Gets the col value for this SpellError.
     * 
     * @return col
     */
    public int getCol() {
        return col;
    }


    /**
     * Sets the col value for this SpellError.
     * 
     * @param col
     */
    public void setCol(int col) {
        this.col = col;
    }


    /**
     * Gets the len value for this SpellError.
     * 
     * @return len
     */
    public int getLen() {
        return len;
    }


    /**
     * Sets the len value for this SpellError.
     * 
     * @param len
     */
    public void setLen(int len) {
        this.len = len;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SpellError)) return false;
        SpellError other = (SpellError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.word==null && other.getWord()==null) || 
             (this.word!=null &&
              this.word.equals(other.getWord()))) &&
            ((this.s==null && other.getS()==null) || 
             (this.s!=null &&
              java.util.Arrays.equals(this.s, other.getS()))) &&
            this.code == other.getCode() &&
            this.pos == other.getPos() &&
            this.row == other.getRow() &&
            this.col == other.getCol() &&
            this.len == other.getLen();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getWord() != null) {
            _hashCode += getWord().hashCode();
        }
        if (getS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCode();
        _hashCode += getPos();
        _hashCode += getRow();
        _hashCode += getCol();
        _hashCode += getLen();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SpellError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "SpellError"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pos");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pos"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("row");
        attrField.setXmlName(new javax.xml.namespace.QName("", "row"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("col");
        attrField.setXmlName(new javax.xml.namespace.QName("", "col"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("len");
        attrField.setXmlName(new javax.xml.namespace.QName("", "len"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("word");
        elemField.setXmlName(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "word"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s");
        elemField.setXmlName(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
