package com.techprimers.db.service;

import java.util.List;

import com.techprimers.db.model.Users;

public interface IUserService {

	public abstract Users findById(Integer id);

	public abstract void saveUser(Users user);

	public abstract void updateUser(Integer id, Users user);

	public abstract void deleteUserById(Integer id);

	public abstract void deleteAllUsers();

	public abstract List<Users> findAllUsers();

}