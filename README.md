[RecipesCollection.postman_collection.json](https://github.com/GreenRiverCollege-SDEV372/372-spring-project-f23-Nathan-Waters/files/14143937/RecipesCollection.postman_collection.json)# Food Suggestion Guide

<img src="src/main/resources/static/images/food-pic.jpg" alt="Image" width="300">

## Project Properties
- **Author:** Nathan Waters
- **Class:** DEV 372
- **Winter 2024**

## Milestones
- Project Creation
- Writing a Web API
- Consuming a Web API
- Integrating Public APIs
- Deploying to the Cloud

## Project Description
This will be an app that allows the user to select a few ingredients they have and be given
a few options to choose from.

[Uploadin{
	"info": {
		"_postman_id": "0c359164-4f35-4741-84e7-6d264308bd3d",
		"name": "RecipesCollection",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "32287800"
	},
	"item": [
		{
			"name": "Recipes",
			"item": [
				{
					"name": "Get Random Recipe",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/recipes/random",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"recipes",
								"random"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get all Recipe",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"name\": \"Homemade potato\",\r\n  \"url\": \"https://example.com/homemade-pizza\",\r\n  \"author\": \"Chris Miller\",\r\n  \"ingredients\": [\r\n    \"Pizza dough\",\r\n    \"Tomato sauce\",\r\n    \"Cheese\",\r\n    \"Pepperoni\"\r\n  ],\r\n  \"method\": [\r\n    \"Roll out pizza dough.\",\r\n    \"Spread tomato sauce and add toppings.\",\r\n    \"Bake in the oven.\"\r\n  ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/recipes/all",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"recipes",
								"all"
							]
						}
					},
					"response": []
				},
				{
					"name": "Create Recipe",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"New Thing\",\r\n    \"url\": \"https://example.com/vegetarian-stir-fry\",\r\n    \"author\": \"Emily White\",\r\n    \"ingredients\": [\r\n        \"Tofu\",\r\n        \"Broccoli\",\r\n        \"Carrots\",\r\n        \"Soy sauce\"\r\n    ]\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/recipes",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"recipes"
							]
						}
					},
					"response": []
				},
				{
					"name": "Create Recipe(Bad Request)",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"id\": 11,\r\n    \"name\": \"\",\r\n    \"url\": \"https://example.com/vegetarian-stir-fry\",\r\n    \"author\": \"Emily White\",\r\n    \"ingredients\": [\r\n        \"Tofu\",\r\n        \"Broccoli\",\r\n        \"Carrots\",\r\n        \"Soy sauce\"\r\n    ],\r\n    \"method\": []\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/recipes",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"recipes"
							]
						}
					},
					"response": []
				},
				{
					"name": "Delete Recipe",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/recipes/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"recipes",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "Update  Recipe",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n        \"id\": 2,\r\n        \"name\": \"Chocolate\",\r\n        \"url\": \"https://example.com/chocolate-cake\",\r\n        \"author\": \"Jane Smith\",\r\n        \"ingredients\": [\r\n            \"1 cup flour\",\r\n            \"1 cup sugar\",\r\n            \"1/2 cup cocoa powder\",\r\n            \"1 tsp baking powder\"\r\n        ],\r\n        \"method\": [\r\n            \"Preheat oven to 350°F.\",\r\n            \"Mix dry ingredients.\",\r\n            \"Bake for 30 minutes.\"\r\n        ]\r\n    }",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/recipes/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"recipes",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "Update Recipe(Bad Request)",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n        \"id\": 2,\r\n        \"name\": \"\",\r\n        \"url\": \"https://example.com/chocolate-cake\",\r\n        \"author\": \"Jane Smith\",\r\n        \"ingredients\": [\r\n            \"1 cup flour\",\r\n            \"1 cup sugar\",\r\n            \"1/2 cup cocoa powder\",\r\n            \"1 tsp baking powder\"\r\n        ],\r\n        \"method\": [\r\n            \"Preheat oven to 350°F.\",\r\n            \"Mix dry ingredients.\",\r\n            \"Bake for 30 minutes.\"\r\n        ]\r\n    }",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/recipes/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"recipes",
								"1"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Reviews",
			"item": [
				{
					"name": "Get Random Review",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/reviews/all",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"reviews",
								"all"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get all Reviews",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/reviews/all",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"reviews",
								"all"
							]
						}
					},
					"response": []
				},
				{
					"name": "Create Review",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n\r\n        \"recipeName\": \"new new thing\",\r\n        \"stars\":12,\r\n        \"review\": \"Amazing homemade pizza! The crust is perfect, and the toppings are delicious.\"\r\n    }",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/reviews",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"reviews"
							]
						}
					},
					"response": []
				},
				{
					"name": "Update Recipe",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n\r\n        \"recipeName\": \"new new thing\",\r\n        \"stars\":12,\r\n        \"review\": \"Amazing homemade pizza! The crust is perfect, and the toppings are delicious.\"\r\n    }",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/reviews/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"reviews",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "Delete Review",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/reviews/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"reviews",
								"1"
							]
						}
					},
					"response": []
				}
			]
		}
	]
}g RecipesCollection.postman_collection.json…]()
