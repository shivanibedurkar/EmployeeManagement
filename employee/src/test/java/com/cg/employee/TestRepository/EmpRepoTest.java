package com.cg.employee.TestRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import com.cg.employee.entity.Employee;
import com.cg.employee.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class EmpRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setFirstName("Shivani");
        employee.setLastName("Bedurkar");
        employee.setSalary(100000);
        employee.setAge(20);
        employee.setDepartment("IT");
        employee.setEmail("shiva@gmail.com");
        employeeRepo.save(employee);
        assertNotNull(employee);

    }

    @Test
    public void testGetEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("shivani");
        employee.setLastName("Bedurkar");
        employee.setSalary(100000);
        employee.setAge(20);
        employee.setDepartment("IT");
        employee.setEmail("shiva@gmail.com");
        employeeRepo.save(employee);
        assertNotNull(employee);

        Employee t = employeeRepo.save(employee);

        assertNotNull(t);
        assertEquals(employee.getFirstName(), t.getFirstName());
        assertEquals(employee.getLastName(), t.getLastName());
        assertEquals(employee.getSalary(), t.getSalary());
        assertEquals(employee.getAge(), t.getAge());
        assertEquals(employee.getDepartment(), t.getDepartment());
        assertEquals(employee.getEmail(), t.getEmail());


    }

    @Test
    public void testDeleteEmployee() {

        Employee employee = new Employee();
        employee.setId(3);
        employee.setFirstName("shivani");
        employee.setLastName("Bedurkar");
        employee.setSalary(100000);
        employee.setAge(20);
        employee.setDepartment("IT");
        employee.setEmail("shiva@gmail.com");

        Employee t = employeeRepo.save(employee);

        employeeRepo.deleteById(t.getId());
        ;

        assertFalse(employeeRepo.existsById(1));

    }

    @Test
    public void testFindAllTrainers() {
        Employee employee = new Employee();
        employee.setId(3);
        employee.setFirstName("Shivani");
        employee.setLastName("Bedurkar");
        employee.setSalary(100000);
        employee.setAge(20);
        employee.setDepartment("IT");
        employee.setEmail("shivani@gmail.com");
        employeeRepo.save(employee);
        assertNotNull(employeeRepo.findAll());
    }

}