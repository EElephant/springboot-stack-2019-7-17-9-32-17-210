package com.tw.apistackbase;

import com.tw.apistackbase.repository.LawCaseRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ApiStackBaseApplicationTests {

	@Autowired
	LawCaseRepository lawCaseRepository;



}
