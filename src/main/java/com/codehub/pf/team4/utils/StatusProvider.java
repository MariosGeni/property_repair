package com.codehub.pf.team4.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class StatusProvider {

    public static boolean isLoggedIn(){
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return user.equals("anonymousUser")? false : true;
    }

    public static String getLoggedInEmail(){
        return isLoggedIn()? SecurityContextHolder.getContext().getAuthentication().getName() : "";
    }
}
