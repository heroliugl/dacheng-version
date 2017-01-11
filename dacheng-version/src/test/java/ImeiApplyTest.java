

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dacheng.entity.ImeiApply;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.ImeiApplyService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml" ,"classpath*:spring-mybatis.xml","classpath*:spring-application.xml"})
public class ImeiApplyTest {


    @Autowired
    private ImeiApplyService imeiApplyService;
    

    @Test
    public void testFindImeiApplyByApplyId() {
       try {
    	  //  11a57a16b585059d
    	   ImeiApply imeiApply = imeiApplyService.findImeiApplyByApplyId("161219050316543543");
    	   System.out.println("testFindImeiApplyByApplyId : "+imeiApply.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    
    @Test
    public void testDeleteImeiApplyByApplyId() {
       try {
    	   int num= imeiApplyService.deleteImeiApplyByApplyId("161219050316543543");
    	   System.out.println("testDeleteImeiApplyByApplyId : "+num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testDeleteImeiApplyByImei() {
       try {
    	   int num= imeiApplyService.deleteImeiApplyByImei("864085022585604");
    	   System.out.println("testDeleteImeiApplyByImei : "+num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindImeiApplyList() {
       try {
    	   List<ImeiApply> list = imeiApplyService.findImeiApplyList(null);
    	   System.out.println("testFindImeiApplyList : "+list.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testPageQuery() {
       try {
    	   PageView<ImeiApply> pageView = imeiApplyService.findPage(2,2,null);
    	   System.out.println(pageView.toString());
    	   System.out.println("==============================================");
    	   System.out.println("pageView.getRecords()"+pageView.getRecords().size());
    	   for(ImeiApply v : pageView.getRecords()){
    		   System.out.println(v.toString());
    	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }

}