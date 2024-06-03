import java.util.ArrayList;

public class Usuario{
  protected String login;
  protected String nome;
  protected String senha;
  protected Local cidade;
  protected ArrayList<Postagem> posts = new ArrayList<Postagem>();
  protected ArrayList<Usuario> seguindo = new ArrayList<Usuario>();
  protected ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
  protected ArrayList<Pessoa> interessados = new ArrayList<Pessoa>();

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
      System.out.println(this.toString());
      p.mostrarDados();
      System.out.println("*");
    }
  }

  public void feed(){
    System.out.println("Feed de "+this.login);
    System.out.println("*");
    for(Usuario u : seguindo){
      u.mostrarPosts();
    }
  }
}