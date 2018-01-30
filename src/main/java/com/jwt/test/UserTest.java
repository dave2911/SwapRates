package com.jwt.test;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwt.model.User;
import com.jwt.service.UserService;
import com.jwt.service.UserServiceImpl;
public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("webapp\\data\\data.csv").getAbsoluteFile();
		System.out.println(file.toString());
	}
}
