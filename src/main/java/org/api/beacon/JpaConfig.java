package org.api.beacon;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // Date 컬럼을 위한 설정
public class JpaConfig {    //Config 클래스 생성

}
