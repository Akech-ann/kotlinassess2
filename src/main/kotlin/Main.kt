fun main() {
    println(analyzeString("ann"))
    println(validPassword("password"))
    println(validPassword("montanaann5"))
    println(printMultiples())


    var  current = CurrentAccount(23745465,"Akech",234566.0)
     current.deposit(4543545.0)
    current.withdraw(56856.0)
     current.details()


    var savings = SavingsAccount(23745465,"Akech",234566.0)
    savings.deposit(336432.0)
    savings.withdraw(32737.0)
    savings.details()

}

//Write and invoke one function that takes in a random string and returns the
//following values: first character, last character, length of the string and
//whether it begins with a vowel or not. (6pts)

fun analyzeString(str: String): Triple<Char, Char, Int> {
        val firstChar = str.first()
        val lastChar = str.last()
        val length = str.length

        return Triple(firstChar, lastChar, length)
    }

//2. Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
//1. Must be at least 8 characters long
//2. Must be at most 16 characters long
//3. Must not be “password”
//4. Must contain a digit
//Your function should determine whether the password provided is valid or not.
//The function returns true/false (7pts)

fun validPassword(password: String): Boolean {
    if (password == "password") {
        return false
    }
    if (password.length < 8 || password.length > 16) {
        return false
    }
    if (!password.any { it.isDigit() }) {
        return false
    }
    return true
}

//question3
//Create a function that prints out multiples of 6 and 8 between 1 and 1000. For
//multiples of both 6 and 8 it should print out “Bingo!” (5pts)

fun printMultiples() {
    for (i in 1..1000) {
        if (i % 6 == 0 && i % 8 == 0) {
            println("Bingo!")
        } else if (i % 6 == 0) {
            println("$i is a multiple of 6")
        } else if (i % 8 == 0) {
            println("$i is a multiple of 8")
        }
    }
}


//question 4
//Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
//a. deposit(amount: Double) - Increments the balance by the amount
//deposited
//b. withdraw(amount: Double) - Decrements the balance by the amount
//withdrawn
//c. details() - Prints out the account number and balance and name in
//this format: “Account number x with balance y is operated by z” (6pts)


class CurrentAccount(val accountNumber: Int, val accountName: String, var balance: Double) {

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if (balance < amount) {
            println("Insufficient balance")
        } else {
            balance -= amount
        }
    }

    fun details() {
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }
}
//question 5
class SavingsAccount(val accountNumber: Int, val accountName: String, var balance: Double) {
    var withdrawals: Int = 0

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if (withdrawals >= 4) {
            println("Maximum number of withdrawals reached for the year")
        } else if (balance < amount) {
            println("Insufficient balance")
        } else {
            balance -= amount
            withdrawals++
            println("Withdrawal successful")
        }
    }
    fun details(){
        println("Account number $accountNumber with $balance savings is operated by $accountName")
    }
}






