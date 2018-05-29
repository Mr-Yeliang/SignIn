package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.entity.Student;

@Component
@Service
public class StudentService {

	private static List<Student> list = new ArrayList<>();

	/**
	 * 初始化班级成员集合
	 */
	public static void init() {
		list.clear();
		list.add(new Student("叶亮", false));
		list.add(new Student("谷宇", false));
		list.add(new Student("王涛", false));
		list.add(new Student("张君意", false));
		list.add(new Student("蒋金贵", false));
		list.add(new Student("杨先亮", false));
		list.add(new Student("王诚信", false));
		list.add(new Student("卢东梅", false));
		list.add(new Student("刘欣", false));
		list.add(new Student("许聪慧", false));
		list.add(new Student("余新亮", false));
	}

	/**
	 * 查询是否为本班学生
	 * 
	 * @param name
	 * @return
	 */
	public boolean check(String name) {
		boolean result = false;
		for (Student student : list) {
			if (name.equals(student.getName())) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * 签到
	 * 
	 * @param name
	 * @return
	 */
	public boolean Sign(String name) {
		boolean result = false;
		for (Student student : list) {
			if (name.equals(student.getName())) {
				if (!student.getState()) {
					student.setState(true);
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * 查询
	 * 
	 * @param name
	 * @return
	 */
	public static Student sel(String name) {
		Student student = null;
		for (Student stu : list) {
			if (name.equals(student.getName())) {
				student = stu;
			}
		}
		return student;
	}

	/**
	 * 统计
	 * 
	 * @return
	 */
	public static int count() {
		int i = 0;
		for (Student stu : list) {
			if (stu.getState()) {
				i++;
			}
		}
		return i;
	}

}
