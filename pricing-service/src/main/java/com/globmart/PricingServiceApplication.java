package com.globmart;

import com.globmart.domain.GlobMartPrice;
import com.globmart.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by subramanian_p on 30-06-2016.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableDiscoveryClient
public class PricingServiceApplication  implements CommandLineRunner {
	@Autowired
	PriceRepository priceRepository;
	public static void main(String[] args) {
		SpringApplication.run(PricingServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		priceRepository.save(new GlobMartPrice("$200","Galaxy"));
		priceRepository.save(new GlobMartPrice("$350","Nexus"));
		priceRepository.save(new GlobMartPrice("$500","iPhone6"));
		priceRepository.save(new GlobMartPrice("$150","MotoG"));
		priceRepository.save(new GlobMartPrice("$2500","MacBook Air"));
        priceRepository.save(new GlobMartPrice("$750","iPad"));
        priceRepository.save(new GlobMartPrice("$2000","Yoga"));
        priceRepository.save(new GlobMartPrice("$1500","ThinkPad"));
        priceRepository.save(new GlobMartPrice("$250","K3 Note"));
        priceRepository.save(new GlobMartPrice("$5000","Surface"));
	}
}


@Configuration
class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
	}
}

