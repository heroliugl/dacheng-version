

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dacheng.entity.Version;
import com.dacheng.service.VersionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml" ,"classpath*:spring-mybatis.xml","classpath*:spring-application.xml"})
public class VersionTest {


    @Autowired
    private VersionService versionService;


    @Test
    public void testInsert() {
       try {
    	   Version version = new Version();
    	   version.setVname("Battery_Monitor_BM2_20161130_V0002_A");
    	   version.setPtype("bm2");
    	   version.setVtype("2");
    	   version.setVm((float) 2);
    	   version.setForceUpdate(false);
    	   version.setUrl("Battery_Monitor_BM2_20161103_V0002_A.bin");
    	   version.setStatus("0");
    	   version.setVflag("A");
    	   int n = versionService.saveVersion(version);
    	   System.out.println(n);
    	   System.out.println(version.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testDel() {
       try {
    	   int n = versionService.deleteVersionById(4L);
    	   System.out.println(n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    
    @Test
    public void testUpdate() {
       try {
    	   Version version = new Version();
    	   version.setId(5L);
    	   version.setVname("Battery_Monitor_BM2_20161130_V0002_V");
    	   version.setPtype("bm2");
    	   version.setVtype("2");
    	   version.setVm((float) 2);
    	   version.setForceUpdate(false);
    	   version.setUrl("Battery_Monitor_BM2_20161103_V0002_A.bin");
    	   version.setStatus("0");
    	   version.setVflag("A");
    	   int n = versionService.UpdateVersion(version);
    	   System.out.println(n);
    	   System.out.println(version.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testQuery() {
       try {
    	   Version version = versionService.findVersionById(1L);
    	   System.out.println(version.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }

   

}