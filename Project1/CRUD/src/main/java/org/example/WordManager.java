package org.example;

import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;
    public WordManager() {
         wordCRUD = new WordCRUD(s);
    }

    public void start(){
        wordCRUD.loadFile();
       while(true){
           int menu = selectMenu();
           if(menu == 0)
               break;
           else if(menu == 1){
               wordCRUD.listAll();
           }
           else if(menu == 2){
               wordCRUD.searchLeve();
           }
           else if(menu == 3){//search word
               wordCRUD.searchWord();
           }
           else if(menu == 4){
               wordCRUD.addItem();
           }
           else if(menu == 5){
               //update word
               wordCRUD.updateItem();
           }
           else if(menu == 6){
               //delete word
               wordCRUD.deleteItem();
           }
           else if(menu == 7){
               wordCRUD.saveFile();
           }
       }
    }
    public int selectMenu(){
        System.out.print(" **** Word Master **** \n"+
                "-------------------\n"+
                "1. 모든 단어 보기\t\t"+"5. 단어 수정\n"+
                "2. 수준별 단어 보기\t\t"+"6. 단어 삭제\n"+
                "3. 단어 검색\t\t\t"+"7. 파일 저장\n"+
                "4. 단어 추가\n"+
                "\t\t\t\t\t0. 나가기\n"+
                "-------------------\n"+
                "=> 원하는 메뉴?");

        return s.nextInt();

    }
}
