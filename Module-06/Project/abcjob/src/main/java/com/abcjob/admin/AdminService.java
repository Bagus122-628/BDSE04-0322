package com.abcjob.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcjob.admin.entity.Admin;
import com.abcjob.admin.entity.Job;
import com.abcjob.admin.entity.User;
import com.abcjob.admin.entity.UserProfile;
import com.abcjob.admin.repository.AdminRepository;
import com.abcjob.admin.repository.JobRepository;
import com.abcjob.admin.repository.UserProfileRepository;
import com.abcjob.admin.repository.UserRepository;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	UserProfileRepository userProfileRepo;
	
	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Admin loadAdminByEmail(String email) {
		Admin admin = adminRepo.findByEmail(email);
		return admin;
	}
	
	public Admin getAdmin(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		
		if(admin != null) {
			System.out.println("User " + admin.getFirst_name());
		}
		return admin;
	}
	
	public List<UserProfile> listUser(){
		List<UserProfile> listOfUser = userProfileRepo.findAll();
		return listOfUser;
	}
	
	public UserProfile findUser(int id) {
		UserProfile profile = userProfileRepo.findById(id).get();
		return profile;
	}
	
	public Job findJob(int id) {
		Job job = jobRepo.findById(id).get();
		return job;
	}
	
	public UserProfile saveEdit(UserProfile userProfile) {
		Job job = findJob(userProfile.getJob().getId_job());
		
		UserProfile profile = findUser(userProfile.getId_profile());
		
		profile.setFirst_name(userProfile.getFirst_name());
		profile.setLast_name(userProfile.getLast_name());
		profile.setCountry(userProfile.getCountry());
		profile.setCity(userProfile.getCity());
		profile.setJob(job);
		
		userProfileRepo.save(profile);
		
		return profile;
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
	
	public List<Job> listJob(){
		List<Job> listJob = jobRepo.findAll();
		return listJob;
	}
	
	public void saveAdd(User regUser) {
		User user = new User();
		UserProfile profile = new UserProfile();
		
		User userAdd = new User(regUser.getEmail(), regUser.getPassword(), true, profile);
		UserProfile userProfile = new UserProfile(user,
				regUser.getProfile().getCity(),
				regUser.getProfile().getFirst_name(), 
				regUser.getProfile().getLast_name(), 
				regUser.getProfile().getCountry(), 
				regUser.getProfile().getJob());
		
		userAdd.setProfile(userProfile);
		userProfile.setUser(userAdd);
		
		userProfileRepo.save(userProfile);
	}
	
	public List<User> findAllUser(){
		List<User> users = userRepo.findAll();
		return users;
	}
}
