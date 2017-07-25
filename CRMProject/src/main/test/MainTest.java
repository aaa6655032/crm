import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/9/23.
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println("Test start.");
        ApplicationContext context = new ClassPathXmlApplicationContext("application-quartz.xml");
        //如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
        //context.getBean("startQuertz");
        System.out.print("Test end..");
    }
}
