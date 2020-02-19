package com.connectall.webinar.adapter.universal.webinartest;

public class EnvironmentVariableCase {

    private static final String JAVA_HOME_VARIABLE_NAME = "JAVA_HOME";
    private static final String MULE_HOME_VARIABLE_NAME = "MULE_HOME";
    private static final String CONNECTALL_HOME_VARIABLE_NAME = "CONNECTALL_HOME123";
    
    public static void main(String[] aa) {
        System.out.println("JAVA Home is : "+System.getenv(JAVA_HOME_VARIABLE_NAME));
        
        System.out.println("Mule Home is : "+System.getenv(MULE_HOME_VARIABLE_NAME));
        
        System.out.println("Connect Home 2 is : "+System.getenv(CONNECTALL_HOME_VARIABLE_NAME));

    }
}
