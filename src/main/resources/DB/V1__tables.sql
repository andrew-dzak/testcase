create schema testcase;


CREATE TABLE IF NOT EXISTS testcase.event (
  id serial PRIMARY key,
  name varchar(150) NOT NULL ,
  start_date date not null,
  end_date date not null,
  venue point null,
  address varchar(150) NULL ,
  description text null,
  created_on_date timestamp not null default now()
);



insert into testcase.event (name,start_date,end_date,venue,address,description)
values('testCase','2020-10-02','2020-10-02',null,null,'testcase example');


CREATE TABLE IF NOT EXISTS testcase.fee(
  id serial PRIMARY key,
  min_band  decimal(19,6) null,
  max_band decimal(19,6) null,
  fee_amount decimal(19,6) null
);



insert into testcase.fee (min_band,max_band,fee_amount)
values(1,100,1.5);

CREATE TABLE IF NOT EXISTS testcase.event_ticket_category (
  id serial PRIMARY key,
  title varchar(150) NOT NULL ,
  price decimal (19,6) not null,
  fee_id  Integer null,
  discount decimal(19,6) null,
  number_of_tickets Integer NOT NULL,
  event_id Integer NOT NULL,
  start_date timestamp not null,
  end_Date timestamp not null ,
  reference_code varchar(200) not null,
  description text null,
  created_on_date timestamp not null default now(),
  CONSTRAINT fk_event_ticket_category_event FOREIGN KEY (event_id) REFERENCES testcase.event (id),
  CONSTRAINT fk_event_ticket_category_fee FOREIGN KEY (fee_id) REFERENCES testcase.fee (id)
);

