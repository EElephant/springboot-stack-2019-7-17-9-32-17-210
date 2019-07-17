package com.tw.apistackbase;

import com.tw.apistackbase.entity.CaseInfo;
import com.tw.apistackbase.entity.LawCase;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class Story2Test {
    @Autowired
    LawCaseRepository lawCaseRepository;

    //Story2-AC2
    @Test
    public void should_return_specific_case_info_when_call_find_by_id_given_law_case_id(){
        Long time = Long.valueOf(20190717);
        CaseInfo caseInfo = new CaseInfo("yeshila","liangfeifan");
        LawCase lawCase = new LawCase("Garson",time,caseInfo);
        lawCaseRepository.save(lawCase);
        CaseInfo caseInfo2 = lawCaseRepository.findById(lawCase.getId()).get().getCaseInfo();
        assertEquals(caseInfo2,caseInfo);
    }

    //Story2-AC4
    @Test
    public void should_add_case_info_description_to_law_case_when_call_find_all(){
        Long time1 = Long.valueOf(20190717);
        Long time2 = Long.valueOf(20190203);
        CaseInfo caseInfo1 = new CaseInfo("yeshila,","liangfeifan");
        CaseInfo caseInfo2 = new CaseInfo("caixukun,","jinitaimei");
        LawCase lawCase1 = new LawCase("Garson",time1,caseInfo1);
        LawCase lawCase2 = new LawCase("Caixukun",time2,caseInfo2);
        LawCase lawCase3 = new LawCase("Garson",time1,caseInfo1,"yeshila,liangfeifan");
        LawCase lawCase4 = new LawCase("Caixukun",time2,caseInfo2,"caixukun,jinitaimei");

        lawCaseRepository.save(lawCase1);
        lawCaseRepository.save(lawCase2);
        for(int i =0;i<lawCaseRepository.findAll().size();i++){
            LawCase lawCase = lawCaseRepository.findAll().get(i);
            lawCase.setDescription(lawCase.getCaseInfo().getObjectiveDescription().concat(lawCase.getCaseInfo().getSubjectiveDescription()));
        }
        List<LawCase> lawCases = lawCaseRepository.findAll();

        assertThat(lawCase3.toString(),is(lawCase1.toString()));
        assertThat(lawCase4.toString(),is(lawCase2.toString()));
    }
}
