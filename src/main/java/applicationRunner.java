import database.pool.ConnectionPool;
import database.repository.CompanyRepository;
import database.repository.CrudRepository;
import database.repository.UserRepository;
import ioc.Container;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.io.Serializable;

public class applicationRunner {
    public static void main(String[] args) {
        String value = "Hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        CompanyRepository companyRepository;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {

            ConnectionPool cp = context.getBean(ConnectionPool.class);

            System.out.println(cp);

            CrudRepository crudRepository = context.getBean("companyRepository", CrudRepository.class);

            System.out.println(crudRepository.getByID(1));
        }
    }
}
