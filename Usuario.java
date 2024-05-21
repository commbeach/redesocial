public class Usuario{
  String login;
  String nome;
  String senha;
  Local cidade;
  Postagem[] posts;
  Usuario[] seguindo;
  Usuario[] seguidores;
  Pessoa[] interessados;

  public Usuario(String l,String n,String s){
    System.out.println("novo usuario criado");
    this.login=l;
    this.nome=n;
    this.senha=s;
    
  }
}