package com.tw.apistackbase;

import com.tw.apistackbase.entity.CaseInfo;
import com.tw.apistackbase.entity.LawCase;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.LawCaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class Story3Test {

    @Autowired
    LawCaseRepository lawCaseRepository;

    //Story3-AC2
    @Test
    public void should_return_specific_case_info_when_call_find_by_id_given_law_case_id(){
        Long time = Long.valueOf(20190717);
        Procuratorate procuratorate = new Procuratorate("yeshila");
        LawCase lawCase = new LawCase("Garson",time,procuratorate);
        lawCaseRepository.save(lawCase);
        Procuratorate procuratorate2 = lawCaseRepository.findById(lawCase.getId()).get().getProcuratorate();
        assertEquals(procuratorate2,procuratorate);
    }

    
}
