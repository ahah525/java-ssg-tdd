package com.ll.exam;

public class WiseSaying {
    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    // WiseSaying 객체를 Json으로 변환하는 메서드
    public String toJson() {
        // stripIndent(): 문자열 안의 모든 라인에 앞 뒤 공백 제거
        return """
                {
                "id" : %d,
                "content": "%s", 
                "author": "%s"
                }
                """.stripIndent().formatted(id, content, author);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
