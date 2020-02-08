CREATE DATABASE dev_profiles_db;

CREATE TABLE profiles_table (
	id integer primary key,
	username character varying(200),
	job_title character varying(200),
	department character varying(200),
	company character varying(200),
	skill character varying(200)
)

CREATE TABLE accounts (
	id integer primary key,
	first_name character varying(200),
	last_name character varying(200),
	city character varying(200),
	gender character varying(200),
	username character varying(200)
)

ALTER TABLE profiles_table RENAME TO profiles;


1. SELECT profiles.* FROM accounts 
INNER JOIN profiles ON profiles.id = accounts.id
WHERE profiles.department = 'Support'
ORDER BY profiles.skill;

2. select job_title, count(job_title) as number_of_repetitions 
from profiles 
group by job_title
having count (job_title) >= 3;

3. select accounts.first_name, accounts.last_name, accounts.city, profiles.job_title, profiles.company
from accounts 
inner join profiles on profiles.id = accounts.id
where accounts.city = 'Frederiksberg';

4. select count(accounts.username), profiles.department
from profiles
inner join accounts on profiles.id = accounts.id
group by profiles.department
order by count desc
limit 1; 

5. select count(profiles.id) as number_of_profiles, profiles.job_title
from profiles
inner join accounts on profiles.id = accounts.id
group by profiles.job_title
order by count(profiles.id) desc; 

6. select * from accounts
order by city;

7. update profiles 
set job_title = 'Developer'
where job_title similar to 'Engineer %';
