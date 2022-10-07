package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;
    final String fname = "dict.txt";
    public WordCRUD(Scanner s) {
        list = new ArrayList<Word>();
        this.s = s;
    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1-2-3) & 단어 입력 :  ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 =>  ");
        String m = s.nextLine();

        return new Word(0, level, word, m);
    }
    public void addItem(){
        Word one = (Word)add();
        list.add(one);
        System.out.println("추가되었습니다 \n");
    }
    @Override
    public int udpate(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public void listAll(){
        if(list.isEmpty()){
            System.out.println("----- 현재 추가된 단어가 없습니다 -----\n");
            return;
        }
        System.out.println("\n<Word List>");
        for(int i =0; i< list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("-------------------\n");
    }
    public ArrayList<Integer> listAll(String keyword){

        ArrayList<Integer> idlist = new ArrayList<>();
        int j =0;
        System.out.println("--------------------");
        for(int i =0; i< list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;

            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------");
        return idlist;
    }
    public void listAll(int level){
       int j = 0;
        System.out.println("--------------------");
        for(int i = 0 ; i< list.size(); i++){
            int ilevel = list.get(i).getLevel();
            if(ilevel != level) continue;
            System.out.print((j+1)+ " ");
            System.out.println(list.get(i).toString());

        }
        System.out.println("--------------------");
    }
    public void updateItem() {
        if(list.isEmpty()){
            System.out.println("----- 현재 추가된 단어가 없습니다 -----\n");
            return;
        }

        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);


        System.out.print("=> 수정할 단어의 번호  :  ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 뜻 수정  : ");
        String mean = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMean(mean);
        System.out.println("단어가 수정되었습니다.");
    }

    public void deleteItem() {
        if(list.isEmpty()){
            System.out.println("----- 현재 삭제할 단어가 없습니다 -----\n");
            return;
        }

        System.out.println("=> 삭제할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);


        System.out.print("=> 삭제할 단어의 번호  :  ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 정말로 삭제하시겠습니까? (Y/n)  : ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("y")) {
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제되었습니다.");
        }
        else{
            System.out.println("취소되었습니다. ");
        }
    }

    public void loadFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int index = 0;
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String mean = data[2];
                list.add(new Word(index,level, word, mean));
                index++;
            }
            br.close();
            System.out.println("==> 총 "+ index + " 개의 단어 로딩 완료에\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));

            for(Word one : list){
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("==> 파일에 데이터 저장 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchLeve() {
        System.out.print("=> 검색할 레벨 (1~3) : ");
        int level = s.nextInt();
        listAll(level);
    }

    public void searchWord() {

        System.out.print("=> 검색할 단어 검색 : ");
        String keyword = s.next();
       listAll(keyword);
    }
}
