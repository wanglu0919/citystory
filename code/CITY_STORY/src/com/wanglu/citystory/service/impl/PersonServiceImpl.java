package com.wanglu.citystory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanglu.citystory.dao.PersonDao;
import com.wanglu.citystory.entity.Person;
import com.wanglu.citystory.service.IPersonService;

@Service("personService")
public class PersonServiceImpl implements IPersonService {

	@Resource
	private PersonDao personDao;
	@Override
	public Person getPersonById(int id) {
		
		return personDao.getPersonById(id);
	}

}
