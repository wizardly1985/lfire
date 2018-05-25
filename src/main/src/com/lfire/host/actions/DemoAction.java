package com.lfire.host.actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.gson.Gson;
import com.lfire.host.entity.JsonBack;
import com.lfire.host.entity.Type;
import com.lfire.host.entity.demo.Dept;
import com.lfire.host.entity.demo.Entity;
import com.lfire.host.service.impl.DeptServiceImpl;
import com.lfire.host.service.impl.EntityServiceImpl;
import com.lfire.host.service.impl.TypeServiceImpl;
import com.lfire.host.utils.FileUpload2;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("json-default")
@Namespace("/")
@Action(value = "demo")
@Results({
		@Result(name = "showentity", type = "json", params = { "root", "jsonBack", "contentType", "text/html",
				"charset", "UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "upload", type = "json", params = { "root", "jsonBack", "contentType", "text/html", "charset",
				"UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "list", type = "json", params = { "root", "jsonBack", "contentType", "text/html", "charset",
				"UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "listDept", type = "json", params = { "root", "jsonBack", "contentType", "text/html", "charset",
				"UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "addentity", type = "json", params = { "root", "jsonBack", "contentType", "text/html", "charset",
				"UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "listtype", type = "json", params = { "root", "jsonBack", "contentType", "text/html", "charset",
				"UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "shrio", type = "json", params = { "root", "jsonBack", "contentType", "text/html", "charset",
				"UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "initActiviti", type = "json", params = { "root", "jsonBack", "contentType", "text/html",
				"charset", "UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "code", type = "json", params = { "root", "jsonBack", "contentType", "image/jpeg",
				"charset", "UTF-8", "characterEncoding", "UTF-8" }),
		@Result(name = "gotoActiviti", location = "/WEB-INF/demo/Activiti.jsp"),
		@Result(name = "gotoCode", location = "/WEB-INF/demo/code.jsp"),
		@Result(name = "delentity", location = "/WEB-INF/demo/entity.jsp"),
		@Result(name = "gotoEntity", location = "/WEB-INF/demo/entity.jsp"),
		@Result(name = "gotoUpload", location = "/WEB-INF/demo/upload.jsp"),
		@Result(name = "gotoAdd", location = "/WEB-INF/demo/addentity.jsp"),
		@Result(name = "gotoTree", location = "/WEB-INF/demo/zTree.jsp"),
		@Result(name = "gotoShrio", location = "/WEB-INF/demo/shrio.jsp"),
		@Result(name = "gotolist", location = "/WEB-INF/demo/listentity.jsp"),
		@Result(name = "gotoWebSocket", location = "/WEB-INF/demo/websockect.jsp"),
		@Result(name = "demo", location = "/WEB-INF/demo/demo.jsp") })
public class DemoAction extends ActionSupport implements ModelDriven<Entity> {

	private Entity e = new Entity();
	private List<Entity> eList = new ArrayList<Entity>();
	private List<Dept> eDept = new ArrayList<Dept>();
	private List<Type> tDept = new ArrayList<Type>();
	private int eid = 0;
	private int pageNo = 5, size = 5;
	private File file;
	private String username;
	private String pwd;
	private JsonBack jsonBack = new JsonBack();
	@Autowired
	private EntityServiceImpl entityServiceImpl;
	@Autowired
	private DeptServiceImpl deptServiceImpl;
	@Autowired
	private TypeServiceImpl typeServiceImpl;
	@Autowired
	ProcessEngineConfiguration processEngineConfiguration;
	@Autowired
	private Producer captchaProducer;

	public String demoAll() {
		System.out.println("------");
		return "demo";
	}

	public String showEntity() {
		System.out.println("------>showEntity:id=" + eid);
		e = entityServiceImpl.findById(eid);
		String data = new Gson().toJson(e).toString();
		jsonBack.code = "0";
		jsonBack.msg = "成功";
		jsonBack.data = e;
		System.out.println(e);
		System.out.println(data);
		System.out.println(jsonBack.data);
		return "showentity";
	}

	public String addEntity() {
		System.out.println("------>addEntity" + "id:" + eid + "e.c:" + e.getC());
		entityServiceImpl.add(e);
		return "addentity";
	}

	public String updateEntity() {
		System.out.println("------>updateEntity" + "id:" + eid + "e.c:" + e.getC());
		entityServiceImpl.add(e);
		return "addentity";
	}

	public String delEntity() {
		System.out.println("------>delEntity");
		boolean bool = entityServiceImpl.del(eid);

		return "delentity";
	}

	public String listEntity() {
		System.out.println("------>listEntity");
		eList.addAll(entityServiceImpl.getListByPage(pageNo, size));
		String data = new Gson().toJson(eList);
		jsonBack.code = "0";
		jsonBack.msg = "成功";
		jsonBack.data = eList;
		System.out.println(data);
		return "list";
	}

	public String listDept() {
		System.out.println("------>listDept");
		eDept.addAll(deptServiceImpl.findAll());
		String data = new Gson().toJson(eDept);
		jsonBack.code = "0";
		jsonBack.msg = "成功";
		jsonBack.data = eDept;
		System.out.println(data);
		return "listDept";
	}

	public String listType() {
		System.out.println("------>listType");
		tDept.addAll(typeServiceImpl.findAll());
		String data = new Gson().toJson(tDept);
		jsonBack.code = "0";
		jsonBack.msg = "成功";
		jsonBack.data = tDept;
		System.out.println(data);
		return "listtype";
	}

	public String upload() {
		System.out.println("----->文件上传");
		System.out.println("文件名：" + file.getName());
		try {
			new FileUpload2().upload(file.getName(), file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "upload";
	}

	public String shrio() {
		System.out.println("----->shrio：" + username + ":" + pwd);
		// 获取Shiro管理的Session
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String passwordsha = new SimpleHash("SHA-1", username, pwd).toString();
		System.out.println(passwordsha);
		// Shiro添加会话
		session.setAttribute("username", username);
		// session.setAttribute(Constants.SESSION_USER, user);
		// 删除验证码Session
		// session.removeAttribute(Constants.SESSION_SECURITY_CODE);
		// 保存登录IP
		// getRemortIP(username);
		/** Shiro加入身份验证 **/
		Subject sub = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
		sub.login(token);
		return "shrio";
	}

	public String initActiviti() {
		// ProcessEngine processEngine = (ProcessEngine)
		// ac.getBean("processEngine");
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("------------流程部署-------------");
		System.out.println("processEngine:" + processEngine);
		Deployment deployment = processEngine.getRepositoryService().createDeployment().name("activiti")
				.addClasspathResource("MyProcess.bpmn").addClasspathResource("MyProcess.png").deploy();
		System.out.println("部署Id：" + deployment.getId());
		System.out.println("部署name：" + deployment.getName());
		System.out.println("------------流程启动-------------");
		String processDefinitionKey = "myProcess"; // 使用Key的启动，默认按照对心版本的流程定义启动
		ProcessInstance pi = processEngine.getRuntimeService() // 与正在执行的流程实例和执行对象相关的Service
				.startProcessInstanceByKey(processDefinitionKey); // 使用流程定义的Key启动流程实例，key对应helloworld.bpmn文件中的流程名称
		System.out.println("流程实例Id" + pi.getId()); // 流程实例Id：57501
		System.out.println("流程定义Id" + pi.getProcessDefinitionId()); // 流程定义Id：psocessVariables:1:55004
		System.out.println("------------查看任务-------------");
		TaskService taskService = processEngine.getTaskService();
		List<Task> taskList = taskService.createTaskQuery().taskAssignee("三三").list();
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println("任务名：" + taskList.get(i).getName() + ";" + "任务id:" + taskList.get(i).getId());
		}
		System.out.println("------------任务审批-------------");
		taskService.complete(taskList.get(0).getId());
		System.out.println("------------查看任务-------------");
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println("任务名：" + taskList.get(i).getName() + ";" + "任务id:" + taskList.get(i).getId());
		}

		return "initActiviti";
	}

	public String code() {
		System.out.println("----------code");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setDateHeader("Expires", 0);// 禁止server端缓存
		// 设置标准的 HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// 设置IE扩展 HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");// 设置标准 HTTP/1.0 不缓存图片
		response.setContentType("image/jpeg");// 返回一个 jpeg 图片，默认是text/html(输出文档的MIMI类型)
		String capText = captchaProducer.createText();// 为图片创建文本
		
		// 将文本保存在session中。这里就使用包中的静态变量吧
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		
		BufferedImage bi = captchaProducer.createImage(capText); // 创建带有文本的图片
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			// 图片数据输出
			ImageIO.write(bi, "jpg", out);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}

		System.out.println("Session 验证码是：" + request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
		return null;
	}

	public String gotoCode() {
		return "gotoCode";
	}

	public String gotoListEntity() {
		return "gotolist";
	}

	public String gotoActiviti() {
		return "gotoActiviti";
	}

	public String gotoEntity() {
		return "gotoEntity";
	}

	public String gotoUpload() {
		return "gotoUpload";
	}

	public String gotoUpdate() {
		return "gotoUpdate";
	}

	public String gotoAdd() {
		return "gotoAdd";
	}

	public String gotoTree() {
		return "gotoTree";
	}

	public String gotoWebSocket() {
		return "gotoWebSocket";
	}

	public String gotoShrio() {
		return "gotoShrio";
	}

	public Entity getE() {
		return e;
	}

	public void setE(Entity e) {
		this.e = e;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public List<Entity> geteList() {
		return eList;
	}

	public void seteList(List<Entity> eList) {
		this.eList = eList;
	}

	public JsonBack getJsonBack() {
		return jsonBack;
	}

	public void setJsonBack(JsonBack jsonBack) {
		this.jsonBack = jsonBack;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Entity getModel() {
		return e;
	}

	public List<Type> gettDept() {
		return tDept;
	}

	public void settDept(List<Type> tDept) {
		this.tDept = tDept;
	}

	public List<Dept> geteDept() {
		return eDept;
	}

	public void seteDept(List<Dept> eDept) {
		this.eDept = eDept;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
