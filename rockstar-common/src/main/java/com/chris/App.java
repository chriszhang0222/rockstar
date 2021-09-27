package com.chris;


import org.jdbi.v3.core.Jdbi;

public class App {
    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:postgresql://192.168.2.19:5432/rockstar?autoReconnect=true&useSSL=false}", "postgres", "31415926");
        jdbi.withHandle(h -> {
           Integer c = h.createQuery("select count(*) from rockstar.test")
                   .mapTo(Integer.class)
                   .first();
            System.out.println(c);
            return null;
        });
    }
}
