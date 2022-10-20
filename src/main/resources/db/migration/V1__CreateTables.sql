-- public.customers definition

-- Drop table

-- DROP TABLE public.customers;

CREATE TABLE customers (
                                  id serial4 NOT NULL,
                                  birthdate date NULL,
                                  first_name varchar(255) NULL,
                                  last_name varchar(255) NULL,
                                  mobile varchar(255) NULL,
                                  CONSTRAINT customers_pkey PRIMARY KEY (id)
);


-- public.employees definition

-- Drop table

-- DROP TABLE public.employees;

CREATE TABLE employees (
                                  id serial4 NOT NULL,
                                  birthdate date NULL,
                                  first_name varchar(255) NULL,
                                  last_name varchar(255) NULL,
                                  CONSTRAINT employees_pkey PRIMARY KEY (id)
);


-- public.bookings definition

-- Drop table

-- DROP TABLE public.bookings;

CREATE TABLE bookings (
                                 id serial4 NOT NULL,
                                 customer_id int4 NULL REFERENCES customers(id),
                                 booking_date date NOT NULL,
                                 employee_id int4 NULL REFERENCES public.employees(id),
                                 end_time time NOT NULL,
                                 start_time time NOT NULL,
                                 CONSTRAINT bookings_pkey PRIMARY KEY (id)
);