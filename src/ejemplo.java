import java.io.FileInputStream;
import java.io.IOException;

public class ejemplo {
    public static void main(String[] args)throws IOException {
        FileInputStream f_in= new FileInputStream("./resources/contacts.txt");
        byte[] buffer = new byte[40];
        int n= f_in.read(buffer);
        while(n!=-1){
            for (int i = 0; i < n; i++)
                System.out.println((char)buffer[i]);
            System.out.println("");
            n = f_in.read(buffer);
        }
        f_in.close();
//        FileInputStream f_in= new FileInputStream("contacts.txt");
//        int c= f_in.read();
//        while(c!= -1){
//            System.out.println((char) c);
//            c= f_in.read();
//        }
//        f_in.close();
    }
}
