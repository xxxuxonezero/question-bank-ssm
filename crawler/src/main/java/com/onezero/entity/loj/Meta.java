package com.onezero.entity.loj;

public class Meta {
    private int id;
    private int displayId;
    private int acceptedSubmissionCount;
    private int submissionCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public int getAcceptedSubmissionCount() {
        return acceptedSubmissionCount;
    }

    public void setAcceptedSubmissionCount(int acceptedSubmissionCount) {
        this.acceptedSubmissionCount = acceptedSubmissionCount;
    }

    public int getSubmissionCount() {
        return submissionCount;
    }

    public void setSubmissionCount(int submissionCount) {
        this.submissionCount = submissionCount;
    }
}
