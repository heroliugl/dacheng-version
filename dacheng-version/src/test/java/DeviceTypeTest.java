

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dacheng.entity.DeviceType;
import com.dacheng.entity.User;
import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.dacheng.service.DeviceTypeService;
import com.dacheng.service.UserService;
import com.dacheng.utils.MD5;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml" ,"classpath*:spring-mybatis.xml","classpath*:spring-application.xml"})
public class DeviceTypeTest {


    @Autowired
    private DeviceTypeService deviceTypeService;
    
    
    @Test
    public void testCheckDeviceTypeNameIsExist() {
       try {
    	   int num= deviceTypeService.checkDeviceTypeNameIsExist("OBD");
    	   System.out.println("num = "+num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testSaveDeviceType() {
       try {
    	   DeviceType deviceType = new DeviceType();
    	   deviceType.setTypeName("PTS");
    	   deviceType.setTypeCode(MD5.Md516("PTS20170111"));
    	   deviceType.setStatus("1");
    	   deviceTypeService.saveDeviceType(deviceType);
    	   System.out.println("deviceType" + deviceType.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindDeviceTypeById() {
       try {
    	  //  11a57a16b585059d
    	   DeviceType deviceType = deviceTypeService.findDeviceTypeById(11L);
    	   System.out.println("testFindDeviceTypeById : "+deviceType.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    
    @Test
    public void testFindDeviceTypeByTypeCode() {
       try {
    	   DeviceType deviceType = deviceTypeService.findDeviceTypeByTypeCode("11a57a16b585059d");
    	   System.out.println("testFindDeviceTypeByTypeCode : "+deviceType.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    
    @Test
    public void testDeleteDeviceTypeById() {
       try {
    	   int num= deviceTypeService.deleteDeviceTypeById(12L);
    	   System.out.println("testDeleteDeviceTypeById : "+num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testFindDeviceTypeList() {
       try {
    	   List<DeviceType> list = deviceTypeService.findDeviceTypeList(null);
    	   System.out.println("testFindDeviceTypeList : "+list.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }
    
    @Test
    public void testPageQuery() {
       try {
    	   PageView<DeviceType> pageView = deviceTypeService.findPage(1,11,null);
    	   System.out.println(pageView.toString());
    	   System.out.println("==============================================");
    	   System.out.println("pageView.getRecords()"+pageView.getRecords().size());
    	   for(DeviceType v : pageView.getRecords()){
    		   System.out.println(v.toString());
    	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // assertTrue(1==1);
    }

}