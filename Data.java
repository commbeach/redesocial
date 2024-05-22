public class Data{
  int dia;
  int mes;
  int ano;

  public Data(int d, int m, int a){
    this.dia=d;
    this.mes=m;
    this.ano=a;
  }

  public String toString(){
    String dia=this.dia+"";
    String mes=this.mes+"";
    if(this.dia<10){
      dia="0"+dia;
    }
    if(this.mes<10){
      mes="0"+mes;
    }
    return dia+"/"+mes+"/"+this.ano;
  }
}