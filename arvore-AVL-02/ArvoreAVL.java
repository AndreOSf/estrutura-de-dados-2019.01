import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.math.*;
import java.util.*;

class ArvoreAVL{
  private int size = 0;
  private No raiz;

  public No root(){
    return this.raiz;
  }

  public boolean isEmpty(){
    return (raiz == null);
  }

  public int getFatorB(No no){
    if(no != null){
      return no.getFB();
    }
    return 0;
  }

  public void rotacaoDireita(No no){
    System.out.println("Rotaçao simples direita");
    No temp = no.getEsquerdo();
    no.setEsquerdo(temp.getDireito());

    if(temp.getDireito() !=null ){
      (temp.getDireito()).setPai(no);
    }

    temp.setDireito(no);
    temp.setPai(no.getPai());

    if(no.getPai() != null){
      if(no.getKey() < no.getPai().getKey()){
        no.getPai().setDireito(temp);
      }
      else{
        no.getPai().setEsquerdo(temp);
      }
    }
    else{
      raiz = temp;
    }
    
    no.setPai(temp);
    no.setFB(no.getFB() - 1 - Math.max(temp.getFB(), 0));
    temp.setFB(temp.getFB() - 1 + Math.min(no.getFB(), 0));
  }
    
    public void rotacaoEsquerda(No no){
    System.out.println("Rotaçao simples esquerda");
    No temp = no.getDireito();
    no.setDireito(temp.getEsquerdo());

    if(temp.getEsquerdo() !=null ){
      (temp.getEsquerdo()).setPai(no);
    }

    temp.setEsquerdo(no);
    temp.setPai(no.getPai());

    if(no.getPai() != null){
      if(no.getKey() < no.getPai().getKey()){
        no.getPai().setEsquerdo(temp);
      }
      else{
        no.getPai().setDireito(temp);
      }
    }
    else{
      raiz = temp;
    }
    
    no.setPai(temp);
    no.setFB(no.getFB() + 1 - Math.min(temp.getFB(), 0));
    temp.setFB(temp.getFB() + 1 + Math.max(no.getFB(), 0));
  }

  public void rotacaoDuplaDireita(No no){
    System.out.println("RDD");
    rotacaoEsquerda(no.getEsquerdo());
    rotacaoDireita(no);
  }

  public void rotacaoDuplaEsquerda(No no){
    System.out.println("RDE");
    rotacaoDireita(no.getDireito());
    rotacaoEsquerda(no);
  }

  public void balance(No no){
    if(no.getFB() == 2){
      if(no.getEsquerdo().getFB() >= 0){
        rotacaoDireita(no);
      }
      else{
        rotacaoDuplaDireita(no);
      }
    }

    else if(no.getFB() == -2){
      if(no.getDireito().getFB() <= 0){
        rotacaoEsquerda(no);
      }
      else{
        rotacaoDuplaEsquerda(no);
      }
    }

  }

  public No attFB(No no, int flag, int lado){
    //System.out.println("\nfb de "+no.getKey()+ "= att: "+ no.getFB());
    no.setFB(no.getFB() + (flag * lado));
    //System.out.println("\nfb de "+no.getKey()+ "= att: "+ no.getFB());
    if(no.getFB() == 2 || no.getFB() == -2){
      return no;
    }
    if(no.getPai() == null || no.getFB() == 0 && flag == 1 || no.getFB() != 0 && flag == -1){
      return null;
    }
    if(no.getKey() < no.getPai().getKey()){
      lado = 1;
    }
    else{
      lado = -1;
    }
    return attFB(no.getPai(), flag, lado);
  }

  public void insert(Object novo, int key){
    if(isEmpty()){
      this.raiz = new No(null, novo, key);
      size ++;
    }
    else {
      insertRec(novo, key, this.raiz);
      }
    }

  public No insertRec(Object novo, int key, No raiz){
    if(key > raiz.getKey()){ //add direita
      if(raiz.getDireito() == null){
        raiz.setDireito(new No(raiz, novo, key));
        No n = attFB(raiz, 1, -1);
        if(n != null){
          balance(n);
        }
        size++;
      }
      insertRec(novo, key, raiz.getDireito());
    }
    else if(key < raiz.getKey()){ //add esquerda
      if(raiz.getEsquerdo() == null){
        raiz.setEsquerdo(new No(raiz, novo, key));
        No n = attFB(raiz, 1, 1);
        if(n != null){
          balance(n);
        }
        size++;
      }
      insertRec(novo, key, raiz.getEsquerdo());
    }

  return raiz; 
  }
  
  public No sucessor(No no){
    if(no.getEsquerdo() == null){
      return no;
    }
    else{
      return sucessor(no.getEsquerdo());
    }
  }

  public void remove(int key){
    removeNo(raiz, key);
  }
  public No removeNo(No raiz, int key){
    if(isEmpty()){
      return null;
    }
    if(key < raiz.getKey()){ //sub-arvore esquerda
      raiz.setEsquerdo(removeNo(raiz.getEsquerdo(), key));
    }
    else if(key > raiz.getKey()){ //sub-arvore direita
      raiz.setDireito(removeNo(raiz.getDireito(), key));
    }
    else{ //casos de remoção
      if(raiz.getEsquerdo() != null && raiz.getDireito() != null){ // dois filhos
        No temp = raiz;
        No troca = sucessor(temp.getDireito());
        raiz.setKey(troca.getKey());

        removeNo(raiz.getDireito(), troca.getKey());
      }
      else if(raiz.getEsquerdo()  != null){ //um filho
        raiz = raiz.getEsquerdo();
      }
      else if(raiz.getDireito() != null){ //um filho
        raiz = raiz.getDireito();
      }
      else{ //nenhum filho
        raiz = null;
      }
    }
  return raiz;
  }


public int size(){
  return size;
}

public boolean noInterno(No no){
  return no.getDireito() != null || no.getClass() != null;
}

public int altura(){
  return alturaP(raiz);
}

public int alturaP(No no){
  if(!noInterno(no)){
    return 0;
  }
  int h = 0;
  Iterator<No> i = no.children();
  while(i.hasNext()){
    h = Math.max(h, alturaP(i.next()));
  }
  return 1 + h;
}

public int profundidade(No no){
  return profundidadeRec(no);
}
public int profundidadeRec(No no){
  if(no == raiz){
    return 0;
  }
  else{
    return 1 + profundidadeRec(no.getPai());
  }
}

  public void inOrder(){
    inOrderRec(raiz);
  }
  public void inOrderRec(No raiz){
    if(raiz != null){
      inOrderRec(raiz.getEsquerdo());
      System.out.print(raiz.getObjeto()+" "); // mostrar em ordem
      inOrderRec(raiz.getDireito());
    }
  }


  public No searchByKey(int key){
    return search(raiz, key);
  }
  public No search(No no, int key){
    if(no.getKey() == key){
      return no;
    }
    if(key > no.getKey()){
      return search(no.getDireito(), key);
    }
    return search(no.getEsquerdo(), key);
  }


  public void inOrderVec(Vector elements, int flag) {
      in(raiz, elements, flag);
  }

  private void in(No n, Vector elements, int flag) {
      if (n != null) {
          in(n.getEsquerdo(), elements, flag);
          if (flag == 1)
              elements.addElement(n.getObjeto());
          else
              elements.addElement(n);
          in(n.getDireito(), elements, flag);
      }
  }


  public Iterator no() {
    Vector<No> no = new Vector<No>();
    inOrderVec(no, 0);
    return no.iterator();
  }

  public void display() {
    if(isEmpty()){
      System.out.println("Arvore vazia!");
    }
    int altura = (altura()+1)*2-1;
    int largura = (int)Math.pow(2, altura()+1) - altura();
    System.out.println("\n");
    Object[][] tab = new Object[altura][largura];
    for(int i = 0; i < altura; i++){
      for(int j = 0; j < largura; j++){
        tab[i][j] = " ";
      }
    }
    Iterator<No> no = no();
    int ordem = 0;
    while(no.hasNext()){
      No n = no.next();
      int profundidade = profundidade(n)*2;
      tab[profundidade][ordem ++] = ""+n.getKey()+"["+n.getFB()+"]";
    } 
    for(int i = 0; i < altura; i++){
      for(int j = 0; j < largura; j++){
        System.out.print(tab[i][j]+"     ");
      }
      System.out.println();
    }
    System.out.println("\nTamanho = "+ size + "\nLargura = " + (altura() +1));
    System.out.print("Em ordem: ");
    inOrder();
    System.out.print("\n\n");
  }
}


