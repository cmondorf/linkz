package de.awacademy.linkz.link;

public class VoteDTO {
    private long linkId;
    private boolean up;

    public VoteDTO(long linkId, boolean up) {
        this.linkId = linkId;
        this.up = up;
    }

    public long getLinkId() {
        return linkId;
    }

    public boolean isUp() {
        return up;
    }
}
