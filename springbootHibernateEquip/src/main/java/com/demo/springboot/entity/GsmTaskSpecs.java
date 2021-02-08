package com.demo.springboot.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gsm_task_specs")
public class GsmTaskSpecs {
	public String idRank;
    public String taskPro;
    public String idSpecs;;
    public String specDesc;;
    public String fileName;
    public String fileDesc;
    public byte[] imageIco;
    public short specsNo;
    public boolean auditing;
    public boolean inuse;
    public boolean delOK;
    
    public GsmTaskSpecs() {
    	super();
    }

    @Id
    @Column(name = "idrank", nullable = false)
    public String getIdRank() {
        return idRank;
    }

    public void setIdRank(String idRank) {
        this.idRank = idRank;
    }

    @Column(name = "taskpro", nullable = false)
    public String getTaskPro() {
        return taskPro;
    }

    public void setTaskPro(String taskPro) {
        this.taskPro = taskPro;
    }
    
    @Column(name = "idspecs", nullable = false)
    public String getIdSpecs() {
        return idSpecs;
    }

    public void setIdSpecs(String idSpecs) {
        this.idSpecs = idSpecs;
    }
    
    
    @Column(name = "specdesc", nullable = false)
    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
    }
    
    @Column(name = "filename", nullable = false)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Column(name = "filedesc", nullable = false)
    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }
    
    @Column(name = "imageico", nullable = false)
    public byte[] getImageIco() {
        return imageIco;
    }

    public void setImageIco(byte[] imageIco) {
        this.imageIco = imageIco;
    }
    
    @Column(name = "specsno", nullable = true)
    public Short getSpecNo() {
        return specsNo;
    }

    public void setSpecNo(Short specNo) {
        this.specsNo = specNo;
    }
    
    @Column(name = "auditing", nullable = true)
    public boolean getAuditing() {
        return auditing;
    }

    public void setAuditing(boolean auditing) {
        this.auditing = auditing;
    }
    
    @Column(name = "inuse", nullable = true)
    public boolean getInuse() {
        return inuse;
    }

    public void setInuse(boolean inuse) {
        this.inuse = inuse;
    }
    
    @Column(name = "delok", nullable = true)
    public boolean getDelOK() {
        return delOK;
    }

    public void setDelOK(boolean delOK) {
        this.delOK = delOK;
    }   
}
