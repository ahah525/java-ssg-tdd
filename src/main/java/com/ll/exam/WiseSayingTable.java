package com.ll.exam;

import java.io.File;
import java.util.Map;

public class WiseSayingTable {
    private String baseDir;

    public WiseSayingTable(String baseDir) {
        this.baseDir = baseDir;
    }
    // ㄷ명언 객체를 파일에 저장하는 메서드
    public void save(WiseSaying wiseSaying) {
        // 해당 경로의 폴더 생성
        Util.file.mkdir("%s/wise_saying".formatted(baseDir));
        String body = wiseSaying.toJson();
        // 해당 경로에 명언의 id를 파일명으로 하여 body를 담아 파일 저장
        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(baseDir, wiseSaying.getId()), body);
    }
    // 자동 넘버링된 id와 명언, 작가값으로 해당 명언을 파일에 저장하는 메서드
    public void save(String content, String author) {
        int id = getLastId() + 1;   // id 자동 넘버링
        // 명언 객체 생성후 파일에 저장
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        save(wiseSaying);

        saveLastId(id); // 마지막 저장된 id 업데이트
    }
    // 파일에 마지막 명언 id를 저장하는 메서드
    public void saveLastId(int id) {
        // 마지막으로 저장된 명언 id 파일에 저장
        Util.file.saveToFile("%s/wise_saying/last_id.txt".formatted(baseDir), id + "");
    }
    // 파일에 저장된 마지막 명언 id를 읽어 반환하는 메서드
    public int getLastId() {
        // 파일에서 마지막으로 저장된 명언 id 읽어오기
        String lastId = Util.file.readFromFile("%s/wise_saying/last_id.txt".formatted(baseDir), "");
        // 저장된 명언이 없으면 0 리턴
        if(lastId.isEmpty())
            return 0;
        return Integer.parseInt(lastId);
    }

    public WiseSaying findById(int id) {
        // 해당 id에 대한 파일경로
        String path = "%s/wise_saying/%d.json".formatted(baseDir, id);
        // 해당 파일이 존재하는지 여부 검사
        if (!new File(path).exists()) {
            return null;
        }
        // 파일에서 읽어온 json -> Map으로 변환한 객체
        Map<String, Object> map = Util.json.jsonToMapFromFile(path);
        // 값이 널이면(파일에 읽어온 json에 값이 없었으면)
        if (map == null) {
            return null;
        }
        return new WiseSaying((int) map.get("id"), (String) map.get("content"), (String) map.get("author"));
    }
}
