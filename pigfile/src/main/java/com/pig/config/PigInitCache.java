package com.pig.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PigInitCache implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if(args ==null || args.length== 0){
            CacheMapConf.localPath = "/usr/local";
        }else {
            CacheMapConf.localPath = args[0];
        }

    }
}
