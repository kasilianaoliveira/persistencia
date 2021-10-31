import entities.Carro;

import java.io.*;
import java.util.Scanner;

public class CadastraCarro {

  public void logar() throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("======================================");
    System.out.println("BEM-VINDO");
    System.out.println("======================================");

    System.out.println("Preencha as informações de login");
    System.out.println("======================================");
    System.out.println("Nome de usuário");
    String name = scanner.nextLine();
    System.out.println(name);
    System.out.println("======================================");
    System.out.println("Digite sua senha");
    String senha = scanner.nextLine();
    System.out.println(senha);
    System.out.println("======================================");

    if(name.equals("Admin") && senha.equals("12345")) {
      cadastrar();
    }else {
      System.out.println("Usuário ou senha incorreto, tente novamente :)");
      logar();
    }
  }

  public void salvar(Carro carro) throws IOException {

    try {
      FileOutputStream fos = new FileOutputStream("carro.csv", true);
      OutputStreamWriter os = new OutputStreamWriter(fos);
      BufferedWriter bw = new BufferedWriter(os);

      String dados = carro.getMarca() + ","
              + carro.getModelo() + ","
              + carro.getCor() + ","
              + carro.getAno() + ","
              + carro.getVersao();

      bw.write(dados);
      bw.newLine();
      bw.flush();  // Libera o fluxo de saída e força a gravação
      bw.close();

    }catch (IOException e){
      e.printStackTrace();
    }
  }

  public void cadastrar() throws IOException {
    Scanner scanner = new Scanner(System.in);

    try {
        System.out.println("Cadastre as informações do carro abaixo: ");

        System.out.println("Digite a marca: ");
        String marca = scanner.nextLine();

        System.out.println("Digite o modelo: ");
        String modelo = scanner.nextLine();

        System.out.println("Digite a cor: ");
        String cor = scanner.nextLine();

        //scanner.next();
        System.out.println("Digite o ano: ");
        int ano = scanner.nextInt();

        System.out.println("Digite a versão: ");
        double versao = scanner.nextDouble();

        Carro carro = new Carro(marca, modelo, cor, ano, versao);
        salvar(carro);

        System.out.println("======================================");
        System.out.println("Digite - 1 - para continuar cadastrando e - 2 - para finalizar");
        int opcao = scanner.nextInt();

        switch (opcao){
          case 1:
            cadastrar();
          break;
          case 2:
            System.out.println("Finalizado");
            break;
          default:
            System.out.println("Desculpa, mas voce nao respondeu corretamente");
        }

    }catch (IOException e){
      e.printStackTrace();
    }finally {
      if (scanner != null) {
        scanner.close();
      }
    }
  }
}
