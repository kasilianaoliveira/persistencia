import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModificaArquivo {
  public void converterCsv() throws IOException {

    try{
      String path = "carro.csv";

      List<Carro> list = new ArrayList<>();

      BufferedReader br = new BufferedReader(new FileReader(path));
      String line = br.readLine();
      while (line != null) {

        String[] vect = line.split(",");
        String marca = vect[0];
        String modelo = vect[1];
        String cor = vect[2];
        Integer ano = Integer.parseInt(vect[3]);
        Double versao = Double.parseDouble(vect[4]);


        Carro carro = new Carro(marca, modelo,cor, ano,versao);
        list.add(carro);

        line = br.readLine();
      }
      transformarParaJson(list);
      transformeXml(list);
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
  public void transformeXml(List<Carro> carro) throws IOException {
    try {
      XmlMapper xmlMapper = new XmlMapper();
      File file = new File("carro.xml");
      xmlMapper.writeValue(file, carro);
    }catch (IOException e){
      System.out.println("Error: " + e.getMessage());
    }
  }
}
