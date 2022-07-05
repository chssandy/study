package com.haifan.entity.sys.ftp;

import com.jcraft.jsch.Session;

public class LoginLinuxResultEntity
{
  private String result;
  private Session session;
  private String errorMsg;

  public String getResult()
  {
    return this.result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Session getSession() {
    return this.session;
  }

  public void setSession(Session session) {
    this.session = session;
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
}