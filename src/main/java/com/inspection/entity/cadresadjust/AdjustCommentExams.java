package com.inspection.entity.cadresadjust;

import java.util.ArrayList;
import java.util.List;

public class AdjustCommentExams {
    private java.lang.String commentScore;
    private java.lang.String examScore;

    public String getExamScore() {
        return examScore;
    }

    public void setExamScore(String examScore) {
        this.examScore = examScore;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDemocraticRecommend() {
        return democraticRecommend;
    }

    public void setDemocraticRecommend(String democraticRecommend) {
        this.democraticRecommend = democraticRecommend;
    }

    public String getDemocraticRecommendTotal() {
        return democraticRecommendTotal;
    }

    public void setDemocraticRecommendTotal(String democraticRecommendTotal) {
        this.democraticRecommendTotal = democraticRecommendTotal;
    }

    public List<String> getAddSubItems() {
        return addSubItems;
    }

    public void setAddSubItems(List<String> addSubItems) {
        this.addSubItems = addSubItems;
    }

    public String getOrganReviewResult() {
        return organReviewResult;
    }

    public void setOrganReviewResult(String organReviewResult) {
        this.organReviewResult = organReviewResult;
    }

    public String getOrganReviewScore() {
        return organReviewScore;
    }

    public void setOrganReviewScore(String organReviewScore) {
        this.organReviewScore = organReviewScore;
    }

    private java.lang.String rank;

    public String getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(String commentScore) {
        this.commentScore = commentScore;
    }

    private java.lang.String democraticRecommend;
    private java.lang.String democraticRecommendTotal;
    private List<String> addSubItems = new ArrayList<String>();

    private java.lang.String organReviewResult;
    private java.lang.String organReviewScore;
}
