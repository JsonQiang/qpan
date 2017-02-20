package cn.pq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import cn.pq.com.JsonResp;
import cn.pq.model.Person;
import cn.pq.service.AddPersonService;
import cn.pq.service.TxService;

@Controller
public class JsonTest {

	@Autowired
	private AddPersonService addPersonService;

	@Autowired
	private TxService txService;

	@RequestMapping(value = "/json/test")
	public @ResponseBody Person doService() {
		Person person = new Person();
		person.setAge(18);
		person.setName("messi");
		return person;
	}

	@RequestMapping(value = "/validate")
	public @ResponseBody Map<String, String> checkPersonInfo(@Valid Person personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			Map<String, String> errors = getErrors(bindingResult);
			return errors;
		}

		return new HashMap<>();
	}

	@RequestMapping(value = "/tx/test")
	public @ResponseBody JsonResp txTest(Person person) {
		txService.testTx(person);
		System.out.println("执行不");
		return new JsonResp();
	}

	private Map<String, String> getErrors(BindingResult result) {
		Map<String, String> map = new HashMap<String, String>();
		List<FieldError> list = result.getFieldErrors();
		for (FieldError error : list) {
			System.out.println("error.getField():" + error.getField());
			System.out.println("error.getDefaultMessage():" + error.getDefaultMessage());

			map.put(error.getField(), error.getDefaultMessage());
		}
		return map;
	}

	@RequestMapping(value="/converTest")
	public @ResponseBody JsonResp converTest(@RequestBody List<Person> persons) {
		System.out.println(persons);
		return new JsonResp();
	}
}
