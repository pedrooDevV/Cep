package br.com.pedro.Cep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.CepService;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class CepApplication  {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CepApplication.class, args);
        Scanner scanner = new Scanner(System.in);

        CepService cepService = new CepService();

        System.out.println("Digite Seu Cep");
        var cep = scanner.nextLine();
        System.out.println(cepService.getCep(cep));


	}

}
