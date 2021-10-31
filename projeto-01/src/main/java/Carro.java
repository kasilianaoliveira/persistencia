import java.io.Serializable;

public class Carro implements Serializable{
  private String marca;
  private String modelo;
  private String cor;
  private int ano;
  private double versao;

  public Carro(String marca, String modelo, String cor, int ano, double versao) {
    this.marca = marca;
    this.modelo = modelo;
    this.cor = cor;
    this.ano = ano;
    this.versao = versao;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public double getVersao() {
    return versao;
  }

  public void setVersao(double versao) {
    this.versao = versao;
  }

  @Override
  public String toString() {
    return "Carro{" +
            "marca='" + marca + '\'' +
            ", modelo='" + modelo + '\'' +
            ", cor='" + cor + '\'' +
            ", ano=" + ano +
            ", versao=" + versao +
            '}';
  }
}
