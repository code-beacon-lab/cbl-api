package org.api.beacon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Date 컬럼을 위한 설정
@SpringBootApplication
public class BeaconApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconApplication.class, args);
    }

}
