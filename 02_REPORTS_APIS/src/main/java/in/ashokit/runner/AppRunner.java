package in.ashokit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.EligibilityDetails;
import in.ashokit.repo.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private EligibilityDetailsRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		EligibilityDetails entity1 = new EligibilityDetails();
		entity1.setEligId(1);
		entity1.setName("John");
		entity1.setMobile(1236547896l);
		entity1.setEmail("john@gmail.com");
		entity1.setGender('M');
		entity1.setSsn(968574l);
		entity1.setPlanName("SNAP");
		entity1.setPlanStatus("Approved");
		repo.save(entity1);
		
		EligibilityDetails entity2 = new EligibilityDetails();
		entity2.setEligId(2);
		entity2.setName("Smith");
		entity2.setMobile(7896547896l);
		entity2.setEmail("smith@gmail.com");
		entity2.setGender('M');
		entity2.setSsn(945574l);
		entity2.setPlanName("CCAP");
		entity2.setPlanStatus("Denied");
		repo.save(entity2);
		
	}

}
