package com.ats.remotetimemanager.Model;

public class WebSocketMessage {

    private String socketMessage;
    private long senderId;
    private boolean theme;

    public boolean isTheme() {
        return theme;
    }

    public void setTheme(boolean theme) {
        this.theme = theme;
    }

    public WebSocketMessage() {
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public WebSocketMessage(String socketMessage, long id, boolean theme) {
        this.socketMessage = socketMessage;
        this.senderId = id;
        this.theme = theme;
    }
    public WebSocketMessage(String socketMessage) {
        this.socketMessage = socketMessage;
    }

    public String getSocketMessage() {
        return socketMessage;
    }

    public void setSocketMessage(String socketMessage) {
        this.socketMessage = socketMessage;
    }
}
