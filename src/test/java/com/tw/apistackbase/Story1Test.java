package com.tw.apistackbase;

import com.tw.apistackbase.entity.CaseInfo;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class Story1Test {
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

    //Story1-AC4
    @Test
    public void should_return_specific_case_when_call_find_by_name_given_specofic_name(){
        Long time1 = Long.valueOf(20190717);
        Long time2 = Long.valueOf(20190622);
        LawCase lawCase1 = new LawCase("Garson",time1);
        LawCase lawCase2 = new LawCase("Garson",time2);
        LawCase lawCase3 = new LawCase("Jucy",time2);

        lawCaseRepository.save(lawCase1);
        lawCaseRepository.save(lawCase2);
        lawCaseRepository.save(lawCase3);
        List<LawCase> lawCases1 = lawCaseRepository.findByName("Garson");
        List<LawCase> lawCases2 = new ArrayList<>();
        lawCases2.add(lawCase1);
        lawCases2.add(lawCase2);

        assertEquals(lawCases2,lawCases1);
    }

    //Story1-AC5
    @Test
    public void should_delete_specific_case_when_call_delete_by_id_given_specific_id(){
        Long time1 = Long.valueOf(20190717);
        Long time2 = Long.valueOf(20190622);
        LawCase lawCase1 = new LawCase("Garson",time1);
        LawCase lawCase2 = new LawCase("Garson",time2);
        LawCase lawCase3 = new LawCase("Jucy",time2);

        lawCaseRepository.save(lawCase1);
        lawCaseRepository.save(lawCase2);
        lawCaseRepository.save(lawCase3);
        lawCaseRepository.delete(lawCase2);
        List<LawCase> lawCases1 = lawCaseRepository.findAll();
        List<LawCase> lawCases2 = new ArrayList<>();
        lawCases2.add(lawCase1);
        lawCases2.add(lawCase3);

        assertEquals(lawCases2,lawCases1);
    }
}
