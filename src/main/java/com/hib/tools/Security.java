package com.hib.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Created by Håvard on 11/15/2016.
 */
public class Security {

    public static String encrypt(String password) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        return bCrypt.encode(password);
    }

    public static boolean matches(String password, String encrypted) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        return bCrypt.matches(password, encrypted);
    }

}
