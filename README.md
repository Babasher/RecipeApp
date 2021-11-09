# RecipeApp
- This is an app that:
	- calculates calories of custom meals
	- stores your current resources in a 'pantry' table
		- will tell you if you have enough ingredients for a recipe
		- if you don't have enough, will tell you what you're missing in order to create that recipe
	
- The goal is to have a vast table of ingredients, that is filled with
many different items ranging from cheese to eggs to flour and so on. 

## Framework ##
Maven 
Spring Framework

## Dependencies ##
springboot-starter-web
springboot-starter-jpa
springboot-starter-test
mysql-connector-java

## To Do ##
- ~~Implement saveIngredient [x]~~
- ~~Implement getAllingredients [x]~~
- ~~Implement getIngredientByName [x]~~
- ~~custom exception class for ingredients that don't exist [x]~~
- ~~Implement updateIngredient [x]~~
- Implement deleteIngredient []


-Implement a pantry to store all of user's readily available ingredients
	

Notes: Look into cookies / Admin permission. In general the ingredients table are populated by Admins only.
Ingredients table should be very large, so all users of the app will have access to various ingredients. 

