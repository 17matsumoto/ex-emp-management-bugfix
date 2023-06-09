package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

/**
 * 従業員情報を操作するコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpForm() {
		return new UpdateEmployeeForm();
	}

	

	

	public String showList( Model model,  Pageable pageable ,String name) {
		System.out.println("aaa");

		List<Employee> employeeList = null;
		Page<Employee> pageList = null;

		if (name != null) {
			employeeList = employeeService.findByName(name);
			pageList = employeeService.findAll(pageable);

		} else {
			pageList = employeeService.findAll(pageable);
			employeeList = pageList.getContent();
		}

		if (employeeList.isEmpty()) {
			model.addAttribute("message", "１件もありませんでした。");
			employeeList = employeeService.showList();
			pageList = employeeService.findAll(pageable);

		}
		return "/employee/list";

	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を表示する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細画面を出力します.
	 * 
	 * @param id    リクエストパラメータで送られてくる従業員ID
	 * @param model モデル
	 * @return 従業員詳細画面
	 */
	@GetMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を更新する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細(ここでは扶養人数のみ)を更新します.
	 * 
	 * @param form 従業員情報用フォーム
	 * @return 従業員一覧画面へリダクレクト
	 */
	@PostMapping("/update")
	public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		Employee employee = new Employee();
		employee.setId(form.getIntId());
		employee.setDependentsCount(form.getIntDependentsCount());
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}


	/**
	 * 従業員曖昧検索.
	 * 
	 * @param name  名前
	 * @param model モデル
	 * @return 従業員リスト
	 */
	@PostMapping("/serch")
	public String serch(String name, Model model) {
		List<Employee> employeeList = employeeService.findByName(name);
		if (employeeList == null) {
			List<Employee> employeeList2 = employeeService.showList();
			model.addAttribute("employeeList", employeeList2);
			model.addAttribute("message", "1件もありませんでした");
			return "employee/list";
		}
		if (employeeList != null) {
			model.addAttribute("employeeList", employeeList);
		}
		return "employee/list";
	}

}