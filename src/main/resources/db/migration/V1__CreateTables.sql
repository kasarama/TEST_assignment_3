CREATE TABLE customers (
                           id serial4 NOT NULL,
                           birthdate date NULL,
                           first_name varchar(255) NULL,
                           last_name varchar(255) NULL,
                           CONSTRAINT customers_pkey PRIMARY KEY (id)
);

CREATE TABLE employees (
                           id serial4 NOT NULL,
                           birthdate date NULL,
                           first_name varchar(255) NULL,
                           last_name varchar(255) NULL,
                           CONSTRAINT employees_pkey PRIMARY KEY (id)
);

CREATE TABLE bookings (
                          id serial4 NOT NULL,
                          customer_id int4 NULL,
                          booking_date date NOT NULL,
                          employee_id int4 NULL,
                          end_time time NOT NULL,
                          start_time time NOT NULL,
                          CONSTRAINT bookings_pkey PRIMARY KEY (id)
);