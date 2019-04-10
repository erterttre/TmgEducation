package io.tmg.lesson09.model.twitt;

import io.tmg.lesson09.facade.data.DataTwitt;

public class Twitt extends DataTwitt {
    private int messageId;
    private String topMessage;
    private String bodyMessage;
    private String timeMessage;
    private int userId;

    public Twitt() {
    }

    public Twitt(String topMessage, String bodyMessage, String timeMessage, int userId) {
        this.topMessage = topMessage;
        this.bodyMessage = bodyMessage;
        this.timeMessage = timeMessage;
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(String topMessage) {
        this.topMessage = topMessage;
    }

    public String getBodyMessage() {
        return bodyMessage;
    }

    public void setBodyMessage(String bodyMessage) {
        this.bodyMessage = bodyMessage;
    }

    public String getTimeMessage() {
        return timeMessage;
    }

    public void setTimeMessage(String timeMessage) {
        this.timeMessage = timeMessage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Twitt2{" +
                "messageId=" + messageId +
                ", topMessage='" + topMessage + '\'' +
                ", bodyMessage='" + bodyMessage + '\'' +
                ", timeMessage='" + timeMessage + '\'' +
                ", userId=" + userId +
                '}';
    }
}
