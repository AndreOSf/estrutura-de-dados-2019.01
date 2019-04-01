class Main {
  public static void main(String[] args) {
    ArvoreAVL arvore = new ArvoreAVL();
    arvore.insert("andre", 10);
    arvore.display();
    arvore.insert("lucas", 8);
    arvore.display();
    arvore.insert("lucas 2", 12);
    arvore.display();
    arvore.insert("lucas 2", 3);
    arvore.display();
    arvore.insert("lucas 2", 30);
    arvore.display();
    arvore.insert("lucas 2", 20);
    //arvore.insert("marília", 8);
    //arvore.insert("test", 16);
    //arvore.insert("test 2", 14);
    /*System.out.println(arvore.isEmpty()? "arvore vazia":"arovre não vazia");
    System.out.println(arvore.root().getEsquerdo().getObjeto());*/
    //System.out.println((arvore.searchByKey(8).getObjeto()));
    //arvore.display();
    //arvore.remove(15);
    arvore.display();
    //System.out.println((arvore.searchByKey(15).getObjeto()));
    //System.out.println((arvore.searchByKey(8).getObjeto()));
    //System.out.println(arvore.altura());

  }
}