package com.company;

import java.io.*;
import java.util.Scanner;

public class Questao01 {

  public static void Read(String arquivo, String substring) throws IOException {

    InputStream is = new FileInputStream(arquivo);
    InputStreamReader filer = new InputStreamReader(is); // faz a leitura de dados binários, não importa a fonte
    BufferedReader bf = new BufferedReader(filer); // ler o arquivo

    try {
      String linha = bf.readLine();
      while (linha != null) {
        if (linha.contains(substring)) {
          System.out.printf("%s\n", linha);
        }

        linha = bf.readLine();
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
    String arquivo = scanner.nextLine();

    System.out.println("Digite abaixo a substring que deseja encontrar: ");
    String linha = scanner.nextLine();

    Read(arquivo, linha);

  }
}
