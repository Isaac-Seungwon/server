package com.test.toy.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.toy.DBUtil;
import com.test.toy.user.model.UserDTO;

public class UserDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public UserDAO() {
		this.conn = DBUtil.open("localhost", "toy", "java1234");
	}
	
	public int register(UserDTO dto) {
		
		/*
	 	//코드조각
		매개변수 유/무
		반환값 유/무 > 단일값, DTO, List<DTO>
		
		queryNoParamNoReturn
		queryParamNoReturn
					
		queryNoParamTokenReturn
		queryParamTokenReturn
		
		queryNoParamDTOReturn
		queryParamDTOReturn
		
		queryNoParamListReturn
		queryParamListReturn
		*/
		
		try {

			String sql = "insert into tblUser (id, pw, name, email, pic, lv, intro, ing) values(?, ?, ?, ?, ?, 1, ?, default)";

			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getPic());
			pstat.setString(6, dto.getIntro());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public UserDTO login(UserDTO dto) {

		//매개변수(O), 반환값(DTO)
		//queryParamDTOReturn
		try {
			
			String sql = "select * from tblUser where id = ? and pw = ? and ing = 'y'";
			//현재 활동중인 멤버만 조회할 수 있도록 함
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				UserDTO result = new UserDTO();
				//위에서 dto가 있어서 result로 이름 변경
				
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setLv(rs.getString("lv"));
				
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
