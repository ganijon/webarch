# Project: MVC Web Application Architecture  

## Objective:

  The objective of this project is to gain practical experience with building web application architecture using Spring MVC Framework.

## Domain

  The Coffee House.

## Technology Stack

  Spring Boot, Spring MVC, Spring Data, Spring Security, Spring REST, Thymeleaf, Bootstrap, MySql, GlassFish, Ubuntu.

## Implementation Plan

### 1. Design Web Application Architecture
  
  MySql database to persist data
  
  REST API to perform the operations and manage the entities
    
  Web application to interact with users and consume REST API services
    
#### 2. Create REST API application with the services to:

    Create, List, Delete, Update Products

    Create, List, Update Registered Users

    Create and List Orders

#### 3. Create web application with pages to:

    Self-register new Users
    
    Sign-in and Sign-out
    
    Create, List, Delete, Update Products

    Create, List, Update Registered Users

    Create and List Orders
    
#### 4. Role-based Access Control
  
  All visitors can access public area to:
    
    List products
    
    Self-register 
    
  Registered Users can sign-in to:

    Select products to place orders

    Update their personal information

  Administrators can login to:

    Maintain the list of products

    Create and List users

    List Orders

#### 5. Explore migration to Microservices architecture
