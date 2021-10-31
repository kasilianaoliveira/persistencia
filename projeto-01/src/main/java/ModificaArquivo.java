import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entities.Carro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModificaArquivo {
  public void converterCsv() throws IOException {

    String path = "carro.csv";

    //try with resources -> desaloca de forma automatizado
    try(BufferedReader br = new BufferedReader(new FileReader(path))){

      List<Carro> list = new ArrayList<>(); //criado para poder manipular os dados
      String line = br.readLine(); //ler a primeira linha

      while (line != null) {

        //padrao internacional (virgula)
        String[] vect = line.split(","); //recota onde tem virgula e coloca no vect
        String marca = vect[0];
        String modelo = vect[1];
        String cor = vect[2];
        Integer ano = Integer.parseInt(vect[3]); //converte para int
        Double versao = Double.parseDouble(vect[4]);


        Carro carro = new Carro(marca, modelo,cor, ano,versao);
        list.add(carro);

        line = br.readLine();
      }

      /*System.out.println("Carros:");
      for (Carro p : list) {
        System.out.println(p);
      }*/

      transformarParaJson(list);
      transformarXml(list);
    }
    catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

  }
  public void transformarParaJson(List<Carro> carro) throws IOException {
    try{
      ObjectMapper objectMapper = new ObjectMapper();
      File file = new File("carro.json");
      objectMapper .writeValue(file, carro);
    }catch (IOException e){
      System.out.println("Error: " + e.getMessage());
    }
  }
  public void transformarXml(List<Carro> carro) throws IOException {
    try {
      XmlMapper xmlMapper = new XmlMapper();
      File file = new File("carro.xml");
      xmlMapper.writeValue(file, carro);
    }catch (IOException e){
      System.out.println("Error: " + e.getMessage());
    }
  }
}
