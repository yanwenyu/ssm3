package com.duyi.common;

public class CustomerContextHolder {
    public static final String DATASOURCE_USERDATE= "userDate";
    public static final String DATASOURCE_USERMSG = "userMsg";

    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }

    public static String getCustomerType() {
        return contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
