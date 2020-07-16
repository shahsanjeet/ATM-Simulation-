
***********************************  USER  *****************************************************
-------------------------------- table 1--------------------------------------
drop table AccountHolder;

create table AccountHolder(
	userid number(10) primary key,
	cardNo varchar2(20),
	pinNo varchar2(20)
);

insert into AccountHolder (uid,cardNo,pinNo) values (1,'sdfasdf','12342');

	------------------- find gmail----------------------------
select userid from AccountHolder where cardno='8829997274';
select sno from additional_req where userid=2;
select email from person where sno=24;

**********         ***********         personal deteil    ***************    *******
	-------------------------------table 2----------------------

drop table person_req;

create table person_req(
	sno number(10) primary key,
	req_time timestamp
);
insert into person_req (sno,req_time) values ((select nvl(max(sno),0)+1 from person_req),sysdate);

	---------------------------table 3----------------------------
	drop table person;
	
	create table person (
	sno number(10) primary key,
	name varchar2(30),
	fname varchar2(30),
	dob date,
	gender varchar2(8),
	email varchar2(50),
	maritalstatus varchar2(10),
	address varchar2(50),
	city varchar2(20),
	pincode varchar2(6),
	state varchar2(20),
	foreign key (sno) references person_req (sno)
	);

	/*...... modify..........*/
	alter table person modify maritalstatus varchar2(10);
	
	insert into person (sno,name,fname,dob,gender,email,maritalstatus,address,city,pincode,state) values(1,'raj','chnTO_DATE('17/03/1997','DD/MM/YYYY'),'male','ladf@gmial.com','no','raipur','raipur','49210','cg')';
	select email from person where sno=2;
	
********************************        Additional detail      ***************************************************
	----------------------------  table 4      ------------------------
drop table additional_req;

create table additional_req(
sno number(10) primary key,
userid number(10),
req_time timestamp,
foreign key (userid) references AccountHolder(userid)
);

insert into additional_req (sno,userid,req_time) values (2,1,sysdate);

select sno from additional_req where userid=.....;

----------------------------------    table 5   -------------------------------------
create table additionDetail (
	userid number(10) primary key,
	sno number(10),
	religion varchar2(10),
	category varchar2(10),
	income varchar2(10),
	education varchar2(20),
	occupation varchar2(20),
	panNo varchar2(20), 
	adarNo varchar2(20), 
	seniorCitizen varchar2(20), 
	existingAc varchar2(10),
	foreign key (userid) references AccountHolder (userid),
	foreign key (sno) references additional_req (sno)
);

insert into additionDetail (userid,religion,category,income,education,occupation,panNo,adarNo,seniorCitizen,existingAc) values ();

******************************     acount details           ************************************
         --------------------      table 6           -------------------------

													     
/////////////////not use these account details													     
/*drop table account_req;

create table account_req(
	uid number(10) primary key,
	req_time timestamp,
	foreign key (uid) references person_req (uid)
);

insert into account_req (uid,req_time) values (1,sysdate);

--------------------         table 7          -----------------------
drop table AccountHolder;

create table AccountHolder(
	userid number(10) primary key,
	cardNo varchar2(20),
	pinNo varchar2(20)
);



insert into AccountHolder (uid,cardNo,pinNo) values (1,'sdfasdf','12342');

*/////////////////

-----------------------         tabele 8         -----------------
drop table accountDetail;
create table accountDetail(
	userid number(10) primary key,
	accountType varchar2(20),
	ATM_CARD varchar2(15),
	INTERNET_BANKING varchar2(15),
	MOBILE_BANKING varchar2(15),
	EMAIL_ALERTS varchar2(15),
	CHEQUE_BOOK varchar2(15),
	E_STATEMENT varchar2(15),
	cardNo varchar2(12) not null,
	confirm varchar2(10),
	foreign key (userid) references additionDetail(userid)
);

insert into accountDetail (userid,accountType,ATM_CARD,INTERNET_BANKING,MOBILE_BANKING,EMAIL_ALERTS,E_STATEMENT,CHEQUE_BOOK,cardNo,confirm) values (); 
insert into accountDetail (userid,accountType,ATM_CARD,INTERNET_BANKING,MOBILE_BANKING,EMAIL_ALERTS,E_STATEMENT,CHEQUE_BOOK,cardNo,confirm) values (12,'as','we','wer','wer','sdf','wew','sdf','weew','wer');
	
													     
													     
***************************      loginSignup      *****************************************************************
----------------------------                tabel 8          -------------------------------------
													     
create table logSignup(
logno number(5) primary key,
cardNo varchar2(20),
logTime timestamp
);

************************************            deposit                  *************************************************
-------------------------           table 9        --------------------------------------
drop table deposit;

create table deposit(
	dno number(10) primary key,
	cardNo varchar2(20),
	amount number(10,5),
	deposit_time timestamp
);
insert into deposit (userid,cardNo,amount,deposit_time) values ();


-----------------------------------------------deposit log ----------------------------------------------------------
		-----------------------------------            table 10  ------------------------------   -----------
drop table deposit_log;

create table deposit_log(
	dno number(10) primary key,
	cardNo varchar2(20),
	amount number(10,5),
	transaction varchar2(10),
	deposit_time timestamp
);
-----------------------------------------withdrol-----------------------------------------------------
================================================== tabel 11=======================================================================
drop table withdrol;

create table withdrol(
	dno naumber(10),
	cardNo varchar2(20),
	amount number(10,5),
	withdrol_time timestamp,
	foreign key (userid) references account_req (userid),
	foreign key (cardNo) references User (cardNo)
);

insert into withdrol (uid,cardNo,amount,withdrol_time) values ();

-------------------------------------------withdrol log------------------------------------------------------------
--------------table 12---------------------------------
drop table withdrol_log;

create table withdrol_log(
	dno naumber(10),
	cardNo varchar2(20),
	amount number(10,5),
	withdrol_time timestamp,
	foreign key (userid) references account_req (userid),
	foreign key (cardNo) references User (cardNo)
);
================================================== some important query for the Atmsimulation system======================
----------------- find gmail where cardno=....... ---------------------------------
select userid from AccountHolder where cardno='5443117608';
select sno from additional_req where userid=?;
select email from person where sno=?;

