## Shop

Goal: Practice OO modelling in Java (unit tests, no UI)

You are required to build an app that allows a Shop to sell goods to a Customer. Stock and items are not important.

### MVP
The Shop must be able to:

* Make a Sale
  - The customer funds go down, shop sales go up
* Give a refund
  - The customer funds go up, shop refunds go up
* Report on income
  - Total sales minus total refunds

The Customer must:

* Have a collection of possible Payment Methods:
  - CreditCard (default), DebitCard
* Be able to select a Payment Method to pay at any Shop
* Be able to select a Payment Method to receive a refund onto a given Payment Method

(You may find HashMaps useful for this project)

### Project Extensions

* Add stock tracking
