package com.techgurus.envioEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EnvioEmailApplication {

	@Autowired
	private JavaMailSender emailSender;
	public static void main(String[] args) {
		SpringApplication.run(EnvioEmailApplication.class, args);
	}

	@PostMapping("/enviarEmail")
	@CrossOrigin(origins = "*")
	public Boolean teste(@RequestBody String mensagem) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("<Email aqui>");
			message.setTo("<Senha aqui>");
			message.setSubject("Mensagem do site da ONG");
			message.setText(mensagem);
			emailSender.send(message);

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
			// TODO: handle exception
		}
	}
}
