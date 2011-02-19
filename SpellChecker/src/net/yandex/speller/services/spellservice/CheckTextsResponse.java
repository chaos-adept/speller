/**
 * CheckTextsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.yandex.speller.services.spellservice;

public class CheckTextsResponse  implements java.io.Serializable {
    private net.yandex.speller.services.spellservice.SpellError[][] arrayOfSpellResult;

    public CheckTextsResponse() {
    }

    public CheckTextsResponse(
           net.yandex.speller.services.spellservice.SpellError[][] arrayOfSpellResult) {
           this.arrayOfSpellResult = arrayOfSpellResult;
    }


    /**
     * Gets the arrayOfSpellResult value for this CheckTextsResponse.
     * 
     * @return arrayOfSpellResult
     */
    public net.yandex.speller.services.spellservice.SpellError[][] getArrayOfSpellResult() {
        return arrayOfSpellResult;
    }


    /**
     * Sets the arrayOfSpellResult value for this CheckTextsResponse.
     * 
     * @param arrayOfSpellResult
     */
    public void setArrayOfSpellResult(net.yandex.speller.services.spellservice.SpellError[][] arrayOfSpellResult) {
        this.arrayOfSpellResult = arrayOfSpellResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckTextsResponse)) return false;
        CheckTextsResponse other = (CheckTextsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayOfSpellResult==null && other.getArrayOfSpellResult()==null) || 
             (this.arrayOfSpellResult!=null &&
              java.util.Arrays.equals(this.arrayOfSpellResult, other.getArrayOfSpellResult())));
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
        if (getArrayOfSpellResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfSpellResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfSpellResult(), i);
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
        new org.apache.axis.description.TypeDesc(CheckTextsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", ">CheckTextsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfSpellResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "ArrayOfSpellResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "SpellResult"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "SpellResult"));
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
