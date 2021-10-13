package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao03 {
  public static void Write(String s, String a) {
    try {
      OutputStream a1 = new FileOutputStream(a, true);
      OutputStreamWriter a2 = new OutputStreamWriter(a1);
      BufferedWriter bw = new BufferedWriter(a2);

      bw.write(s);
      bw.close();

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static ArrayList<String> Read(String arquivo) {
    ArrayList<String> linhas = new ArrayList<>();

    try {
      InputStream file = new FileInputStream(arquivo);
      InputStreamReader filer = new InputStreamReader(file);
      BufferedReader bf = new BufferedReader(filer);
      try {
        String linha = bf.readLine();
        linhas.add(linha);

        while (linha != null) {
          linha = bf.readLine();
          linhas.add(linha);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return linhas;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    ArrayList<String> array = new ArrayList<>();
    System.out.println(" Digite o comando seguindo o exemplo -> arquivo-01.txt copia arquivo-02.txt");

    for(int i = 0; i < 3; i++){
      array.add(scanner.next());
    }

    while (!array.get(1).equals("copia")) {
      System.out.println("Erro ao digitar o comando, confira e digite novamente");
      array.set(1, scanner.next());
    }
    ArrayList<String> txt1 = Read(array.get(0));

    long tempoInicio = System.currentTimeMillis();

    for (String s : txt1) {
      if (s != null) {
        Write(s, array.get(2));
      }
    }
    System.out.println("A cópia foi realizada em: "
            + (System.currentTimeMillis() - tempoInicio)
            + " milisegundos");
  }

}