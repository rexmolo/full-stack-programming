# SQL Join exercise
#
use world;

#
# 1: Get the cities with a name starting with ping sorted by their population with the least populated cities first
#
select * from city
where name like "ping%"
order by population;

#
# 2: Get the cities with a name starting with ran sorted by their population with the most populated cities first
#
select * from city
where name like "ran%"
order by population desc;
#
# 3: Count all cities
#
select count(*) from city; 
#
# 4: Get the average population of all cities
#
select avg(population) from city;

#
# 5: Get the biggest population found in any of the cities
#
select max(population) from city;

#
# 6: Get the smallest population found in any of the cities
#
select min(population) from city;

select * from city
where population = 42;


############################# What is least();

#
# 7: Sum the population of all cities with a population below 10000
#
select sum(population) from city
where population < 10000;
#
# 8: Count the cities with the countrycodes MOZ and VNM
#
select count(*) from city
where CountryCode in ("MOZ","VNM");

#
# 9: Get individual count of cities for the countrycodes MOZ and VNM
#
select count(*),CountryCode from city
where CountryCode in ("MOZ","VNM") group by countrycode;
#
# 10: Get average population of cities in MOZ and VNM
#
select avg(population) from city
where CountryCode in ("MOZ","VNM");
#
# 11: Get the countrycodes with more than 200 cities
#

##################################################
#select count(*) as counting,countrycode from city
#where counting > 200
#group by CountryCode;

#select countrycode from city
#where max(city) < 200;
#limit = 200;


### Working
select count(CountryCode) as c from city
group by CountryCode having c>200;

#not working
# SELECT countrycode FROM city GROUP BY countrycode HAVING COUNT(city) > 200;

#
# 12: Get the countrycodes with more than 200 cities ordered by city count
#
select count(CountryCode) as c from city
group by CountryCode having c>200
order by c;

#
# 13: What language(s) is spoken in the city with a population between 400 and 500 ?
#
select language,Population from countrylanguage
join city
where population between 400 and 500
#where population between 400 and 1500
;

#
# 14: What are the name(s) of the cities with a population between 500 and 600 people and the language(s) spoken in them
#
select language,name,Population from countrylanguage
join city
where population between 500 and 600
;
#
# 15: What names of the cities are in the same country as the city with a population of 122199 (including the that city itself)
#
#select city.name from city
#join city
#where city.Population = 122199;

#select * from city;
#select * from country;
#select * from city
#where population >= 122199;

############################33
select city.*, country.name as city_name from city left join country
ON city.`CountryCode` = country.`Code`
where city.`Population` = 122199;



#
# 16: What names of the cities are in the same country as the city with a population of 122199 (excluding the that city itself)
select city.*, country.name as city_name from city left join country
ON city.`CountryCode` = country.`Code` 
where city.`Population` != 122199
and country.`Code` = (
select city.CountryCode from city left join country
ON city.`CountryCode` = country.`Code` 
where city.`Population` = 122199
)
#
# 17: What are the city names in the country where Luanda is capital?
#

select * from city where CountryCode=(
select CountryCode from city where `Name`="Luanda");

#
# 18: What are the names of the capital cities in countries in the same region as the city named Yaren
#
SET @r = (select ct.Region from city as c 
 join country as ct 
on c.CountryCode = ct.Code
where c.`Name`="Yaren");

select * from city where ID in (select Capital from country where Region=@r);

#
# 19: What unique languages are spoken in the countries in the same region as the city named Riga
SET @r = (select ct.Region from city as c 
 join country as ct 
on c.CountryCode = ct.Code
where c.`Name`="Riga");

Select Language,isOfficial from countrylanguage where CountryCode in (select Code from country where Region=@r);


#
# 20: Get the name of the most populous city
#
select * from city order by Population DESC limit 1;
