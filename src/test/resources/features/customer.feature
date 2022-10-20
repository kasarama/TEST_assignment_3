Feature:
  It must be possible to create customers

  Scenario: Customers data are saved in database
    Given Firstname "Magdalena", lastname "Wawrzak" and birthday "14-04-1922"
    When Creating new Customer
    Then New Customer is created with firstname "Magdalena", lastname "Wawrzak", birthday "14-04-1922" and new id

