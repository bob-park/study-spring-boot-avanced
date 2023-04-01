package hello.datasource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;


@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {

    private String url;
    private String username;
    private String password;

    private Etc etc;

    // @DefaultValue 는 해당 properties 가 없는 경우 default 값이 들어간다.
    // @ConstructorBinding 은 생성자가 2개 이상일 경우 사용하고자하는 생성자에 사용하면 된다.
    public MyDataSourcePropertiesV2(String url, String username, String password, @DefaultValue Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {

        private int maxConnection;
        private Duration timeout;
        private List<String> options;

        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }

}
