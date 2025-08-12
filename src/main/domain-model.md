# Bobs bagel

## Classdiagram
![img_1.png](img_1.png)

## Basket
| Classes | Members                     | Methods                       | Scenario                 | Output                        | 
|---------|-----------------------------|-------------------------------|--------------------------|-------------------------------|
| Basket  | customerBasket: List\<Item> |                               |                          |                               | 
|         | capacity: int               |                               |                          |                               |
|         |                             | getAllItems()                 | at least one item        | return all items              |
|         |                             |                               | empty                    | return nothing                |
|         |                             | getCap()                      |                          | return capacity               |
|         |                             | setCapacity(int newCap)       | newCap > capacity        | change capacity               |
|         |                             |                               | newCap <= capacity       | do not change capacity        |
|         |                             | isFull()                      | basket is full           | return true                   |
|         |                             |                               | basket is not full       | return false                  |
|         |                             | getRemainingCapacity()        |                          | return capacity - basket.size() |
|         |                             | addItem(Item item, Inventory) | item is in inventory     | add to basket                 |
|         |                             |                               | item is not in inventory | do not add to basket          |
|         |                             |                               | basket is full           | do not add to basket          |
|         |                             | removeItem(Item item)         | item is in basket        | remove from basket            |
|         |                             |                               | item is not in basket    | do nothing                    |
|         |                             |                               | basket is empty          | do nothing                    |
|         |                             | calculateTotalCost()          | basket is empty          | return 0                      |
|         |                             |                               | basket is not empty      | calculate cost and return     |

## User
| Classes | Members          | Methods                                         | Scenario                         | Output                       | 
|---------|------------------|-------------------------------------------------|----------------------------------|------------------------------|
| User    | name: String     |                                                 |                                  |                              | 
|         | DEFAULT_CAP: int |                                                 |                                  |                              |
|         | basket: Basket   |                                                 |                                  |                              |
|         |                  | getName()                                       | name given                       | return name                  |
|         |                  |                                                 | no name given                    | returns no name              |
|         |                  | getBasket()                                     | empty basket                     | no basket returned           |
|         |                  |                                                 | basket has at least one item     | return basket with items     |
|         |                  | addItemToBasket(Item item, Inventory inventory) | item exists in inventory         | add item to basket           |
|         |                  |                                                 | item does not exist in inventory | item is not added to basket  |
|         |                  |                                                 | basket is full                   | item is not added to basket  |
|         |                  | removeItemFromBasket(Item item)                 | item exists in basket            | remove said item from basket |
|         |                  |                                                 | item does not exist in basket    | item is not removed          |
|         |                  |                                                 | basket is empty                  | nothing is done              |


## Manager
### Does everything a User can do, but also has some extra accesses as shown below
| Classes | Member              | Methods                      | Scenario                     | Output                                         | 
|---------|---------------------|------------------------------|------------------------------|------------------------------------------------|
| Manager | name: String        |                              |                              |                                                |
|         | Inventory inventory |                              |                              |                                                |
|         |                     | changeCapacity(int capacity) | capacity > oldCapacity       | change capacity to new capacity                | 
|         |                     |                              | capacity <= oldCapacity      | return message to show new capacity is too low | 
|         |                     | isInInventory(Item item)     | fillings is in inventory     | make bagel and serve customer                  | 
|         |                     |                              | fillings is not in inventory | tell customer that filling is not available    |

## Customer
### Does everything a User can do, but also has some extra accesses as shown below
| Classes  | Member         | Methods                                                | Scenario                    | Output                                         |
|----------|----------------|--------------------------------------------------------|-----------------------------|------------------------------------------------|
| Customer | name:String    |                                                        |                             |                                                |
|          |                | totalCostOfBasket(Basket basket)                       | emptyBasket                 | show 0                                         |    
|          |                |                                                        | at least one item in basket | calculate cost                                 |    
|          |                | showCostBeforeAdding(Items item (bagels and fillings)) | valid item                  | show cost                                      |    
|          |                |                                                        | not valid item              | tell item is not valid                         |    
|          |                | choseFillingsForBagel()                                | fillings in inventory       | add fillings to basket                         |    
|          |                |                                                        | fillings not in inventory   | inform customer that fillings not in inventory |


## MemberPublic
### Does everything a User can do, has no extra accesses
| Classes      | Member         | Methods                                         | Scenario                         | Output                       |
|--------------|----------------|-------------------------------------------------|----------------------------------|------------------------------|
| MemberPublic | name: String   |                                                 |                                  |                              |
|              | basket: Basket |                                                 |                                  |                              |              
|              |                | addItemToBasket(Item item, Inventory inventory) | item exists in inventory         | add item to basket           |
|              |                |                                                 | item does not exist in inventory | item is not added to basket  |
|              |                |                                                 | basket is full                   | item is not added to basket  |
|              |                | removeItemFromBasket(Item item)                 | item exists in basket            | remove said item from basket |
|              |                |                                                 | item does not exist in basket    | item is not removed          |
|              |                |                                                 | basket is empty                  | nothing is done              |

## Items
| Classes | Member          | Methods      | Scenario              | Output         |
|---------|-----------------|--------------|-----------------------|----------------|
| Items   | SKU: String     |              |                       |                |
|         | Price: float    |              |                       |                |    
|         | name: String    |              |                       |                |    
|         | Variant: String |              |                       |                |    
|         |                 | getSKU()     | SKU available         | return SKU     |    
|         |                 |              | SKU not available     | return nothing |    
|         |                 | getPrice()   | Price available       | return price   |    
|         |                 |              | price not available   | return nothing |    
|         |                 | getName()    | name available        | return name    |
|         |                 |              | name not available    | return nothing |
|         |                 | getVariant() | variant available     | return variant |
|         |                 |              | variant not available | return nothing |    

## Inventory
| Classes   | Member                 | Methods                   | Scenario                         | Output           |
|-----------|------------------------|---------------------------|----------------------------------|------------------|
| Inventory |                        |                           |                                  |                  | 
|           | inventory: List\<Item> |                           |                                  |                  | 
|           |                        | isInInventory(String sku) | item exists in inventory         | return true      | 
|           |                        |                           | item does not exist in inventory | return false     | 
|           |                        | getItem(String sku)       | item is in inventory             | return said item | 
|           |                        |                           | item is not in inventory         | return null      | 

