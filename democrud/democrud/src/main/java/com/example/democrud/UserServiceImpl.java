package com.example.democrud;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	private Type listDTOType=new TypeToken<List<UserDTO>>(){}.getType();
	@Override
	public User create(User user) {
		return repository.save(user);
	}

	@Override
	public User delete(int id) {
		Optional<User> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			User user = optional.get();
			if(user != null) {
				repository.delete(user);
			}
			return user;
		}
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		
		List<User> userDtO = repository.findAll();
		List<UserDTO> dd = modelMapper.map(userDtO,listDTOType);
		return dd;
	}

	@Override
	public User findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public User update(User user) {
		return repository.save(user);
	}

}
