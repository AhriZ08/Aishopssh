package com.Aishopssh.Entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_user", schema = "e_shopwebsite")
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

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "Blocked")
    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "QQ")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "SecurityQuestion")
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    @Basic
    @Column(name = "SecurityAnswer")
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    @Basic
    @Column(name = "Addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "Postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "RegisterTime")
    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Basic
    @Column(name = "RecentLoginTime")
    public String getRecentLoginTime() {
        return recentLoginTime;
    }

    public void setRecentLoginTime(String recentLoginTime) {
        this.recentLoginTime = recentLoginTime;
    }

    @Basic
    @Column(name = "LoginTime")
    public int getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(int loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "TrueName")
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "ComfirmPwd")
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
        if (!Objects.equals(registerTime, user.registerTime))
            return false;
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
}
