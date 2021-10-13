package com.company;

import java.io.*;
import java.util.Scanner;

public class Questao01 {


  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    try {
      System.out.println("Digite nome do arquivo de origem");
      String arquivo1 = scan.next();

      System.out.println("Digite nome do arquivo de destino");
      String arquivo2 = scan.next();

      long time = System.currentTimeMillis();

      File destiny = new File(arquivo2);
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(arquivo1));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();

      int x = 0;
      while((x = in.read()) != -1){
        baos.write(x);
      }
      in.close();

      String fileC  = new String(baos.toByteArray());

      FileOutputStream fos = new FileOutputStream(destiny);
      fos.write(fileC.getBytes());
      fos.close();

      System.out.println("O tempo total de cópia foi de "+ (System.currentTimeMillis() - time)+ " milisegundos.");
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

}