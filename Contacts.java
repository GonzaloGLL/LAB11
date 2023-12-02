import java.util.Scanner;

public class Contacts {
    private Dictionary<String, Person> contacts;

    public Contacts() {
        contacts = new Dictionary<>();
    }

    public void addContact(String dni, Person person) {
        contacts.add(dni, person);
    }

    public boolean deleteContact(String dni) {
        return contacts.delete(dni);
    }

    public Person getContact(String dni) throws ObjectNoExistException {
        return contacts.getValue(dni);
    }

    public void showContacts() {
        System.out.println(contacts);
    }

    public static void main(String[] args) {
        Contacts contactManager = new Contacts();
        Scanner scanner = new Scanner(System.in);
        String dni, name, phone, email;
        int option;

        do {
            System.out.println("Menu de Contactos:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Mostrar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Ingrese DNI: ");
                    dni = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    name = scanner.nextLine();
                    System.out.print("Ingrese telefono: ");
                    phone = scanner.nextLine();
                    System.out.print("Ingrese email: ");
                    email = scanner.nextLine();
                    contactManager.addContact(dni, new Person(name, phone, email));
                    break;
                case 2:
                    System.out.print("Ingrese DNI del contacto a eliminar: ");
                    dni = scanner.nextLine();
                    if (contactManager.deleteContact(dni)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese DNI del contacto a mostrar: ");
                    dni = scanner.nextLine();
                    try {
                        Person contact = contactManager.getContact(dni);
                        System.out.println(contact);
                    } catch (ObjectNoExistException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    contactManager.showContacts();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        } while (option != 5);

        scanner.close();
    }
}
