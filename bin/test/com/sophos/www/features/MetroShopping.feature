#Author: pedromtrivino@gmail.com
Feature: Agregar compra al carrito

  Scenario: Compra Satisfactoria
    Given Pedro ingresa a la pagina de metro
    When Selecciona un Play 4 para agregar al carro de compras
    Then El producto es agregado satisfactoriamente al carro de compras