@SceTest
Feature: Acceder al sitio para agregar un producto y finalizar el proceso de compra, completando el formulario.
  COMO un usuario final del merchant portal
  QUIERO acceder al sitio y seleccionar un producto
  PARA finalizar el proceso y obtener el numero de orden
  
  	@Regression @Compra
	  Scenario: Se agrega un producto a la cesta de compra
	  	Given accedo al Store del sitio de demoblaze
	    And ingreso a la categoria Phones del home page
	    And selecciono el primer telefono de la lista
	    When lo agrego al carro de compra
	    And accedo al carro de compra
	    When se agrego el producto a la grilla
	    And completo los datos requeridos de la compra
	    Then se confirma el proceso de compra
