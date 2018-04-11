package tk.mybatis.simple.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysRole {


    private Long id;


    private String roleName;



    private Integer enabled;



    private Long createBy;



    private Date createTime;


    private SysUser user;
}
