package hello.external;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CommandLineV1 {

    /**
     * command line 는 key=value 형식이 아님
     *
     * @param args
     */
    public static void main(String[] args) {

        for (String arg : args) {
            log.info("arg {}", arg);
        }
    }

}
