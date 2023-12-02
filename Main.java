public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.add("manzana", 1);
        dictionary.add("banana", 2);
        dictionary.add("cereza", 3);

        boolean result = dictionary.delete("banana"); 
        System.out.println("Se eliminó la clave 'banana': " + result);
        result = dictionary.delete("papaya"); .
        System.out.println("Se eliminó la clave 'papaya': " + result);

        try {
            int value = dictionary.getValue("manzana");
            System.out.println("El valor de 'manzana' es: " + value);
        } catch (ObjectNoExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            int value = dictionary.getValue("papaya");
        } catch (ObjectNoExistException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Contenido del diccionario:");
        System.out.println(dictionary.toString());
    }
}
