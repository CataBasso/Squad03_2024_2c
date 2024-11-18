package com.financeModule.CRUD.repository;

import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, String> {
}
