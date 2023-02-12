package database.repository;

import bpp.InjectBean;
import bpp.Transaction;
import database.entity.Company;
import database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;
@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init(){
        System.out.println("PC init method...");
    }

    @Override
    public Optional<Company> getByID(Integer id) {
        System.out.println("Find be ID method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void deleteEntity(Company entity) {
        System.out.println("Delete entity method...");
    }


}
