package com.zlx.reverce;

import com.zlx.reverce.entity.TAddressInfo;
import com.zlx.reverce.entity.TAddressRoomInfo;
import com.zlx.reverce.service.ITAddressInfoService;
import com.zlx.reverce.service.ITAddressRoomInfoService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReverceApplicationTests {

    @Autowired
    ITAddressInfoService itAddressInfoService;

    @Autowired
    ITAddressRoomInfoService itAddressRoomInfoService;


    @Rule
   public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Test
    @PerfTest(invocations = 5000,threads = 1)//10个线程执行10次
    public void contextLoads() {

        TAddressInfo addrInfo = new TAddressInfo();
        addrInfo.setAddressName("北京朗丽兹西山花园酒店");
        addrInfo.setAddressDescription("北京朗丽兹西山花园酒店");
        addrInfo.setAddressRoomNumber("18");
        addrInfo.setAddressAreaSize("65—1300cm");
        addrInfo.setAddressCapacity("50—1300");
        addrInfo.setAddressInsideParkNumber("0");
        addrInfo.setAddressOutsideParkNumber("0");
        addrInfo.setAddressImage("http://www.huixiaomeier.com/data/upload/item/1807/27/5b5ae7cfeb010_s.jpg");
        addrInfo.setAddressLevel("五星级酒店");
        itAddressInfoService.save(addrInfo);
//
//        String id = addrInfo.getId();
//        System.out.println(id);
//        TAddressRoomInfo tAddressRoomInfo = new TAddressRoomInfo();
//        tAddressRoomInfo.setAddressId(id);
//        tAddressRoomInfo.setName("悦麟殿");
//        tAddressRoomInfo.setDescription("层高6.5m");
//        tAddressRoomInfo.setAreaSize("475平方米");
//        tAddressRoomInfo.setCapacity("400人");
//        tAddressRoomInfo.setImage("http://www.huixiaomeier.com/data/upload/item/1807/25/5b581df734dc8_s.jpg");
//        itAddressRoomInfoService.save(tAddressRoomInfo);
    }

}
