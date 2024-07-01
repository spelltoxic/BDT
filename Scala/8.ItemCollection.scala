/*8. For the below given collection of items with item-names and quantity, write the scala code for the given statement.

Items = {(“Pen”:20), (“Pencil”:10), (“Erasor”:7), (“Book”:25), (“Sheet”:15)}

i.           Display item-name and quantity

ii.          Display sum of quantity and total number of   items

iii.       Add 3 Books to the collection

Add new item “Board” with quantity 15 to the collection
*/

object ItemCollection {
  def main(args: Array[String]): Unit = {
    // Define the initial collection of items as a Map
    var items = Map("Pen" -> 20, "Pencil" -> 10, "Eraser" -> 7, "Book" -> 25, "Sheet" -> 15)
    
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
    
    // iii. Add 3 Books to the collection
    items += ("Book" -> (items.getOrElse("Book", 0) + 3))
    
    // Add new item "Board" with quantity 15 to the collection
    items += ("Board" -> 15)
    
    // Display the updated collection after additions
    println("\nUpdated Items in the collection after additions:")
    items.foreach { case (item, quantity) =>
      println(s"$item : $quantity")
    }
  }
}
