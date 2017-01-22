package cn.pq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pq.model.Person;

@Service
public class TxService {
    @Autowired
    private AddPersonService addPersonService;
    @Autowired
    private UpdatePersonService updatePersonService;

    @Transactional
    public void testTx(Person person) {
        updatePersonService.update(person);
        addPersonService.save(person);
        int i = 1/0;
    }
}
