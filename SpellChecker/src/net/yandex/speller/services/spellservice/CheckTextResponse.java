/**
 * CheckTextResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.yandex.speller.services.spellservice;

public class CheckTextResponse  implements java.io.Serializable {
    private net.yandex.speller.services.spellservice.SpellError[] spellResult;

    public CheckTextResponse() {
    }

    public CheckTextResponse(
           net.yandex.speller.services.spellservice.SpellError[] spellResult) {
           this.spellResult = spellResult;
    }


    /**
     * Gets the spellResult value for this CheckTextResponse.
     * 
     * @return spellResult
     */
    public net.yandex.speller.services.spellservice.SpellError[] getSpellResult() {
        return spellResult;
    }


    /**
     * Sets the spellResult value for this CheckTextResponse.
     * 
     * @param spellResult
     */
    public void setSpellResult(net.yandex.speller.services.spellservice.SpellError[] spellResult) {
        this.spellResult = spellResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckTextResponse)) return false;
        CheckTextResponse other = (CheckTextResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.spellResult==null && other.getSpellResult()==null) || 
             (this.spellResult!=null &&
              java.util.Arrays.equals(this.spellResult, other.getSpellResult())));
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
        if (getSpellResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSpellResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSpellResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckTextResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", ">CheckTextResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spellResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "SpellResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "SpellError"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "error"));
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
