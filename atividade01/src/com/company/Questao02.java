package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao02 {

  public static void write(String s, String a) {
    try {
      OutputStream a1 = new FileOutputStream(a, true);
      OutputStreamWriter a2 = new OutputStreamWriter(a1);
      BufferedWriter bw = new BufferedWriter(a2);
      bw.write(s);
      bw.close();
    } catch (IOException erro) {
      erro.getMessage();
    }
  }

  public static ArrayList<String> read(String arquivo) {
    ArrayList<String> linhas = new ArrayList<>();
    try {
      InputStream file = new FileInputStream(arquivo);
      InputStreamReader filer = new InputStreamReader(file);
      BufferedReader br = new BufferedReader(filer);
      try {
        String linha = br.readLine();
        linhas.add(linha);

        while (linha != null) {
          linha = br.readLine();
          linhas.add(linha);
        }
      } catch (IOException e) {
        e.getMessage();
      }

    } catch (FileNotFoundException e) {
      e.getMessage();
    }
    return linhas;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Arquivo 01 com a extensão .txt: ");
    String arquivo01 = scanner.nextLine();
    System.out.println("Arquivo 02 com a extensão .txt: ");
    String arquivo02 = scanner.nextLine();
    System.out.println("Arquivo 03 com a extensão .txt: ");
    String arquivo03 = scanner.nextLine();

    ArrayList<String> arr1;
    ArrayList<String> arr2;

    arr1 = read(arquivo01);
    arr2 = read(arquivo02);

    ArrayList<String> arr3 = new ArrayList<>();

    long tempoInicio = System.currentTimeMillis();
    arr3.addAll(arr1);
    arr3.addAll(arr2);

    for (String s : arr3) {
      if (s != null) {
        write(s + "\n", arquivo03);
      }
    }

    ArrayList<String> arr4 = read(arquivo03);

    double bytes = arr4.size();
    System.out.println("A cópia foi realizada em: " + (System.currentTimeMillis() - tempoInicio) + " milisegundos");
    System.out.println("O tamanho em " + bytes + " em bytes");

  }
}
