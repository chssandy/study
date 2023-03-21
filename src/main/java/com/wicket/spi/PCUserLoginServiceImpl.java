package com.wicket.spi;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname PCUserServiceImpl
 * @description TODO
 * @date 2021/7/1 14:38
 */
public class PCUserLoginServiceImpl implements UserService{
    @Override
    public void login() {
        System.out.println("PC user login");
    }
}
