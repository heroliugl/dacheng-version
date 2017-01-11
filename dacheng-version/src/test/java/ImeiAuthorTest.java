

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dacheng.entity.ImeiAuthor;
import com.dacheng.entity.User;
import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.ImeiAuthorService;
import com.dacheng.service.UserService;
import com.dacheng.utils.MD5;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml" ,"classpath*:spring-mybatis.xml","classpath*:spring-application.xml"})
public class ImeiAuthorTest {


    @Autowired
    private ImeiAuthorService imeiAuthorService;
    
    @Test
    public void testSaveImeiAuthor() {
       try {
    	   ImeiAuthor imeiAuthor = new ImeiAuthor();
    	   imeiAuthor.setImei("867323023671108");
    	   imeiAuthor.setStatus("1");
    	   imeiAuthorService.saveImeiAuthor(imeiAuthor);
    	   System.out.println("imeiAuthor" + imeiAuthor.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindImeiAuthorByImei() {
       try {
    	  //  11a57a16b585059d
    	   ImeiAuthor imeiAuthor = imeiAuthorService.findImeiAuthorByImei("867323023671108");
    	   System.out.println("testFindImeiAuthorByImei : "+imeiAuthor.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    
    @Test
    public void testDeleteImeiAuthorByImei() {
       try {
    	   int num= imeiAuthorService.deleteImeiAuthorByImei("867323023671108");
    	   System.out.println("testDeleteImeiAuthorByImei : "+num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindImeiAuthorList() {
       try {
    	   List<ImeiAuthor> list = imeiAuthorService.findImeiAuthorList(null);
    	   System.out.println("testFindImeiAuthorList : "+list.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testPageQuery() {
       try {
    	   PageView<ImeiAuthor> pageView = imeiAuthorService.findPage(1,11,null);
    	   System.out.println(pageView.toString());
    	   System.out.println("==============================================");
    	   System.out.println("pageView.getRecords()"+pageView.getRecords().size());
    	   for(ImeiAuthor v : pageView.getRecords()){
    		   System.out.println(v.toString());
    	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }

}