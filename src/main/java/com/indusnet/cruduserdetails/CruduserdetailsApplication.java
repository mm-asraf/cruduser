package com.indusnet.cruduserdetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indusnet.cruduserdetails.Repository.IDemoScanAadhaarRepository;
import com.indusnet.cruduserdetails.Repository.IDemoScanPanRepository;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.DemoScanPan;

@SpringBootApplication
public class CruduserdetailsApplication implements CommandLineRunner{

	@Autowired
	private IDemoScanPanRepository iDemoScanPanRepo;
	
	@Autowired
	private IDemoScanAadhaarRepository iDemoScanAadhaarRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CruduserdetailsApplication.class, args);
	}
	
	public static void setdata() {
		
	}
//	
;
	@Override
	public void run(String... args) throws Exception {
		
		try {
//			DemoScanPan pan1 = new DemoScanPan(1235,"CRYFA5555T","Mahboob Asraf","2001-10-24");
//			DemoScanPan pan2 = new DemoScanPan(1236,"CKLFA5555T","Lucky Raj","2002-10-24");
//			DemoScanPan pan3 = new DemoScanPan(1237,"CQLFA5555T","Rajiv Ranjan","2005-10-24");
//			
//			
//			iDemoScanPanRepo.save(pan1);
//			iDemoScanPanRepo.save(pan2);
//			iDemoScanPanRepo.save(pan3);
		

//			DemoScanAadhaar aadhaar1 = new DemoScanAadhaar(1235L,"mohammad","mahboob","asraf","jahangir","5689 8754 5665","2001-11-19","dhanbad","jharkhand1","123589","salt lake city");
//			DemoScanAadhaar aadhaar2 = new DemoScanAadhaar(1236L,"Lucky","raj","srb","mukesh sisodiya","5899 8824 2665","2001-12-19","jamshedpur","jharkhand2","589687","something dsskj");
//			DemoScanAadhaar aadhaar3 = new DemoScanAadhaar(1237L,"Mr","Rajiv","Ranjan","kamlesh singh","9869 8324 1665","1999-11-09","giridih","jharkhand3","589687","somthing new");
//			System.out.println("aadhar 1" + aadhaar1);
//			System.out.println("aadhar 2" + aadhaar2);
//			System.out.println("aadhar 3" + aadhaar3);
//			iDemoScanAadhaarRepo.save(aadhaar1);
//			iDemoScanAadhaarRepo.save(aadhaar2);
//			iDemoScanAadhaarRepo.save(aadhaar3);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
