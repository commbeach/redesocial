import java.util.ArrayList;

public class Usuario{
  String login;
  String nome;
  String senha;
  Local cidade;
  ArrayList<Postagem> posts = new ArrayList<Postagem>();
  ArrayList<Usuario> seguindo = new ArrayList<Usuario>();
  ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
  ArrayList<Pessoa> interessados = new ArrayList<Pessoa>();

  public Usuario(String l,String n,String s){
    System.out.println("novo usuario criado");
    this.login=l;
    this.nome=n;
    this.senha=s;
    
  }

  public boolean validarAcesso(String pwd){
    if(this.senha.equals(pwd)){
      return true;
    }
    else{
      return false;
    }
  }

  public String toString(){
    return this.nome+" - "+this.login;
  }

  public void postar(String foto, String legenda,Data hoje,String senha){
    if(this.validarAcesso(senha)){
      Postagem novo_post=new Postagem(foto,legenda,hoje);
      posts.add(novo_post);
    }
    else{
      System.out.println("Senha incorreta!");
    }
  }

  public void seguir(Usuario u){
    this.seguindo.add(u);
    u.seguidores.add(this);
  }

  public void mostrarPosts(){
    for(Postagem p : this.posts){
      p.mostrarDados();
    }
  }

  public void feed(){
    for(Usuario u : seguindo){
      u.mostrarPosts();
    }
  }
}