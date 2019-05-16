package com.luer.comm.enums;

public enum msgtypeEnum {
    mpnews("mpnews", "图文"),
    text("text", "文字"),
    voice("voice", "音频"),
    music("music", "音乐"),
    image("image", "图片"),
    video("video", "视频"),
    wxcard("wxcard", "卡"),
    mpvideo("mpvideo", "图视频"),
    ;

    private final String txt;
    private final String value;
    private msgtypeEnum(String value, String txt) {
        this.value = value;
        this.txt = txt;
    }
    public String getText() {
        return txt;
    }
    public String getValue() {
        return value;
    }
}
