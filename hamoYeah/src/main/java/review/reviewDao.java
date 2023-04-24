package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class reviewDao {
	private DBConnect dbconn;

	public reviewDao() {
		dbconn = DBConnect.getInstance();
	}
	
	//리뷰작성(add)
	public void insert(reviewVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into H_review values(?,seq_H_review.nextval, ?, sysdate,0,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMember_id());
			pstmt.setInt(2, vo.getBoard_num());
			pstmt.setString(3, vo.getImagepath());
			pstmt.setString(4, vo.getContent());

			int num = pstmt.executeUpdate();
			System.out.println(num + " 줄이 추가되었다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//후기수정(edit)	primary key(review_num)로 내용(content) 수정
	public void update(reviewVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update H_review set content=?, imagepath=? where review_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getImagepath());
			pstmt.setString(3, vo.getMember_id());
			int num = pstmt.executeUpdate();
			System.out.println(num + " 줄이 수정됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// delete: primary key(review_num)로 찾아서 삭제
	public void delete(int review_num) {
		Connection conn = dbconn.conn();
		String sql = "delete from H_review where review_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			int num = pstmt.executeUpdate();
			System.out.println(num + " 줄이 삭제됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//selectAll(review 전체목록 띄우기)
	public ArrayList<reviewVo> selectAll(){
		Connection conn = dbconn.conn();
		ArrayList<reviewVo> list = new ArrayList<>();
		String sql = "select * from H_review order by review_num desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new reviewVo(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	//selectByTag(Tag로 검색)
	public reviewVo selectByTag(String tag) {
		Connection conn = dbconn.conn();
		String sql = "select * from H_review where tag=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new reviewVo(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
	//selectByMember(작성자로 검색)
	public ArrayList<reviewVo> selectByMemberId(String member_id){
		Connection conn = dbconn.conn();
		ArrayList<reviewVo> list = new ArrayList<>();
		String sql = "select * from H_review where member_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new reviewVo(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}


