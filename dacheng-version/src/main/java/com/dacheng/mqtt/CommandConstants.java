package com.dacheng.mqtt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Kai Wang on 16/8/12.
 * command code constants
 */
public class CommandConstants {
    //semm
    public static final int REGISTER =1;
    public static final int QUERY_DEVICE =2;
    public static final int DEVICE_ATTR_SET =3;
    public static final int RE_INTIALIZE=0x11;
    public static final int SEARCH_DEIVCE=0x12;
    public static final int LAMP_ATTR_QUERY=0x13;
    public static final int LAMP_ATTR_SET=0x14;
    public static final int LAMP_DETAIL_QUERY=0x20;
    public static final int LAMP_TEST_STATUS_QUERY=0x21;
    public static final int LAMP_LOCATION_SET=0x24;


    public static final int TIME_SETTING=0x15;
    public static final int GROUP_TIMING_TEST_SET=0xE7;

    //lamp
    public static final int LAMP_FUNC_TEST=0xE3;
    public static final int LAMP_DURATION_TEST=0xE4;
    public static final int LAMP_STOP_TEST=0xE5;
    public static final int LAMP_INHIBIT_MODE=0xE1;
    public static final int LAMP_REST_MODE=0xE0;
    public static final int LAMP_TERMINATE_INHIBIT_REST_MODE=0xE2;
    //menu
    public static final int A_B_LAMP =0x07;
    public static final int A_B_LAMP_ACTION_OFF= 0x10;
    public static final int A_B_LAMP_ACTION_ON= 0x11;
    public static final int A_B_LAMP_ACTION_FLASH_STOP= 0x20;
    public static final int A_B_LAMP_ACTION_FLASH_START= 0x21;
//    public static final int A_B_LAMP_OFF =0x07;
//    public static final int A_B_LAMP_ON =0x08;
//    public static final int A_B_LAMP_FLASH =0x09;
    public static final int ADD_NEW_LAMP =0x10;

    public static final int LAMP_INFO_REPORT =0x50;
    
    // others
    public static final int VERSION_QUERY =0x04;


    public static final int RESULT_SUCCESS =0;
    public static final int RESULT_FAILED =1;
    public static final int SEARCHING_RESULT =1;
    public static final int MSG_DIR_REQUEST =0;
    public static final int MSG_DIR_RESPONSE =1;

    public static final int MSG_OBJ_LAMP=0;
    public static final int MSG_OBJ_SEMM=1;

    public static final int MSG_TYPE_REG=0;
    public static final int MSG_TYPE_SET=1;
    public static final int MSG_TYPE_QUERY=2;
    public static final int MSG_ACK_YES=1;
    public static final int MSG_ACK_NO=0;

    public static final int STATUS_ONLINE=0;

    public static final int MAX_IDLE_TIME =120*1000;


    public static final String STR_LAMP_FUNC_TEST="function_test";
    public static final String STR_LAMP_DURATION_TEST="duration_test";
    public static final String STR_LAMP_STOP_TEST="stop_test";
    public static final String STR_LAMP_INHIBIT_MODE="inhibit_mode";
    public static final String STR_LAMP_REST_MODE="reset_mode";
    public static final String STR_TERMINATE_INHIBIT_REST_MODE="exit_mode";
    
    
    public static final String LAMP_ON_MODE="lamp_on";
    public static final String LAMP_OFF_MODE="lamp_off";
    public static final String LAMP_FLASH_MODE="lamp_flash";

    public static final String LAMP_GROUP_A="A255";
    public static final String LAMP_GROUP_B="B255";


    public static String[] LAMP_STATUS_BITS= new String[]{"Lamp Ready","Lamp Failure","Lamp arc power on"
            ,"Limit Error","Fade running","Reset mode","Missing short address","Power Failure"};


    public static String[] LAMP_FEATURES_BITS =new String[]{"Integral Emergency Control Gear","Maintened Control Gear",
            "Switched Maintained Control Gear"," Auto-Test Capable","Adjustable Emergency Level","Hardwired Inhibit Supported",
            "Physical Selection Supported","Re-Light in Rest Mode Supported"
    };

    public static String[] LAMP_OP_MODEL_BITS = new String[]{
        "Rest Mode Active","Normal Mode Active","Emergency Mode Active","Emergency Mode After",
            "Mains Return Active","Funtion Test in Progress","Duration Test in Progress","Hardwired Inhibit Mode Active"
            ,"Hardwired Switch Is On","nouse","nouse","nouse","nouse","nouse","nouse","nouse"
    };

    public static String[] LAMP_EMERGENCY_STATUS_BITS =new String[]{
        "Inhibit Mode","Function Test Done"," Duration Test Done","Battery Fully Charged","Function Test Request Pending",
            "Duration Test Request Pending","Identification Active","Physically Selected"
    };

    public static String[] LAMP_FAULTS_BITS = new String[]{
        "Circuit Failure","Rated Duration not Achieved","Battery Fault","Lamp Failure",
            "Test Window for Function Test Exceeded","Test Window for Duration Test Exceeded",
            "Function Test Failed","Duration Test Failed"
    };

    public static String[] LAMP_STATUS_STR =new String[]{
        "","Comunication Failure","Battery Failure","Lamp Failure","","","",""
    };

    public static String getLampStatusString(int sta){
        if(sta == 0){
            return "Ok";
        }else {
            BitSet lampStatusBit=BitSet.valueOf(new long[]{sta});
            return IntStream.range(0, 8).filter(i->lampStatusBit.get(i)).mapToObj(i->{
                return LAMP_STATUS_STR[i];
            }).collect(Collectors.joining(""));

        }
    }

    public static  final String BROADCAST ="ff:ff:ff:ff:ff:ff";
    
    public static void main(String[] args) {
    	String result1 = getLampStatusString(2);
    	System.out.println("result:"+result1);
    	List<Integer> result= new ArrayList<>();
 /*   	 BitSet bs1= BitSet.valueOf(new byte[]{12});
         
         for (int i = 0; i <6 ; i++) {
             if(bs1.get(i)){
                 result.add(i);
             }
         }*/
         result =  getLampGroups(0);

         System.out.println(result);
         
         List<Integer> list = new ArrayList<Integer>();
         list.add(2);
         list.add(3);
         
        //  BitSet bs2=new BitSet();
         // Arrays.asList(2,3).forEach(i -> bs2.set(i,true));
         
        // list.forEach(i -> bs2.set(i,true));
         //System.out.println(getLampGroupValue(list));
	}
    
    
    public static List<Integer> getLampGroups(Integer group){
    	List<Integer> list = new ArrayList<Integer>();
    	if(null != group){
    		BitSet bs1= BitSet.valueOf(new byte[]{group.byteValue()});
            List<Integer> result= new ArrayList<>(6);
            for (int i = 0; i <6 ; i++) {
                if(bs1.get(i)){
                	list.add(i);
                }
            }
    	}
    	return list;
    }
    
    
    public static Integer getLampGroupValue(List<Integer> list){
    	if(null != list && list.size() >0){
    		BitSet bs2=new BitSet();
            list.forEach(i -> bs2.set(i,true));
            return (int) bs2.toLongArray()[0];
    	}
    	return 0;
    }
}
