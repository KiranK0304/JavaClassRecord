class A {
    int a = 10;

    A() {
        System.out.println("Constructor of Class A invoked");
    }

    void display() {
        System.out.println("Display method from Class A, value a = " + a);
    }
}

class B extends A {
    int b = 20;

    B() {
        super(); // Call superclass constructor
        System.out.println("Constructor of Class B invoked");
    }

    @Override
    void display() {
        super.display(); // Call superclass method
        System.out.println("Overridden display in Class B, value b = " + b);
    }
}

// Multilevel inheritance demonstration
class C extends B {
    int c = 30;

    C() {
        super();
        System.out.println("Constructor of Class C invoked");
    }

    void showSum() {
        int total = a + b + c;
        System.out.println("Sum of inherited members (a + b + c) = " + total);
    }
}

public class co3 {
    public static void main(String[] blesson) {
        System.out.println("=== Single and Multilevel Inheritance Demonstration ===");
        C objC = new C();
        objC.display();
        objC.showSum();
    }
}
