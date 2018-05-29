package com.example.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.example.entity.Student;
import com.example.service.StudentService;

@Configuration
public class SignInController {

	@Autowired
	static StudentService ss;
	static Scanner sin = new Scanner(System.in);

	
	/**
	 * 主菜单
	 */
	@Bean
	public static String meun() {
		ss.init();
		String i = sin.next();
		while (true) {
			System.out.println("****************************");
			System.out.println("1.签到");
			System.out.println("2.查询");
			System.out.println("3.统计");
			System.out.println("****************************");
			System.out.println("请输入您的选择：");
			switch (i) {
			case "1":
				singIn();
				break;
			case "2":
				sel();
				break;
			case "3":
				count();
				break;
			default:
				System.out.println("输入错误，请输入1~3！");
				break;
			}
		}
	}

	/**
	 * 签到
	 */
	@Bean
	public static void singIn() {

		System.out.println("****************************");
		System.out.println("请输入姓名：");
		String name = sin.next();
		if (name != null) {
			if (ss.check(name)) {
				if (ss.Sign(name)) {
					System.out.println("签到成功");
				} else {
					System.out.println("你已经签过到了");
				}
			} else {
				System.out.println("非本班学员，请重输！");
			}
		} else {
			System.out.println("姓名不得为空！");
		}
		System.out.println("****************************\n");
	}

	/**
	 * 查询
	 */
	@Bean
	public static void sel() {

		System.out.println("****************************");
		System.out.println("请输入要查询学生的姓名：");
		String name = sin.next();
		if (name != null) {
			if (ss.check(name)) {
				Student student = ss.sel(name);
				String state = "未签到";
				if (student.getState()) {
					state = "已签到";
				}
				System.out.println("姓名：" + student.getName() + "\t签到状态：" + state);
			} else {
				System.out.println("非本班学员，请重输！");
			}
		} else {
			System.out.println("姓名不得为空！");
		}
		System.out.println("****************************\n");
	}

	/**
	 * 统计
	 */
	@Bean
	public static void count() {

		System.out.println("****************************");
		System.out.printf("已签到%d人\n", ss.count());
		System.out.println("****************************\n");
	}
}