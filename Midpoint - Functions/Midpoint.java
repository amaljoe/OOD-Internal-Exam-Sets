// 2.Write a method named hasMidpoint that accepts three integers as parameters and returns true 
// if one of the integers is the midpoint between the other two integers; that is, if one integer 
// is exactly halfway between them. Your method should return false if no such midpoint relationship 
// exists.The integers could be passed in any order; the midpoint could be the 1st, 2nd, or 3rd. 
// You must check all cases.

public class Midpoint {
    public static boolean hasMidpoint(int n1, int n2, int n3) {
        if((n1 + n2) / 2 == n3 || (n1 + n3) / 2 == n2 || (n2 + n3) / 2 == n1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(hasMidpoint(4, 6, 8));
        System.out.println(hasMidpoint(2, 10, 6));
        System.out.println(hasMidpoint(8, 8, 8));
        System.out.println(hasMidpoint(25, 10, -5));
        System.out.println(hasMidpoint(3, 1, 3));
        System.out.println(hasMidpoint(1, 3, 1));
        System.out.println(hasMidpoint(21, 9, 58));
        System.out.println(hasMidpoint(2, 8, 16));
    }
}
