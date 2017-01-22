package cn.pq.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.pq.model.Person;

@Repository
public interface PersonDao {

    @Insert("insert into person (name,age) values(#{name},#{age})")
    public void save(Person person);

    @Update(value="update person set age=#{age} where name=#{name}")
    public void update(Person person);
    
}
