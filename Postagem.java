public class Postagem{
  private String foto;
  private String legenda;
  private Data d;

public Postagem(String foto,String legenda,Data d){
  this.foto=foto;
  this.legenda=legenda;
  this.d=d;
}

public void mostrarDados(){
  System.out.println(this.foto);
  System.out.println(this.legenda);
  System.out.println(this.d.toString());

}
}