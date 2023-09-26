package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.converter.TestConverter;
import com.mycompany.myapp.domain.Test;
import com.mycompany.myapp.repository.TestRepository;
import com.mycompany.myapp.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestConverter testConverter;
    private final TestRepository testRepository;

    @Transactional
    @Override
    public Test create(String name){
        Test test = testConverter.toTest(name);
        return testRepository.save(test);
    }
}
