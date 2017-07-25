import com._520it.crm.domain.Clew;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClewQueryObject;
import com._520it.crm.service.IClewService;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * Created by Administrator on 2016/9/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-mvc.xml")
public class TestLucene {

    @Autowired
    private IClewService clewService;

    @Test
    public void testWrite() throws Exception {

        clewService.luceneWriteIndex();
    }


    @Test
    public void testList() throws Exception {
        PageResult result = clewService.querybyLuceneAll("*:*");
        //PageResult result = clewService.listAll();
        for (Object o : result.getRows()) {
            Clew c = (Clew) o;
            System.out.println("c = " + c);
        }

    }


    @Test
    public void name() throws Exception {
        ClewQueryObject qo = new ClewQueryObject();
        qo.setKeyword("百度");
        PageResult result = clewService.querybyLuceneCondition(qo);
        System.out.println("result.getRows() = " + result.getRows());
    }


    @Test
    public void test() throws Exception {

        Directory directory = FSDirectory.open(new File("D:/lucene/data2"));
        // 2:创建索引读取对象
        IndexReader r = DirectoryReader.open(directory);
        r.numDeletedDocs();
        r.close();

    }
}
