drop database jspproject;
create database jspproject;
use jspproject

drop table  tAdmin;
CREATE TABLE IF NOT EXISTS tAdmin( 
	   iAdminID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT, 
	   sAdminName varchar(45) NOT NULL, 
	   sAdminEmail varchar(45) NOT NULL UNIQUE, 
	   sAdminPassword varchar(45) NOT NULL, 
	   sAdminPhoneNumber varchar(45)  NULL, 
	   sAdminAddress varchar(100)  NULL, 
	   PRIMARY KEY(iAdminID )); 

insert into tAdmin(sAdminName ,sAdminEmail ,sAdminPassword ,  sAdminPhoneNumber , sAdminAddress ) values ("admin","admin","admin","998096","Chandigarh");



drop table  tSignIn;
CREATE TABLE IF NOT EXISTS tSignIn( 
	   iSignInID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT, 
	   sEmail varchar(45) NOT NULL UNIQUE, 
	   sPassword varchar(45) NOT NULL, 
	   PRIMARY KEY(iSignInID)); 

	
drop table  tSignUpSeller;
CREATE TABLE IF NOT EXISTS tSignUpSeller( 
	   iSellerID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT, 
	   sName varchar(45) NOT NULL, 
	   sEmail varchar(45) NOT NULL UNIQUE, 
	   sPassword varchar(45) NOT NULL, 
	   sPhoneNumber varchar(45) NOT NULL, 
	   sAddress varchar(100)  DEFAULT NULL,
	   iRegistrationStatus int(10) ,
	   PRIMARY KEY(iSellerID)); 



drop table tTheater;

 CREATE TABLE IF NOT EXISTS tTheater( 
	   iTheaterID int(10) UNSIGNED NOT NULL  AUTO_INCREMENT, 
	   sName varchar(45) NOT NULL, 
	   sPhoneNumber varchar(45) NOT NULL, 
	   sAddress varchar(100)  DEFAULT NULL, 
	   sCity varchar(45) NOT NULL, 
	   sState varchar(45) NOT NULL, 
	   iNumberOfSeates int(10),
	 
	   iSellerID int(10)   REFERENCES tSignUpSeller(iSellerID) ON DELETE CASCADE,
                  PRIMARY KEY(iTheaterID)); 


drop table tTheaterClassAndPrice;

 CREATE TABLE IF NOT EXISTS tTheaterClassAndPrice (
	   iTheaterClassID int(10) UNSIGNED NOT NULL  				                AUTO_INCREMENT, 
	   sClass  varchar(45) NOT NULL,
	   iPrice  int(10), 
	   iNumberOfSeatsPerClass int(10), 
	    iTheaterID int(10)  REFERENCES tTheater(iTheaterID) ON DELETE CASCADE, 
	   PRIMARY KEY(iTheaterClassID)); 




drop table tMovies;

 CREATE TABLE IF NOT EXISTS tMovies( 
	   iMovieID int(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	   sName varchar(45) NOT NULL, 
	   iRating int(10) NOT NULL, 
	   dScreeningStartDate date NOT NULL, 
	   dScreeningEndDate date NOT NULL, 
	   tShowTiming1 time  DEFAULT NULL, 
	   tShowTiming2 time  DEFAULT NULL, 
	   tShowTiming3 time  DEFAULT NULL, 
	   tShowTiming4 time  DEFAULT NULL, 
	   iTheaterID int(10) NOT NULL REFERENCES tTheater		(iTheaterID)  	   ON DELETE CASCADE, 
	   PRIMARY KEY(iMovieID)); 




drop table tSignUpSubscriber;

 CREATE TABLE IF NOT EXISTS tSignUpSubscriber( 
	   iSubscriberID int(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	   sName varchar(45) NOT NULL , 
	   sEmail varchar(45) NOT NULL UNIQUE, 
	   sPassword varchar(45) NOT NULL , 
	   sPhoneNumber int(10) NOT NULL, 
	   sAddress  varchar(100) DEFAULT NULL, 
	   iDOB date NOT NULL,
	    iBalance int(10) NOT NULL, 
	   PRIMARY KEY(iSubscriberID));


drop table  tMovieTimings;
CREATE TABLE IF NOT EXISTS tMovieTimings( 
	   iMovieTimingID int(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	   dDate date NOT NULL, 
	   tTime time NOT NULL,

	   iSeatsLeft int(10) NOT NULL,

        sClass1 varchar(45),
        sClass2 varchar(45),
        sClass3 varchar(45),

	   iSeatsLeftType1 int(10) ,
sSeatsLeftOfType1 varchar(150),
iPriceOfType1 int(10),
        	
   iSeatsLeftType2 int(10) ,
sSeatsLeftOfType2 varchar(150),
iPriceOfType2 int(10),

        	   iSeatsLeftType3 int(10) , 
sSeatsLeftOfType3 varchar(150),
iPriceOfType3 int(10),

	   iMovieID int(10) NOT NULL REFERENCES tMovies(iMovieID)  ON DELETE CASCADE, 
	   PRIMARY KEY(iMovieTimingID)); 


drop table tTicket;

 CREATE TABLE IF NOT EXISTS tTicket( 
	   iTicketID int(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	   iAmountPaid int(10) NOT NULL, 
	   iNumberOfTicketsBought int(10) NOT NULL, 
	   iSubscriberID int(10) NOT NULL REFERENCES tSignUpSubscriber(iSubscriberID)  ON DELETE CASCADE, 
iMovieTimingID int(10) NOT NULL REFERENCES tMovieTimings(iMovieTimingID) ON DELETE SET NULL, 
	   PRIMARY KEY(iTicketID)); 



drop table if exists tSignUpSubscriber;

 CREATE TABLE IF NOT EXISTS tSignUpSubscriber( 
	   iSubscriberID int(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	   sName varchar(45) NOT NULL , 
	   sEmail varchar(45) NOT NULL UNIQUE, 
	   sPassword varchar(45) NOT NULL , 
	   sPhoneNumber int(10) NOT NULL, 
	   sAddress  varchar(100) DEFAULT NULL, 
	   iDOB date NOT NULL, 
	   iBalance int(10) NOT NULL,
 	   iRegistrationStatus int(10) ,

	   PRIMARY KEY(iSubscriberID));




drop table tTicket;

 CREATE TABLE IF NOT EXISTS tTicket( 
	   iTicketID int(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	   iAmountPaid int(10) NOT NULL, 
	   iNumberOfTicketsBought int(10) NOT NULL, 
	   sSeatNumber varchar(100) NOT NULL,
	   sClass varchar(50) NOT NULL,
	   dDate Date NOT NULL, 
	   sTime varchar(50) NOT NULL,
	   sPaidStatus varchar(50) NOT NULL,
	   iSubscriberID int(10) NOT NULL REFERENCES tSignUpSubscriber(iSubscriberID)  ON DELETE CASCADE, 
iMovieTimingID int(10) NOT NULL REFERENCES tMovieTimings(iMovieTimingID) ON DELETE SET NULL, 
	   PRIMARY KEY(iTicketID)); 



