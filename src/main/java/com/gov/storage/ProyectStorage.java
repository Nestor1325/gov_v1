package com.gov.storage;

import com.gov.model.Proyect;

import java.util.ArrayList;
import java.util.List;
import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;

public class ProyectStorage implements StorageStrategy<Proyect> {

  private final String rutaArchivo;

  protected ProyectStorage(String rutaArchivo) {

    this.rutaArchivo = rutaArchivo;
  }

  @Override
  public void guardar(List<Proyect> datos) {

    try (RandomAccessFile raf = new RandomAccessFile(new File(rutaArchivo), "rw")) {
      raf.setLength(0);
      raf.seek(0);

      raf.writeInt(datos.size());

      for (Proyect p : datos) {
        raf.writeUTF(p.getNombre());
        raf.writeUTF(p.getDescripcion());
        raf.writeUTF(p.getEmpresa());
        raf.writeUTF(p.getUbicacion());
        raf.writeUTF(p.getEstado());
        raf.writeInt(p.getPreuspuesto());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Proyect> cargar() {

    List<Proyect> proyectsList = new ArrayList<>();
    File file = new File(rutaArchivo);

    if (!file.exists() || file.length() == 0) {
      return proyectsList;
    }

    try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {

      raf.seek(0);
      int nroProyectos = raf.readInt();

      for (int i = 0; i < nroProyectos; i++) {
        String nombre = raf.readUTF();
        String desc = raf.readUTF();
        String empr = raf.readUTF();
        String ubic = raf.readUTF();
        String estd = raf.readUTF();
        int pres = raf.readInt();

        proyectsList.add(new Proyect(nombre, desc, empr, ubic, estd, pres));
      }
    } catch (EOFException e) {

      return proyectsList;
    } catch (Exception e) {

      e.printStackTrace();
      return proyectsList;
    }
    return proyectsList;
  }
}
