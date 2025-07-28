package com.foro.foro_hub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class ForoHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoHubApplication.class, args);
	}

	//Probar la conexión a la base de datos
	@Bean
	CommandLineRunner run(DataSource dataSource) {
		return args -> {
			try (Connection conn = dataSource.getConnection()) {
				System.out.println("\n✅ ¡Conexión a la base de datos exitosa!");
				System.out.println("\nURL: " + conn.getMetaData().getURL());
				System.out.println("Usuario: " + conn.getMetaData().getUserName());
			} catch (SQLException e) {
				System.out.println("\n❌ Error de conexión a la base de datos:");
				e.printStackTrace();
			}
		};
	}

}
