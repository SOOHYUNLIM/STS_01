package org.zerock.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class MySQLConnectTests {

	@Test
	public void testConnect() throws Exception {
		//MySQL 6 ÀÌ»ף => com.mysql.cj.jdbc.Driver
		Class<?> clz = Class.forName("com.mysql.jdbc.Driver");
		
		log.info(clz);
		
		Connection con = 
				DriverManager.getConnection(
				"jdbc:mysql://192.168.1.29:3306/bitdb?serverTimezone=Asia/Seoul&useSSL=false"
				,"bit04", "1234");
		
		log.info(con);
		
		con.close();
	}
	
}
