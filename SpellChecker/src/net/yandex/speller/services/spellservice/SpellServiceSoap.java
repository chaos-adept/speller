/**
 * SpellServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.yandex.speller.services.spellservice;

public interface SpellServiceSoap extends java.rmi.Remote {
    public net.yandex.speller.services.spellservice.CheckTextResponse checkText(net.yandex.speller.services.spellservice.CheckTextRequest parameters) throws java.rmi.RemoteException;
    public net.yandex.speller.services.spellservice.CheckTextsResponse checkTexts(java.lang.String[] parameters) throws java.rmi.RemoteException;
}
