package com.haifan.util;

import com.haifan.entity.enums.FTPTypeEnum;
import com.haifan.entity.sys.ftp.LoginLinuxResultEntity;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinuxUtils
{
  private static final Logger logger = LoggerFactory.getLogger(LinuxUtils.class);

  public static LoginLinuxResultEntity login(String host, String userName, String password)
  {
    JSch jsch = new JSch();
    Session session = null;
    LoginLinuxResultEntity resultEntity = new LoginLinuxResultEntity();
    try {
      session = jsch.getSession(userName, host);
      Properties sshConfig = new Properties();
      sshConfig.put("StrictHostKeyChecking", "no");
      session.setConfig(sshConfig);
      session.setPassword(password);
      session.connect(3000);
      resultEntity.setSession(session);
      resultEntity.setResult(FTPTypeEnum.LOGIN_SUCCESS.getCode());
    }
    catch (JSchException e) {
      logger.error("验证文件服务器账户出错:", e);
      resultEntity.setResult(FTPTypeEnum.LOGIN_FAILRUE.getCode());
      resultEntity.setErrorMsg(e.getMessage());
    } catch (Exception e) {
      logger.error("验证文件服务器账户时出现未知错误:", e);
      resultEntity.setResult(FTPTypeEnum.LOGIN_FAILRUE.getCode());
      resultEntity.setErrorMsg(e.getMessage());
    }
    return resultEntity;
  }

  public static Boolean isLoginSuccess(String host, String userName, String password)
  {
    LoginLinuxResultEntity result = login(host, userName, password);
    Session session = null;
    try {
      if (FTPTypeEnum.LOGIN_SUCCESS.getCode().equals(result.getResult())) {
        session = result.getSession();
        if (null != session) {
          logger.info("连接成功,正在验证.....");
          return Boolean.valueOf(session.isConnected());
        }
      }

      logger.info("finnally.");
      if (null != session) {
        session.disconnect();
        logger.info("已成功关闭连接!");
      }
    }
    finally
    {
      logger.info("finnally.");
      if (null != session) {
        session.disconnect();
        logger.info("已成功关闭连接!");
      }
    }
    return Boolean.valueOf(false);
  }

  public static void check() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime expire = LocalDateTime.of(2021, 6, 9, 23, 59);
    Duration duration = Duration.between(now, expire);
    long days = duration.toDays();
    if (days > 0L) {
      days -= 1L;
    }
    logger.info("可用时间还剩{}天", Long.valueOf(days));
//    if (days == 0L)
      //System.exit(0);
  }
}