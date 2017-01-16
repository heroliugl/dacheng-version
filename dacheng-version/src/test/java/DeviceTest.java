

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dacheng.entity.Device;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.DeviceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml" ,"classpath*:spring-mybatis.xml","classpath*:spring-application.xml"})
public class DeviceTest {


    @Autowired
    private DeviceService deviceService;
    
  
    @Test
    public void testFindDeviceById() {
       try {
    	  //  11a57a16b585059d
    	   Device device = deviceService.findDeviceById("1C:BA:8C:1F:3C:24");
    	   System.out.println("testFindDeviceById : "+device.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindDeviceList() {
       try {
    	   List<Device> list = deviceService.findDeviceList(null);
    	   System.out.println("testFindDeviceList : "+list.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testPageQuery() {
       try {
    	   PageView<Device> pageView = deviceService.findPage(1,11,null);
    	   System.out.println(pageView.toString());
    	   System.out.println("==============================================");
    	   System.out.println("pageView.getRecords()"+pageView.getRecords().size());
    	   for(Device v : pageView.getRecords()){
    		   System.out.println(v.toString());
    	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }

}