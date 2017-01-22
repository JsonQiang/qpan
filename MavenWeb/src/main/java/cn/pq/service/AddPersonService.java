package cn.pq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.pq.dao.PersonDao;
import cn.pq.model.Person;

@Service
public class AddPersonService {

    @Autowired
    private PersonDao personDao;
    
    @Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=RuntimeException.class)
    public void save (Person person) throws RuntimeException{
        personDao.save(person);
    }
    
}
