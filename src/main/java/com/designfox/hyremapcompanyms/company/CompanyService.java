package com.designfox.hyremapcompanyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company findCompanyById(Long id);
    List<Company> findCompanyByIds(List<Long> ids);
    Company createCompany(Company newCompany);
    Company updateCompanyById(Long id, Company body);
    boolean deleteCompanyById(Long id);
    boolean companyExistsById(Long id);
}
