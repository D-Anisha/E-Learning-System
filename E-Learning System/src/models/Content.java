package models;

import java.io.Serializable;

public class Content implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String contentId;
    private String title;
    private String type; // VIDEO, TEXT, DOCUMENT
    private String content;
    private String filePath;
    private int order;
    
    public Content(String contentId, String title, String type, String content, int order) {
        this.contentId = contentId;
        this.title = title;
        this.type = type;
        this.content = content;
        this.order = order;
    }
    
    // Getters and setters
    public String getContentId() { return contentId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getContent() { return content; }
    public String getFilePath() { return filePath; }
    public int getOrder() { return order; }
    
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public void setOrder(int order) { this.order = order; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", type, title, contentId);
    }
}
