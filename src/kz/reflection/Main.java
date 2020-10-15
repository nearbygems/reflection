package kz.reflection;

public class Main {

  public static void main(String[] args) {
    getDeclaredFields(); // Метод возвращает все объявленные переменные в классе
    getDeclaredField(); // Метод возвращает переменную по её имени
    getFields(); // Метод возвращает только public переменные
    getField(); // Метод возвращает только public переменную
    getDeclaredMethods(); // Метод возвращает все объявленные методы в классе
    getDeclaredMethod(); // Метод принимает имя и var-args с типами параметров метода
    getMethods(); // Метод возвращает все public методы класса и public методы его родительского класса/интерфейсов
    getMethod(); // Метод возвращает все public методы класса
    getEnclosingMethod(); // Метод возвращает тот метод в котором этот класс был создан, иначе метод возвращает null
  }

  public static void getDeclaredFields() {

    var carClass = Car.class;
    var declaredFields = carClass.getDeclaredFields();

    for (var field : declaredFields) {
      System.out.println(field);
    }

  }

  public static void getDeclaredField() {

    var carClass = Car.class;

    try {
      var horsepowerField = carClass.getDeclaredField("horsepower");
      System.out.println(horsepowerField);
      var blaBlaField = carClass.getDeclaredField("bla_bla");
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }

  }

  public static void getFields() {

    var carClass = Car.class;

    var fields = carClass.getFields();

    for (var field : fields) {
      System.out.println(field);
    }

  }

  public static void getField() {

    var carClass = Car.class;

    try {
      var serialNumberField = carClass.getField("serialNumber");
      System.out.println(serialNumberField);
      var horsepowerField = carClass.getField("horsepower");
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }

  }

  public static void getDeclaredMethods() {

    var carClass = Car.class;
    var declaredMethods = carClass.getDeclaredMethods();

    for (var method : declaredMethods) {
      System.out.println(method);
    }

  }

  public static void getDeclaredMethod() {

    var carClass = Car.class;

    try {

      var printSerialNumberMethod = carClass.getDeclaredMethod("printSerialNumber");
      System.out.println(printSerialNumberMethod);

      var setHorsepowerMethod = carClass.getDeclaredMethod("setHorsepower", int.class);
      System.out.println(setHorsepowerMethod);

      carClass.getDeclaredMethod("dodooooo");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

  }

  public static void getMethods() {

    var carClass = Car.class;
    var methods = carClass.getMethods();

    for (var method : methods) {
      System.out.println(method);
    }

  }

  public static void getMethod() {

    var carClass = Car.class;

    try {
      var getHorsepowerMethod = carClass.getMethod("notifyAll");
      System.out.println(getHorsepowerMethod);

      var printSerialNumberMethod = carClass.getMethod("printSerialNumber");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

  }

  public static void getEnclosingMethod() {

    var car = new Car() {
      @Override
      protected void printSerialNumber() {

      }
    };

    var enclosingMethod = car.getClass().getEnclosingMethod();
    System.out.println(enclosingMethod);

  }

}
