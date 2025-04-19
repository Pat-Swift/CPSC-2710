package edu.au.cpsc.module6.data;

import java.io.*;

public class AirlineDatabaseIO {

    public static void save(AirlineDatabase ad, OutputStream strm) {
        try (ObjectOutputStream out = new ObjectOutputStream(strm)) {
            out.writeObject(ad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AirlineDatabase load(InputStream strm) {
        try (ObjectInputStream in = new ObjectInputStream(strm)) {
            return (AirlineDatabase) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
