import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, CantLoadContacts {
        Agenda agenda = new Agenda(new FileContactProvider());

        FileContactProvider provider = new FileContactProvider();

        Scanner sc= new Scanner(System.in);
        int opcion;
//---------------------------------------Menu-------------------------------------------------------------------------------------
        do {
            System.out.println("----AGENDA----");
            System.out.println("1. Añadir contactos");
            System.out.println("2. Eliminar un contacto");
            System.out.println("3. Modificar un contacto");
            System.out.println("4. Mostrar contactos");
            System.out.println("5. Vaciar la agenda");
            System.out.println("6. Salir");
            System.out.println("-------------");
            System.out.println("¿Que quieres hacer?(introduce el numero):");
            opcion = sc.nextInt();

            switch (opcion){
//---------------------------------------Añadir contacto-------------------------------------------------------------------------------------
                case 1:
                    String name;
                    String phoneNumber;
                    String email;
                    String address;
                    System.out.println("Name: ");
                    name = sc.next();
                    System.out.println("Number: ");
                    phoneNumber = sc.next();
                    System.out.println("Email: ");
                    email = sc.next();
                    System.out.println("Direccion: ");
                    address = sc.next();

                    if(phoneNumber.length()!=9){
                        do {
                            System.out.println("---ERROR---");
                            System.out.println("El numero ha de tener 9 digitos: ");
                            phoneNumber = sc.next();
                        }while(phoneNumber.length()!=9);
                    }
                    agenda.add(new Contact(agenda.generateid(), name, phoneNumber, address, email));
                    break;
//---------------------------------------Eliminar contacto-------------------------------------------------------------------------------------
                case 2:
                    System.out.println(agenda);
                    System.out.println("Que contacto quieres eliminar: (introduce el id)");
                    String index = sc.next();
                    agenda.remove(agenda.searchContact(index));
                    break;
//---------------------------------------Editar contactos-------------------------------------------------------------------------------------
                case 3:
                    System.out.println(agenda);
                    System.out.println("Que contacto quieres editar: (introduce el id)");
                    index = sc.next();
                    System.out.println("¿Que quieres editar?: ");
                    System.out.println("1. Nombre ");
                    System.out.println("2. Numero ");
                    System.out.println("3. Email ");
                    System.out.println("4. Direccion ");
                    int opcionEditar = sc.nextInt();
                    switch (opcionEditar){
                        case 1:
                            System.out.println("Introduce un nuevo nombre:");
                            name = sc.next();
                            agenda.searchContact(index).setName(name);
                            agenda.update(agenda.searchContact(index));
                            break;
                        case 2:
                            System.out.println("Introduce un nuevo numero:");
                            phoneNumber = sc.next();
                            agenda.searchContact(index).setPhoneNumber(phoneNumber);
                            agenda.update(agenda.searchContact(index));
                            break;
                        case 3:
                            System.out.println("Introduce un nuevo email:");
                            email = sc.next();
                            agenda.searchContact(index).setEmail(email);
                            agenda.update(agenda.searchContact(index));
                            break;
                        case 4:
                            System.out.println("Introduce un nuevo direccion:");
                            address = sc.next();
                            agenda.searchContact(index).setAddress(address);
                            agenda.update(agenda.searchContact(index));
                            break;
                    }
                    break;
//---------------------------------------Ver contactos-------------------------------------------------------------------------------------
                case 4:
                    System.out.println("---CONTACTOS---");
                    System.out.println(agenda);
                    System.out.println("---------------");
                    break;
//---------------------------------------Vaciar agenda-------------------------------------------------------------------------------------
                case 5:
                    System.out.println("Eliminando contactos de la agenda...");
                    agenda.removeAll();
                    System.out.println("Contactos eliminados");
                    break;
            }

        }while (opcion!=6);


    }

}
