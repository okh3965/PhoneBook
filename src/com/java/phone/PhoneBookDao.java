package com.java.phone;

import java.util.List;

public interface PhoneBookDao {

	public List<PhoneBookVo> getList();
	public List<PhoneBookVo> search(String keyword);
	public PhoneBookVo get(Long id);
	public boolean insert(PhoneBookVo vo);
	public boolean update(PhoneBookVo vo);
	public boolean delete(Long id);
	
	
}
