package cn.pq.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.pq.model.Person;

@Component
public class PersonConverter implements Converter<String, Person>{

	@Override
	public Person convert(String str) {
		Person person = new Person();
		if(!StringUtils.isEmpty(str)){
			String[] items = str.split("_");
			if (items.length == 2) {
			   person.setAge(Integer.parseInt(items[0]));
			   person.setName(items[1]);
			}
		}
		return person;
	}
	
}
