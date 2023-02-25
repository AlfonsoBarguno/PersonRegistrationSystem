package com.Bargunyo.PersonDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class PersonDbApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(PersonDbApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver(){

		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.getDefault());

		return slr;
	}

	/*
	* El método LocaleChangeINterceptor bUscará la presencia
	* de la palabra locale en la url (locale=EN) y luego la pasará
	* al LocaleResolver para que la almacene en una Session,
	* de modo que almacene la info de un request a otro
	*
	* */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){

		return new LocaleChangeInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}


}
