package com.mycompany.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.myapp.domain.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
