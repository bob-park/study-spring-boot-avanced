package hello.datasource;

import java.time.Duration;
import java.util.List;

import jakarta.annotation.PostConstruct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class MyDataSource {

    private String url;
    private String username;
    private String password;
    private int maxConnection;
    private Duration timeout;
    private List<String> options;


    @PostConstruct
    public void init(){
        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);
        log.info("maxConnection={}", maxConnection);
        log.info("timeout={}", timeout);
        log.info("options={}", options);
    }


}
