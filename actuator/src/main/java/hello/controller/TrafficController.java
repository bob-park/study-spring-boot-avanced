package hello.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TrafficController {

    private List<String> list = new ArrayList<>();

    private final DataSource dataSource;

    @GetMapping(path = "cpu")
    public String cpu() {

        log.info("cpu");

        long value = 0;
        for (long i = 0; i < 1000000000000L; i++) {
            value++;
        }

        return "ok value=" + value;
    }

    @GetMapping(path = "jvm")
    public String jvm() {
        log.info("jvm");

        for (int i = 0; i < 1000000; i++) {
            list.add("hello jvm!" + i);
        }

        return "hello list " + list.size();
    }

    @GetMapping(path = "jdbc")
    public String jdbc() throws SQLException {
        log.info("jdbc");

        Connection conn = dataSource.getConnection();
        log.info("connection info={}", conn);
        // conn.close();

        return "ok";
    }

    @GetMapping(path = "error-log")
    public String errorLog() {
        log.error("error log");
        return "error";
    }
}
