package com.jk.login.action;


import com.jk.login.model.Power;
import com.jk.login.service.WxxService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ParentPackage("struts-default")
@Namespace("/")
@Action(value = "login",results = {
        @Result(name = "login",location = "login.jsp")
})
public class WxxAction  extends BaseAction{

    @Autowired
    private WxxService wxxService;

    //私有list
    private List<Power> list;

    public List<Power> getList() {
        return list;
    }

    public void setList(List<Power> list1) {
        this.list = list;
    }
    //私有power
    private Power power=new Power();

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
        List list= wxxService.getTree(name);

     //Map<String,Object>  list1=getList(list,0);
       // System.out.println(list1);
        //ServletActionContext.getRequest().getSession().setAttribute("list",list1);
        super.writeJson(getList(list,0));

    }


    private List<Map<String,Object>>getList(List<Map<String,Object>> tree, int id){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < tree.size(); i++) {
            Map<String,Object> t = tree.get(i);
            Map<String,Object> map = null;
            if(t!=null){
                if(Integer.parseInt(t.get("parentid").toString()) == id){
                    map = new HashMap<String, Object>();
                    map.put("text", t.get("text"));
                    map.put("id", t.get("id"));
                    map.put("iconCls", t.get("icon"));
                    map.put("url", t.get("url"));
                    map.put("children", getList(tree,Integer.parseInt(t.get("id").toString())));
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
    }

}
