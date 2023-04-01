package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import hello.configure.MyDataSourceConfigurationV1;
import hello.configure.MyDataSourceConfigurationV2;
import hello.configure.MyDataSourceConfigurationV3;
import hello.configure.MyDataSourceEnvConfiguration;
import hello.configure.MyDataSourceValueConfiguration;

//@Import(MyDataSourceEnvConfiguration.class)
//@Import(MyDataSourceValueConfiguration.class)
//@Import(MyDataSourceConfigurationV1.class)
//@Import(MyDataSourceConfigurationV2.class)
@Import(MyDataSourceConfigurationV3.class)
@SpringBootApplication(scanBasePackages = "hello.datasource")
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
