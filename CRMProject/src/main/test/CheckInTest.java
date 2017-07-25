import com._520it.crm.domain.CheckIn;
import com._520it.crm.mapper.CheckInMapper;
import com._520it.crm.query.CheckInQueryObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-mvc.xml")
public class CheckInTest {

    @Autowired
    private CheckInMapper  dao;
    
    @Test
    public void testQueryByCondition() throws Exception {
    	CheckInQueryObject qo = new CheckInQueryObject();
    	
		 List<CheckIn> list =dao.queryByCondition(qo);
		
    	for (CheckIn checkIn : list) {
			System.out.println(checkIn);
		}
	}
    @Test
    public void testDate() throws Exception {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(date);  
		System.out.println(dateNowStr);
	}
  
    @Test
    public void testSave() throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CheckIn checkIn =  new CheckIn();
		Date date = new Date();
		String dateNowStr = sdf.format(date);
		System.out.println("当前时间:" +dateNowStr);
		checkIn.setSignintime(date);
		int a =  0 ;
    	List<CheckIn> queryByEid = dao.queryByEid(24L);
    	for (CheckIn checkIn2 : queryByEid) {
    		Date signintime = checkIn2.getSignintime();
    		String dateStr = sdf.format(signintime);
    		System.out.println("数据库时间:" +dateStr);
    		if (dateNowStr.equals(dateStr)) {
    			System.out.println("已经签到了"); 
    			a = 1 ;
    			break;
			}
		  }
    	if ( a == 0 ) {
    		dao.insert(checkIn);
		}
	}
    @Test
    public void testCompare() throws Exception {
    	Date date1 = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    	String dateNowStr = sdf.format(date1);
    	System.out.println(dateNowStr);
    	String s1 = "08";
    	int i =Integer.parseInt(s1);
    	System.out.println(i);
    	
    	
    	
    	 Calendar c = Calendar.getInstance();
    	 Date date = new Date();
         c.setTime(date);
         
         c.set(Calendar.HOUR_OF_DAY, 8);
         c.set(Calendar.MINUTE, 30);
         c.set(Calendar.SECOND, 0);
         System.out.println("date:" + date);
         System.out.println( "c:" +c.getTime());
         int compareTo = date.compareTo(c.getTime());
         //0 表示等于     -1 表示当前时间和比较的时间早      1表示当前时间和比较的时间晚
         System.out.println("compareTo:" + compareTo);
    }
    
    @Test
    public void testMethod() throws Exception {
    	
    	
	}
    
   
    
   
}