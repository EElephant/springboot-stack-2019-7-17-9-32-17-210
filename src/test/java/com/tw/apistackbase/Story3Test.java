package com.tw.apistackbase;

import com.tw.apistackbase.entity.CaseInfo;
import com.tw.apistackbase.entity.LawCase;
import com.tw.apistackbase.entity.Procurator;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.LawCaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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

    //Story3.1-AC2
    @Test
    public void should_return_specific_case_info_when_call_find_by_id_given_law_case_id_1(){
        Long time = Long.valueOf(20190717);
        Procuratorate procuratorate = new Procuratorate("yeshila");
        LawCase lawCase = new LawCase("Garson",time,procuratorate);
        lawCaseRepository.save(lawCase);
        Procuratorate procuratorate2 = lawCaseRepository.findById(lawCase.getId()).get().getProcuratorate();
        assertEquals(procuratorate2,procuratorate);
    }

    //Story3.1-AC4
    @Test
    public void should_add_case_info_description_to_law_case_when_call_find_all_1(){
        Long time1 = Long.valueOf(20190717);
        Long time2 = Long.valueOf(20190203);
        Procuratorate procuratorate1 = new Procuratorate("yeshila");
        Procuratorate procuratorate2 = new Procuratorate("caixukun");
        LawCase lawCase1 = new LawCase("Garson",time1,procuratorate1);
        LawCase lawCase2 = new LawCase("Caixukun",time2,procuratorate2);
        LawCase lawCase3 = new LawCase("Garson",time1,procuratorate1,"yeshila");
        LawCase lawCase4 = new LawCase("Caixukun",time2,procuratorate2,"caixukun");

        lawCaseRepository.save(lawCase1);
        lawCaseRepository.save(lawCase2);
        for(int i =0;i<lawCaseRepository.findAll().size();i++){
            LawCase lawCase = lawCaseRepository.findAll().get(i);
            lawCase.setProDescription(lawCase.getProcuratorate().getName());
        }

        assertThat(lawCase3.toString1(),is(lawCase1.toString1()));
        assertThat(lawCase4.toString1(),is(lawCase2.toString1()));
    }

    //Story3.2-AC2
    @Test
    public void should_return_specific_case_info_when_call_find_by_id_given_law_case_id_2(){
        Long time = Long.valueOf(20190717);
        Procurator procurator1 = new Procurator("liangfeifan");
        Procurator procurator2 = new Procurator("zhazhahui");
        List<Procurator> procuratorList = new ArrayList<>();

        procuratorList.add(procurator1);
        procuratorList.add(procurator2);
        Procuratorate procuratorate = new Procuratorate("yeshila",procuratorList);
        LawCase lawCase = new LawCase("Garson",time,procuratorate);
        lawCaseRepository.save(lawCase);
        Procuratorate procuratorate2 = lawCaseRepository.findById(lawCase.getId()).get().getProcuratorate();
        assertEquals(procuratorate2,procuratorate);
    }

    
}
