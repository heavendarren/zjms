/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.zongjiao.entity;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 民族宗教信息Entity
 * @author lizhi
 * @version 2017-05-12
 */
@XmlRootElement(name="RelgPer")
public class RelgPer  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;		// 姓名
	private String sex;		// 性别
	private String relgNameCode;		// 宗教姓名区分
	private String relgName;		// 宗教姓名
	private String birth;		// 出生年月日
	private String birthB;		// 出生年月日
	private String birthA;		// 出生年月日
	private String photo;		// 照片
	private String nation;		// 民族
	private String nativePlaceP;		// 籍贯省
	private String nativePlaceC;		// 籍贯市
	private String nativePlaceA;		// 籍贯县
	private String birthplaceP;		// 出生地省
	private String birthplaceC;		// 出生地市
	private String birthplaceA;		// 出生地县
	private String politicsStatus;		// 政治面貌
	private String partyTime;		// 入党时间
	private String startingWorkTime;		// 参加工作时间
	private String workUnitPosition;		// 工作单位及职务
	private String domicilePlaceP;		// 户籍所在地
	private String domicilePlaceC;		// 户籍所在地
	private String domicilePlaceA;		// 户籍所在地
	private String religion;		// 宗教信仰
	private String relgIdentity;		// 宗教身份
	private String startingRelgTime;		// 成为教职人员时间
	private String reglPlace;		// 所在宗教场所
	private String relgPosition;		// 教内职务
	private String health;		// 健康状况
	private String education;		// 学历
	private String school;		// 毕业院校系及专业
	private String proEducation;		// 在职教育学历
	private String proSchool;		// 在职教育毕业院校系及专业
	private String reglEducation;		// 宗教教育学历
	private String reglSchool;		// 宗教教育毕业院校系及专业
	private String idCardNo;		// 身份证号
	private String contact;		// 联系方式
	private String socialPosition;		// 社会职务
	private String resume;		// 基本简历
	private String winningRecord;		// 获奖情况
	private String results;		// 主要业绩简述
	private String region;		// 归属地区
	private String identityCode;		// 身份区分
	private String commitFlag;		// 提交标记
	private String enterTrml;		// 录入终端
	private String imgString;		// 照片流
	private String createBy;		// 创建者
	private String createDate;		// 创建时间
	private String updateBy;		// 更新着
	private String updateDate;		// 更新时间
	private String remarks;		// 备注
	private String delFlag;		// 删除标记
	private String notClose;		// 
	private Integer pageNo;		// 
	private int srow;		// 


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRelgNameCode() {
		return relgNameCode;
	}

	public void setRelgNameCode(String relgNameCode) {
		this.relgNameCode = relgNameCode;
	}

	public String getRelgName() {
		return relgName;
	}

	public void setRelgName(String relgName) {
		this.relgName = relgName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getBirthB() {
		return birthB;
	}

	public void setBirthB(String birthB) {
		this.birthB = birthB;
	}

	public String getBirthA() {
		return birthA;
	}

	public void setBirthA(String birthA) {
		this.birthA = birthA;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getNativePlaceP() {
		return nativePlaceP;
	}

	public void setNativePlaceP(String nativePlaceP) {
		this.nativePlaceP = nativePlaceP;
	}

	public String getNativePlaceC() {
		return nativePlaceC;
	}

	public void setNativePlaceC(String nativePlaceC) {
		this.nativePlaceC = nativePlaceC;
	}

	public String getNativePlaceA() {
		return nativePlaceA;
	}

	public void setNativePlaceA(String nativePlaceA) {
		this.nativePlaceA = nativePlaceA;
	}

	public String getBirthplaceP() {
		return birthplaceP;
	}

	public void setBirthplaceP(String birthplaceP) {
		this.birthplaceP = birthplaceP;
	}

	public String getBirthplaceC() {
		return birthplaceC;
	}

	public void setBirthplaceC(String birthplaceC) {
		this.birthplaceC = birthplaceC;
	}

	public String getBirthplaceA() {
		return birthplaceA;
	}

	public void setBirthplaceA(String birthplaceA) {
		this.birthplaceA = birthplaceA;
	}

	public String getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public String getPartyTime() {
		return partyTime;
	}

	public void setPartyTime(String partyTime) {
		this.partyTime = partyTime;
	}

	public String getStartingWorkTime() {
		return startingWorkTime;
	}

	public void setStartingWorkTime(String startingWorkTime) {
		this.startingWorkTime = startingWorkTime;
	}

	public String getWorkUnitPosition() {
		return workUnitPosition;
	}

	public void setWorkUnitPosition(String workUnitPosition) {
		this.workUnitPosition = workUnitPosition;
	}

	public String getDomicilePlaceP() {
		return domicilePlaceP;
	}

	public void setDomicilePlaceP(String domicilePlaceP) {
		this.domicilePlaceP = domicilePlaceP;
	}

	public String getDomicilePlaceC() {
		return domicilePlaceC;
	}

	public void setDomicilePlaceC(String domicilePlaceC) {
		this.domicilePlaceC = domicilePlaceC;
	}

	public String getDomicilePlaceA() {
		return domicilePlaceA;
	}

	public void setDomicilePlaceA(String domicilePlaceA) {
		this.domicilePlaceA = domicilePlaceA;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getRelgIdentity() {
		return relgIdentity;
	}

	public void setRelgIdentity(String relgIdentity) {
		this.relgIdentity = relgIdentity;
	}

	public String getStartingRelgTime() {
		return startingRelgTime;
	}

	public void setStartingRelgTime(String startingRelgTime) {
		this.startingRelgTime = startingRelgTime;
	}

	public String getReglPlace() {
		return reglPlace;
	}

	public void setReglPlace(String reglPlace) {
		this.reglPlace = reglPlace;
	}

	public String getRelgPosition() {
		return relgPosition;
	}

	public void setRelgPosition(String relgPosition) {
		this.relgPosition = relgPosition;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getProEducation() {
		return proEducation;
	}

	public void setProEducation(String proEducation) {
		this.proEducation = proEducation;
	}

	public String getProSchool() {
		return proSchool;
	}

	public void setProSchool(String proSchool) {
		this.proSchool = proSchool;
	}

	public String getReglEducation() {
		return reglEducation;
	}

	public void setReglEducation(String reglEducation) {
		this.reglEducation = reglEducation;
	}

	public String getReglSchool() {
		return reglSchool;
	}

	public void setReglSchool(String reglSchool) {
		this.reglSchool = reglSchool;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSocialPosition() {
		return socialPosition;
	}

	public void setSocialPosition(String socialPosition) {
		this.socialPosition = socialPosition;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getWinningRecord() {
		return winningRecord;
	}

	public void setWinningRecord(String winningRecord) {
		this.winningRecord = winningRecord;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getCommitFlag() {
		return commitFlag;
	}

	public void setCommitFlag(String commitFlag) {
		this.commitFlag = commitFlag;
	}

	public String getEnterTrml() {
		return enterTrml;
	}

	public void setEnterTrml(String enterTrml) {
		this.enterTrml = enterTrml;
	}

	public String getImgString() {
		return imgString;
	}

	public void setImgString(String imgString) {
		this.imgString = imgString;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getNotClose() {
		return notClose;
	}

	public void setNotClose(String notClose) {
		this.notClose = notClose;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public int getSrow() {
		return srow;
	}

	public void setSrow(int srow) {
		this.srow = srow;
	}


}