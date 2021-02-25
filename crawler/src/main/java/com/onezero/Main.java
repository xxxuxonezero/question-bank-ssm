package com.onezero;

import com.onezero.crawler.NowCoderCrawler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        NowCoderCrawler bean = ac.getBean(NowCoderCrawler.class);
        Map<String, Object> map = new HashMap<>();
        map.put("url", "https://m.nowcoder.com/kaoyan?fm=ios_app_3.0.0&client=4&t=33E1579758B1F6E88BDF7D7856C6CA6D");

//        System.setProperty("webdriver.chrome.driver", "D:\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://www.nowcoder.com/kaoyan");
//        JavascriptExecutor JS = driver;
//        try {
//            JS.executeScript("$('#areaSection a:eq(2)').click()");
//            String sou = driver.getPageSource();
//            System.out.println(sou);
//        } catch (Exception e) {
//
//        }
        bean.execute(map);
    }
}
