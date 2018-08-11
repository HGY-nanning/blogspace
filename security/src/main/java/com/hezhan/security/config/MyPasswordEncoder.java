package com.hezhan.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Create by 何光义 on 2018/08/11 00:18
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
