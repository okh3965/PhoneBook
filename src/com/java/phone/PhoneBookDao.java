package com.java.phone;

import java.util.List;

public interface PhoneBookDao {

	public List<PhoneBookVo> getList();
	public List<PhoneBookVo> search(String keyword);
	public PhoneBookVo get(Long id);
	public void insert(PhoneBookVo vo);
	public void update(PhoneBookVo vo);
	public void delete(Long id);
	
	
}
