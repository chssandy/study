package com.haifan.entity.enums;

public enum FTPTypeEnum
{
  MASTER("master", "主服务器"), 
  SERVANT("servant", "从服务器"), 
  SYNCD("sync", "已经与主服务器进行文件同步"), 
  UNSYNCD("unsync", "没有与主服务器文件进行同步"), 
  LOGIN_SUCCESS("login_success", "登陆Linux服务器成功"), 
  LOGIN_FAILRUE("login_failrue", "登陆Linux服务器失败"), 
  UNVERIFIED("unverified", "验证未通过"), 
  VERIFIED("verified", "验证通过");

  private String code;
  private String name;

  public String getCode()
  {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private FTPTypeEnum(String code, String name) {
    this.code = code;
    this.name = name;
  }
}