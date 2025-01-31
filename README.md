
# Spring Data JPA





## persistence layer 

- It contains set of classes & interfaces to communicate with database.

- In java, we have several options to develop persistence layer

			1) JDBC
			2) Hibernate ORM
			3) Spring JDBC
			4) Spring ORM
			5) Spring Data JPA

Note: Spring Data JPA is the latest trend in the market to developer Persistence layer in java based applications.			


## Use Spring Data JPA 

- No need to write boilerplate code (duplicate)

- No need to write queries 

- Ready made methods support is available

				- save () - insert record into db table
				- findById ( )
				- findAll ( )
				- count ( )
				- deleteAll ( ) 

- Reducing development time


## ORM (Object relational mapping)

- ORM stands for Object relational mapping

- It is a technique to map java objects with database tables.

- Using ORM we can deal with objects to perform DB operations.

- When we are using ORM framworks we no need to map java classes with database tables.

			User.java     ============>  USER_TBL

			Product.java  ============>  PRODUCT_TBL

Note: The java class which is mapped with database table is called as Entity class.


			Entity class  ---------> db table

			Entity class variables -----> db tbl columns

			Entity class obj ------> db tbl row


- We will use below annotations to create Entity classes


@Entity : Represent java class as an Entity class.

@Table : To map java class name with table name (Optional)

@Id  : Represents entity variable mapped with PK column in table

@Column	: To map java class variables with table column names  (optional)


## Jpa Repository ?


- Data JPA provided repository interfaces to simplify Persistence layer development.

			a) CrudRepository
			b) JpaRepository (more features)

Note: To perform DB operations we will create interface by extending from JpaRepository.

- ***JpaRepository = CrudRepository + Pagination + Storting + QueryByExample***



### Developing First Data JPA Application 


1) DB Setup (database MySQL Workbench)

- show databases;

- create database Rollower(**DatabaseName**);

- use Rollower;

- show tables;

2) Create Spring Boot application with below dependencies

		a) data-jpa-starter
		b) mysql-driver

3) Configure Datasource properties in application.properties

	   spring.datasource.username=root
       spring.datasource.password=9928
	   spring.datasource.url=jdbc:mysql://localhost:3306/Rollower

	   spring.jpa.hibernate.ddl-auto=update
       spring.jpa.show-sql=true

4) Create Entity class (class to table mapping)

5) Create Repository interface (CrudRepository/JpaRepository)

6) Create Service class and inject Repository interface

7) Test service class methods from start class.

		@@ save ( ) = insert + update ==> upsert 		

## Crud Repository Methods (12)


- CrudRepository is a spring data jpa repositry interface

- CrudRepository providing methods to perform crud operation

- To use crud repo methods we need to extend properties

      - save(T) : one object for Upsert

      saveAll(Iterable T) : Collection of objects for upsert

      findById(ID id) : To retrieve record based on given pk value

      findAllById(Iterable ids) : Retrieve records based on given pks

      findAll( ) : Retrieve all records from table

      existsById(ID id) : To check record presence in table

      count () : To get total no.of records

      deleteById(ID id) : To delete record based on given pK

      deleteAllById(Iterable ids) : Delete multiple records based on pks

      delete(T entity) : Delete record based on given entity obj

      deleteAll(Iterable entities) : delete records based on entities

      deleteAll ( ) : To delete all records from table



## findByXXX methods	


- findBy methods are used to retrieve records based on non-primary key column values

- *Note : findBy methods are used for select operations only*

	  // select * from employee where ename=:ename
	  public List<Employee> findByEname(String ename);
	

	  // select * from employee where esalary=:esalary
	  public List<Employee> findByEsalary(Double salary);


	  //select * from employee where esalary >= :esalary
	  public List<Employee> findByEsalaryGreaterThanEqual(Double salary);


## Custom Queries	

- Executing our own queries using data jpa.

- To work with custom queries, we will use **@Query** annotation

- Custom Queries we can write in 2 ways

			1) Native SQL (plain sql)
			2) HQL 


### SQL Queries

-  SQL Queries are db dependent queries. 

- In SQL query we will use table names and column names directley

	  Ex: select * from emp_tbl where emp_sal <= 10000.00

- Note: If we want to change from one DB to another DB then we have to modify SQL queries and we have to re-test entire application.

- To make our application loosely coupled with database we can use HQL queries.


### HQL Queries

- HQL stands for hibernate query language. 

- HQL queries are database independent.

- HQL queries will make our app loosely coupled with database.

- In HQL queries we will use entity class name and entity variable names.

		Ex: From Employee where esal=1000.00

- *Note:* Database can't understand HQL directley

- HQL should be converted to SQL for execution.	

- Dialect classes are used to convert HQL to SQL.

- Every DB will have its own dialect class

		Ex: OracleDialect, MySQLDialect......		

- SQL and HQL Queries

      SQL : select * from  emp_tbl
      HQL : From Employee

      SQL : select * from emp_tbl where emp_id=101
      HQL : From Employee where eid=101 	

      SQL : select emp_id, emp_name from emp_tbl	
      HQL : select eid, ename from Employee


-

     public interface EmpRepository extends CrudRepository<Employee, Integer> {

	@Query("from Employee")
	public List<Employee> getAllEmpsHQL();

	@Query("from Employee where eid=:id")
	public Employee getEmpById(Integer id);
	
	@Query(value = "select * from employee", nativeQuery = true)
	public List<Employee> getAllEmpsSQL();

	// select * from employee where ename=:ename
	public List<Employee> findByEname(String ename);

	// select * from employee where esalary=:esalary
	public List<Employee> findByEsalary(Double salary);

	// select * from employee where esalary >= :esalary
	public List<Employee> findByEsalaryGreaterThanEqual(Double salary);
     }


### better SQL or HQL.

=> Performance wise SQL is better

=> Flexibility wise HQL is better


## *JpaRepository*


=> This is predefined data jpa interface

=> It is providing several methods to perform DB ops

	JpaRepo = CrudRepo + Pagination + Sorting + QBE



## Pagination

- Divide total records into multiple pages for display.	

	- decide page size (how many records shud display)

	- calculage no.of pages required

Scenario-1 : 
	
		- Total records in db tbl : 50
		- page size : 10		
		- total pages = total-records/page-size	 => 5 pages


		
## Sorting	


- Soring the records in ascending or descending order

  Ex: display mobile based on price high to low

  display emps based on salary low to high	



## QBE (Query By Example)

- It is used to construct query dynamically

- It is used to implement dynamic search functionalities




## Timestamping

- It is  used to populate record creation date and record updated date.

- We will use below annotations in entity class to enable timestamping

		@CreationTimestamp
		@UpdateTimestamp

----------------------------------------------------
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;

-----------------------------------


## Generators


- Generators are used to set the value for primary key columns

		@@ Primary Key = Not null + unique contrains

- Primary key is used to maintain unique records in table

- For every table atleast one primary key is required.


### Generator Strategies


- table : it will maintain seperate table for pks

- identity : it supports auto_increment (mysql)

- sequence : it supports db sequences (oracle)

- uuid : alpha-numeric value for pk (datatype string)

   
	   @Id
	   @GeneratedValue(strategy = GenerationType.UUID)
	   private String pid;


### Composite Primary keys


- If table is having more than one primary key then it is called as composite primary key


      create table person(
	   pid   int(10),
	   name  varchar(100),
	   email varchar(100),
	   primary key(pid, passport)
                                   )


## Database Relationships

- We can see below relationship with db tables

1) **One To One**

- Note: One record in parent table will have relationship with one record in child table.

	  Ex: One person will have one passport.

2) **One To Many**

- Note: One record in parent table will have relationship with multiple records in child table. 

	  Ex: One Employee can have multiple addresses.

3) **Many To One**

- Note : Many records in one table will have relationship with one record.

	  Ex: Multiple Books belongs to one Author

4) **Many To Many**

	   Ex: Multiple Users will have multiple roles.

- Note: To represent Many To Many relationship we need 3 tables.	

	  Ex : users, roles, user_roles (join table)


- When DB tables having relationships then we have to represent those relationships in Entity classes which is called as **Association Mapping**.	

- To establish assocation mapping in entity classes we will use below annotations...

			- @OneToOne
			- @OneToMany
			- @ManyToOne
			- @ManyToMany
			- @JoinColumn
			- @JoinTable



**Cascade :**


- Parent table Operations should reflect on child table or not will be represented by **CASCADE.**	


**Fetch Type :**


- Fetch Type represents child records should be loaded along with parent record or not

=> We have below 2 fetch types

			- Lazy (default)

			- Eager

- Lazy means child records will be retrieved on demand basis.	

- Eager means child records will be retrieved along with parent record in single query.



## summary

1) What is ORM & why
2) What is Data JPA & Why ?
3) Data JPA Repositories
		- CrudRepository
		- JpaRepository
4) What is Entity
5) Data JPA Application
6) Crud Operations
7) Pagination & Sorting
8) Query By Example (QBE)
9) findByXXX methods
10) Custom Queries (@Query)
11) Native SQL vs HQL
12) Primary Keys & Generators
13) Composite Primary Key
		- @Embeddable
		- @EmbeddedId
14) Timestamping
		- @CreationTimestamp
		- @UpdateTimestamp
15) Transactions
		- @Transactional
16) Connection Pooling
17) Association Mapping 
18) Conclusion