package com.familydetails.services.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {
	
	@Autowired
	private DataRepository dataRepository;
	
	List<FamilyDetail> family =new ArrayList<>(Arrays.asList(new FamilyDetail("1","Dinesh","Father of the family"),
			new FamilyDetail("2","Mother","Mother of the family")));
	
	public List<FamilyDetail> GetFamilyDetails(){
		//return family;
		List<FamilyDetail> familydetails = new ArrayList<FamilyDetail>();
		dataRepository.findAll()
		.forEach(familydetails::add);;
		return familydetails;
		
	}
	
	public Optional<FamilyDetail> SpecificFamilyMember(String id){
		//return family.stream().filter(a -> a.getId().equals(id)).findFirst().get();
		return dataRepository.findById(id);
	}
	
	public void addFamily(FamilyDetail body){
		//family.add(body);
		dataRepository.save(body);
	}
	
	public void updateFamily(FamilyDetail fam){
		dataRepository.save(fam);
	}

	public void deleteFamily(String id){
		//family.removeIf(b->b.getId().equals(id));
		dataRepository.deleteById(id);
	}
}
