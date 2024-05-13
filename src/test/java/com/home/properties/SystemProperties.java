package com.home.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemProperties {

    @Test
    void systenPropertyTest() {

        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void systenPropertyTest1() {

        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("one_property")
    void systenPropertyTest2() {

        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }
        // gradle clean one_test
        // gradle clean one_test -Dbrowser=opera // передача параметров(опера) из вне  в наш код
    @Test
    @Tag("hello_test")
    void systenPropertyTest3() {
        System.out.println("Hello," + System.getProperty("user_name", "unknown_student"));
    }
    /*
    gradle clean hello_test
    gradle clean hello_test -Duser_name=Alex        //передача параметров(Alex) из вне  в наш код
    gradle clean hello_test -Duser_name="Alex Egorov"
    gradle clean hello_test "-Duser_name=Alex Egorov"
    gradle clean twice_test                         // запускаем два теста
    gradle clean remote_test "-Dbrowser_url=https://user1:1234@selenoid.autotests.cloud/wd/hub"
    gradle clean remote_test "-Dbrowser_type=opera"



     */

}
