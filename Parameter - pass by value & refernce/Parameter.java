// ii) Create a class named Parameter with two alternate functions specified below,
// of which each simply triples the variable count defined in main()
// (a) Function tripleByValue() passes a copy of count by value, triple the copy
// and returns the new value
// (b) Function tripleByReference() passes count by reference via a reference
// parameter triple the original value of count.
// Write a program to compare the two functions

class Parameter {
    int b;

    Parameter(int b) {
        this.b = b;
    }

    void triplebyvalue(int i) {
        i *= 3;
    }

    void tripleByReference(Parameter p) {
        p.b *= 3;
    }

    public static void main (String args[]){
        Parameter p = new Parameter(10);
        int a = 10;
        System.out.println("a = " + a);
        System.out.println("b = " + p.b);
        p.triplebyvalue(a);
        p.tripleByReference(p);
        System.out.println("When passed by value, a is: "+ a);
        System.out.println("When passed by reference, b is: "+ p.b);
    }
}