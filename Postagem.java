public class Postagem implements Comparable<Postagem>{
  private String foto;
  private String legenda;
  private Data d;
  private Usuario user;

public Postagem(String foto,String legenda,Data d,Usuario u){
  this.foto=foto;
  this.legenda=legenda;
  this.d=d;
  this.user=u;
}

public Data getData(){
  return this.d;
}

public void mostrarDados(){
  int seg=this.user.numSeg();
  if(seg==1){
    System.out.println("*\n"+this.user.toString()+"  ("+seg+" seguidor)");
  }
  else{
    System.out.println("*\n"+this.user.toString()+"  ("+seg+" seguidores)");
  }
  System.out.println(this.foto);
  System.out.println(this.legenda);
  System.out.println(this.d.toString());

}

public int compareTo(Postagem p) {
  if(this.d.compareTo(p.d)==-1)return 1;
  if(this.d.compareTo(p.d)==1)return -1;

  int valor=this.user.compareTo(p.user);
  return valor;
}
}