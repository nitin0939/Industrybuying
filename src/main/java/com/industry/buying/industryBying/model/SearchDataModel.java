package com.industry.buying.industryBying.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * Created by Nitin.
 */
@Entity
@Table(name = "searchData")
public class SearchDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 5000)
    @Column(name="Message")
    private String Message;

    @Column(name="truth")
    private String truth;
    
    @Column(name="cube")
    private String cube;
    
    @Column(name="google")
    private String google;
    
    @Column(name="google_spam")
    private Double google_spam;
    
    @Column(name="google_not_spam")
    private Double google_not_spam;
    
    @Column(name="ibm")
    private String ibm;
    
    @Column(name="ibm_spam")
    private Double ibm_spam;
    
    @Column(name="ibm_not_spam")
    private Double ibm_not_spam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getTruth() {
		return truth;
	}

	public void setTruth(String truth) {
		this.truth = truth;
	}

	public String getCube() {
		return cube;
	}

	public void setCube(String cube) {
		this.cube = cube;
	}

	public String getGoogle() {
		return google;
	}

	public void setGoogle(String google) {
		this.google = google;
	}

	public Double getGoogle_spam() {
		return google_spam;
	}

	public void setGoogle_spam(Double google_spam) {
		this.google_spam = google_spam;
	}

	public Double getGoogle_not_spam() {
		return google_not_spam;
	}

	public void setGoogle_not_spam(Double google_not_spam) {
		this.google_not_spam = google_not_spam;
	}

	public String getIbm() {
		return ibm;
	}

	public void setIbm(String ibm) {
		this.ibm = ibm;
	}

	public Double getIbm_spam() {
		return ibm_spam;
	}

	public void setIbm_spam(Double ibm_spam) {
		this.ibm_spam = ibm_spam;
	}

	public Double getIbm_not_spam() {
		return ibm_not_spam;
	}

	public void setIbm_not_spam(Double ibm_not_spam) {
		this.ibm_not_spam = ibm_not_spam;
	}
    
	public SearchDataModel() {
		super();
	}

	public SearchDataModel(String message, String truth, String cube, String google, Double google_spam,
			Double google_not_spam, String ibm, Double ibm_spam, Double ibm_not_spam) {
		super();
		Message = message;
		this.truth = truth;
		this.cube = cube;
		this.google = google;
		this.google_spam = google_spam;
		this.google_not_spam = google_not_spam;
		this.ibm = ibm;
		this.ibm_spam = ibm_spam;
		this.ibm_not_spam = ibm_not_spam;
	}
}
