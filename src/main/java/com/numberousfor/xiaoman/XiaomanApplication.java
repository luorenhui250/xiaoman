package com.numberousfor.xiaoman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cuddly
 */
@SpringBootApplication
@MapperScan("com.numberousfor.xiaoman.dao")
public class XiaomanApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaomanApplication.class, args);
    }

}
