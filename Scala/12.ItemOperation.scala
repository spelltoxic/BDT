/*12. For the below given collection of items with item names and quantity, write the scala code for the given statement. Items = {(“Butter”:20), (“Bun”:10), (“Egg”:7), (“Biscuit”:25),(“Bread”:15)}

i.  Display item-name and quantity

ii. Display sum of quantity and total number of items

iii. Add 3 Buns to the collection

iv. Add new item “Cheese” with quantity 12 to the collection */

object ItemOperations {
  def main(args: Array[String]): Unit = {
    // Given collection of items as a Map
    var items = Map("Butter" -> 20, "Bun" -> 10, "Egg" -> 7, "Biscuit" -> 25, "Bread" -> 15)
    
    // i. Display item-name and quantity
    println("Items in the collection:")
    items.foreach { case (item, quantity) =>
      println(s"$item : $quantity")
    }
    
    // ii. Display sum of quantity and total number of items
    val totalQuantity = items.values.sum
    val totalItems = items.size
    println(s"\nTotal Quantity: $totalQuantity")
    println(s"Total Number of Items: $totalItems")
    
    // iii. Add 3 Buns to the collection
    items += ("Bun" -> (items.getOrElse("Bun", 0) + 3))
    
    // iv. Add new item "Cheese" with quantity 12 to the collection
    items += ("Cheese" -> 12)
    
    // Display the updated collection after additions
    println("\nUpdated Items in the collection after additions:")
    items.foreach { case (item, quantity) =>
      println(s"$item : $quantity")
    }
  }
}
