package com.wicket.spi;

import java.util.ServiceLoader;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SpiTest
 * @description TODO
 * @date 2021/7/1 14:46
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<UserService> serviceLoader = ServiceLoader.load(UserService.class);
        for(UserService userService : serviceLoader){
            userService.login();
        }
    }
}
