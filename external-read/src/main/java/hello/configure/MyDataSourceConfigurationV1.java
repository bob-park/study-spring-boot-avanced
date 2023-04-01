package hello.configure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;

@Slf4j
@RequiredArgsConstructor
//@EnableConfigurationProperties(MyDataSourcePropertiesV1.class)
@ConfigurationPropertiesScan("hello.datasource")
public class MyDataSourceConfigurationV1 {

    private final MyDataSourcePropertiesV1 properties;

    @Bean
    public MyDataSource myDataSource() {
        return new MyDataSource(
            properties.getUrl(),
            properties.getUsername(),
            properties.getPassword(),
            properties.getEtc().getMaxConnection(),
            properties.getEtc().getTimeout(),
            properties.getEtc().getOptions());
    }

}
