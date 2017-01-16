

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dacheng.entity.Agency;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.AgencyService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml" ,"classpath*:spring-mybatis.xml","classpath*:spring-application.xml"})
public class AgencyTest {


    @Autowired
    private AgencyService agencyService;
    
  
    @Test
    public void testFindAgencyById() {
       try {
    	  //  11a57a16b585059d
    	   Agency agency = agencyService.findAgencyById(1L);
    	   System.out.println("testFindAgencyById : "+agency.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindAgencyList() {
       try {
    	   List<Agency> list = agencyService.findAgencyList(null);
    	   System.out.println("testFindAgencyList : "+list.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testPageQuery() {
       try {
    	   PageView<Agency> pageView = agencyService.findPage(1,11,null);
    	   System.out.println(pageView.toString());
    	   System.out.println("==============================================");
    	   System.out.println("pageView.getRecords()"+pageView.getRecords().size());
    	   for(Agency v : pageView.getRecords()){
    		   System.out.println(v.toString());
    	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }

}