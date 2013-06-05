package edu.iiitb.OnlineMovieTicketBooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RuntimeSettings {
	public static final String APPLICATION_NAME = "OnlineMovieTIcketBooking";
	public static final String VERSION_ID = " version 0.1"
			+ " dated December 27, 2011";
	public static final String SERVER_IP = "localhost";
	static String databaseName = "jspproject";
	static String dbUserID = "root";
	static String dbPassword = "1234";
	public static String RUN_MODE = "Test"; 
											
	public static boolean IS_IN_DEBUG_MODE = true; 
	public static int ROWS_IN_PAGE = 10;
	static int portNo = 3306;// 5432; //
	public static String DB_DIRECTORY = "/DB/";
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String scriptSql9[] = {
		
		
		" use jspproject;",
		
		

		"drop table IF EXISTS tAdmin;",
		"CREATE TABLE IF NOT EXISTS tAdmin( "
			+ "  iAdminID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT, "
			+  " sAdminName varchar(45) NOT NULL, "
			+  " sAdminEmail varchar(45) NOT NULL UNIQUE, "
			+  " sAdminPassword varchar(45) NOT NULL, "
			+   "sAdminPhoneNumber varchar(45)  NULL, "
			+  " sAdminAddress varchar(100)  NULL, "
			+  " PRIMARY KEY(iAdminID ));" ,

			
			
			"insert into tAdmin(sAdminName ,sAdminEmail ,sAdminPassword , sAdminPhoneNumber , sAdminAddress ) values ('vijay','vijay','vijay','252118','asdf');"
		
		  };
	
	
	
	public static String scriptSql[] = {
		
		" use jspproject;",
		
		
		
		"drop table IF EXISTS tSignIn;",
		"CREATE TABLE  tSignIn("
		   + "itSignInID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT," 
		   + "sEmail varchar(45) NOT NULL UNIQUE," 
		   + "sPassword varchar(45) NOT NULL," 
		   + "PRIMARY KEY(itSignInID));"  };

		public static String scriptSql1[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",
		"drop table IF EXISTS tSignUpSeller;",
		"CREATE TABLE IF NOT EXISTS tSignUpSeller(" 
		   + "iSellerID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT," 
		   + "sName varchar(45) NOT NULL," 
		   + "sEmail varchar(45) NOT NULL UNIQUE," 
		   + "sPassword varchar(45) NOT NULL," 
		   + "sPhoneNumber varchar(45) NOT NULL," 
		   + "sAddress varchar(100)  DEFAULT NULL," 
		   +"iRegistrationStatus int(10) ,"
		   + "PRIMARY KEY(iSellerID));"   };
		
		public static String scriptSql2[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",

		"drop table IF EXISTS tTheater;",
		 "CREATE TABLE IF NOT EXISTS tTheater(" 
		   + "iTheaterID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT," 
		   + "sName varchar(45) NOT NULL," 
		   + "sPhoneNumber varchar(45) NOT NULL," 
		   + "sAddress varchar(100)  DEFAULT NULL," 
		   + "sCity varchar(45) NOT NULL," 
		   + "sState varchar(45) NOT NULL," 
		   + "iNumberOfSeates int(10)," 
		   + "iSellerID int(10)   REFERENCES tSignUpSeller(iSellerID) ON DELETE CASCADE,"
		       + "PRIMARY KEY(iTheaterID));"  };
		
		
		public static String scriptSql3[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",

		"drop table IF EXISTS tTheaterClassAndPrice;",

		 "CREATE TABLE IF NOT EXISTS tTheaterClassAndPrice ("
		   + "iTheaterClassID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT," 
		   + "sClass  varchar(45) NOT NULL," 
		   + "iPrice  int(10)," 
		   + "iNumberOfSeatsPerClass int(10),"
		   + "iTheaterID int(10)  REFERENCES tTheater(iTheaterID) ON DELETE CASCADE," 
		   + "PRIMARY KEY(iTheaterClassID));" };
		
		
		public static String scriptSql4[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",
		"drop table IF EXISTS tMovies;",
		 "CREATE TABLE IF NOT EXISTS tMovies(" 
		   + "iMovieID int(10) UNSIGNED NOT NULL AUTO_INCREMENT," 
		   + "sName varchar(45) NOT NULL," 
		   + "iRating int(10) NOT NULL," 
		   + "dScreeningStartDate date NOT NULL," 
		   + "dScreeningEndDate date NOT NULL," 
		   + "tShowTiming1 time ," 
		   + "tShowTiming2 time ," 
		   + "tShowTiming3 time ," 
		   + "tShowTiming4 time ," 
		   + "iTheaterID int(10) NOT NULL REFERENCES tTheater (iTheaterID) ON DELETE CASCADE," 
		   + "PRIMARY KEY(iMovieID));"  };
		
		
		
		public static String scriptSql5[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",
		"drop table IF EXISTS tSignUpSubscriber;",
		 "CREATE TABLE IF NOT EXISTS tSignUpSubscriber(" 
		   + "iSubscriberID int(10) UNSIGNED NOT NULL AUTO_INCREMENT," 
		   + "sName varchar(45) NOT NULL ," 
		   + "sEmail varchar(45) NOT NULL UNIQUE," 
		   + "sPassword varchar(45) NOT NULL ," 
		   + "sPhoneNumber varchar(45) NOT NULL," 
		   + "sAddress  varchar(100) DEFAULT NULL," 
		   + "iDOB date DEFAULT NULL," 
		   + "iBalance int(10) NOT NULL,"
		   + "iRegistrationStatus int(10) ,"
		   + "PRIMARY KEY(iSubscriberID));" };
		
		
		
		
		public static String scriptSql6[] ={
			
			"use jspproject;",			
			"drop table if exists tmovietimings;",
			"CREATE TABLE tmovietimings("

				+ "iMovieTimingID int(10) UNSIGNED NOT NULL AUTO_INCREMENT,"
				+ "dDate date NOT NULL,"
				+ "tTime time NOT NULL,"
				+ "iSeatsLeft int(10) NOT NULL,"
				+ "sClass1 varchar(45),"
				+ "sClass2 varchar(45),"
				+ "sClass3 varchar(45),"
				+ "iSeatsLeftType1 int(10) ,"
				+ "sSeatsLeftOfType1 varchar(200),"
				+ "iPriceOfType1 int(10),"
				+ "iSeatsLeftType2 int(10) ,"
				+ "sSeatsLeftOfType2 varchar(200),"
				+ "iPriceOfType2 int(10),"
				+ "iSeatsLeftType3 int(10) ,"
				+ "sSeatsLeftOfType3 varchar(200),"
				+ "iPriceOfType3 int(10),"
				+ "iMovieID int(10) NOT NULL REFERENCES tMovies(iMovieID)  ON DELETE CASCADE,"
				+ "PRIMARY KEY(iMovieTimingID));"
		};
		
		
		
		/*
		
		public static String scriptSql6[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",
		"drop table IF EXISTS  tMovieTimings;",
		"CREATE TABLE IF NOT EXISTS tMovieTimings(" 
		   + "iMovieTimingID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT," 
		   + "dDate datetime NOT NULL," 
		   + "iSeatsLeft int(10) NOT NULL,"	        
		   + "iSeatsLeftType1 int(10),"
		   + "sSeatsLeftOfType1 varchar(150),"
		       + "iSeatsLeftType2 int(10) ,"
		       + "sSeatsLeftOfType2 varchar(150),"
		       + "iSeatsLeftType3 int(10) ," 
		       + "sSeatsLeftOfType3 varchar(150),"
		   + "iMovieID int(10) NOT NULL REFERENCES tMovies(iMovieID)  ON DELETE CASCADE," 
		   + "PRIMARY KEY(iMovieTimingID));"  };
		
		
		*/
		
		public static String scriptSql7[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",
		"drop table IF EXISTS tTicket;",
		 "CREATE TABLE IF NOT EXISTS tTicket(" 
		   + "iTicketID int(10) UNSIGNED NOT NULL AUTO_INCREMENT," 
		   + "iAmountPaid int(10) NOT NULL," 
		   + "iNumberOfTicketsBought int(10) NOT NULL," 
		   + "sSeatNumber varchar(100) NOT NULL,"
		   + "sClass varchar(50) NOT NULL,"
		   + "dDate Date NOT NULL,"		   
		   + "sTime varchar(50) NOT NULL,"
		   + "sPaidStatus varchar(50) NOT NULL,"
		   + "iSubscriberID int(10) NOT NULL REFERENCES tSignUpSubscriber(iSubscriberID)  ON DELETE CASCADE,"
		   + "iMovieTimingID int(10) NOT NULL REFERENCES tMovieTimings(iMovieTimingID) ON DELETE SET NULL," 
		   + "PRIMARY KEY(iTicketID));"  };
		
		
		
	/*	public static String scriptSql8[] = {
		// " drop database if exists store_development;",
		// " create database store_development;",
		" use jspproject;",
		"drop table IF EXISTS tSeatBooked;",
		 "CREATE TABLE IF NOT EXISTS tSeatBooked(" 
		   + "iSeatBookedID int(10) UNSIGNED NOT NULL AUTO_INCREMENT," 
		   + "iSeatNumber int(10) NOT NULL," 
		   + "dShowTime datetime NOT NULL," 
		   + "iTicketID  int(10) NOT NULL REFERENCES tTicket(iTicketID) ON DELETE CASCADE," 
		   + "PRIMARY KEY(iSeatBookedID));"  };
		
		
		
		
		public static String scriptSqlDummy[] = {
			// " drop database if exists store_development;",
			// " create database store_development;",
			" use jspproject;",
			"drop table IF EXISTS tDummy;",
			
			"CREATE TABLE IF NOT EXISTS tDummy("
				+"iDummyID int(10) UNSIGNED NOT NULL AUTO_INCREMENT,"
				+"iSubscriberID int(10) NOT NULL,"
				+"sCity varchar(45) NOT NULL,"
				+"sTheatre varchar(45) NOT NULL,"
				+"sMovie varchar(45) NOT NULL,"
				+"sClass varchar(45) NOT NULL,"
				+"dDate Date NOT NULL,"
				+"tTime Time NOT NULL,"
				+"PRIMARY KEY(iDummyID));" };
		
	/*public static String scriptSql[] = {
			// " drop database if exists store_development;",
			// " create database store_development;",
			" use paperless_hospital_service;",
			"DROP TABLE IF EXISTS patient;",
			"CREATE TABLE  patient ("
					+ "id int(10) unsigned NOT NULL AUTO_INCREMENT,"
					+ "name varchar(45) NOT NULL,"
					+ "fathersName varchar(45),"
					+ "address varchar(50),"
					+ "dateOfBirth date NOT NULL,"
					+ "gender varchar(10),"
					+ "languagesSpoken varchar(50),"
					+ "doctor varchar(30),"
					+ "reasonForAdmission varchar(100),"
					+ "deptAssigned varchar(20),"
					+ "doctorAssigned varchar(20),"
					+ "treatmentDetails varchar(200),"
					+ "PRIMARY KEY (`id`));" };


	public static String scriptSql1[] = {
		
		" use paperless_hospital_service;",
		"DROP TABLE IF EXISTS loginTable;",
		"CREATE TABLE loginTable ("
				+ "UserId varchar(15) NOT NULL,"
				+ "Password varchar(15)NOT NULL,"
				+ "usertype varchar(15) NOT NULL,"
				+ "PRIMARY KEY (`userId`));", 
		"INSERT into loginTable values ('clerk', 'clerk', 'clerk');", 
		"INSERT into loginTable values ('admin', 'admin', 'admin');",
		"INSERT into loginTable values ('doc1', 'doc1', 'doctor');",	
		"INSERT into loginTable values ('billing', 'billing', 'billing');"
	};*/
	}
