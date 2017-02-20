package cn.pq.model;

import java.util.Date;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class Person {

	private int age;

	@Size(max = 15, min = 5, message = "长度不合法")
	private String name;

	@DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
	private Date birthday;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

}
