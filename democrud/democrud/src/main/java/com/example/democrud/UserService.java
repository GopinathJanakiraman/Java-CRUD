package com.example.democrud;

import java.util.List;

public interface UserService {

	User create(User user);
	User delete(int id);
	List<UserDTO> findAll();
	User findById(int id);
	User update(User user);
}
