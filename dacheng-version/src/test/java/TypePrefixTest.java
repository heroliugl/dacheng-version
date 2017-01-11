

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dacheng.entity.TypePrefix;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.TypePrefixService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml" ,"classpath*:spring-mybatis.xml","classpath*:spring-application.xml"})
public class TypePrefixTest {


    @Autowired
    private TypePrefixService typePrefixService;
    
    
    @Test
    public void testCheckTypePrefixIsExist() {
       try {
    	   int num= typePrefixService.checkTypePrefixIsExist("PTS");
    	   System.out.println("testCheckTypePrefixIsExist num = "+num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testSaveTypePrefix() {
       try {
    	   TypePrefix typePrefix = new TypePrefix();
    	   typePrefix.setTypeId(9L);
    	   typePrefix.setTypePrefix("PTS");
    	   typePrefix.setStatus("1");
    	   typePrefixService.saveTypePrefix(typePrefix);
    	   System.out.println("testSaveTypePrefix" + typePrefix.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindTypePrefixByPrefix() {
       try {
    	  //  11a57a16b585059d
    	   TypePrefix typePrefix = typePrefixService.findTypePrefixByPrefix("PTS");
    	   System.out.println("testFindTypePrefixByPrefix : "+typePrefix.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    
    @Test
    public void testFindTypePrefixByTypeIdAndPrefix() {
       try {
    	   TypePrefix typePrefix = typePrefixService.findTypePrefixByTypeIdAndPrefix(9L, "PTS");
    	   System.out.println("testFindTypePrefixByTypeIdAndPrefix : "+typePrefix.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    
    @Test
    public void testDeleteTypePrefixById() {
       try {
    	   int num= typePrefixService.deleteTypePrefixByTypeId(9L);
    	   System.out.println("testDeleteTypePrefixById : "+num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindTypePrefixList() {
       try {
    	   List<TypePrefix> list = typePrefixService.findTypePrefixList(null);
    	   System.out.println("testFindTypePrefixList : "+list.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testPageQuery() {
       try {
    	   PageView<TypePrefix> pageView = typePrefixService.findPage(1,11,null);
    	   System.out.println(pageView.toString());
    	   System.out.println("==============================================");
    	   System.out.println("pageView.getRecords()"+pageView.getRecords().size());
    	   for(TypePrefix v : pageView.getRecords()){
    		   System.out.println(v.toString());
    	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }

}