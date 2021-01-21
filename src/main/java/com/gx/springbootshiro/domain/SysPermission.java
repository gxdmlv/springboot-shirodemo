package com.gx.springbootshiro.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootshiro.domain
 * @date 2021/1/20 11:36
 */
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键.
    private long id;
    // 名称.
    private String name;
    // 资源类型，[menu|button]
    private String resourceType;
    // 资源路径.
    private String url;
    // 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private String permission;
    // 父编号
    private Long parentId;
    // 父编号列表
    private String parentIds;
    private Boolean available = Boolean.FALSE;


    //对应多个角色
    private List<SysRole> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                ", roles=" + roles +
                '}';
    }
}
