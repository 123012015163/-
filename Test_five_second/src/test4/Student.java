package test4;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1234L;
	private String StudentID=null;
	private String Name=null;
	private String Sex;
	
	public String getStudentID(){//获得学生ID
		return StudentID;
	}
	
	public String getName(){//获得学生姓名
		return Name;
	} 
	
	public String getSex(){//获得学生性别
		return Sex;
	}
	
	public void SetName(String name){
		this.Name=name;
	}
	
	public void SetStudentID(String StudentID){
		this.StudentID=StudentID;
	}
	
	public void SetSex(String sex){
		this.Sex=sex;
	}


}

