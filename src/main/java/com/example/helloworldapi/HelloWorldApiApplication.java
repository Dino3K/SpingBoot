package com.example.helloworldapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@RestController
public class HelloWorldApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApiApplication.class, args);
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/connect")
	public String connect() {
		String url = "jdbc:mysql://azure-mysqlxd.mysql.database.azure.com:3306/consecionario";
		String usuario = "consumidor";
		String contraseña = "nose1234*";

		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			if (conexion != null) {
				conexion.close();
				return "Conexión establecida con éxito";
			}
		} catch (SQLException e) {
			return "Error al conectar: " + e.getMessage();
		}
		return "Error desconocido";
	}
}
