package com.vaccinationApp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.DTO.VaccineRegistrationDTO;
import com.vaccinationApp.exceptions.NotFoundException;
import com.vaccinationApp.model.Member;
import com.vaccinationApp.model.VaccineRegistration;
import com.vaccinationApp.repository.VaccineRegistrationRepository;


@Service
public class VaccineRegistrationServiceImp implements VaccineRegistrationService {
	
	
	@Autowired
	private VaccineRegistrationRepository vaccineRegRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public VaccineRegistrationDTO addVaccineRegistration(VaccineRegistration reg) {
		VaccineRegistration regis = vaccineRegRepo.save(reg);
		VaccineRegistrationDTO vaccRegDto = modelMapper.map(regis, VaccineRegistrationDTO.class);
		return vaccRegDto;
	}
	
	
	@Override
	public VaccineRegistrationDTO getVaccineRegistration(Long mobileNo) {
		VaccineRegistration  vaccReg = vaccineRegRepo.findById(mobileNo).orElseThrow(()->new NotFoundException("mobile number: "+ mobileNo +" is not registered."));
		VaccineRegistrationDTO vaccRegDto = modelMapper.map(vaccReg, VaccineRegistrationDTO.class);
		return vaccRegDto;
	}

	@Override
	public List<Member> getAllMember(Long mobileNo) {
		VaccineRegistration vaccReg = vaccineRegRepo.findById(mobileNo).orElseThrow(()->new NotFoundException("No member found by mobile number: "+mobileNo));
		VaccineRegistrationDTO vaccRegDto = modelMapper.map(vaccReg, VaccineRegistrationDTO.class);
		List<Member> members = vaccRegDto.getMembers();
		return members;
	}

	


	@Override
	public boolean deleteVaccineRegistration(long mobileNo) {
		VaccineRegistration vaccReg = vaccineRegRepo.findById(mobileNo).orElseThrow(()->new NotFoundException("This mobile number is not registered."));
		vaccineRegRepo.delete(vaccReg);
		return true;
	}

	@Override
	public List<VaccineRegistration> getAllVaccineRegistration() {
		List<VaccineRegistration> regs = vaccineRegRepo.findAll();
		return regs;
	}

	

	@Override
	public VaccineRegistrationDTO updateVaccineRegistration(VaccineRegistrationDTO reg) {
		VaccineRegistration vaccReg  = vaccineRegRepo.findById(reg.getMobileNo()).orElseThrow(()->new NotFoundException("This user is not registered."));
		vaccReg.setDateOfReg(reg.getDateOfReg());
		vaccReg.setMembers(reg.getMembers());
		return reg;
	}
}
