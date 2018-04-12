package tk.mybatis.simple.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysRole implements Serializable {


    private Long id;


    private String roleName;



    private Integer enabled;



    private Long createBy;



    private Date createTime;


    private SysUser user;
}
