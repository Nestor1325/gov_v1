package com.gov.storage;

import com.gov.model.User;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.RandomAccessFile;

public class UserStorage implements StorageStrategy<User> {

  private final String rutaArchivo;

  protected UserStorage(String rutaArchivo) {
    this.rutaArchivo = rutaArchivo;
  }

  @Override
  public void guardar(List<User> datos) {

    try (RandomAccessFile raf = new RandomAccessFile(new File(rutaArchivo), "rw")) {
      raf.setLength(0);
      raf.seek(0);

      raf.writeInt(datos.size());

      for (User u : datos) {
        raf.writeUTF(u.getName());
        raf.writeUTF(u.getPassword());
        raf.writeBoolean(u.isAdmin());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<User> cargar() {

    List<User> userList = new ArrayList<>();
    File file = new File(rutaArchivo);

    if (!file.exists()) {
      return userList;
    }

    try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {

      raf.seek(0);
      int nroUsuarios = raf.readInt();

      for (int i = 0; i < nroUsuarios; i++) {
        String name = raf.readUTF();
        String pass = raf.readUTF();
        boolean isAdmin = raf.readBoolean();

        userList.add(new User(name, pass, isAdmin));
      }
    } catch (Exception e) {

      e.printStackTrace();
      return new ArrayList<>();
    }
    return userList;
  }

}
