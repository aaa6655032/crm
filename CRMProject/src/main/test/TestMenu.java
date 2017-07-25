import com._520it.crm.domain.Menu;
import com._520it.crm.mapper.MenuMapper;
import com._520it.crm.service.IRoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-mvc.xml")
public class TestMenu {

    @Autowired
    private MenuMapper mapper;
    


    @Autowired
    private IRoleService roleService;

    @Test
    public void testList() throws Exception {
        List<Menu> menus = mapper.selectRoot();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(menus);
        System.out.println("jsonValue = " + jsonValue);

    }

    @Test
    public void test() throws Exception {
//        List<Department> departments = deptMapper.selectRoot();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonValue = objectMapper.writeValueAsString(departments);
//        System.out.println("jsonValue = " + jsonValue);
    }
}
