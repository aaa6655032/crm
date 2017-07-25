import com._520it.crm.domain.Department;
import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.service.ICustomerService;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.service.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-mvc.xml")
public class EmployeeServiceImplTest {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;


    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRoleService roleService;

    @Test
    public void deleteByPrimaryKey() throws Exception {


    }

    @Test
    public void insert() throws Exception {
        Employee e = new Employee();
        e.setUsername("dengyw");
        e.setAdmin(true);
        e.setPassword("1");
        e.setEmail("feilong@163.com");
        e.setRealname("飞龙");
//        employeeService.save(e);
        employeeMapper.insert(e);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void selectAll() throws Exception {
        List<Employee> employees = employeeService.listAll();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
            Department dept = employee.getDept();
            System.out.println("dept = " + dept);
        }


    }


    @Test
    public void updateByPrimaryKey() throws Exception {
        List<Role> roles = roleService.selectByEid(2L);
        for (Role role : roles) {
            if(role.getName().equals("营销主管")){
                PageResult result = customerService.listAll();
                System.out.println("result = " + result.getRows());

            }
        }
    }
    
    @Test
    public void testname() throws Exception {
    	UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID);
	}

}