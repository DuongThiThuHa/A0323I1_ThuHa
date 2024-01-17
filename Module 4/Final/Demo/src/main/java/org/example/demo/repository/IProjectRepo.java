package org.example.demo.repository;

import org.example.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepo extends JpaRepository< Project, Integer > {
}
