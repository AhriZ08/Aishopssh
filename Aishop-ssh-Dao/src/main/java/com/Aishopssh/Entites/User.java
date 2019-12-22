package com.Aishopssh.Entites;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private String pwd;
    private int blocked;
    private String email;
    private String tel;
    private String qq;
    private String ip;
    private String securityQuestion;
    private String securityAnswer;
    private String addr;
    private String postcode;
    private String registerTime;
    private String recentLoginTime;
    private int loginTime;
    private String trueName;
    private String comfirmPwd;
    private Set<AdminReply> tbAdminRepliesById;
    private Set<Cartlist> tbCartlistsById;
    private Set<Comments> tbCommentsById;
    private Set<Leaveword> tbLeavewordsById;
    private Set<PwdRest> tbPwdRestsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getRecentLoginTime() {
        return recentLoginTime;
    }

    public void setRecentLoginTime(String recentLoginTime) {
        this.recentLoginTime = recentLoginTime;
    }

    public int getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(int loginTime) {
        this.loginTime = loginTime;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getComfirmPwd() {
        return comfirmPwd;
    }

    public void setComfirmPwd(String comfirmPwd) {
        this.comfirmPwd = comfirmPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (blocked != user.blocked) return false;
        if (loginTime != user.loginTime) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(pwd, user.pwd)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(tel, user.tel)) return false;
        if (!Objects.equals(qq, user.qq)) return false;
        if (!Objects.equals(ip, user.ip)) return false;
        if (!Objects.equals(securityQuestion, user.securityQuestion))
            return false;
        if (!Objects.equals(securityAnswer, user.securityAnswer))
            return false;
        if (!Objects.equals(addr, user.addr)) return false;
        if (!Objects.equals(postcode, user.postcode)) return false;
        if (!Objects.equals(registerTime, user.registerTime)) return false;
        if (!Objects.equals(recentLoginTime, user.recentLoginTime))
            return false;
        if (!Objects.equals(trueName, user.trueName)) return false;
        return Objects.equals(comfirmPwd, user.comfirmPwd);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + blocked;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (securityQuestion != null ? securityQuestion.hashCode() : 0);
        result = 31 * result + (securityAnswer != null ? securityAnswer.hashCode() : 0);
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (recentLoginTime != null ? recentLoginTime.hashCode() : 0);
        result = 31 * result + loginTime;
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (comfirmPwd != null ? comfirmPwd.hashCode() : 0);
        return result;
    }

    public Set<AdminReply> getTbAdminRepliesById() {
        return tbAdminRepliesById;
    }

    public void setTbAdminRepliesById(Set<AdminReply> tbAdminRepliesById) {
        this.tbAdminRepliesById = tbAdminRepliesById;
    }

    public Set<Cartlist> getTbCartlistsById() {
        return tbCartlistsById;
    }

    public void setTbCartlistsById(Set<Cartlist> tbCartlistsById) {
        this.tbCartlistsById = tbCartlistsById;
    }

    public Set<Comments> getTbCommentsById() {
        return tbCommentsById;
    }

    public void setTbCommentsById(Set<Comments> tbCommentsById) {
        this.tbCommentsById = tbCommentsById;
    }

    public Set<Leaveword> getTbLeavewordsById() {
        return tbLeavewordsById;
    }

    public void setTbLeavewordsById(Set<Leaveword> tbLeavewordsById) {
        this.tbLeavewordsById = tbLeavewordsById;
    }

    public Set<PwdRest> getTbPwdRestsById() {
        return tbPwdRestsById;
    }

    public void setTbPwdRestsById(Set<PwdRest> tbPwdRestsById) {
        this.tbPwdRestsById = tbPwdRestsById;
    }
}
