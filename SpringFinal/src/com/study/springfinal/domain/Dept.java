package com.study.springfinal.domain;

import java.util.List;

/*
	�μ��� ������� ���谡 1:�� �� �����̹Ƿ� �ټ��� �ڽ��� ������ ���踦
	Mybatis ������ collection�̶� �Ѵ�!!!
*/

public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	//memo 12. ������� �Ŵ�����
	private List<Emp> empList;	//�� �ϳ��� �μ��� ���� ����� �Ҽӽ�ų �� �ִ�

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	

	
	
}
