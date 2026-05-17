package com.grupo2.sistemamonitoramento;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Forçando o teste de contexto a usar propriedades falsas em memória, evitando que ele procure o MySQL local
@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password="
})

class SistemaMonitoramentoDemandasApplicationTests {

	@Test
	void contextLoads() {
	}

}
