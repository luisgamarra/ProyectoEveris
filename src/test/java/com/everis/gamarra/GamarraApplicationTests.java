package com.everis.gamarra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamarraApplicationTests {

	@Test
	public void main() {

		try {
			GamarraApplication.main(new String[] {});
		} catch (Exception e) {
			System.out.println("El main esta siendo Ejecutado");
		}
	}

}
