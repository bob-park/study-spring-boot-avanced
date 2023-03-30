package hello.external;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class OsEnv {

    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv(); // system env 를 가져온다.

        for (String key : envMap.keySet()) {
            log.info("env {}={}", key, envMap.get(key));
        }

        // DBURL=dev.db.com - dev server
        // DBURL=prod.db.com - prod server
        String dburl = System.getenv("DBURL");

        log.info("dburl={}", dburl);

    }

}
