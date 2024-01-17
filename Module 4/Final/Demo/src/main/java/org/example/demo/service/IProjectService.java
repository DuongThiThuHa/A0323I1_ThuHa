package org.example.demo.service;

import org.example.demo.model.Company;
import org.example.demo.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProjectService extends IService< Project > {
    List< Project > findAllByName(String project_name);
    Page< Project > findAllAndPaging(Pageable pageable);
}
