import java.io.*;

public class readstudent {
    public student deserialzeAddress(String filename) {

        student stuaddress = null;

        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream(filename);
            ois = new ObjectInputStream(fin);
            stuaddress = (student) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return stuaddress;

    }



}
