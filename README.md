# Restaurant_Management_Syatem
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
</center>
This is a Spring Boot project for managing restaurants and user can order food online.

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Language Used
* Java

---
<br>

## Data Model

* User model
```
private Integer userId;
private String userFirstName;
private String userLastName;
private String userPhoneNumber;
private String userEmail;
private String userPassword;
```
* Admin model
```
private Integer adminId;
private String adminName;
private String adminEmail;
private String adminPassword;

```
* Restaurant model
```
private Integer restaurantId;
private String restaurantName;
private String restaurantAddress;
private List<Food> food;
```

* Food model
```
private Integer foodId;
private String title;
private String description;
private Integer price;
```

* Order Food model
```
private Integer orderId;
private Food food;
private Restaurant restaurant;
private User user;
private Integer orderQuantity;
private String userAddress;
private OrderStatus status;
```

### Validation

To validate the input we get from client, we've used validation annotations that are used to enforce specific constraints on the values of the variables. These constraints ensure that the data input by the user is of the correct format and meets certain criteria.

* @Valid - In Spring Framework, the @Valid annotation is used in conjunction with @PostMapping and @PutMapping annotations, which are used to handle POST and PUT requests, respectively. When used with @PostMapping or @PutMapping, the @Valid annotation is typically applied to a method parameter annotated with @RequestBody.

* @NotEmpty: This annotation is used to validate that the annotated field is not null or empty. 

* @NotNull: This annotation is used to validate that the annotated field is not null.

* @Pattern: It is used to validate that the code field matches the regular expression pattern
---
<br>

## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points (Event)
### User
```
1. @PostMapping("signup"): user for signup 
2. @PostMapping("signin"): used for signin 
3. @PutMapping("{userEmail}/{token}"): used updated the information of user
```

### Admin
```
1. @PostMapping("admin): create admins
2. @GetMapping("users/{adminEmail}"): Admin can have access to get all the users
3. @PutMapping("order/{orderId}/status/{orderStatus}"): only admin can change the status of the Order 
```

### Resataurant
```
1. @PostMapping("/add/{adminEmail}"): Only admin can have the access to add restaurants
2. @PutMapping("update/{adminEmail}"): Updated the information about the restaurants
3. @DeleteMapping("{adminEmail}/delete/{id}"): Only admin can delete the restaurants
```

### Visistor
```
1. @GetMapping("visitor"): Visitors can only see information about resataurants
2. @GetMapping("menu/{restaurantId}"): Visitors can only see the menu of the resataurants
```
### Order
```
1. @PostMapping("{userEmail}/{token}"): only signed in user can place the orders
```


## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary
The Restaurants Management System is a Spring Boot project written in Java that enables basic functionality for managing restaurants and placing online orders. This project is built using the Spring Boot framework. 
