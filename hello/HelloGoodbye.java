/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     16/02/2020
 **************************************************************************** */

/* Takes two names as command-line arguments and prints hello and goodbye
messages as shown below (with the names for the hello message in the same order
as the command-line arguments and with the names for the goodbye message in
reverse order.

~/Desktop/hello> javac HelloGoodbye.java

~/Desktop/hello> java HelloGoodbye Kevin Bob
Hello Kevin and Bob.
Goodbye Bob and Kevin.

~/Desktop/hello> java HelloGoodbye Alejandra Bahati
Hello Alejandra and Bahati.
Goodbye Bahati and Alejandra. */

public class HelloGoodbye {
    public static void main(String[] args) {

        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");

    }
}
