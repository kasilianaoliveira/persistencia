package com.company;

import java.io.*;
import java.util.Scanner;

public class Questao01 {

  public static void read(String arquivo, String substring) throws IOException {

    InputStream is = new FileInputStream(arquivo);
    InputStreamReader filer = new InputStreamReader(is); // faz a leitura de dados binários, não importa a fonte
    BufferedReader bf = new BufferedReader(filer); // ler o arquivo

    try {
      String line = bf.readLine();
      while (line != null) {
        if (line.contains(substring)) {
          System.out.printf("%s\n", line);
        }

        line = bf.readLine();
      }
      filer.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + is + "\nMessage: " + e.getMessage());
    } catch (IOException e) {
      e.getMessage();
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite abaixo o nome do seu arquivo .txt : ");
    String file = scanner.nextLine();

    System.out.println("Digite abaixo a substring que deseja encontrar: ");
    String line = scanner.nextLine();

    read(file, line);

  }
}
