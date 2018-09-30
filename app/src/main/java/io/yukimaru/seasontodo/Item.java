package io.yukimaru.seasontodo;

public class Item {
    private String content;
    private String key;


public Item(String content, String key){
   this.content = content;
   this.key = key;
}

public Item(){

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent(){//今までの内容
        return content;
    }

    public void setContent(String content){//タイトルの情報の取得
        this.content = content;
    }
}