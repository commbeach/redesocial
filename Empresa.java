public class Empresa extends Usuario{
  private String cnpj;
  private String endereco;
  private String site;
  private String descricao;
  private Area area;

  public Empresa(String l,String n,String s,String c){
    super(l,n,s);
    this.cnpj=c;
    System.out.println("empresa cadastrada");
    
  }
  public String toString(){
    return this.nome+" ("+this.login+" - "+this.cnpj+")";
  }
}