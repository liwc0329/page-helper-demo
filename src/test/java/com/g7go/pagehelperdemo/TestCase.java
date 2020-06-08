package com.g7go.pagehelperdemo;

import com.g7go.pagehelperdemo.demo.domain.Persons;
import com.g7go.pagehelperdemo.demo.service.PersonsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Mr_Lee
 * @date 2020-06-08 15:05
 */
@SpringBootTest
public class TestCase {

    @Autowired
    private PersonsService personsService;

    @Test
    void test(){
        List<Persons> all = personsService.findAll();
        System.out.println(all);
    }

}
