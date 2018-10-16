package com.inspection.entity.evaluation;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "t_evaluation", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class EvaluationResidualMain {
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private EvaluationResidualEntity entity;

    @Transient
    public EvaluationResidualEntity getEntity() {
        return entity;
    }

    public void setEntity(EvaluationResidualEntity entity) {
        this.entity = entity;
    }

    //证明人
    private String zhengMingRen1;
    private String zhengMingRen2;

    //评残审查
    private byte[] geRenZiShu;
    private String ziShuFilename;

    public String getZiShuFilename() {
        return ziShuFilename;
    }

    public void setZiShuFilename(String ziShuFilename) {
        this.ziShuFilename = ziShuFilename;
    }

    private String zhiCanXingZhi;
    private String oanZhengRen1;
    private String oanZhengRen2;
    private String oanZhengRen3;

    //残疾评定
    private byte[] fuHeXing;
    private String fuHeFilename;

    public String getFuHeFilename() {
        return fuHeFilename;
    }

    public void setFuHeFilename(String fuHeFilename) {
        this.fuHeFilename = fuHeFilename;
    }

    private String jueYi;
    private byte[] shenFenZheng;
    private String ShenFenZhengFilename;
    private byte[] junGuangZheng;
    private String junGuangZhengFilename;
    private byte[] baoZhangKa;
    private String baoZhangKaFilename;
    private byte[] bingLi;
    private String bingLiFilename;

    public String getShenFenZhengFilename() {
        return ShenFenZhengFilename;
    }

    public void setShenFenZhengFilename(String shenFenZhengFilename) {
        ShenFenZhengFilename = shenFenZhengFilename;
    }

    public String getJunGuangZhengFilename() {
        return junGuangZhengFilename;
    }

    public void setJunGuangZhengFilename(String junGuangZhengFilename) {
        this.junGuangZhengFilename = junGuangZhengFilename;
    }

    public String getBaoZhangKaFilename() {
        return baoZhangKaFilename;
    }

    public void setBaoZhangKaFilename(String baoZhangKaFilename) {
        this.baoZhangKaFilename = baoZhangKaFilename;
    }

    public String getBingLiFilename() {
        return bingLiFilename;
    }

    public void setBingLiFilename(String bingLiFilename) {
        this.bingLiFilename = bingLiFilename;
    }

    public String getZhengMingRen1() {
        return zhengMingRen1;
    }

    public void setZhengMingRen1(String zhengMingRen1) {
        this.zhengMingRen1 = zhengMingRen1;
    }

    public String getZhengMingRen2() {
        return zhengMingRen2;
    }

    public void setZhengMingRen2(String zhengMingRen2) {
        this.zhengMingRen2 = zhengMingRen2;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getGeRenZiShu() {
        return geRenZiShu;
    }

    public void setGeRenZiShu(byte[] geRenZiShu) {
        this.geRenZiShu = geRenZiShu;
    }

    public String getZhiCanXingZhi() {
        return zhiCanXingZhi;
    }

    public void setZhiCanXingZhi(String zhiCanXingZhi) {
        this.zhiCanXingZhi = zhiCanXingZhi;
    }

    public String getOanZhengRen1() {
        return oanZhengRen1;
    }

    public void setOanZhengRen1(String oanZhengRen1) {
        this.oanZhengRen1 = oanZhengRen1;
    }

    public String getOanZhengRen2() {
        return oanZhengRen2;
    }

    public void setOanZhengRen2(String oanZhengRen2) {
        this.oanZhengRen2 = oanZhengRen2;
    }

    public String getOanZhengRen3() {
        return oanZhengRen3;
    }

    public void setOanZhengRen3(String oanZhengRen3) {
        this.oanZhengRen3 = oanZhengRen3;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getFuHeXing() {
        return fuHeXing;
    }

    public void setFuHeXing(byte[] fuHeXing) {
        this.fuHeXing = fuHeXing;
    }

    public String getJueYi() {
        return jueYi;
    }

    public void setJueYi(String jueYi) {
        this.jueYi = jueYi;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getShenFenZheng() {
        return shenFenZheng;
    }

    public void setShenFenZheng(byte[] shenFenZheng) {
        this.shenFenZheng = shenFenZheng;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getJunGuangZheng() {
        return junGuangZheng;
    }

    public void setJunGuangZheng(byte[] junGuangZheng) {
        this.junGuangZheng = junGuangZheng;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getBaoZhangKa() {
        return baoZhangKa;
    }

    public void setBaoZhangKa(byte[] baoZhangKa) {
        this.baoZhangKa = baoZhangKa;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getBingLi() {
        return bingLi;
    }

    public void setBingLi(byte[] bingLi) {
        this.bingLi = bingLi;
    }
}
