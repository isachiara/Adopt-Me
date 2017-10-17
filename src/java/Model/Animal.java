package Model;


public class Animal {

  public Long id;
  public String nome;
  public String tipo;
  public String idade;
  public String caract;
  public String tratamento;
  public String dono;

  public Animal(){
      
  }
  
  public String getNome() {
    return this.nome;
  }
  public void setNome(String novo) {
    this.nome = novo;
  }

  public String getTipo() {
    return this.tipo;
  }
  public void setTipo(String novo) {
    this.tipo = novo;
  }

  public String getIdade() {
    return this.idade;
  }
  public void setIdade(String novo) {
    this.idade = novo;
  }

  public String getCaract() {
    return this.caract;
  }
  public void setCaract(String novo) {
    this.caract = novo;
  }
  
  public void setTratamento(String tratamento){
      this.tratamento = tratamento;
  }
  
  public String getTratamento(){
      return this.tratamento;
  }
  
  public String getDono(){
      return this.dono;
  }
  
  public void setDono(String dono){
      this.dono=dono;
  }
  
}
