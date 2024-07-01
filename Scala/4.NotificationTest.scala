/* 4. Write the program to illustrate the use of pattern matching in scala, for the following
Matching on case classes.

Define two case classes as below:
abstract class Notification
case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification
Define a function showNotification which takes as a parameter the abstract type Notification and matches on the type of Notification (i.e. it figures out whether it’s an Email or SMS).
In the case it’s an Email(email, title, _) return the string: s"You got an email from $email with title: $title“
In the case it’s an SMS return the String: s"You got an SMS from $number! Message: $message“
*/
// Define an abstract class and case classes
abstract class Notification
case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification

// Function to show notification based on the type of Notification
def showNotification(notification: Notification): String = {
  notification match {
    case Email(email, title, _) =>
      s"You got an email from $email with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
  }
}

object NotificationTest {
  def main(args: Array[String]): Unit = {
    val emailNotification = Email("sender@example.com", "Meeting reminder", "Don't forget our meeting tomorrow!")
    val smsNotification = SMS("+1234567890", "Reminder: Meeting tomorrow at 10 AM")

    // Displaying notifications
    println(showNotification(emailNotification))
    println(showNotification(smsNotification))
  }
}
