package hello.configure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV2;
import hello.datasource.MyDataSourcePropertiesV3;

@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(MyDataSourcePropertiesV3.class)
public class MyDataSourceConfigurationV3 {

    private final MyDataSourcePropertiesV3 properties;

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
