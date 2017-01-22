package cn.pq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pq.dao.PersonDao;
import cn.pq.model.Person;

@Service
public class UpdatePersonService {

    @Autowired
    private PersonDao personDao;
    
    @Transactional
    public void update(Person person){
        person.setName("qpan");
        personDao.update(person);
    }
}
