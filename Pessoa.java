public class Pessoa extends Usuario{
  String cpf;
  Data nasc;
  String bio;
  Usuario[] interesses;

  public Pessoa(String l,String n,String s, String cpf, int dia, int mes, int ano){
    super(l,n,s);
    Data datanasc=new Data(dia,mes,ano);
    this.cpf=cpf;
    this.nasc=datanasc;
    System.out.println("nova pessoa criada");
  }
}