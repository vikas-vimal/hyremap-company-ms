package com.designfox.hyremapcompanyms.company.impl;

import com.designfox.hyremapcompanyms.company.Company;
import com.designfox.hyremapcompanyms.company.CompanyRepository;
import com.designfox.hyremapcompanyms.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Long id) {
        return this.companyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Company> findCompanyByIds(List<Long> ids) {
        return this.companyRepository.findAllById(ids);
    }

    @Override
    public boolean companyExistsById(Long id) {
        return this.companyRepository.existsById(id);
    }

    @Override
    public Company createCompany(Company newCompany) {
        newCompany.setId(null);
        return this.companyRepository.save(newCompany);
    }

    @Override
    public Company updateCompanyById(Long id, Company body) {
        Optional<Company> optionalCompany = this.companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setId(id);
            company.setName(body.getName());
            company.setDescription(body.getDescription());
            company.setEmployeeCount(body.getEmployeeCount());
            company.setLocation(body.getLocation());
            this.companyRepository.save(company);
            return company;
        }
        return null;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try{
            this.companyRepository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
