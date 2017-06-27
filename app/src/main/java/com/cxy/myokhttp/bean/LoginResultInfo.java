package com.cxy.myokhttp.bean;

import android.text.TextUtils;


/**
 * 登录接口返回的结果
 *
 * @author heaven7
 */
public class LoginResultInfo {
    private static final long serialVersionUID = 1L;
    String message = "";
    String msg = "";
    String fax = "";
    String fax2 = "";
    String gender = ""; // 1 = 男, 2=女
    String hashSend = "";
    String mobile = "";
    String mobile2 = "";
    String nickname = "";
    String name = "";
    String hospitalId = ""; // 医院id
    String hospitalName = "";
    String headIconUrl = "";
    String job = "";
    String projectName = "";
    String regionName = ""; // 行政规划
    String orgName="";
    String orgId = "";
    int status; // "状态 0 失败 1 成功",

    String tel = ""; // 座机
    String tel2 = "";
    String token = ""; // 登录令牌
    String userId = "";
    String userType = "";
    String username = "";
    String photo="";

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "LoginResultInfo [message=" + message + ", fax=" + fax
                + ", fax2=" + fax2 + ", gender=" + gender + ", hashSend="
                + hashSend + ", mobile=" + mobile + ", mobile2=" + mobile2
                + ", name=" + name + ", hospitalId=" + hospitalId
                + ", hospitalName=" + hospitalName + ", headIconUrl="
                + headIconUrl + ", job=" + job + ", projectName=" + projectName
                + ", regionName=" + regionName + ", status=" + status
                + ", tel=" + tel + ", tel2=" + tel2 + ", token=" + token
                + ", userId=" + userId + ", userType=" + userType
                + ", username=" + username + "]";
    }

    public String getMessage() {
        if (TextUtils.isEmpty(message)) {
            return msg;
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHashSend() {
        return hashSend;
    }

    public void setHashSend(String hashSend) {
        this.hashSend = hashSend;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHeadIconUrl() {
        return headIconUrl;
    }

    public void setHeadIconUrl(String headIconUrl) {
        this.headIconUrl = headIconUrl;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

    public String getUsername() {
        return username ;
//		return name;
    }

    public String getMUsername() {
        return username;
//		return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
/**
 * { "fax": "传真1", "fax2": "传真2", "gender": "性别 1：男 2：女", "hashSend": false,
 * "mobile": "移动电话", "mobile2": "移动电话2", "name": "用户名称", "orgId": "医院ID",
 * "orgName": "医院名称", "photo": "头像地址", "position": "岗位", "projectName": "项目名",
 * "regionName": "行政区划", "status": "状态 0 失败 1 成功", "tel": "座机", "tel2": "座机2",
 * "token": "登录令牌", "userId": "用户ID", "userType": "用户类型", "username": "用户名" }
 */
