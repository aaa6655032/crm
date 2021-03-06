import com._520it.crm.service.IKnowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.KnowQueryObject;
import com._520it.crm.service.IKnowService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:application-mvc.xml")
public class KnowTest {
	@Autowired
	private IKnowService Service;
	
	@Test
	public void testname() throws Exception {
		
		Service.indexWriterReload();
	}
	
	@Test
	public void test1() throws Exception {
		KnowQueryObject qo = new  KnowQueryObject();
		qo.setKeyword("4G");
		PageResult querySearch = Service.querySearch(qo);
		System.out.println(querySearch.getRows());
	}
	
}
