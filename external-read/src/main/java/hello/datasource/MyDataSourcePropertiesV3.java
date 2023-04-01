package hello.datasource;

import java.time.Duration;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;


@Getter
@ConfigurationProperties("my.datasource")
@Validated // 반드시 추가해줘야 jakarta validator 가 적용됨
public class MyDataSourcePropertiesV3 {

    @NotEmpty
    private String url;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private Etc etc;

    // @DefaultValue 는 해당 properties 가 없는 경우 default 값이 들어간다.
    // @ConstructorBinding 은 생성자가 2개 이상일 경우 사용하고자하는 생성자에 사용하면 된다.
    public MyDataSourcePropertiesV3(String url, String username, String password, Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {

        @Min(1)
        @Max(999)
        private int maxConnection;

        @DurationMin(seconds = 1)
        @DurationMax(seconds = 60)
        private Duration timeout;

        private List<String> options;

        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }

}
