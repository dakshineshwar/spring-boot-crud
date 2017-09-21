package com.techprimers.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimers.db.model.Users;
import com.techprimers.db.repository.UsersRepository;

@Service
public class userService implements IUserService {
	@Autowired
	private UsersRepository usersRepository;

	/* (non-Javadoc)
	 * @see com.techprimers.db.service.IUserService#findById(java.lang.Integer)
	 */
	@Override
	public Users findById(Integer id) {
		return usersRepository.findOne(id);
	}


	/* (non-Javadoc)
	 * @see com.techprimers.db.service.IUserService#saveUser(com.techprimers.db.model.Users)
	 */
	@Override
	public void saveUser(Users user) {
		usersRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.techprimers.db.service.IUserService#updateUser(java.lang.Integer, com.techprimers.db.model.Users)
	 */
	@Override
	public void updateUser(Integer id, Users user){
		Users currentUser = findById(id);

		///if(currentUser.getId().equals(id)){
			//currentUser.setId(id);
			currentUser.setName(user.getName());
			currentUser.setSalary(user.getSalary());
			currentUser.setTeamName(user.getTeamName());
			//return;
		//}
		
		saveUser(currentUser);
	}

	/* (non-Javadoc)
	 * @see com.techprimers.db.service.IUserService#deleteUserById(java.lang.Integer)
	 */
	@Override
	public void deleteUserById(Integer id){
		usersRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.techprimers.db.service.IUserService#deleteAllUsers()
	 */
	@Override
	public void deleteAllUsers(){
		usersRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.techprimers.db.service.IUserService#findAllUsers()
	 */
	@Override
	public List<Users> findAllUsers(){
		return usersRepository.findAll();
	}

}
