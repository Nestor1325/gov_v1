package com.gov.storage;

import java.util.List;

interface StorageStrategy<T> {

  void guardar(List<T> datos);

  List<T> cargar();
}
