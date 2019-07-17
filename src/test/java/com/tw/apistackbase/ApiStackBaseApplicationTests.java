package com.tw.apistackbase;

import com.tw.apistackbase.entity.LawCase;
import com.tw.apistackbase.repository.LawCaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ApiStackBaseApplicationTests {

	@Autowired
	LawCaseRepository lawCaseRepository;

	//Story1-AC2
	@Test
	public void should_return_specific_case_when_call_find_by_id_given_specofic_id(){
		Long time = Long.valueOf(20190717);
		LawCase lawCase = new LawCase("Garson",time);
		lawCaseRepository.save(lawCase);
		LawCase lawCase2 = lawCaseRepository.findById(lawCase.getId()).get();
		assertEquals(lawCase2,lawCase);
	}

	//Story1-AC3
	@Test
	public void should_return_order_case_when_call_find_all(){
		Long time1 = Long.valueOf(20190717);
		Long time2 = Long.valueOf(20190716);
		LawCase lawCase1 = new LawCase("Garson",time1);
		LawCase lawCase2 = new LawCase("Jucy",time2);
		//降序，从近到远
		Sort sort = new Sort(Sort.Direction.DESC, "time");
		List<LawCase> lawCases2 = new ArrayList<>();

		lawCaseRepository.save(lawCase1);
		lawCaseRepository.save(lawCase2);
		List<LawCase> lawCases1 = lawCaseRepository.findAll(sort);
		lawCases2.add(lawCase1);
		lawCases2.add(lawCase2);


		assertEquals(lawCases2,lawCases1);
	}

}
