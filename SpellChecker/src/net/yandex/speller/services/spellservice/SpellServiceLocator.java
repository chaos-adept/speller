/**
 * SpellServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.yandex.speller.services.spellservice;

public class SpellServiceLocator extends org.apache.axis.client.Service implements net.yandex.speller.services.spellservice.SpellService {

    public SpellServiceLocator() {
    }


    public SpellServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SpellServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SpellServiceSoap
    private java.lang.String SpellServiceSoap_address = "http://speller.yandex.net/services/spellservice";

    public java.lang.String getSpellServiceSoapAddress() {
        return SpellServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SpellServiceSoapWSDDServiceName = "SpellServiceSoap";

    public java.lang.String getSpellServiceSoapWSDDServiceName() {
        return SpellServiceSoapWSDDServiceName;
    }

    public void setSpellServiceSoapWSDDServiceName(java.lang.String name) {
        SpellServiceSoapWSDDServiceName = name;
    }

    public net.yandex.speller.services.spellservice.SpellServiceSoap getSpellServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SpellServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSpellServiceSoap(endpoint);
    }

    public net.yandex.speller.services.spellservice.SpellServiceSoap getSpellServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.yandex.speller.services.spellservice.SpellServiceSoapStub _stub = new net.yandex.speller.services.spellservice.SpellServiceSoapStub(portAddress, this);
            _stub.setPortName(getSpellServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSpellServiceSoapEndpointAddress(java.lang.String address) {
        SpellServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.yandex.speller.services.spellservice.SpellServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                net.yandex.speller.services.spellservice.SpellServiceSoapStub _stub = new net.yandex.speller.services.spellservice.SpellServiceSoapStub(new java.net.URL(SpellServiceSoap_address), this);
                _stub.setPortName(getSpellServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SpellServiceSoap".equals(inputPortName)) {
            return getSpellServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "SpellService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://speller.yandex.net/services/spellservice", "SpellServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SpellServiceSoap".equals(portName)) {
            setSpellServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
