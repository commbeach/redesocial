public class Pessoa extends Usuario{
  private String cpf;
  private Data nasc;
  private String bio;
  private Usuario[] interesses;

  public Pessoa(String l,String n,String s, String cpf, int dia, int mes, int ano){
    super(l,n,s);
    Data datanasc=new Data(dia,mes,ano);
    this.cpf=cpf;
    this.nasc=datanasc;
    System.out.println("nova pessoa criada");
  }

  public String toString(){
    return this.nome+" ("+this.login+" - "+this.cpf+")";
  }
}