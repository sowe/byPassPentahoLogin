package com.pentaho.customFilter.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
/**
 * 
 * @author sowe
 * @version 1
 * Data Access Object for configuration file
 *
 */
public class DaoConfiguration {
    
	
  private String username = null;
  private String token = null;
  private Boolean type = null;
  private String tokenMD5 = null;
  private String password = null;
  private HashMap<String, String> dst = null;
    
  public String getTokenMD5() {
    return tokenMD5;
  }
    
  public void setTokenMD5(String tokenMD5) {
    MessageDigest md;
    StringBuffer sb = new StringBuffer();
    try {
      md = MessageDigest.getInstance("MD5");
      md.update(tokenMD5.getBytes());
      byte byteData[] = md.digest();
        //convert the byte to hex format method 1
      for (int i = 0; i < byteData.length; i++) {
        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
      }
      System.out.println("Digest(in hex format) ["+tokenMD5+"]:: " + sb.toString());
    } catch (NoSuchAlgorithmException e) {
    }
        
    this.tokenMD5 = sb.toString();
  }
    
    
  public String getUsername() {
    return username;
  }
    
  public void setUsername(String username) {
    this.username = username;
  }
    
  public String getToken() {
    return token;
  }
    
  public void setToken(String token) {
    this.token = token;
  }
    
  public String getPassword() {
    return password;
  }
    
  public void setPassword(String password) {
    this.password = password;
  }
    
  public HashMap<String, String> getDst() {
    return dst;
  }
    
    
  public void setDst(HashMap<String, String> dst) {
    this.dst = dst;
  }
    
  public Boolean getType() {
    return type;
  }
  
  public void setType(Boolean type) {
    this.type = type;
  }
}