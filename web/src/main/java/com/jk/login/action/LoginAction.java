package com.jk.login.action;


import com.jk.login.model.Power;
import com.jk.login.service.WxxService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ParentPackage("struts-default")
@Namespace("/")
@Action(value = "login",results = {
        @Result(name = "login",location = "login.jsp")
})
public class LoginAction extends BaseAction{
    @Autowired
    private WxxService wxxService;

    //私有treelist
    private List<Map<String,Object>> treelist;

    public List<Map<String, Object>> getTreelist() {
        return treelist;
    }

    public void setTreelist(List<Map<String, Object>> treelist) {
        this.treelist = treelist;
    }
    //私有power
    private Power power;

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    //私有name
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WxxService getWxxService() {
        return wxxService;
    }

    public void setWxxService(WxxService wxxService) {
        this.wxxService = wxxService;
    }

    //递归树

    public void getMenu(){
        List<Power> list = wxxService.getTree(name);
       // List<Map<String,Object>>  list1 =getList(list,0);
       // System.out.println(list1);
        //ServletActionContext.getRequest().getSession().setAttribute("list",list1);
        super.writeJson(list);

    }


  /*  private List<Map<String,Object>> getList(List<Power> tree,Integer pid){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < tree.size(); i++) {
            Power t = tree.get(i);
            Map<String,Object> map = null;
            if(t!=null){
                if(t.getP_parentid() == pid){
                    map = new HashMap<String, Object>();
                    map.put("text", t.getP_text());
                    map.put("id", t.getP_id());
                    map.put("iconCls", t.getP_icon());
                    map.put("url", t.getP_url());
                    map.put("state", t.getP_state());
                    map.put("children", getList(tree, t.getP_id()));
                }
            }
            if(map != null){
                List l = (List) map.get("children");
                if(l.size()<=0){
                    map.remove("children");
                }
                list.add(map);
            }
        }
        return list;
    }*/

}
