package marco.zlc.dabl.modules.system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/9 18:04
 *@修改人和其它信息 是es的实体类，用来创建
 */

@Document(indexName = "fo_daboluo", type = "doc")
public class ElasticSerachEntity {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("code")
    private String code;


    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("phone")
    private String phone;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

