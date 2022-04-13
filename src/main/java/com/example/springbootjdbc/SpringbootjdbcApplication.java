package com.example.springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class SpringbootjdbcApplication {
	
	// points to note  ( to work this application ,we need to create
	//  below table in the h2 database.
	// how to h2 console url is below
	//  http://localhost:8080/h2-console
	// examle referred from -- https://www.bezkoder.com/spring-boot-jdbctemplate-example-mysql/
	// Tutorial is not marked with @entity.. so create dabase table manually
	/* CREATE TABLE tutorials
		(
		    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		    title VARCHAR(255),
		    description VARCHAR(255),
		    published BOOLEAN
		); */
	/*  used H2 databse
	 *    -- no driver externally required.. only add dependency of h2 database.
	 */
	
	/* post json format
       {
		  "title":"title 2",
		  "description":"description 2"
		}  */
	
	/* very imp point -> @Service   annotation needs to be put on the Service Impl class
	 * not on the interface.. if we put on interface it gives error.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootjdbcApplication.class, args);
	}

}
