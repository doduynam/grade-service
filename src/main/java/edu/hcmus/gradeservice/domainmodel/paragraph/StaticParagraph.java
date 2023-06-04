package edu.hcmus.gradeservice.domainmodel.paragraph;

public class StaticParagraph implements IParagraph {

    protected String wallpaper;
    protected String title;
    protected String content;

    @Override
    public String getWallpaper() {
        return wallpaper;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
