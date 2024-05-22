public class Postagem{
  String foto;
  String legenda;
  Data d;

public Postagem(String foto,String legenda,Data d){
  this.foto=foto;
  this.legenda=legenda;
  this.d=d;
}

public void mostrarDados(){
  System.out.println("***********");
  System.out.println(this.foto);
  System.out.println(this.legenda);
  System.out.println(this.d.toString());

}
}