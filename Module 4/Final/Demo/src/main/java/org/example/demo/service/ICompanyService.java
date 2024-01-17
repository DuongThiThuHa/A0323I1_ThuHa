package org.example.demo.service;

import org.example.demo.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICompanyService extends IService< Company > {

    List< Company > findAllByName(String tenDoanhNghiep);

    Page< Company > findAllAndPaging(Pageable pageable);
}
