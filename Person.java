import java.util.Scanner;

class Person {
    private String name;
    private String phoneNumber;
    private String email;

    public Person(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Telefono: " + phoneNumber + ", Email: " + email;
    }
}

