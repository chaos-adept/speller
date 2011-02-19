package net.yandex.speller.services.spellservice;

public class SpellServiceSoapProxy implements net.yandex.speller.services.spellservice.SpellServiceSoap {
  private String _endpoint = null;
  private net.yandex.speller.services.spellservice.SpellServiceSoap spellServiceSoap = null;
  
  public SpellServiceSoapProxy() {
    _initSpellServiceSoapProxy();
  }
  
  public SpellServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSpellServiceSoapProxy();
  }
  
  private void _initSpellServiceSoapProxy() {
    try {
      spellServiceSoap = (new net.yandex.speller.services.spellservice.SpellServiceLocator()).getSpellServiceSoap();
      if (spellServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)spellServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)spellServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (spellServiceSoap != null)
      ((javax.xml.rpc.Stub)spellServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.yandex.speller.services.spellservice.SpellServiceSoap getSpellServiceSoap() {
    if (spellServiceSoap == null)
      _initSpellServiceSoapProxy();
    return spellServiceSoap;
  }
  
  public net.yandex.speller.services.spellservice.CheckTextResponse checkText(net.yandex.speller.services.spellservice.CheckTextRequest parameters) throws java.rmi.RemoteException{
    if (spellServiceSoap == null)
      _initSpellServiceSoapProxy();
    return spellServiceSoap.checkText(parameters);
  }
  
  public net.yandex.speller.services.spellservice.CheckTextsResponse checkTexts(java.lang.String[] parameters) throws java.rmi.RemoteException{
    if (spellServiceSoap == null)
      _initSpellServiceSoapProxy();
    return spellServiceSoap.checkTexts(parameters);
  }
  
  
}