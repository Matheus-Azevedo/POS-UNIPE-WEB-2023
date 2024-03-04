package com.example.teste;

interface ValoresITF {
  boolean ins(int v); // insere um valor
  int del(int i); // remove o valor armazenado no índice i e retorna o valor removido
  int size(); // retorna a quantidade de valores armazenados
}

public class Valores implements ValoresITF {

  public int[] valores = new int[10];

  public boolean ins(int valor) {
    
    if(valor > 0) {
      for(int i = 0; i < valores.length; i++) {
        if(valores[i] == 0) {
          valores[i] = valor;
          return true;
        }
      }
    }      

    return false;
  }

  public int del(int indice) {

    if(indice >= 0 && indice < valores.length) {
      int valor = valores[indice];
      valores[indice] = 0;
      return valor;
    }
    return -1;
  }

  public int size() {
    int count = 0;
    
    for(int i = 0; i < valores.length; i++) {
      if(valores[i] != 0) {
        count++;
      }
    }
    return count;
  }

}
