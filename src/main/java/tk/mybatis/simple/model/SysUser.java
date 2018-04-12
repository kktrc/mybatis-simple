package tk.mybatis.simple.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysUser implements Serializable {


    private Long id;



    private String userName;



    private String userPassword;



    private String userEmail;



    private String userInfo;



    private byte[] headImg;



    private Date createTime;
}
